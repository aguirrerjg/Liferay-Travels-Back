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
 * Provides a wrapper for {@link TripLocalService}.
 *
 * @author Javier de Arcos
 * @see TripLocalService
 * @generated
 */
public class TripLocalServiceWrapper
	implements ServiceWrapper<TripLocalService>, TripLocalService {

	public TripLocalServiceWrapper(TripLocalService tripLocalService) {
		_tripLocalService = tripLocalService;
	}

	@Override
	public com.liferay.travels.model.Trip addTrip(
			long groupId, long userId, String name, String description,
			java.util.Date startingDate, String image)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tripLocalService.addTrip(
			groupId, userId, name, description, startingDate, image);
	}

	/**
	 * Adds the trip to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TripLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param trip the trip
	 * @return the trip that was added
	 */
	@Override
	public com.liferay.travels.model.Trip addTrip(
		com.liferay.travels.model.Trip trip) {

		return _tripLocalService.addTrip(trip);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tripLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new trip with the primary key. Does not add the trip to the database.
	 *
	 * @param tripId the primary key for the new trip
	 * @return the new trip
	 */
	@Override
	public com.liferay.travels.model.Trip createTrip(long tripId) {
		return _tripLocalService.createTrip(tripId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tripLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the trip with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TripLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param tripId the primary key of the trip
	 * @return the trip that was removed
	 * @throws PortalException if a trip with the primary key could not be found
	 */
	@Override
	public com.liferay.travels.model.Trip deleteTrip(long tripId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tripLocalService.deleteTrip(tripId);
	}

	/**
	 * Deletes the trip from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TripLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param trip the trip
	 * @return the trip that was removed
	 */
	@Override
	public com.liferay.travels.model.Trip deleteTrip(
		com.liferay.travels.model.Trip trip) {

		return _tripLocalService.deleteTrip(trip);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _tripLocalService.dynamicQuery();
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

		return _tripLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.travels.model.impl.TripModelImpl</code>.
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

		return _tripLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.travels.model.impl.TripModelImpl</code>.
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

		return _tripLocalService.dynamicQuery(
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

		return _tripLocalService.dynamicQueryCount(dynamicQuery);
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

		return _tripLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.travels.model.Trip fetchTrip(long tripId) {
		return _tripLocalService.fetchTrip(tripId);
	}

	/**
	 * Returns the trip matching the UUID and group.
	 *
	 * @param uuid the trip's UUID
	 * @param groupId the primary key of the group
	 * @return the matching trip, or <code>null</code> if a matching trip could not be found
	 */
	@Override
	public com.liferay.travels.model.Trip fetchTripByUuidAndGroupId(
		String uuid, long groupId) {

		return _tripLocalService.fetchTripByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _tripLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _tripLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _tripLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _tripLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tripLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the trip with the primary key.
	 *
	 * @param tripId the primary key of the trip
	 * @return the trip
	 * @throws PortalException if a trip with the primary key could not be found
	 */
	@Override
	public com.liferay.travels.model.Trip getTrip(long tripId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tripLocalService.getTrip(tripId);
	}

	/**
	 * Returns the trip matching the UUID and group.
	 *
	 * @param uuid the trip's UUID
	 * @param groupId the primary key of the group
	 * @return the matching trip
	 * @throws PortalException if a matching trip could not be found
	 */
	@Override
	public com.liferay.travels.model.Trip getTripByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tripLocalService.getTripByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<com.liferay.travels.model.Trip> getTrips() {
		return _tripLocalService.getTrips();
	}

	/**
	 * Returns a range of all the trips.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.travels.model.impl.TripModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @return the range of trips
	 */
	@Override
	public java.util.List<com.liferay.travels.model.Trip> getTrips(
		int start, int end) {

		return _tripLocalService.getTrips(start, end);
	}

	/**
	 * Returns all the trips matching the UUID and company.
	 *
	 * @param uuid the UUID of the trips
	 * @param companyId the primary key of the company
	 * @return the matching trips, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.liferay.travels.model.Trip>
		getTripsByUuidAndCompanyId(String uuid, long companyId) {

		return _tripLocalService.getTripsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of trips matching the UUID and company.
	 *
	 * @param uuid the UUID of the trips
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of trips
	 * @param end the upper bound of the range of trips (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching trips, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.liferay.travels.model.Trip>
		getTripsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.travels.model.Trip> orderByComparator) {

		return _tripLocalService.getTripsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of trips.
	 *
	 * @return the number of trips
	 */
	@Override
	public int getTripsCount() {
		return _tripLocalService.getTripsCount();
	}

	@Override
	public com.liferay.travels.model.Trip updateTrip(
			long groupId, long userId, long tripId, String name,
			String description, java.util.Date startingDate, String image)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _tripLocalService.updateTrip(
			groupId, userId, tripId, name, description, startingDate, image);
	}

	/**
	 * Updates the trip in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TripLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param trip the trip
	 * @return the trip that was updated
	 */
	@Override
	public com.liferay.travels.model.Trip updateTrip(
		com.liferay.travels.model.Trip trip) {

		return _tripLocalService.updateTrip(trip);
	}

	@Override
	public TripLocalService getWrappedService() {
		return _tripLocalService;
	}

	@Override
	public void setWrappedService(TripLocalService tripLocalService) {
		_tripLocalService = tripLocalService;
	}

	private TripLocalService _tripLocalService;

}