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

package com.liferay.travels.internal.security.permission.resource.definition;

import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.StagedModelPermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.definition.ModelResourcePermissionDefinition;
import com.liferay.travels.constants.TravelsConstants;
import com.liferay.travels.model.Trip;
import com.liferay.travels.service.TripLocalService;

import java.util.function.Consumer;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Javier de Arcos
 */
@Component(immediate = true, service = ModelResourcePermissionDefinition.class)
public class TripModelResourcePermissionDefinition
	implements ModelResourcePermissionDefinition<Trip> {

	@Override
	public Trip getModel(long primaryKey) throws PortalException {
		return _tripLocalService.getTrip(primaryKey);
	}

	@Override
	public Class<Trip> getModelClass() {
		return Trip.class;
	}

	@Override
	public PortletResourcePermission getPortletResourcePermission() {
		return _portletResourcePermission;
	}

	@Override
	public long getPrimaryKey(Trip trip) {
		return trip.getTripId();
	}

	@Override
	public void registerModelResourcePermissionLogics(
		ModelResourcePermission<Trip> modelResourcePermission,
		Consumer<ModelResourcePermissionLogic<Trip>>
			modelResourcePermissionLogicConsumer) {

		modelResourcePermissionLogicConsumer.accept(
			new StagedModelPermissionLogic<>(
				_stagingPermission,
				"com_liferay_travels_web_LiferayTravelsPortlet",
				Trip::getTripId));
	}

	@Reference(
		target = "(resource.name=" + TravelsConstants.RESOURCE_NAME + ")"
	)
	private PortletResourcePermission _portletResourcePermission;

	@Reference
	private StagingPermission _stagingPermission;

	@Reference
	private TripLocalService _tripLocalService;

}