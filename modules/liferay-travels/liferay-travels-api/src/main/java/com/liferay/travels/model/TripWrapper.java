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
 * This class is a wrapper for {@link Trip}.
 * </p>
 *
 * @author Javier de Arcos
 * @see Trip
 * @generated
 */
public class TripWrapper
	extends BaseModelWrapper<Trip> implements ModelWrapper<Trip>, Trip {

	public TripWrapper(Trip trip) {
		super(trip);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("tripId", getTripId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("startingDate", getStartingDate());
		attributes.put("image", getImage());
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

		Long tripId = (Long)attributes.get("tripId");

		if (tripId != null) {
			setTripId(tripId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date startingDate = (Date)attributes.get("startingDate");

		if (startingDate != null) {
			setStartingDate(startingDate);
		}

		String image = (String)attributes.get("image");

		if (image != null) {
			setImage(image);
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
	 * Returns the company ID of this trip.
	 *
	 * @return the company ID of this trip
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this trip.
	 *
	 * @return the create date of this trip
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this trip.
	 *
	 * @return the description of this trip
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this trip.
	 *
	 * @return the group ID of this trip
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the image of this trip.
	 *
	 * @return the image of this trip
	 */
	@Override
	public String getImage() {
		return model.getImage();
	}

	/**
	 * Returns the modified date of this trip.
	 *
	 * @return the modified date of this trip
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this trip.
	 *
	 * @return the name of this trip
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this trip.
	 *
	 * @return the primary key of this trip
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the starting date of this trip.
	 *
	 * @return the starting date of this trip
	 */
	@Override
	public Date getStartingDate() {
		return model.getStartingDate();
	}

	/**
	 * Returns the trip ID of this trip.
	 *
	 * @return the trip ID of this trip
	 */
	@Override
	public long getTripId() {
		return model.getTripId();
	}

	/**
	 * Returns the user ID of this trip.
	 *
	 * @return the user ID of this trip
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this trip.
	 *
	 * @return the user name of this trip
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this trip.
	 *
	 * @return the user uuid of this trip
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this trip.
	 *
	 * @return the uuid of this trip
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
	 * Sets the company ID of this trip.
	 *
	 * @param companyId the company ID of this trip
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this trip.
	 *
	 * @param createDate the create date of this trip
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this trip.
	 *
	 * @param description the description of this trip
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this trip.
	 *
	 * @param groupId the group ID of this trip
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the image of this trip.
	 *
	 * @param image the image of this trip
	 */
	@Override
	public void setImage(String image) {
		model.setImage(image);
	}

	/**
	 * Sets the modified date of this trip.
	 *
	 * @param modifiedDate the modified date of this trip
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this trip.
	 *
	 * @param name the name of this trip
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this trip.
	 *
	 * @param primaryKey the primary key of this trip
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the starting date of this trip.
	 *
	 * @param startingDate the starting date of this trip
	 */
	@Override
	public void setStartingDate(Date startingDate) {
		model.setStartingDate(startingDate);
	}

	/**
	 * Sets the trip ID of this trip.
	 *
	 * @param tripId the trip ID of this trip
	 */
	@Override
	public void setTripId(long tripId) {
		model.setTripId(tripId);
	}

	/**
	 * Sets the user ID of this trip.
	 *
	 * @param userId the user ID of this trip
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this trip.
	 *
	 * @param userName the user name of this trip
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this trip.
	 *
	 * @param userUuid the user uuid of this trip
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this trip.
	 *
	 * @param uuid the uuid of this trip
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
	protected TripWrapper wrap(Trip trip) {
		return new TripWrapper(trip);
	}

}