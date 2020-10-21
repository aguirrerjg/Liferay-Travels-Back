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

package com.liferay.travels.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.travels.service.TripServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>TripServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Javier de Arcos
 * @see TripServiceSoap
 * @generated
 */
public class TripServiceHttp {

	public static com.liferay.travels.model.Trip addTrip(
			HttpPrincipal httpPrincipal, long groupId, long userId, String name,
			String description, java.util.Date startingDate, String image)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				TripServiceUtil.class, "addTrip", _addTripParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, userId, name, description, startingDate,
				image);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.travels.model.Trip)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.travels.model.Trip deleteTrip(
			HttpPrincipal httpPrincipal, long tripId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				TripServiceUtil.class, "deleteTrip",
				_deleteTripParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, tripId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.travels.model.Trip)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.travels.model.Trip getTrip(
			HttpPrincipal httpPrincipal, long tripId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				TripServiceUtil.class, "getTrip", _getTripParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, tripId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.travels.model.Trip)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.travels.model.Trip> getTrips(
		HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				TripServiceUtil.class, "getTrips", _getTripsParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.liferay.travels.model.Trip>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.travels.model.Trip updateTrip(
			HttpPrincipal httpPrincipal, long groupId, long userId, long tripId,
			String name, String description, java.util.Date startingDate,
			String image)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				TripServiceUtil.class, "updateTrip",
				_updateTripParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, userId, tripId, name, description,
				startingDate, image);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.travels.model.Trip)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(TripServiceHttp.class);

	private static final Class<?>[] _addTripParameterTypes0 = new Class[] {
		long.class, long.class, String.class, String.class,
		java.util.Date.class, String.class
	};
	private static final Class<?>[] _deleteTripParameterTypes1 = new Class[] {
		long.class
	};
	private static final Class<?>[] _getTripParameterTypes2 = new Class[] {
		long.class
	};
	private static final Class<?>[] _getTripsParameterTypes3 = new Class[] {};
	private static final Class<?>[] _updateTripParameterTypes4 = new Class[] {
		long.class, long.class, long.class, String.class, String.class,
		java.util.Date.class, String.class
	};

}