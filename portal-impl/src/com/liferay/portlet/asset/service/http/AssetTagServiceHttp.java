/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portlet.asset.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.asset.kernel.service.AssetTagServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * {@link AssetTagServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link HttpPrincipal} parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssetTagServiceSoap
 * @see HttpPrincipal
 * @see AssetTagServiceUtil
 * @generated
 */
@ProviderType
public class AssetTagServiceHttp {
	public static com.liferay.asset.kernel.model.AssetTag addTag(
		HttpPrincipal httpPrincipal, long groupId, String name,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(AssetTagServiceUtil.class,
					"addTag", _addTagParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					name, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.asset.kernel.model.AssetTag)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static void deleteTag(HttpPrincipal httpPrincipal, long tagId)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(AssetTagServiceUtil.class,
					"deleteTag", _deleteTagParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, tagId);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static void deleteTags(HttpPrincipal httpPrincipal, long[] tagIds)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(AssetTagServiceUtil.class,
					"deleteTags", _deleteTagsParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, tagIds);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.asset.kernel.model.AssetTag> getGroupsTags(
		HttpPrincipal httpPrincipal, long[] groupIds) {
		try {
			MethodKey methodKey = new MethodKey(AssetTagServiceUtil.class,
					"getGroupsTags", _getGroupsTagsParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupIds);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.liferay.asset.kernel.model.AssetTag>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.asset.kernel.model.AssetTag> getGroupTags(
		HttpPrincipal httpPrincipal, long groupId) {
		try {
			MethodKey methodKey = new MethodKey(AssetTagServiceUtil.class,
					"getGroupTags", _getGroupTagsParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.liferay.asset.kernel.model.AssetTag>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.asset.kernel.model.AssetTag> getGroupTags(
		HttpPrincipal httpPrincipal, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.asset.kernel.model.AssetTag> obc) {
		try {
			MethodKey methodKey = new MethodKey(AssetTagServiceUtil.class,
					"getGroupTags", _getGroupTagsParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					start, end, obc);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.liferay.asset.kernel.model.AssetTag>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int getGroupTagsCount(HttpPrincipal httpPrincipal,
		long groupId) {
		try {
			MethodKey methodKey = new MethodKey(AssetTagServiceUtil.class,
					"getGroupTagsCount", _getGroupTagsCountParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.asset.kernel.model.AssetTagDisplay getGroupTagsDisplay(
		HttpPrincipal httpPrincipal, long groupId, String name, int start,
		int end) {
		try {
			MethodKey methodKey = new MethodKey(AssetTagServiceUtil.class,
					"getGroupTagsDisplay", _getGroupTagsDisplayParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					name, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.asset.kernel.model.AssetTagDisplay)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.asset.kernel.model.AssetTag getTag(
		HttpPrincipal httpPrincipal, long tagId)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(AssetTagServiceUtil.class,
					"getTag", _getTagParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(methodKey, tagId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.asset.kernel.model.AssetTag)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int getTagsCount(HttpPrincipal httpPrincipal,
		long classNameId, long classPK) {
		try {
			MethodKey methodKey = new MethodKey(AssetTagServiceUtil.class,
					"getTagsCount", _getTagsCountParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					classNameId, classPK);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int getTagsCount(HttpPrincipal httpPrincipal,
		String className, long classPK) {
		try {
			MethodKey methodKey = new MethodKey(AssetTagServiceUtil.class,
					"getTagsCount", _getTagsCountParameterTypes10);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					className, classPK);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.asset.kernel.model.AssetTag> getTags(
		HttpPrincipal httpPrincipal, long groupId, long classNameId, String name) {
		try {
			MethodKey methodKey = new MethodKey(AssetTagServiceUtil.class,
					"getTags", _getTagsParameterTypes11);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					classNameId, name);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.liferay.asset.kernel.model.AssetTag>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.asset.kernel.model.AssetTag> getTags(
		HttpPrincipal httpPrincipal, long groupId, long classNameId,
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.asset.kernel.model.AssetTag> obc) {
		try {
			MethodKey methodKey = new MethodKey(AssetTagServiceUtil.class,
					"getTags", _getTagsParameterTypes12);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					classNameId, name, start, end, obc);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.liferay.asset.kernel.model.AssetTag>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.asset.kernel.model.AssetTag> getTags(
		HttpPrincipal httpPrincipal, long groupId, String name, int start,
		int end) {
		try {
			MethodKey methodKey = new MethodKey(AssetTagServiceUtil.class,
					"getTags", _getTagsParameterTypes13);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					name, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.liferay.asset.kernel.model.AssetTag>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.asset.kernel.model.AssetTag> getTags(
		HttpPrincipal httpPrincipal, long groupId, String name, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.asset.kernel.model.AssetTag> obc) {
		try {
			MethodKey methodKey = new MethodKey(AssetTagServiceUtil.class,
					"getTags", _getTagsParameterTypes14);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					name, start, end, obc);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.liferay.asset.kernel.model.AssetTag>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.asset.kernel.model.AssetTag> getTags(
		HttpPrincipal httpPrincipal, long[] groupIds, String name, int start,
		int end) {
		try {
			MethodKey methodKey = new MethodKey(AssetTagServiceUtil.class,
					"getTags", _getTagsParameterTypes15);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					groupIds, name, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.liferay.asset.kernel.model.AssetTag>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.asset.kernel.model.AssetTag> getTags(
		HttpPrincipal httpPrincipal, long[] groupIds, String name, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.asset.kernel.model.AssetTag> obc) {
		try {
			MethodKey methodKey = new MethodKey(AssetTagServiceUtil.class,
					"getTags", _getTagsParameterTypes16);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					groupIds, name, start, end, obc);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.liferay.asset.kernel.model.AssetTag>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.asset.kernel.model.AssetTag> getTags(
		HttpPrincipal httpPrincipal, String className, long classPK) {
		try {
			MethodKey methodKey = new MethodKey(AssetTagServiceUtil.class,
					"getTags", _getTagsParameterTypes17);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					className, classPK);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.liferay.asset.kernel.model.AssetTag>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<com.liferay.asset.kernel.model.AssetTag> getTags(
		HttpPrincipal httpPrincipal, String className, long classPK, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.asset.kernel.model.AssetTag> obc) {
		try {
			MethodKey methodKey = new MethodKey(AssetTagServiceUtil.class,
					"getTags", _getTagsParameterTypes18);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					className, classPK, start, end, obc);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<com.liferay.asset.kernel.model.AssetTag>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int getTagsCount(HttpPrincipal httpPrincipal, long groupId,
		String name) {
		try {
			MethodKey methodKey = new MethodKey(AssetTagServiceUtil.class,
					"getTagsCount", _getTagsCountParameterTypes19);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					name);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int getVisibleAssetsTagsCount(HttpPrincipal httpPrincipal,
		long groupId, long classNameId, String name) {
		try {
			MethodKey methodKey = new MethodKey(AssetTagServiceUtil.class,
					"getVisibleAssetsTagsCount",
					_getVisibleAssetsTagsCountParameterTypes20);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					classNameId, name);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int getVisibleAssetsTagsCount(HttpPrincipal httpPrincipal,
		long groupId, String name) {
		try {
			MethodKey methodKey = new MethodKey(AssetTagServiceUtil.class,
					"getVisibleAssetsTagsCount",
					_getVisibleAssetsTagsCountParameterTypes21);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					name);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static void mergeTags(HttpPrincipal httpPrincipal, long fromTagId,
		long toTagId)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(AssetTagServiceUtil.class,
					"mergeTags", _mergeTagsParameterTypes22);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					fromTagId, toTagId);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static void mergeTags(HttpPrincipal httpPrincipal,
		long[] fromTagIds, long toTagId)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(AssetTagServiceUtil.class,
					"mergeTags", _mergeTagsParameterTypes23);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					fromTagIds, toTagId);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.portal.kernel.json.JSONArray search(
		HttpPrincipal httpPrincipal, long groupId, String name, int start,
		int end) {
		try {
			MethodKey methodKey = new MethodKey(AssetTagServiceUtil.class,
					"search", _searchParameterTypes24);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					name, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.portal.kernel.json.JSONArray)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.portal.kernel.json.JSONArray search(
		HttpPrincipal httpPrincipal, long[] groupIds, String name, int start,
		int end) {
		try {
			MethodKey methodKey = new MethodKey(AssetTagServiceUtil.class,
					"search", _searchParameterTypes25);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					groupIds, name, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.portal.kernel.json.JSONArray)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.asset.kernel.model.AssetTag updateTag(
		HttpPrincipal httpPrincipal, long tagId, String name,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(AssetTagServiceUtil.class,
					"updateTag", _updateTagParameterTypes26);

			MethodHandler methodHandler = new MethodHandler(methodKey, tagId,
					name, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (com.liferay.asset.kernel.model.AssetTag)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(AssetTagServiceHttp.class);
	private static final Class<?>[] _addTagParameterTypes0 = new Class[] {
			long.class, String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deleteTagParameterTypes1 = new Class[] {
			long.class
		};
	private static final Class<?>[] _deleteTagsParameterTypes2 = new Class[] {
			long[].class
		};
	private static final Class<?>[] _getGroupsTagsParameterTypes3 = new Class[] {
			long[].class
		};
	private static final Class<?>[] _getGroupTagsParameterTypes4 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getGroupTagsParameterTypes5 = new Class[] {
			long.class, int.class, int.class,
			com.liferay.portal.kernel.util.OrderByComparator.class
		};
	private static final Class<?>[] _getGroupTagsCountParameterTypes6 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getGroupTagsDisplayParameterTypes7 = new Class[] {
			long.class, String.class, int.class, int.class
		};
	private static final Class<?>[] _getTagParameterTypes8 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getTagsCountParameterTypes9 = new Class[] {
			long.class, long.class
		};
	private static final Class<?>[] _getTagsCountParameterTypes10 = new Class[] {
			String.class, long.class
		};
	private static final Class<?>[] _getTagsParameterTypes11 = new Class[] {
			long.class, long.class, String.class
		};
	private static final Class<?>[] _getTagsParameterTypes12 = new Class[] {
			long.class, long.class, String.class, int.class, int.class,
			com.liferay.portal.kernel.util.OrderByComparator.class
		};
	private static final Class<?>[] _getTagsParameterTypes13 = new Class[] {
			long.class, String.class, int.class, int.class
		};
	private static final Class<?>[] _getTagsParameterTypes14 = new Class[] {
			long.class, String.class, int.class, int.class,
			com.liferay.portal.kernel.util.OrderByComparator.class
		};
	private static final Class<?>[] _getTagsParameterTypes15 = new Class[] {
			long[].class, String.class, int.class, int.class
		};
	private static final Class<?>[] _getTagsParameterTypes16 = new Class[] {
			long[].class, String.class, int.class, int.class,
			com.liferay.portal.kernel.util.OrderByComparator.class
		};
	private static final Class<?>[] _getTagsParameterTypes17 = new Class[] {
			String.class, long.class
		};
	private static final Class<?>[] _getTagsParameterTypes18 = new Class[] {
			String.class, long.class, int.class, int.class,
			com.liferay.portal.kernel.util.OrderByComparator.class
		};
	private static final Class<?>[] _getTagsCountParameterTypes19 = new Class[] {
			long.class, String.class
		};
	private static final Class<?>[] _getVisibleAssetsTagsCountParameterTypes20 = new Class[] {
			long.class, long.class, String.class
		};
	private static final Class<?>[] _getVisibleAssetsTagsCountParameterTypes21 = new Class[] {
			long.class, String.class
		};
	private static final Class<?>[] _mergeTagsParameterTypes22 = new Class[] {
			long.class, long.class
		};
	private static final Class<?>[] _mergeTagsParameterTypes23 = new Class[] {
			long[].class, long.class
		};
	private static final Class<?>[] _searchParameterTypes24 = new Class[] {
			long.class, String.class, int.class, int.class
		};
	private static final Class<?>[] _searchParameterTypes25 = new Class[] {
			long[].class, String.class, int.class, int.class
		};
	private static final Class<?>[] _updateTagParameterTypes26 = new Class[] {
			long.class, String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
}