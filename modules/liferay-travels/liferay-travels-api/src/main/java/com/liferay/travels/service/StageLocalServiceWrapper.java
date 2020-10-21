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
 * Provides a wrapper for {@link StageLocalService}.
 *
 * @author Javier de Arcos
 * @see StageLocalService
 * @generated
 */
public class StageLocalServiceWrapper
	implements ServiceWrapper<StageLocalService>, StageLocalService {

	public StageLocalServiceWrapper(StageLocalService stageLocalService) {
		_stageLocalService = stageLocalService;
	}

	@Override
	public com.liferay.travels.model.Stage addStage(
			long groupId, long userId, long tripId, String name,
			String description, String place, String image)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stageLocalService.addStage(
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
	@Override
	public com.liferay.travels.model.Stage addStage(
		com.liferay.travels.model.Stage stage) {

		return _stageLocalService.addStage(stage);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stageLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new stage with the primary key. Does not add the stage to the database.
	 *
	 * @param stageId the primary key for the new stage
	 * @return the new stage
	 */
	@Override
	public com.liferay.travels.model.Stage createStage(long stageId) {
		return _stageLocalService.createStage(stageId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stageLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public com.liferay.travels.model.Stage deleteStage(long stageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stageLocalService.deleteStage(stageId);
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
	@Override
	public com.liferay.travels.model.Stage deleteStage(
		com.liferay.travels.model.Stage stage) {

		return _stageLocalService.deleteStage(stage);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _stageLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _stageLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _stageLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _stageLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _stageLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _stageLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.travels.model.Stage fetchStage(long stageId) {
		return _stageLocalService.fetchStage(stageId);
	}

	/**
	 * Returns the stage matching the UUID and group.
	 *
	 * @param uuid the stage's UUID
	 * @param groupId the primary key of the group
	 * @return the matching stage, or <code>null</code> if a matching stage could not be found
	 */
	@Override
	public com.liferay.travels.model.Stage fetchStageByUuidAndGroupId(
		String uuid, long groupId) {

		return _stageLocalService.fetchStageByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _stageLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _stageLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _stageLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _stageLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stageLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the stage with the primary key.
	 *
	 * @param stageId the primary key of the stage
	 * @return the stage
	 * @throws PortalException if a stage with the primary key could not be found
	 */
	@Override
	public com.liferay.travels.model.Stage getStage(long stageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stageLocalService.getStage(stageId);
	}

	/**
	 * Returns the stage matching the UUID and group.
	 *
	 * @param uuid the stage's UUID
	 * @param groupId the primary key of the group
	 * @return the matching stage
	 * @throws PortalException if a matching stage could not be found
	 */
	@Override
	public com.liferay.travels.model.Stage getStageByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stageLocalService.getStageByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<com.liferay.travels.model.Stage> getStages(
		int start, int end) {

		return _stageLocalService.getStages(start, end);
	}

	@Override
	public java.util.List<com.liferay.travels.model.Stage> getStages(
		long tripId) {

		return _stageLocalService.getStages(tripId);
	}

	/**
	 * Returns all the stages matching the UUID and company.
	 *
	 * @param uuid the UUID of the stages
	 * @param companyId the primary key of the company
	 * @return the matching stages, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.liferay.travels.model.Stage>
		getStagesByUuidAndCompanyId(String uuid, long companyId) {

		return _stageLocalService.getStagesByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<com.liferay.travels.model.Stage>
		getStagesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.travels.model.Stage> orderByComparator) {

		return _stageLocalService.getStagesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of stages.
	 *
	 * @return the number of stages
	 */
	@Override
	public int getStagesCount() {
		return _stageLocalService.getStagesCount();
	}

	@Override
	public com.liferay.travels.model.Stage updateStage(
			long stageId, String name, String description, String place,
			String image)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stageLocalService.updateStage(
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
	@Override
	public com.liferay.travels.model.Stage updateStage(
		com.liferay.travels.model.Stage stage) {

		return _stageLocalService.updateStage(stage);
	}

	@Override
	public StageLocalService getWrappedService() {
		return _stageLocalService;
	}

	@Override
	public void setWrappedService(StageLocalService stageLocalService) {
		_stageLocalService = stageLocalService;
	}

	private StageLocalService _stageLocalService;

}