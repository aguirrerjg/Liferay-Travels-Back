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

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.travels.exception.NoSuchStageException;
import com.liferay.travels.model.Stage;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the stage service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Javier de Arcos
 * @see StageUtil
 * @generated
 */
@ProviderType
public interface StagePersistence extends BasePersistence<Stage> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StageUtil} to access the stage persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the stages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching stages
	 */
	public java.util.List<Stage> findByUuid(String uuid);

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
	public java.util.List<Stage> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Stage> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Stage>
			orderByComparator);

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
	public java.util.List<Stage> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Stage>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first stage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stage
	 * @throws NoSuchStageException if a matching stage could not be found
	 */
	public Stage findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Stage>
				orderByComparator)
		throws NoSuchStageException;

	/**
	 * Returns the first stage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stage, or <code>null</code> if a matching stage could not be found
	 */
	public Stage fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Stage>
			orderByComparator);

	/**
	 * Returns the last stage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stage
	 * @throws NoSuchStageException if a matching stage could not be found
	 */
	public Stage findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Stage>
				orderByComparator)
		throws NoSuchStageException;

	/**
	 * Returns the last stage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stage, or <code>null</code> if a matching stage could not be found
	 */
	public Stage fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Stage>
			orderByComparator);

	/**
	 * Returns the stages before and after the current stage in the ordered set where uuid = &#63;.
	 *
	 * @param stageId the primary key of the current stage
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stage
	 * @throws NoSuchStageException if a stage with the primary key could not be found
	 */
	public Stage[] findByUuid_PrevAndNext(
			long stageId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Stage>
				orderByComparator)
		throws NoSuchStageException;

	/**
	 * Removes all the stages where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of stages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching stages
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the stage where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchStageException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching stage
	 * @throws NoSuchStageException if a matching stage could not be found
	 */
	public Stage findByUUID_G(String uuid, long groupId)
		throws NoSuchStageException;

	/**
	 * Returns the stage where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching stage, or <code>null</code> if a matching stage could not be found
	 */
	public Stage fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the stage where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching stage, or <code>null</code> if a matching stage could not be found
	 */
	public Stage fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the stage where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the stage that was removed
	 */
	public Stage removeByUUID_G(String uuid, long groupId)
		throws NoSuchStageException;

	/**
	 * Returns the number of stages where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching stages
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the stages where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching stages
	 */
	public java.util.List<Stage> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Stage> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Stage> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Stage>
			orderByComparator);

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
	public java.util.List<Stage> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Stage>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first stage in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stage
	 * @throws NoSuchStageException if a matching stage could not be found
	 */
	public Stage findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Stage>
				orderByComparator)
		throws NoSuchStageException;

	/**
	 * Returns the first stage in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stage, or <code>null</code> if a matching stage could not be found
	 */
	public Stage fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Stage>
			orderByComparator);

	/**
	 * Returns the last stage in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stage
	 * @throws NoSuchStageException if a matching stage could not be found
	 */
	public Stage findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Stage>
				orderByComparator)
		throws NoSuchStageException;

	/**
	 * Returns the last stage in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stage, or <code>null</code> if a matching stage could not be found
	 */
	public Stage fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Stage>
			orderByComparator);

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
	public Stage[] findByUuid_C_PrevAndNext(
			long stageId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Stage>
				orderByComparator)
		throws NoSuchStageException;

	/**
	 * Removes all the stages where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of stages where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching stages
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the stages where tripId = &#63;.
	 *
	 * @param tripId the trip ID
	 * @return the matching stages
	 */
	public java.util.List<Stage> findByTripId(long tripId);

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
	public java.util.List<Stage> findByTripId(long tripId, int start, int end);

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
	public java.util.List<Stage> findByTripId(
		long tripId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Stage>
			orderByComparator);

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
	public java.util.List<Stage> findByTripId(
		long tripId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Stage>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first stage in the ordered set where tripId = &#63;.
	 *
	 * @param tripId the trip ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stage
	 * @throws NoSuchStageException if a matching stage could not be found
	 */
	public Stage findByTripId_First(
			long tripId,
			com.liferay.portal.kernel.util.OrderByComparator<Stage>
				orderByComparator)
		throws NoSuchStageException;

	/**
	 * Returns the first stage in the ordered set where tripId = &#63;.
	 *
	 * @param tripId the trip ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stage, or <code>null</code> if a matching stage could not be found
	 */
	public Stage fetchByTripId_First(
		long tripId,
		com.liferay.portal.kernel.util.OrderByComparator<Stage>
			orderByComparator);

	/**
	 * Returns the last stage in the ordered set where tripId = &#63;.
	 *
	 * @param tripId the trip ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stage
	 * @throws NoSuchStageException if a matching stage could not be found
	 */
	public Stage findByTripId_Last(
			long tripId,
			com.liferay.portal.kernel.util.OrderByComparator<Stage>
				orderByComparator)
		throws NoSuchStageException;

	/**
	 * Returns the last stage in the ordered set where tripId = &#63;.
	 *
	 * @param tripId the trip ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stage, or <code>null</code> if a matching stage could not be found
	 */
	public Stage fetchByTripId_Last(
		long tripId,
		com.liferay.portal.kernel.util.OrderByComparator<Stage>
			orderByComparator);

	/**
	 * Returns the stages before and after the current stage in the ordered set where tripId = &#63;.
	 *
	 * @param stageId the primary key of the current stage
	 * @param tripId the trip ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stage
	 * @throws NoSuchStageException if a stage with the primary key could not be found
	 */
	public Stage[] findByTripId_PrevAndNext(
			long stageId, long tripId,
			com.liferay.portal.kernel.util.OrderByComparator<Stage>
				orderByComparator)
		throws NoSuchStageException;

	/**
	 * Removes all the stages where tripId = &#63; from the database.
	 *
	 * @param tripId the trip ID
	 */
	public void removeByTripId(long tripId);

	/**
	 * Returns the number of stages where tripId = &#63;.
	 *
	 * @param tripId the trip ID
	 * @return the number of matching stages
	 */
	public int countByTripId(long tripId);

	/**
	 * Caches the stage in the entity cache if it is enabled.
	 *
	 * @param stage the stage
	 */
	public void cacheResult(Stage stage);

	/**
	 * Caches the stages in the entity cache if it is enabled.
	 *
	 * @param stages the stages
	 */
	public void cacheResult(java.util.List<Stage> stages);

	/**
	 * Creates a new stage with the primary key. Does not add the stage to the database.
	 *
	 * @param stageId the primary key for the new stage
	 * @return the new stage
	 */
	public Stage create(long stageId);

	/**
	 * Removes the stage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stageId the primary key of the stage
	 * @return the stage that was removed
	 * @throws NoSuchStageException if a stage with the primary key could not be found
	 */
	public Stage remove(long stageId) throws NoSuchStageException;

	public Stage updateImpl(Stage stage);

	/**
	 * Returns the stage with the primary key or throws a <code>NoSuchStageException</code> if it could not be found.
	 *
	 * @param stageId the primary key of the stage
	 * @return the stage
	 * @throws NoSuchStageException if a stage with the primary key could not be found
	 */
	public Stage findByPrimaryKey(long stageId) throws NoSuchStageException;

	/**
	 * Returns the stage with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stageId the primary key of the stage
	 * @return the stage, or <code>null</code> if a stage with the primary key could not be found
	 */
	public Stage fetchByPrimaryKey(long stageId);

	/**
	 * Returns all the stages.
	 *
	 * @return the stages
	 */
	public java.util.List<Stage> findAll();

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
	public java.util.List<Stage> findAll(int start, int end);

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
	public java.util.List<Stage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Stage>
			orderByComparator);

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
	public java.util.List<Stage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Stage>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the stages from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of stages.
	 *
	 * @return the number of stages
	 */
	public int countAll();

}