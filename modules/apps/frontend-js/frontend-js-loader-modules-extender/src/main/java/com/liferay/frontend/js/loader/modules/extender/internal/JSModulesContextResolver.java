package com.liferay.frontend.js.loader.modules.extender.internal;

import com.liferay.frontend.js.loader.modules.extender.internal.adapter.JSLoaderModuleAdapter;
import com.liferay.frontend.js.loader.modules.extender.internal.adapter.JSModuleAdapter;
import com.liferay.frontend.js.loader.modules.extender.internal.adapter.NPMRegistryModuleAdapter;
import com.liferay.frontend.js.loader.modules.extender.npm.JSModule;
import com.liferay.frontend.js.loader.modules.extender.npm.NPMRegistry;
import com.liferay.portal.kernel.util.Portal;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author Rodolfo Roza Miranda
 */
@Component(
	immediate = true,
	service = JSModulesContextResolver.class
)
public class JSModulesContextResolver {

	public JSModuleContext resolve(List<String> modules) {

		JSModuleContext context = new JSModuleContext();

		for (String module : modules) {
			_resolve(module, context);
		}

		return context;
	}

	@Reference(unbind = "-")
	public void setJsLoaderModulesTracker(
		JSLoaderModulesTracker jsLoaderModulesTracker) {
		_jsLoaderModulesTracker = jsLoaderModulesTracker;
	}

	@Reference(unbind = "-")
	public void setMapper(JSModulesNameMapper mapper) {
		_mapper = mapper;
	}

	@Reference(unbind = "-")
	public void setNpmRegistry(NPMRegistry npmRegistry) {
		_npmRegistry = npmRegistry;
	}

	@Reference(unbind = "-")
	public void setPortal(Portal portal) {
		_portal = portal;
	}

	private ArrayList<JSModuleAdapter> _getAllModules() {
		List<JSLoaderModuleAdapter> jsLoaderModuleAdapters =
			_jsLoaderModulesTracker.getJSLoaderModules().stream()
				.map(m -> new JSLoaderModuleAdapter(m, _portal))
				.collect(Collectors.toList());

		List<NPMRegistryModuleAdapter> npmRegistryModules =
			_npmRegistry.getResolvedJSModules().stream()
				.map(
					m -> new NPMRegistryModuleAdapter(m, _npmRegistry, _portal))
				.collect(Collectors.toList());

		ArrayList<JSModuleAdapter> allModules = new ArrayList<>();

		allModules.addAll(jsLoaderModuleAdapters);
		allModules.addAll(npmRegistryModules);

		return allModules;
	}

	private String _mapModuleName(
		String module, Map<String, String> contextMap) {
		return _mapper.mapModule(module, contextMap);
	}

	private String _mapModuleName(String module) {
		return _mapper.mapModule(module);
	}

	private void _processModule(
		JSModuleAdapter adapter, JSModuleContext context) {

		if (adapter == null) {
			return;
		}

		Collection<String> dependencies = adapter.getDependencies();

		String alias = adapter.getAlias();

		Map<String, String> dependenciesMap = new ConcurrentHashMap<>();

		for (String dependency : dependencies) {

			if (!dependency.equals("require") &&
				!dependency.equals("exports") &&
				!dependency.equals("module")) {

				String resolvedPath =
					PathResolver.resolvePath(alias, dependency);

				String mappedModuleName =
					_mapModuleName(resolvedPath, adapter.getMap());

				dependenciesMap.put(dependency, mappedModuleName);

				if (!context.processedModule(mappedModuleName)) {
					context.addProcessedModule(mappedModuleName);
					_processModule(mappedModuleName, context);
					context.addResolvedModule(mappedModuleName);
				}
			}
		}

		context.putPath(alias, adapter.getPath());
		context.putModuleDependencyMap(alias, dependenciesMap);
	}

	private void _processModule(String module, JSModuleContext context) {
		JSModule jsModule = _npmRegistry.getResolvedJSModule(module);

		if (jsModule != null) {
			_processModule(new NPMRegistryModuleAdapter(jsModule, _npmRegistry,
				_portal), context);
		}
	}

	private void _resolve(String module, JSModuleContext context) {
		String mappedModule = _mapModuleName(module);

		ArrayList<JSModuleAdapter> allModules = _getAllModules();

		JSModuleAdapter adapter = null;

		for (JSModuleAdapter m : allModules) {
			if (m.getAlias().equals(mappedModule)) {
				adapter = m;
				break;
			}
		}

		if (adapter != null) {
			context.putConfig(module, mappedModule);

			_processModule(adapter, context);

			context.addResolvedModule(adapter.getAlias());
		}
		else {
			context.addResolvedModule(
				":ERROR: Module " + module + " not found");
		}
	}

	private JSLoaderModulesTracker _jsLoaderModulesTracker;
	private JSModulesNameMapper _mapper;
	private NPMRegistry _npmRegistry;
	private Portal _portal;

}
