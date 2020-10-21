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
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.travels.model.Trip;
import com.liferay.travels.service.base.TripLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the trip local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.travels.service.TripLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Javier de Arcos
 * @see TripLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.travels.model.Trip",
	service = AopService.class
)
public class TripLocalServiceImpl extends TripLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	public Trip addTrip(
			long groupId, long userId, String name, String description,
			Date startingDate, String image)
		throws PortalException {

		Group group = groupLocalService.getGroup(groupId);

		long tripId = counterLocalService.increment();

		Trip newTrip = tripPersistence.create(tripId);

		newTrip.setCompanyId(group.getCompanyId());
		newTrip.setDescription(description);
		newTrip.setGroupId(groupId);
		newTrip.setImage(image);
		newTrip.setName(name);
		newTrip.setStartingDate(startingDate);
		newTrip.setUserId(userId);

		resourceLocalService.addResources(
			group.getCompanyId(), groupId, userId, Trip.class.getName(), tripId,
			false, true, true);

		_updateAsset(userId, groupId, tripId);

		return super.addTrip(newTrip);
	}

	@Indexable(type = IndexableType.DELETE)
	public Trip deleteTrip(long tripId) throws PortalException {
		Trip trip = getTrip(tripId);

		resourceLocalService.deleteResource(
			trip.getCompanyId(), Trip.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, tripId);

		assetEntryLocalService.deleteEntry(Trip.class.getName(), tripId);

		return super.deleteTrip(trip);
	}

	public List<Trip> getTrips() {
		return tripPersistence.findAll();
	}

	@Indexable(type = IndexableType.REINDEX)
	public Trip updateTrip(
			long groupId, long userId, long tripId, String name,
			String description, Date startingDate, String image)
		throws PortalException {

		Trip trip = tripPersistence.findByPrimaryKey(tripId);

		trip.setName(name);
		trip.setStartingDate(startingDate);
		trip.setDescription(description);
		trip.setImage(image);

		_updateAsset(userId, groupId, tripId);

		return super.updateTrip(trip);
	}

	private void _updateAsset(Long userId, Long groupId, Long classPK)
		throws PortalException {

		assetEntryLocalService.updateEntry(
			userId, groupId, Trip.class.getName(), classPK, null, null);
	}

}