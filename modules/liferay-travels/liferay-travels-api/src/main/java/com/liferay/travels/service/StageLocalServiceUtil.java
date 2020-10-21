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
 * Provides the local service utility for Stage. This utility wraps
 * <code>com.liferay.travels.service.impl.StageLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Javier de Arcos
 * @see StageLocalService
 * @generated
 */
public class StageLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.travels.service.impl.StageLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.travels.model.Stage addStage(
			long groupId, long userId, long tripId, String name,
			String description, String place, String image)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addStage(
			groupId, userId, tripId, name, description, place, image);
	}

	/**
	 * Adds the stage to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stage the stage
	 * @return the stage that was added
	 */
	public static com.liferay.travels.model.Stage addStage(
		com.liferay.travels.model.Stage stage) {

		return getService().addStage(stage);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new stage with the primary key. Does not add the stage to the database.
	 *
	 * @param stageId the primary key for the new stage
	 * @return the new stage
	 */
	public static com.liferay.travels.model.Stage createStage(long stageId) {
		return getService().createStage(stageId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the stage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stageId the primary key of the stage
	 * @return the stage that was removed
	 * @throws PortalException if a stage with the primary key could not be found
	 */
	public static com.liferay.travels.model.Stage deleteStage(long stageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteStage(stageId);
	}

	/**
	 * Deletes the stage from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stage the stage
	 * @return the stage that was removed
	 */
	public static com.liferay.travels.model.Stage deleteStage(
		com.liferay.travels.model.Stage stage) {

		return getService().deleteStage(stage);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.travels.model.impl.StageModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.travels.model.impl.StageModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.travels.model.Stage fetchStage(long stageId) {
		return getService().fetchStage(stageId);
	}

	/**
	 * Returns the stage matching the UUID and group.
	 *
	 * @param uuid the stage's UUID
	 * @param groupId the primary key of the group
	 * @return the matching stage, or <code>null</code> if a matching stage could not be found
	 */
	public static com.liferay.travels.model.Stage fetchStageByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchStageByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the stage with the primary key.
	 *
	 * @param stageId the primary key of the stage
	 * @return the stage
	 * @throws PortalException if a stage with the primary key could not be found
	 */
	public static com.liferay.travels.model.Stage getStage(long stageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getStage(stageId);
	}

	/**
	 * Returns the stage matching the UUID and group.
	 *
	 * @param uuid the stage's UUID
	 * @param groupId the primary key of the group
	 * @return the matching stage
	 * @throws PortalException if a matching stage could not be found
	 */
	public static com.liferay.travels.model.Stage getStageByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getStageByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the stages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.travels.model.impl.StageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stages
	 * @param end the upper bound of the range of stages (not inclusive)
	 * @return the range of stages
	 */
	public static java.util.List<com.liferay.travels.model.Stage> getStages(
		int start, int end) {

		return getService().getStages(start, end);
	}

	public static java.util.List<com.liferay.travels.model.Stage> getStages(
		long tripId) {

		return getService().getStages(tripId);
	}

	/**
	 * Returns all the stages matching the UUID and company.
	 *
	 * @param uuid the UUID of the stages
	 * @param companyId the primary key of the company
	 * @return the matching stages, or an empty list if no matches were found
	 */
	public static java.util.List<com.liferay.travels.model.Stage>
		getStagesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getStagesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of stages matching the UUID and company.
	 *
	 * @param uuid the UUID of the stages
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of stages
	 * @param end the upper bound of the range of stages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching stages, or an empty list if no matches were found
	 */
	public static java.util.List<com.liferay.travels.model.Stage>
		getStagesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.travels.model.Stage> orderByComparator) {

		return getService().getStagesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of stages.
	 *
	 * @return the number of stages
	 */
	public static int getStagesCount() {
		return getService().getStagesCount();
	}

	public static com.liferay.travels.model.Stage updateStage(
			long stageId, String name, String description, String place,
			String image)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateStage(
			stageId, name, description, place, image);
	}

	/**
	 * Updates the stage in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stage the stage
	 * @return the stage that was updated
	 */
	public static com.liferay.travels.model.Stage updateStage(
		com.liferay.travels.model.Stage stage) {

		return getService().updateStage(stage);
	}

	public static StageLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<StageLocalService, StageLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(StageLocalService.class);

		ServiceTracker<StageLocalService, StageLocalService> serviceTracker =
			new ServiceTracker<StageLocalService, StageLocalService>(
				bundle.getBundleContext(), StageLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}