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
	 * Returns the image of this stage.
	 *
	 * @return the image of this stage
	 */
	@Override
	public String getImage() {
		return model.getImage();
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
	 * Sets the description of this stage.
	 *
	 * @param description the description of this stage
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
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
	 * Sets the uuid of this stage.
	 *
	 * @param uuid the uuid of this stage
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected StageWrapper wrap(Stage stage) {
		return new StageWrapper(stage);
	}

}