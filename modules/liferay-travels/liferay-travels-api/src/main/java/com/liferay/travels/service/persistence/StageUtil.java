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

package com.liferay.travels.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.travels.model.Stage;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the stage service. This utility wraps <code>com.liferay.travels.service.persistence.impl.StagePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Javier de Arcos
 * @see StagePersistence
 * @generated
 */
public class StageUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Stage stage) {
		getPersistence().clearCache(stage);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Stage> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Stage> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Stage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Stage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Stage> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Stage update(Stage stage) {
		return getPersistence().update(stage);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Stage update(Stage stage, ServiceContext serviceContext) {
		return getPersistence().update(stage, serviceContext);
	}

	/**
	 * Returns all the stages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching stages
	 */
	public static List<Stage> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the stages where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of stages
	 * @param end the upper bound of the range of stages (not inclusive)
	 * @return the range of matching stages
	 */
	public static List<Stage> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the stages where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of stages
	 * @param end the upper bound of the range of stages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stages
	 */
	public static List<Stage> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Stage> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the stages where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of stages
	 * @param end the upper bound of the range of stages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching stages
	 */
	public static List<Stage> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Stage> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first stage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stage
	 * @throws NoSuchStageException if a matching stage could not be found
	 */
	public static Stage findByUuid_First(
			String uuid, OrderByComparator<Stage> orderByComparator)
		throws com.liferay.travels.exception.NoSuchStageException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first stage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stage, or <code>null</code> if a matching stage could not be found
	 */
	public static Stage fetchByUuid_First(
		String uuid, OrderByComparator<Stage> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last stage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stage
	 * @throws NoSuchStageException if a matching stage could not be found
	 */
	public static Stage findByUuid_Last(
			String uuid, OrderByComparator<Stage> orderByComparator)
		throws com.liferay.travels.exception.NoSuchStageException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last stage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stage, or <code>null</code> if a matching stage could not be found
	 */
	public static Stage fetchByUuid_Last(
		String uuid, OrderByComparator<Stage> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the stages before and after the current stage in the ordered set where uuid = &#63;.
	 *
	 * @param stageId the primary key of the current stage
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stage
	 * @throws NoSuchStageException if a stage with the primary key could not be found
	 */
	public static Stage[] findByUuid_PrevAndNext(
			long stageId, String uuid,
			OrderByComparator<Stage> orderByComparator)
		throws com.liferay.travels.exception.NoSuchStageException {

		return getPersistence().findByUuid_PrevAndNext(
			stageId, uuid, orderByComparator);
	}

	/**
	 * Removes all the stages where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of stages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching stages
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the stage where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchStageException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching stage
	 * @throws NoSuchStageException if a matching stage could not be found
	 */
	public static Stage findByUUID_G(String uuid, long groupId)
		throws com.liferay.travels.exception.NoSuchStageException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the stage where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching stage, or <code>null</code> if a matching stage could not be found
	 */
	public static Stage fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the stage where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching stage, or <code>null</code> if a matching stage could not be found
	 */
	public static Stage fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the stage where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the stage that was removed
	 */
	public static Stage removeByUUID_G(String uuid, long groupId)
		throws com.liferay.travels.exception.NoSuchStageException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of stages where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching stages
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the stages where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching stages
	 */
	public static List<Stage> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the stages where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of stages
	 * @param end the upper bound of the range of stages (not inclusive)
	 * @return the range of matching stages
	 */
	public static List<Stage> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the stages where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of stages
	 * @param end the upper bound of the range of stages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stages
	 */
	public static List<Stage> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Stage> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the stages where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of stages
	 * @param end the upper bound of the range of stages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching stages
	 */
	public static List<Stage> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Stage> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first stage in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stage
	 * @throws NoSuchStageException if a matching stage could not be found
	 */
	public static Stage findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Stage> orderByComparator)
		throws com.liferay.travels.exception.NoSuchStageException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first stage in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stage, or <code>null</code> if a matching stage could not be found
	 */
	public static Stage fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Stage> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last stage in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stage
	 * @throws NoSuchStageException if a matching stage could not be found
	 */
	public static Stage findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Stage> orderByComparator)
		throws com.liferay.travels.exception.NoSuchStageException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last stage in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stage, or <code>null</code> if a matching stage could not be found
	 */
	public static Stage fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Stage> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the stages before and after the current stage in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param stageId the primary key of the current stage
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stage
	 * @throws NoSuchStageException if a stage with the primary key could not be found
	 */
	public static Stage[] findByUuid_C_PrevAndNext(
			long stageId, String uuid, long companyId,
			OrderByComparator<Stage> orderByComparator)
		throws com.liferay.travels.exception.NoSuchStageException {

		return getPersistence().findByUuid_C_PrevAndNext(
			stageId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the stages where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of stages where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching stages
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the stages where tripId = &#63;.
	 *
	 * @param tripId the trip ID
	 * @return the matching stages
	 */
	public static List<Stage> findByTripId(long tripId) {
		return getPersistence().findByTripId(tripId);
	}

	/**
	 * Returns a range of all the stages where tripId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StageModelImpl</code>.
	 * </p>
	 *
	 * @param tripId the trip ID
	 * @param start the lower bound of the range of stages
	 * @param end the upper bound of the range of stages (not inclusive)
	 * @return the range of matching stages
	 */
	public static List<Stage> findByTripId(long tripId, int start, int end) {
		return getPersistence().findByTripId(tripId, start, end);
	}

	/**
	 * Returns an ordered range of all the stages where tripId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StageModelImpl</code>.
	 * </p>
	 *
	 * @param tripId the trip ID
	 * @param start the lower bound of the range of stages
	 * @param end the upper bound of the range of stages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stages
	 */
	public static List<Stage> findByTripId(
		long tripId, int start, int end,
		OrderByComparator<Stage> orderByComparator) {

		return getPersistence().findByTripId(
			tripId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the stages where tripId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StageModelImpl</code>.
	 * </p>
	 *
	 * @param tripId the trip ID
	 * @param start the lower bound of the range of stages
	 * @param end the upper bound of the range of stages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching stages
	 */
	public static List<Stage> findByTripId(
		long tripId, int start, int end,
		OrderByComparator<Stage> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByTripId(
			tripId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first stage in the ordered set where tripId = &#63;.
	 *
	 * @param tripId the trip ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stage
	 * @throws NoSuchStageException if a matching stage could not be found
	 */
	public static Stage findByTripId_First(
			long tripId, OrderByComparator<Stage> orderByComparator)
		throws com.liferay.travels.exception.NoSuchStageException {

		return getPersistence().findByTripId_First(tripId, orderByComparator);
	}

	/**
	 * Returns the first stage in the ordered set where tripId = &#63;.
	 *
	 * @param tripId the trip ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stage, or <code>null</code> if a matching stage could not be found
	 */
	public static Stage fetchByTripId_First(
		long tripId, OrderByComparator<Stage> orderByComparator) {

		return getPersistence().fetchByTripId_First(tripId, orderByComparator);
	}

	/**
	 * Returns the last stage in the ordered set where tripId = &#63;.
	 *
	 * @param tripId the trip ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stage
	 * @throws NoSuchStageException if a matching stage could not be found
	 */
	public static Stage findByTripId_Last(
			long tripId, OrderByComparator<Stage> orderByComparator)
		throws com.liferay.travels.exception.NoSuchStageException {

		return getPersistence().findByTripId_Last(tripId, orderByComparator);
	}

	/**
	 * Returns the last stage in the ordered set where tripId = &#63;.
	 *
	 * @param tripId the trip ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stage, or <code>null</code> if a matching stage could not be found
	 */
	public static Stage fetchByTripId_Last(
		long tripId, OrderByComparator<Stage> orderByComparator) {

		return getPersistence().fetchByTripId_Last(tripId, orderByComparator);
	}

	/**
	 * Returns the stages before and after the current stage in the ordered set where tripId = &#63;.
	 *
	 * @param stageId the primary key of the current stage
	 * @param tripId the trip ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stage
	 * @throws NoSuchStageException if a stage with the primary key could not be found
	 */
	public static Stage[] findByTripId_PrevAndNext(
			long stageId, long tripId,
			OrderByComparator<Stage> orderByComparator)
		throws com.liferay.travels.exception.NoSuchStageException {

		return getPersistence().findByTripId_PrevAndNext(
			stageId, tripId, orderByComparator);
	}

	/**
	 * Removes all the stages where tripId = &#63; from the database.
	 *
	 * @param tripId the trip ID
	 */
	public static void removeByTripId(long tripId) {
		getPersistence().removeByTripId(tripId);
	}

	/**
	 * Returns the number of stages where tripId = &#63;.
	 *
	 * @param tripId the trip ID
	 * @return the number of matching stages
	 */
	public static int countByTripId(long tripId) {
		return getPersistence().countByTripId(tripId);
	}

	/**
	 * Caches the stage in the entity cache if it is enabled.
	 *
	 * @param stage the stage
	 */
	public static void cacheResult(Stage stage) {
		getPersistence().cacheResult(stage);
	}

	/**
	 * Caches the stages in the entity cache if it is enabled.
	 *
	 * @param stages the stages
	 */
	public static void cacheResult(List<Stage> stages) {
		getPersistence().cacheResult(stages);
	}

	/**
	 * Creates a new stage with the primary key. Does not add the stage to the database.
	 *
	 * @param stageId the primary key for the new stage
	 * @return the new stage
	 */
	public static Stage create(long stageId) {
		return getPersistence().create(stageId);
	}

	/**
	 * Removes the stage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stageId the primary key of the stage
	 * @return the stage that was removed
	 * @throws NoSuchStageException if a stage with the primary key could not be found
	 */
	public static Stage remove(long stageId)
		throws com.liferay.travels.exception.NoSuchStageException {

		return getPersistence().remove(stageId);
	}

	public static Stage updateImpl(Stage stage) {
		return getPersistence().updateImpl(stage);
	}

	/**
	 * Returns the stage with the primary key or throws a <code>NoSuchStageException</code> if it could not be found.
	 *
	 * @param stageId the primary key of the stage
	 * @return the stage
	 * @throws NoSuchStageException if a stage with the primary key could not be found
	 */
	public static Stage findByPrimaryKey(long stageId)
		throws com.liferay.travels.exception.NoSuchStageException {

		return getPersistence().findByPrimaryKey(stageId);
	}

	/**
	 * Returns the stage with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stageId the primary key of the stage
	 * @return the stage, or <code>null</code> if a stage with the primary key could not be found
	 */
	public static Stage fetchByPrimaryKey(long stageId) {
		return getPersistence().fetchByPrimaryKey(stageId);
	}

	/**
	 * Returns all the stages.
	 *
	 * @return the stages
	 */
	public static List<Stage> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the stages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stages
	 * @param end the upper bound of the range of stages (not inclusive)
	 * @return the range of stages
	 */
	public static List<Stage> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the stages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stages
	 * @param end the upper bound of the range of stages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of stages
	 */
	public static List<Stage> findAll(
		int start, int end, OrderByComparator<Stage> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the stages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stages
	 * @param end the upper bound of the range of stages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of stages
	 */
	public static List<Stage> findAll(
		int start, int end, OrderByComparator<Stage> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the stages from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of stages.
	 *
	 * @return the number of stages
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StagePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<StagePersistence, StagePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(StagePersistence.class);

		ServiceTracker<StagePersistence, StagePersistence> serviceTracker =
			new ServiceTracker<StagePersistence, StagePersistence>(
				bundle.getBundleContext(), StagePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}