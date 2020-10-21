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
 * Provides a wrapper for {@link StageService}.
 *
 * @author Javier de Arcos
 * @see StageService
 * @generated
 */
public class StageServiceWrapper
	implements ServiceWrapper<StageService>, StageService {

	public StageServiceWrapper(StageService stageService) {
		_stageService = stageService;
	}

	@Override
	public com.liferay.travels.model.Stage addStage(
			long groupId, long userId, long tripId, String name,
			String description, String place, String image)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stageService.addStage(
			groupId, userId, tripId, name, description, place, image);
	}

	@Override
	public com.liferay.travels.model.Stage deleteStage(long stageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stageService.deleteStage(stageId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _stageService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.travels.model.Stage getStage(long stageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stageService.getStage(stageId);
	}

	@Override
	public java.util.List<com.liferay.travels.model.Stage> getStages(
			long tripId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stageService.getStages(tripId);
	}

	@Override
	public com.liferay.travels.model.Stage updateStage(
			long stageId, String name, String description, String place,
			String image)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stageService.updateStage(
			stageId, name, description, place, image);
	}

	@Override
	public StageService getWrappedService() {
		return _stageService;
	}

	@Override
	public void setWrappedService(StageService stageService) {
		_stageService = stageService;
	}

	private StageService _stageService;

}