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

package com.liferay.headless.foundation.internal.resource.v1_0;

import com.liferay.headless.foundation.dto.v1_0.UserAccount;
import com.liferay.headless.foundation.resource.v1_0.UserAccountResource;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.multipart.MultipartBody;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.TransformUtil;

import java.util.Collection;
import java.util.Collections;
import java.util.Dictionary;
import java.util.List;

import javax.annotation.Generated;

import javax.ws.rs.core.UriInfo;

/**
 * @author Javier Gamarra
 * @generated
 */
@Generated("")
public abstract class BaseUserAccountResourceImpl
	implements AopService, UserAccountResource {

	@Override
	public Dictionary<String, Object> getProperties() {
		Dictionary<String, Object> properties = new HashMapDictionary<>();

		properties.put("api.version", "v1.0");
		properties.put(
			"osgi.jaxrs.application.select",
			"(osgi.jaxrs.name=Liferay.Headless.Foundation)");
		properties.put("osgi.jaxrs.resource", true);

		return properties;
	}

	@Override
	public UserAccount getMyUserAccount(Long userAccountId) throws Exception {
		return new UserAccount();
	}

	@Override
	public Page<UserAccount> getOrganizationUserAccountsPage(
			Long organizationId, String search, Filter filter,
			Pagination pagination, Sort[] sorts)
		throws Exception {

		return Page.of(Collections.emptyList());
	}

	@Override
	public Page<UserAccount> getUserAccountsPage(
			String search, Filter filter, Pagination pagination, Sort[] sorts)
		throws Exception {

		return Page.of(Collections.emptyList());
	}

	@Override
	public UserAccount postUserAccount(UserAccount userAccount)
		throws Exception {

		return new UserAccount();
	}

	@Override
	public UserAccount postUserAccount(MultipartBody multipartBody)
		throws Exception {

		return new UserAccount();
	}

	@Override
	public void deleteUserAccount(Long userAccountId) throws Exception {
	}

	@Override
	public UserAccount getUserAccount(Long userAccountId) throws Exception {
		return new UserAccount();
	}

	@Override
	public UserAccount putUserAccount(
			Long userAccountId, UserAccount userAccount)
		throws Exception {

		return new UserAccount();
	}

	@Override
	public Page<UserAccount> getWebSiteUserAccountsPage(
			Long webSiteId, String search, Filter filter, Pagination pagination,
			Sort[] sorts)
		throws Exception {

		return Page.of(Collections.emptyList());
	}

	@Override
	public void setContextAcceptLanguage(AcceptLanguage contextAcceptLanguage) {
		this.contextAcceptLanguage = contextAcceptLanguage;
	}

	@Override
	public void setContextCompany(Company contextCompany) {
		this.contextCompany = contextCompany;
	}

	@Override
	public void setContextUriInfo(UriInfo contextUriInfo) {
		this.contextUriInfo = contextUriInfo;
	}

	protected void preparePatch(
		UserAccount userAccount, UserAccount existingUserAccount) {
	}

	protected <T, R> List<R> transform(
		Collection<T> collection,
		UnsafeFunction<T, R, Exception> unsafeFunction) {

		return TransformUtil.transform(collection, unsafeFunction);
	}

	protected <T, R> R[] transform(
		T[] array, UnsafeFunction<T, R, Exception> unsafeFunction,
		Class<?> clazz) {

		return TransformUtil.transform(array, unsafeFunction, clazz);
	}

	protected <T, R> R[] transformToArray(
		Collection<T> collection,
		UnsafeFunction<T, R, Exception> unsafeFunction, Class<?> clazz) {

		return TransformUtil.transformToArray(
			collection, unsafeFunction, clazz);
	}

	protected <T, R> List<R> transformToList(
		T[] array, UnsafeFunction<T, R, Exception> unsafeFunction) {

		return TransformUtil.transformToList(array, unsafeFunction);
	}

	protected AcceptLanguage contextAcceptLanguage;
	protected Company contextCompany;
	protected UriInfo contextUriInfo;

}