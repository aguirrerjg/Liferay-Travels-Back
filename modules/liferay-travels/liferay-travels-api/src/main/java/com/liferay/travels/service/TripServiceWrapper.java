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

package com.liferay.travels.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TripService}.
 *
 * @author Javier de Arcos
 * @see TripService
 * @generated
 */
public class TripServiceWrapper
	implements ServiceWrapper<TripService>, TripService {

	public TripServiceWrapper(TripService tripService) {
		_tripService = tripService;
	}

	@Override
	public com.liferay.travels.model.Trip addTrip(
			long groupId, long userId, String name, String description,
			java.util.Date startingDate, String image)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tripService.addTrip(
			groupId, userId, name, description, startingDate, image);
	}

	@Override
	public com.liferay.travels.model.Trip deleteTrip(long tripId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tripService.deleteTrip(tripId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _tripService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.travels.model.Trip getTrip(long tripId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tripService.getTrip(tripId);
	}

	@Override
	public java.util.List<com.liferay.travels.model.Trip> getTrips() {
		return _tripService.getTrips();
	}

	@Override
	public com.liferay.travels.model.Trip updateTrip(
			long groupId, long userId, long tripId, String name,
			String description, java.util.Date startingDate, String image)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tripService.updateTrip(
			groupId, userId, tripId, name, description, startingDate, image);
	}

	@Override
	public TripService getWrappedService() {
		return _tripService;
	}

	@Override
	public void setWrappedService(TripService tripService) {
		_tripService = tripService;
	}

	private TripService _tripService;

}