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

package com.liferay.travels.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.travels.model.Stage;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Stage in entity cache.
 *
 * @author Javier de Arcos
 * @generated
 */
public class StageCacheModel implements CacheModel<Stage>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof StageCacheModel)) {
			return false;
		}

		StageCacheModel stageCacheModel = (StageCacheModel)object;

		if (stageId == stageCacheModel.stageId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, stageId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", stageId=");
		sb.append(stageId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", place=");
		sb.append(place);
		sb.append(", image=");
		sb.append(image);
		sb.append(", tripId=");
		sb.append(tripId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Stage toEntityModel() {
		StageImpl stageImpl = new StageImpl();

		if (uuid == null) {
			stageImpl.setUuid("");
		}
		else {
			stageImpl.setUuid(uuid);
		}

		stageImpl.setStageId(stageId);

		if (name == null) {
			stageImpl.setName("");
		}
		else {
			stageImpl.setName(name);
		}

		if (description == null) {
			stageImpl.setDescription("");
		}
		else {
			stageImpl.setDescription(description);
		}

		if (place == null) {
			stageImpl.setPlace("");
		}
		else {
			stageImpl.setPlace(place);
		}

		if (image == null) {
			stageImpl.setImage("");
		}
		else {
			stageImpl.setImage(image);
		}

		stageImpl.setTripId(tripId);
		stageImpl.setGroupId(groupId);
		stageImpl.setUserId(userId);

		if (userName == null) {
			stageImpl.setUserName("");
		}
		else {
			stageImpl.setUserName(userName);
		}

		stageImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			stageImpl.setCreateDate(null);
		}
		else {
			stageImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			stageImpl.setModifiedDate(null);
		}
		else {
			stageImpl.setModifiedDate(new Date(modifiedDate));
		}

		stageImpl.resetOriginalValues();

		return stageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		stageId = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		place = objectInput.readUTF();
		image = objectInput.readUTF();

		tripId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(stageId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (place == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(place);
		}

		if (image == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(image);
		}

		objectOutput.writeLong(tripId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long stageId;
	public String name;
	public String description;
	public String place;
	public String image;
	public long tripId;
	public long groupId;
	public long userId;
	public String userName;
	public long companyId;
	public long createDate;
	public long modifiedDate;

}