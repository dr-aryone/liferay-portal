package com.liferay.frontend.js.loader.modules.extender.internal.resolution;

import com.liferay.frontend.js.loader.modules.extender.internal.resolution.descriptor.JSConfigGeneratorModuleDescriptor;
import com.liferay.frontend.js.loader.modules.extender.internal.resolution.descriptor.JSModuleDescriptor;
import com.liferay.frontend.js.loader.modules.extender.internal.config.generator.JSConfigGeneratorModule;
import com.liferay.frontend.js.loader.modules.extender.internal.config.generator.JSConfigGeneratorPackage;
import com.liferay.frontend.js.loader.modules.extender.internal.config.generator.JSConfigGeneratorPackagesTracker;
import com.liferay.frontend.js.loader.modules.extender.npm.JSModule;
import com.liferay.frontend.js.loader.modules.extender.npm.ModuleNameUtil;
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
import java.util.stream.Stream;

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
	public void setJsConfigGeneratorPackagesTracker(
		JSConfigGeneratorPackagesTracker jsConfigGeneratorPackagesTracker) {
		_jsConfigGeneratorPackagesTracker = jsConfigGeneratorPackagesTracker;
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

	private ArrayList<ModuleDescriptor> _getAllModules() {
		Collection<JSConfigGeneratorPackage> jsConfigGeneratorPackages =
			_jsConfigGeneratorPackagesTracker.getJSConfigGeneratorPackages();

		Stream<JSConfigGeneratorPackage> jsConfigGeneratorPackagesStream =
			jsConfigGeneratorPackages.stream();

		List<JSConfigGeneratorModuleDescriptor> jsConfigGeneratorModuleAdapters =
			jsConfigGeneratorPackagesStream.reduce(
				new ArrayList<>(),
				(arrayList, pkg) -> {
					for (JSConfigGeneratorModule jsConfigGeneratorModule :
						pkg.getJSConfigGeneratorModules()) {

						arrayList.add(
							new JSConfigGeneratorModuleDescriptor(
								jsConfigGeneratorModule));
					}

					return arrayList;
				},
				(arrayList1, arrayList2) -> {
					ArrayList<JSConfigGeneratorModuleDescriptor> result =
						new ArrayList<>(arrayList1);

					result.addAll(arrayList2);

					return result;
				});

		List<JSModuleDescriptor> npmRegistryModules =
			_npmRegistry.getResolvedJSModules().stream()
				.map(
					m -> new JSModuleDescriptor(m, _npmRegistry))
				.collect(Collectors.toList());

		ArrayList<ModuleDescriptor> allModules = new ArrayList<>();

		allModules.addAll(jsConfigGeneratorModuleAdapters);
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
		ModuleDescriptor adapter, JSModuleContext context) {

		if (adapter == null) {
			return;
		}

		Collection<String> dependencies = adapter.getDependencies();

		String alias = adapter.getName();

		Map<String, String> dependenciesMap = new ConcurrentHashMap<>();

		for (String dependency : dependencies) {

			if (!dependency.equals("require") &&
				!dependency.equals("exports") &&
				!dependency.equals("module")) {

				String resolvedPath =
					ModuleNameUtil.resolvePath(alias, dependency);

				String mappedModuleName =
					_mapModuleName(resolvedPath, adapter.getMappings());

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
			_processModule(
				new JSModuleDescriptor(jsModule, _npmRegistry), context);
		}
	}

	private void _resolve(String module, JSModuleContext context) {
		String mappedModule = _mapModuleName(module);

		ArrayList<ModuleDescriptor> allModules = _getAllModules();

		ModuleDescriptor adapter = null;

		for (ModuleDescriptor m : allModules) {
			if (m.getName().equals(mappedModule)) {
				adapter = m;
				break;
			}
		}

		if (adapter != null) {
			context.putConfig(module, mappedModule);

			_processModule(adapter, context);

			context.addResolvedModule(adapter.getName());
		}
		else {
			context.addResolvedModule(
				":ERROR: Module " + module + " not found");
		}
	}

	private JSConfigGeneratorPackagesTracker _jsConfigGeneratorPackagesTracker;
	private JSModulesNameMapper _mapper;
	private NPMRegistry _npmRegistry;
	private Portal _portal;

}
