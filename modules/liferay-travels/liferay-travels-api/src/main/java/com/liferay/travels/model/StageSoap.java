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
 * This class is used by SOAP remote services, specifically {@link com.liferay.travels.service.http.StageServiceSoap}.
 *
 * @author Javier de Arcos
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class StageSoap implements Serializable {

	public static StageSoap toSoapModel(Stage model) {
		StageSoap soapModel = new StageSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setStageId(model.getStageId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setPlace(model.getPlace());
		soapModel.setImage(model.getImage());
		soapModel.setTripId(model.getTripId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static StageSoap[] toSoapModels(Stage[] models) {
		StageSoap[] soapModels = new StageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StageSoap[][] toSoapModels(Stage[][] models) {
		StageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StageSoap[] toSoapModels(List<Stage> models) {
		List<StageSoap> soapModels = new ArrayList<StageSoap>(models.size());

		for (Stage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StageSoap[soapModels.size()]);
	}

	public StageSoap() {
	}

	public long getPrimaryKey() {
		return _stageId;
	}

	public void setPrimaryKey(long pk) {
		setStageId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getStageId() {
		return _stageId;
	}

	public void setStageId(long stageId) {
		_stageId = stageId;
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

	public String getPlace() {
		return _place;
	}

	public void setPlace(String place) {
		_place = place;
	}

	public String getImage() {
		return _image;
	}

	public void setImage(String image) {
		_image = image;
	}

	public long getTripId() {
		return _tripId;
	}

	public void setTripId(long tripId) {
		_tripId = tripId;
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
	private long _stageId;
	private String _name;
	private String _description;
	private String _place;
	private String _image;
	private long _tripId;
	private long _groupId;
	private long _userId;
	private String _userName;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;

}