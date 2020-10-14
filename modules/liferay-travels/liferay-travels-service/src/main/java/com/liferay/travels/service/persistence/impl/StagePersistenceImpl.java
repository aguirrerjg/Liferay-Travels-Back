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

package com.liferay.travels.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.travels.exception.NoSuchStageException;
import com.liferay.travels.model.Stage;
import com.liferay.travels.model.impl.StageImpl;
import com.liferay.travels.model.impl.StageModelImpl;
import com.liferay.travels.service.persistence.StagePersistence;
import com.liferay.travels.service.persistence.impl.constants.LiferayTravelsPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the stage service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Javier de Arcos
 * @generated
 */
@Component(service = StagePersistence.class)
public class StagePersistenceImpl
	extends BasePersistenceImpl<Stage> implements StagePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StageUtil</code> to access the stage persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StageImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the stages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching stages
	 */
	@Override
	public List<Stage> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Stage> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Stage> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Stage> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Stage> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Stage> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Stage> list = null;

		if (useFinderCache) {
			list = (List<Stage>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Stage stage : list) {
					if (!uuid.equals(stage.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_STAGE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StageModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<Stage>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first stage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stage
	 * @throws NoSuchStageException if a matching stage could not be found
	 */
	@Override
	public Stage findByUuid_First(
			String uuid, OrderByComparator<Stage> orderByComparator)
		throws NoSuchStageException {

		Stage stage = fetchByUuid_First(uuid, orderByComparator);

		if (stage != null) {
			return stage;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchStageException(sb.toString());
	}

	/**
	 * Returns the first stage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stage, or <code>null</code> if a matching stage could not be found
	 */
	@Override
	public Stage fetchByUuid_First(
		String uuid, OrderByComparator<Stage> orderByComparator) {

		List<Stage> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last stage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stage
	 * @throws NoSuchStageException if a matching stage could not be found
	 */
	@Override
	public Stage findByUuid_Last(
			String uuid, OrderByComparator<Stage> orderByComparator)
		throws NoSuchStageException {

		Stage stage = fetchByUuid_Last(uuid, orderByComparator);

		if (stage != null) {
			return stage;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchStageException(sb.toString());
	}

	/**
	 * Returns the last stage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stage, or <code>null</code> if a matching stage could not be found
	 */
	@Override
	public Stage fetchByUuid_Last(
		String uuid, OrderByComparator<Stage> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Stage> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Stage[] findByUuid_PrevAndNext(
			long stageId, String uuid,
			OrderByComparator<Stage> orderByComparator)
		throws NoSuchStageException {

		uuid = Objects.toString(uuid, "");

		Stage stage = findByPrimaryKey(stageId);

		Session session = null;

		try {
			session = openSession();

			Stage[] array = new StageImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, stage, uuid, orderByComparator, true);

			array[1] = stage;

			array[2] = getByUuid_PrevAndNext(
				session, stage, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Stage getByUuid_PrevAndNext(
		Session session, Stage stage, String uuid,
		OrderByComparator<Stage> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_STAGE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(StageModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(stage)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Stage> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the stages where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Stage stage :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(stage);
		}
	}

	/**
	 * Returns the number of stages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching stages
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STAGE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "stage.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(stage.uuid IS NULL OR stage.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByTripId;
	private FinderPath _finderPathWithoutPaginationFindByTripId;
	private FinderPath _finderPathCountByTripId;

	/**
	 * Returns all the stages where tripId = &#63;.
	 *
	 * @param tripId the trip ID
	 * @return the matching stages
	 */
	@Override
	public List<Stage> findByTripId(long tripId) {
		return findByTripId(tripId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Stage> findByTripId(long tripId, int start, int end) {
		return findByTripId(tripId, start, end, null);
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
	@Override
	public List<Stage> findByTripId(
		long tripId, int start, int end,
		OrderByComparator<Stage> orderByComparator) {

		return findByTripId(tripId, start, end, orderByComparator, true);
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
	@Override
	public List<Stage> findByTripId(
		long tripId, int start, int end,
		OrderByComparator<Stage> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTripId;
				finderArgs = new Object[] {tripId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTripId;
			finderArgs = new Object[] {tripId, start, end, orderByComparator};
		}

		List<Stage> list = null;

		if (useFinderCache) {
			list = (List<Stage>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Stage stage : list) {
					if (tripId != stage.getTripId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_STAGE_WHERE);

			sb.append(_FINDER_COLUMN_TRIPID_TRIPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StageModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(tripId);

				list = (List<Stage>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first stage in the ordered set where tripId = &#63;.
	 *
	 * @param tripId the trip ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stage
	 * @throws NoSuchStageException if a matching stage could not be found
	 */
	@Override
	public Stage findByTripId_First(
			long tripId, OrderByComparator<Stage> orderByComparator)
		throws NoSuchStageException {

		Stage stage = fetchByTripId_First(tripId, orderByComparator);

		if (stage != null) {
			return stage;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tripId=");
		sb.append(tripId);

		sb.append("}");

		throw new NoSuchStageException(sb.toString());
	}

	/**
	 * Returns the first stage in the ordered set where tripId = &#63;.
	 *
	 * @param tripId the trip ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stage, or <code>null</code> if a matching stage could not be found
	 */
	@Override
	public Stage fetchByTripId_First(
		long tripId, OrderByComparator<Stage> orderByComparator) {

		List<Stage> list = findByTripId(tripId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last stage in the ordered set where tripId = &#63;.
	 *
	 * @param tripId the trip ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stage
	 * @throws NoSuchStageException if a matching stage could not be found
	 */
	@Override
	public Stage findByTripId_Last(
			long tripId, OrderByComparator<Stage> orderByComparator)
		throws NoSuchStageException {

		Stage stage = fetchByTripId_Last(tripId, orderByComparator);

		if (stage != null) {
			return stage;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("tripId=");
		sb.append(tripId);

		sb.append("}");

		throw new NoSuchStageException(sb.toString());
	}

	/**
	 * Returns the last stage in the ordered set where tripId = &#63;.
	 *
	 * @param tripId the trip ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stage, or <code>null</code> if a matching stage could not be found
	 */
	@Override
	public Stage fetchByTripId_Last(
		long tripId, OrderByComparator<Stage> orderByComparator) {

		int count = countByTripId(tripId);

		if (count == 0) {
			return null;
		}

		List<Stage> list = findByTripId(
			tripId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Stage[] findByTripId_PrevAndNext(
			long stageId, long tripId,
			OrderByComparator<Stage> orderByComparator)
		throws NoSuchStageException {

		Stage stage = findByPrimaryKey(stageId);

		Session session = null;

		try {
			session = openSession();

			Stage[] array = new StageImpl[3];

			array[0] = getByTripId_PrevAndNext(
				session, stage, tripId, orderByComparator, true);

			array[1] = stage;

			array[2] = getByTripId_PrevAndNext(
				session, stage, tripId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Stage getByTripId_PrevAndNext(
		Session session, Stage stage, long tripId,
		OrderByComparator<Stage> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_STAGE_WHERE);

		sb.append(_FINDER_COLUMN_TRIPID_TRIPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(StageModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(tripId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(stage)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Stage> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the stages where tripId = &#63; from the database.
	 *
	 * @param tripId the trip ID
	 */
	@Override
	public void removeByTripId(long tripId) {
		for (Stage stage :
				findByTripId(
					tripId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(stage);
		}
	}

	/**
	 * Returns the number of stages where tripId = &#63;.
	 *
	 * @param tripId the trip ID
	 * @return the number of matching stages
	 */
	@Override
	public int countByTripId(long tripId) {
		FinderPath finderPath = _finderPathCountByTripId;

		Object[] finderArgs = new Object[] {tripId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STAGE_WHERE);

			sb.append(_FINDER_COLUMN_TRIPID_TRIPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(tripId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TRIPID_TRIPID_2 =
		"stage.tripId = ?";

	public StagePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Stage.class);

		setModelImplClass(StageImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the stage in the entity cache if it is enabled.
	 *
	 * @param stage the stage
	 */
	@Override
	public void cacheResult(Stage stage) {
		entityCache.putResult(StageImpl.class, stage.getPrimaryKey(), stage);

		stage.resetOriginalValues();
	}

	/**
	 * Caches the stages in the entity cache if it is enabled.
	 *
	 * @param stages the stages
	 */
	@Override
	public void cacheResult(List<Stage> stages) {
		for (Stage stage : stages) {
			if (entityCache.getResult(StageImpl.class, stage.getPrimaryKey()) ==
					null) {

				cacheResult(stage);
			}
			else {
				stage.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all stages.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StageImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the stage.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Stage stage) {
		entityCache.removeResult(StageImpl.class, stage.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Stage> stages) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Stage stage : stages) {
			entityCache.removeResult(StageImpl.class, stage.getPrimaryKey());
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(StageImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new stage with the primary key. Does not add the stage to the database.
	 *
	 * @param stageId the primary key for the new stage
	 * @return the new stage
	 */
	@Override
	public Stage create(long stageId) {
		Stage stage = new StageImpl();

		stage.setNew(true);
		stage.setPrimaryKey(stageId);

		String uuid = PortalUUIDUtil.generate();

		stage.setUuid(uuid);

		return stage;
	}

	/**
	 * Removes the stage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stageId the primary key of the stage
	 * @return the stage that was removed
	 * @throws NoSuchStageException if a stage with the primary key could not be found
	 */
	@Override
	public Stage remove(long stageId) throws NoSuchStageException {
		return remove((Serializable)stageId);
	}

	/**
	 * Removes the stage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the stage
	 * @return the stage that was removed
	 * @throws NoSuchStageException if a stage with the primary key could not be found
	 */
	@Override
	public Stage remove(Serializable primaryKey) throws NoSuchStageException {
		Session session = null;

		try {
			session = openSession();

			Stage stage = (Stage)session.get(StageImpl.class, primaryKey);

			if (stage == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStageException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(stage);
		}
		catch (NoSuchStageException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Stage removeImpl(Stage stage) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(stage)) {
				stage = (Stage)session.get(
					StageImpl.class, stage.getPrimaryKeyObj());
			}

			if (stage != null) {
				session.delete(stage);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (stage != null) {
			clearCache(stage);
		}

		return stage;
	}

	@Override
	public Stage updateImpl(Stage stage) {
		boolean isNew = stage.isNew();

		if (!(stage instanceof StageModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(stage.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(stage);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in stage proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Stage implementation " +
					stage.getClass());
		}

		StageModelImpl stageModelImpl = (StageModelImpl)stage;

		if (Validator.isNull(stage.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			stage.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (stage.isNew()) {
				session.save(stage);

				stage.setNew(false);
			}
			else {
				stage = (Stage)session.merge(stage);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			Object[] args = new Object[] {stageModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {stageModelImpl.getTripId()};

			finderCache.removeResult(_finderPathCountByTripId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTripId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((stageModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {stageModelImpl.getOriginalUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {stageModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((stageModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTripId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					stageModelImpl.getOriginalTripId()
				};

				finderCache.removeResult(_finderPathCountByTripId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTripId, args);

				args = new Object[] {stageModelImpl.getTripId()};

				finderCache.removeResult(_finderPathCountByTripId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTripId, args);
			}
		}

		entityCache.putResult(
			StageImpl.class, stage.getPrimaryKey(), stage, false);

		stage.resetOriginalValues();

		return stage;
	}

	/**
	 * Returns the stage with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the stage
	 * @return the stage
	 * @throws NoSuchStageException if a stage with the primary key could not be found
	 */
	@Override
	public Stage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStageException {

		Stage stage = fetchByPrimaryKey(primaryKey);

		if (stage == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStageException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return stage;
	}

	/**
	 * Returns the stage with the primary key or throws a <code>NoSuchStageException</code> if it could not be found.
	 *
	 * @param stageId the primary key of the stage
	 * @return the stage
	 * @throws NoSuchStageException if a stage with the primary key could not be found
	 */
	@Override
	public Stage findByPrimaryKey(long stageId) throws NoSuchStageException {
		return findByPrimaryKey((Serializable)stageId);
	}

	/**
	 * Returns the stage with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stageId the primary key of the stage
	 * @return the stage, or <code>null</code> if a stage with the primary key could not be found
	 */
	@Override
	public Stage fetchByPrimaryKey(long stageId) {
		return fetchByPrimaryKey((Serializable)stageId);
	}

	/**
	 * Returns all the stages.
	 *
	 * @return the stages
	 */
	@Override
	public List<Stage> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Stage> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Stage> findAll(
		int start, int end, OrderByComparator<Stage> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Stage> findAll(
		int start, int end, OrderByComparator<Stage> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Stage> list = null;

		if (useFinderCache) {
			list = (List<Stage>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STAGE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STAGE;

				sql = sql.concat(StageModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Stage>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the stages from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Stage stage : findAll()) {
			remove(stage);
		}
	}

	/**
	 * Returns the number of stages.
	 *
	 * @return the number of stages
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_STAGE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "stageId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_STAGE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StageModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the stage persistence.
	 */
	@Activate
	public void activate() {
		_finderPathWithPaginationFindAll = new FinderPath(
			StageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll",
			new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			StageImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);

		_finderPathCountAll = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			StageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			StageImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid", new String[] {String.class.getName()},
			StageModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid", new String[] {String.class.getName()});

		_finderPathWithPaginationFindByTripId = new FinderPath(
			StageImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTripId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTripId = new FinderPath(
			StageImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTripId", new String[] {Long.class.getName()},
			StageModelImpl.TRIPID_COLUMN_BITMASK);

		_finderPathCountByTripId = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTripId", new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(StageImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = LiferayTravelsPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = LiferayTravelsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = LiferayTravelsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_STAGE =
		"SELECT stage FROM Stage stage";

	private static final String _SQL_SELECT_STAGE_WHERE =
		"SELECT stage FROM Stage stage WHERE ";

	private static final String _SQL_COUNT_STAGE =
		"SELECT COUNT(stage) FROM Stage stage";

	private static final String _SQL_COUNT_STAGE_WHERE =
		"SELECT COUNT(stage) FROM Stage stage WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "stage.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Stage exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Stage exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		StagePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	static {
		try {
			Class.forName(LiferayTravelsPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}