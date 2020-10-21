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
import com.liferay.travels.model.Trip;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Trip in entity cache.
 *
 * @author Javier de Arcos
 * @generated
 */
public class TripCacheModel implements CacheModel<Trip>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TripCacheModel)) {
			return false;
		}

		TripCacheModel tripCacheModel = (TripCacheModel)object;

		if (tripId == tripCacheModel.tripId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, tripId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", tripId=");
		sb.append(tripId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", startingDate=");
		sb.append(startingDate);
		sb.append(", image=");
		sb.append(image);
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
	public Trip toEntityModel() {
		TripImpl tripImpl = new TripImpl();

		if (uuid == null) {
			tripImpl.setUuid("");
		}
		else {
			tripImpl.setUuid(uuid);
		}

		tripImpl.setTripId(tripId);

		if (name == null) {
			tripImpl.setName("");
		}
		else {
			tripImpl.setName(name);
		}

		if (description == null) {
			tripImpl.setDescription("");
		}
		else {
			tripImpl.setDescription(description);
		}

		if (startingDate == Long.MIN_VALUE) {
			tripImpl.setStartingDate(null);
		}
		else {
			tripImpl.setStartingDate(new Date(startingDate));
		}

		if (image == null) {
			tripImpl.setImage("");
		}
		else {
			tripImpl.setImage(image);
		}

		tripImpl.setGroupId(groupId);
		tripImpl.setUserId(userId);

		if (userName == null) {
			tripImpl.setUserName("");
		}
		else {
			tripImpl.setUserName(userName);
		}

		tripImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			tripImpl.setCreateDate(null);
		}
		else {
			tripImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			tripImpl.setModifiedDate(null);
		}
		else {
			tripImpl.setModifiedDate(new Date(modifiedDate));
		}

		tripImpl.resetOriginalValues();

		return tripImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		tripId = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		startingDate = objectInput.readLong();
		image = objectInput.readUTF();

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

		objectOutput.writeLong(tripId);

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

		objectOutput.writeLong(startingDate);

		if (image == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(image);
		}

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
	public long tripId;
	public String name;
	public String description;
	public long startingDate;
	public String image;
	public long groupId;
	public long userId;
	public String userName;
	public long companyId;
	public long createDate;
	public long modifiedDate;

}