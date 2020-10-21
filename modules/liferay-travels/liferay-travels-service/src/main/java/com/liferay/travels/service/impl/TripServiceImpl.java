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
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.travels.constants.TravelsConstants;
import com.liferay.travels.model.Trip;
import com.liferay.travels.service.base.TripServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * The implementation of the trip remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.travels.service.TripService</code> interface.
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
			long groupId, long userId, String name, String description,
			Date startingDate, String image)
		throws PortalException {

		_portletResourcePermission.check(
			getPermissionChecker(), groupId, ActionKeys.ADD_ENTRY);

		return tripLocalService.addTrip(
			groupId, userId, name, description, startingDate, image);
	}

	public Trip deleteTrip(long tripId) throws PortalException {
		_tripModelResourcePermission.check(
			getPermissionChecker(), tripId, ActionKeys.DELETE);

		return tripLocalService.deleteTrip(tripId);
	}

	public Trip getTrip(long tripId) throws PortalException {
		_tripModelResourcePermission.check(
			getPermissionChecker(), tripId, ActionKeys.VIEW);

		return tripLocalService.getTrip(tripId);
	}

	public List<Trip> getTrips() {
		return tripLocalService.getTrips();
	}

	public Trip updateTrip(
			long groupId, long userId, long tripId, String name,
			String description, Date startingDate, String image)
		throws PortalException {

		_tripModelResourcePermission.check(
			getPermissionChecker(), tripId, ActionKeys.UPDATE);

		return tripLocalService.updateTrip(
			groupId, userId, tripId, name, description, startingDate, image);
	}

	@Reference(
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY,
		target = "(resource.name=" + TravelsConstants.RESOURCE_NAME + ")"
	)
	private volatile PortletResourcePermission _portletResourcePermission;

	@Reference(
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY,
		target = "(model.class.name=" + TravelsConstants.RESOURCE_NAME + ".Trip)"
	)
	private volatile ModelResourcePermission<Trip> _tripModelResourcePermission;

}