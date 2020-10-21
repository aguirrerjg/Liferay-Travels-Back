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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Trip. This utility wraps
 * <code>com.liferay.travels.service.impl.TripServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Javier de Arcos
 * @see TripService
 * @generated
 */
public class TripServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.travels.service.impl.TripServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.travels.model.Trip addTrip(
			long groupId, long userId, String name, String description,
			java.util.Date startingDate, String image)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addTrip(
			groupId, userId, name, description, startingDate, image);
	}

	public static com.liferay.travels.model.Trip deleteTrip(long tripId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTrip(tripId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.travels.model.Trip getTrip(long tripId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTrip(tripId);
	}

	public static java.util.List<com.liferay.travels.model.Trip> getTrips() {
		return getService().getTrips();
	}

	public static com.liferay.travels.model.Trip updateTrip(
			long groupId, long userId, long tripId, String name,
			String description, java.util.Date startingDate, String image)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateTrip(
			groupId, userId, tripId, name, description, startingDate, image);
	}

	public static TripService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TripService, TripService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TripService.class);

		ServiceTracker<TripService, TripService> serviceTracker =
			new ServiceTracker<TripService, TripService>(
				bundle.getBundleContext(), TripService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}