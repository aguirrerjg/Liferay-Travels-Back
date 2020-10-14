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
	 * Returns the image of this trip.
	 *
	 * @return the image of this trip
	 */
	@Override
	public String getImage() {
		return model.getImage();
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
	 * Sets the description of this trip.
	 *
	 * @param description the description of this trip
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
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
	 * Sets the uuid of this trip.
	 *
	 * @param uuid the uuid of this trip
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected TripWrapper wrap(Trip trip) {
		return new TripWrapper(trip);
	}

}