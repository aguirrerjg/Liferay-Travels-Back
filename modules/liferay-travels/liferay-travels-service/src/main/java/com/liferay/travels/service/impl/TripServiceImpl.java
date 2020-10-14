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

package com.liferay.travels.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.travels.model.Trip;
import com.liferay.travels.service.base.TripServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the trip remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.travel.service.TripService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Javier de Arcos
 * @see TripServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=foo",
		"json.web.service.context.path=Trip"
	},
	service = AopService.class
)
public class TripServiceImpl extends TripServiceBaseImpl {

	public Trip addTrip(
		String name, String description, Date startingDate, String image) {

		return tripLocalService.addTrip(name, description, startingDate, image);
	}

	public Trip deleteTrip(long tripId) throws PortalException {
		return tripLocalService.deleteTrip(tripId);
	}

	public Trip getTrip(long tripId) throws PortalException {
		return tripLocalService.getTrip(tripId);
	}

	public List<Trip> getTrips() {
		return tripLocalService.getTrips();
	}

	public Trip updateTrip(
			long tripId, String name, String description, Date startingDate,
			String image)
		throws PortalException {

		return tripLocalService.updateTrip(
			tripId, name, description, startingDate, image);
	}

}