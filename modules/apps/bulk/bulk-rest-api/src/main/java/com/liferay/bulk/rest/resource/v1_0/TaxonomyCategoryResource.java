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

package com.liferay.bulk.rest.resource.v1_0;

import com.liferay.bulk.rest.dto.v1_0.TaxonomyCategoryBulkSelection;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

import javax.annotation.Generated;

import javax.ws.rs.Consumes;
import javax.ws.rs.PATCH;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * To access this resource, run:
 *
 *     curl -u your@email.com:yourpassword -D - http://localhost:8080/o/bulk-rest/v1.0
 *
 * @author Alejandro Tardín
 * @generated
 */
@Generated("")
@Path("/v1.0")
public interface TaxonomyCategoryResource {

	@Consumes("application/json")
	@PATCH
	@Path("/taxonomy-categories/batch")
	@Tags(value = {@Tag(name = "TaxonomyCategory")})
	public Response patchTaxonomyCategoryBatch(
			TaxonomyCategoryBulkSelection taxonomyCategoryBulkSelection)
		throws Exception;

	@Consumes("application/json")
	@PUT
	@Path("/taxonomy-categories/batch")
	@Tags(value = {@Tag(name = "TaxonomyCategory")})
	public Response putTaxonomyCategoryBatch(
			TaxonomyCategoryBulkSelection taxonomyCategoryBulkSelection)
		throws Exception;

	@Context
	public void setContextAcceptLanguage(AcceptLanguage contextAcceptLanguage);

	@Context
	public void setContextCompany(Company contextCompany);

	@Context
	public void setContextUriInfo(UriInfo contextUriInfo);

}