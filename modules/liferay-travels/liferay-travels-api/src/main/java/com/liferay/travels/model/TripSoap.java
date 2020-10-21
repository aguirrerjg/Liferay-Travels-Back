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

package com.liferay.travels.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.travels.service.http.TripServiceSoap}.
 *
 * @author Javier de Arcos
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class TripSoap implements Serializable {

	public static TripSoap toSoapModel(Trip model) {
		TripSoap soapModel = new TripSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setTripId(model.getTripId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setStartingDate(model.getStartingDate());
		soapModel.setImage(model.getImage());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static TripSoap[] toSoapModels(Trip[] models) {
		TripSoap[] soapModels = new TripSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TripSoap[][] toSoapModels(Trip[][] models) {
		TripSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TripSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TripSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TripSoap[] toSoapModels(List<Trip> models) {
		List<TripSoap> soapModels = new ArrayList<TripSoap>(models.size());

		for (Trip model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TripSoap[soapModels.size()]);
	}

	public TripSoap() {
	}

	public long getPrimaryKey() {
		return _tripId;
	}

	public void setPrimaryKey(long pk) {
		setTripId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getTripId() {
		return _tripId;
	}

	public void setTripId(long tripId) {
		_tripId = tripId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public Date getStartingDate() {
		return _startingDate;
	}

	public void setStartingDate(Date startingDate) {
		_startingDate = startingDate;
	}

	public String getImage() {
		return _image;
	}

	public void setImage(String image) {
		_image = image;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private String _uuid;
	private long _tripId;
	private String _name;
	private String _description;
	private Date _startingDate;
	private String _image;
	private long _groupId;
	private long _userId;
	private String _userName;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;

}