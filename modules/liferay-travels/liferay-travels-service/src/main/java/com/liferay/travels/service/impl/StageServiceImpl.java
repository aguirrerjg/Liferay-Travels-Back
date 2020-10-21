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
import com.liferay.travels.constants.TravelsConstants;
import com.liferay.travels.model.Stage;
import com.liferay.travels.model.Trip;
import com.liferay.travels.service.base.StageServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * The implementation of the stage remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.travels.service.StageService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Javier de Arcos
 * @see StageServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=LiferayTravel",
		"json.web.service.context.path=Stage"
	},
	service = AopService.class
)
public class StageServiceImpl extends StageServiceBaseImpl {

	public Stage addStage(
			long groupId, long userId, long tripId, String name,
			String description, String place, String image)
		throws PortalException {

		_tripModelResourcePermission.check(
			getPermissionChecker(), tripId, "ADD_STAGE");

		return stageLocalService.addStage(
			groupId, userId, tripId, name, description, place, image);
	}

	public Stage deleteStage(long stageId) throws PortalException {
		_stageModelResourcePermission.check(
			getPermissionChecker(), stageId, ActionKeys.DELETE);

		return stageLocalService.deleteStage(stageId);
	}

	public Stage getStage(long stageId) throws PortalException {
		_stageModelResourcePermission.check(
			getPermissionChecker(), stageId, ActionKeys.VIEW);

		return stageLocalService.getStage(stageId);
	}

	public List<Stage> getStages(long tripId) throws PortalException {
		_tripModelResourcePermission.check(
			getPermissionChecker(), tripId, ActionKeys.VIEW);

		return stageLocalService.getStages(tripId);
	}

	public Stage updateStage(
			long stageId, String name, String description, String place,
			String image)
		throws PortalException {

		_stageModelResourcePermission.check(
			getPermissionChecker(), stageId, ActionKeys.UPDATE);

		return stageLocalService.updateStage(
			stageId, name, description, place, image);
	}

	@Reference(
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY,
		target = "(model.class.name=" + TravelsConstants.RESOURCE_NAME + ".Stage)"
	)
	private volatile ModelResourcePermission<Stage>
		_stageModelResourcePermission;

	@Reference(
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY,
		target = "(model.class.name=" + TravelsConstants.RESOURCE_NAME + ".Trip)"
	)
	private volatile ModelResourcePermission<Trip> _tripModelResourcePermission;

}