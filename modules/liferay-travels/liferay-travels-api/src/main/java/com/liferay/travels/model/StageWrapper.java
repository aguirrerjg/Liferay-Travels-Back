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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Stage}.
 * </p>
 *
 * @author Javier de Arcos
 * @see Stage
 * @generated
 */
public class StageWrapper
	extends BaseModelWrapper<Stage> implements ModelWrapper<Stage>, Stage {

	public StageWrapper(Stage stage) {
		super(stage);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("stageId", getStageId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("place", getPlace());
		attributes.put("image", getImage());
		attributes.put("tripId", getTripId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long stageId = (Long)attributes.get("stageId");

		if (stageId != null) {
			setStageId(stageId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String place = (String)attributes.get("place");

		if (place != null) {
			setPlace(place);
		}

		String image = (String)attributes.get("image");

		if (image != null) {
			setImage(image);
		}

		Long tripId = (Long)attributes.get("tripId");

		if (tripId != null) {
			setTripId(tripId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	 * Returns the company ID of this stage.
	 *
	 * @return the company ID of this stage
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this stage.
	 *
	 * @return the create date of this stage
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this stage.
	 *
	 * @return the description of this stage
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this stage.
	 *
	 * @return the group ID of this stage
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the image of this stage.
	 *
	 * @return the image of this stage
	 */
	@Override
	public String getImage() {
		return model.getImage();
	}

	/**
	 * Returns the modified date of this stage.
	 *
	 * @return the modified date of this stage
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this stage.
	 *
	 * @return the name of this stage
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the place of this stage.
	 *
	 * @return the place of this stage
	 */
	@Override
	public String getPlace() {
		return model.getPlace();
	}

	/**
	 * Returns the primary key of this stage.
	 *
	 * @return the primary key of this stage
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the stage ID of this stage.
	 *
	 * @return the stage ID of this stage
	 */
	@Override
	public long getStageId() {
		return model.getStageId();
	}

	/**
	 * Returns the trip ID of this stage.
	 *
	 * @return the trip ID of this stage
	 */
	@Override
	public long getTripId() {
		return model.getTripId();
	}

	/**
	 * Returns the user ID of this stage.
	 *
	 * @return the user ID of this stage
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this stage.
	 *
	 * @return the user name of this stage
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this stage.
	 *
	 * @return the user uuid of this stage
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this stage.
	 *
	 * @return the uuid of this stage
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this stage.
	 *
	 * @param companyId the company ID of this stage
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this stage.
	 *
	 * @param createDate the create date of this stage
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this stage.
	 *
	 * @param description the description of this stage
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this stage.
	 *
	 * @param groupId the group ID of this stage
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the image of this stage.
	 *
	 * @param image the image of this stage
	 */
	@Override
	public void setImage(String image) {
		model.setImage(image);
	}

	/**
	 * Sets the modified date of this stage.
	 *
	 * @param modifiedDate the modified date of this stage
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this stage.
	 *
	 * @param name the name of this stage
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the place of this stage.
	 *
	 * @param place the place of this stage
	 */
	@Override
	public void setPlace(String place) {
		model.setPlace(place);
	}

	/**
	 * Sets the primary key of this stage.
	 *
	 * @param primaryKey the primary key of this stage
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the stage ID of this stage.
	 *
	 * @param stageId the stage ID of this stage
	 */
	@Override
	public void setStageId(long stageId) {
		model.setStageId(stageId);
	}

	/**
	 * Sets the trip ID of this stage.
	 *
	 * @param tripId the trip ID of this stage
	 */
	@Override
	public void setTripId(long tripId) {
		model.setTripId(tripId);
	}

	/**
	 * Sets the user ID of this stage.
	 *
	 * @param userId the user ID of this stage
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this stage.
	 *
	 * @param userName the user name of this stage
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this stage.
	 *
	 * @param userUuid the user uuid of this stage
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this stage.
	 *
	 * @param uuid the uuid of this stage
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected StageWrapper wrap(Stage stage) {
		return new StageWrapper(stage);
	}

}