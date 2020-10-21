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
 * Provides the remote service utility for Stage. This utility wraps
 * <code>com.liferay.travels.service.impl.StageServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Javier de Arcos
 * @see StageService
 * @generated
 */
public class StageServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.travels.service.impl.StageServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.travels.model.Stage addStage(
			long groupId, long userId, long tripId, String name,
			String description, String place, String image)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addStage(
			groupId, userId, tripId, name, description, place, image);
	}

	public static com.liferay.travels.model.Stage deleteStage(long stageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteStage(stageId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.travels.model.Stage getStage(long stageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getStage(stageId);
	}

	public static java.util.List<com.liferay.travels.model.Stage> getStages(
			long tripId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getStages(tripId);
	}

	public static com.liferay.travels.model.Stage updateStage(
			long stageId, String name, String description, String place,
			String image)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateStage(
			stageId, name, description, place, image);
	}

	public static StageService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<StageService, StageService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(StageService.class);

		ServiceTracker<StageService, StageService> serviceTracker =
			new ServiceTracker<StageService, StageService>(
				bundle.getBundleContext(), StageService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}