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

package com.liferay.change.tracking.model.impl;

import com.liferay.change.tracking.model.CTProcess;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing CTProcess in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CTProcessCacheModel
	implements CacheModel<CTProcess>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CTProcessCacheModel)) {
			return false;
		}

		CTProcessCacheModel ctProcessCacheModel = (CTProcessCacheModel)obj;

		if (ctProcessId == ctProcessCacheModel.ctProcessId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ctProcessId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{ctProcessId=");
		sb.append(ctProcessId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", ctCollectionId=");
		sb.append(ctCollectionId);
		sb.append(", backgroundTaskId=");
		sb.append(backgroundTaskId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CTProcess toEntityModel() {
		CTProcessImpl ctProcessImpl = new CTProcessImpl();

		ctProcessImpl.setCtProcessId(ctProcessId);
		ctProcessImpl.setCompanyId(companyId);
		ctProcessImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			ctProcessImpl.setCreateDate(null);
		}
		else {
			ctProcessImpl.setCreateDate(new Date(createDate));
		}

		ctProcessImpl.setCtCollectionId(ctCollectionId);
		ctProcessImpl.setBackgroundTaskId(backgroundTaskId);

		ctProcessImpl.resetOriginalValues();

		return ctProcessImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ctProcessId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();

		ctCollectionId = objectInput.readLong();

		backgroundTaskId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ctProcessId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(ctCollectionId);

		objectOutput.writeLong(backgroundTaskId);
	}

	public long ctProcessId;
	public long companyId;
	public long userId;
	public long createDate;
	public long ctCollectionId;
	public long backgroundTaskId;

}