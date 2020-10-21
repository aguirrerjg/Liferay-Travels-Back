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
import com.liferay.travels.exception.NoSuchTripException;
import com.liferay.travels.model.Trip;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the trip service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Javier de Arcos
 * @see TripUtil
 * @generated
 */
@ProviderType
public interface TripPersistence extends BasePersistence<Trip> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TripUtil} to access the trip persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the trips where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching trips
	 */
	public java.util.List<Trip> findByUuid(String uuid);

	/**
	 * Returns a range of all the trips where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TripModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @return the range of matching trips
	 */
	public java.util.List<Trip> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the trips where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TripModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trips
	 */
	public java.util.List<Trip> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Trip>
			orderByComparator);

	/**
	 * Returns an ordered range of all the trips where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TripModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trips
	 */
	public java.util.List<Trip> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Trip>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first trip in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trip
	 * @throws NoSuchTripException if a matching trip could not be found
	 */
	public Trip findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Trip>
				orderByComparator)
		throws NoSuchTripException;

	/**
	 * Returns the first trip in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trip, or <code>null</code> if a matching trip could not be found
	 */
	public Trip fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Trip>
			orderByComparator);

	/**
	 * Returns the last trip in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trip
	 * @throws NoSuchTripException if a matching trip could not be found
	 */
	public Trip findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Trip>
				orderByComparator)
		throws NoSuchTripException;

	/**
	 * Returns the last trip in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trip, or <code>null</code> if a matching trip could not be found
	 */
	public Trip fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Trip>
			orderByComparator);

	/**
	 * Returns the trips before and after the current trip in the ordered set where uuid = &#63;.
	 *
	 * @param tripId the primary key of the current trip
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trip
	 * @throws NoSuchTripException if a trip with the primary key could not be found
	 */
	public Trip[] findByUuid_PrevAndNext(
			long tripId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Trip>
				orderByComparator)
		throws NoSuchTripException;

	/**
	 * Removes all the trips where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of trips where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching trips
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the trip where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTripException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trip
	 * @throws NoSuchTripException if a matching trip could not be found
	 */
	public Trip findByUUID_G(String uuid, long groupId)
		throws NoSuchTripException;

	/**
	 * Returns the trip where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trip, or <code>null</code> if a matching trip could not be found
	 */
	public Trip fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the trip where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trip, or <code>null</code> if a matching trip could not be found
	 */
	public Trip fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the trip where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the trip that was removed
	 */
	public Trip removeByUUID_G(String uuid, long groupId)
		throws NoSuchTripException;

	/**
	 * Returns the number of trips where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching trips
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the trips where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching trips
	 */
	public java.util.List<Trip> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the trips where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TripModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @return the range of matching trips
	 */
	public java.util.List<Trip> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the trips where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TripModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trips
	 */
	public java.util.List<Trip> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Trip>
			orderByComparator);

	/**
	 * Returns an ordered range of all the trips where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TripModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trips
	 */
	public java.util.List<Trip> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Trip>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first trip in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trip
	 * @throws NoSuchTripException if a matching trip could not be found
	 */
	public Trip findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Trip>
				orderByComparator)
		throws NoSuchTripException;

	/**
	 * Returns the first trip in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trip, or <code>null</code> if a matching trip could not be found
	 */
	public Trip fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Trip>
			orderByComparator);

	/**
	 * Returns the last trip in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trip
	 * @throws NoSuchTripException if a matching trip could not be found
	 */
	public Trip findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Trip>
				orderByComparator)
		throws NoSuchTripException;

	/**
	 * Returns the last trip in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trip, or <code>null</code> if a matching trip could not be found
	 */
	public Trip fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Trip>
			orderByComparator);

	/**
	 * Returns the trips before and after the current trip in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param tripId the primary key of the current trip
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trip
	 * @throws NoSuchTripException if a trip with the primary key could not be found
	 */
	public Trip[] findByUuid_C_PrevAndNext(
			long tripId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Trip>
				orderByComparator)
		throws NoSuchTripException;

	/**
	 * Removes all the trips where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of trips where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching trips
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the trip in the entity cache if it is enabled.
	 *
	 * @param trip the trip
	 */
	public void cacheResult(Trip trip);

	/**
	 * Caches the trips in the entity cache if it is enabled.
	 *
	 * @param trips the trips
	 */
	public void cacheResult(java.util.List<Trip> trips);

	/**
	 * Creates a new trip with the primary key. Does not add the trip to the database.
	 *
	 * @param tripId the primary key for the new trip
	 * @return the new trip
	 */
	public Trip create(long tripId);

	/**
	 * Removes the trip with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tripId the primary key of the trip
	 * @return the trip that was removed
	 * @throws NoSuchTripException if a trip with the primary key could not be found
	 */
	public Trip remove(long tripId) throws NoSuchTripException;

	public Trip updateImpl(Trip trip);

	/**
	 * Returns the trip with the primary key or throws a <code>NoSuchTripException</code> if it could not be found.
	 *
	 * @param tripId the primary key of the trip
	 * @return the trip
	 * @throws NoSuchTripException if a trip with the primary key could not be found
	 */
	public Trip findByPrimaryKey(long tripId) throws NoSuchTripException;

	/**
	 * Returns the trip with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tripId the primary key of the trip
	 * @return the trip, or <code>null</code> if a trip with the primary key could not be found
	 */
	public Trip fetchByPrimaryKey(long tripId);

	/**
	 * Returns all the trips.
	 *
	 * @return the trips
	 */
	public java.util.List<Trip> findAll();

	/**
	 * Returns a range of all the trips.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TripModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @return the range of trips
	 */
	public java.util.List<Trip> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the trips.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TripModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trips
	 */
	public java.util.List<Trip> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Trip>
			orderByComparator);

	/**
	 * Returns an ordered range of all the trips.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TripModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of trips
	 */
	public java.util.List<Trip> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Trip>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the trips from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of trips.
	 *
	 * @return the number of trips
	 */
	public int countAll();

}