package com.liferay.travels.rest.internal.graphql.query.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.travels.rest.dto.v1_0.Stage;
import com.liferay.travels.rest.dto.v1_0.Trip;
import com.liferay.travels.rest.resource.v1_0.StageResource;
import com.liferay.travels.rest.resource.v1_0.TripResource;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Javier de Arcos
 * @generated
 */
@Generated("")
public class Query {

	public static void setStageResourceComponentServiceObjects(
		ComponentServiceObjects<StageResource>
			stageResourceComponentServiceObjects) {

		_stageResourceComponentServiceObjects =
			stageResourceComponentServiceObjects;
	}

	public static void setTripResourceComponentServiceObjects(
		ComponentServiceObjects<TripResource>
			tripResourceComponentServiceObjects) {

		_tripResourceComponentServiceObjects =
			tripResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {tripStages(tripId: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public StagePage tripStages(@GraphQLName("tripId") Long tripId)
		throws Exception {

		return _applyComponentServiceObjects(
			_stageResourceComponentServiceObjects,
			this::_populateResourceContext,
			stageResource -> new StagePage(
				stageResource.getTripStagesPage(tripId)));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {stage(stageId: ___){id, name, description, place, image}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Stage stage(@GraphQLName("stageId") Long stageId) throws Exception {
		return _applyComponentServiceObjects(
			_stageResourceComponentServiceObjects,
			this::_populateResourceContext,
			stageResource -> stageResource.getStage(stageId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {trips(filter: ___, page: ___, pageSize: ___, search: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public TripPage trips(
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_tripResourceComponentServiceObjects,
			this::_populateResourceContext,
			tripResource -> new TripPage(
				tripResource.getTripsPage(
					search, _filterBiFunction.apply(tripResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(tripResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {trip(tripId: ___){id, name, description, starting-date, image, stages}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Trip trip(@GraphQLName("tripId") Long tripId) throws Exception {
		return _applyComponentServiceObjects(
			_tripResourceComponentServiceObjects,
			this::_populateResourceContext,
			tripResource -> tripResource.getTrip(tripId));
	}

	@GraphQLName("StagePage")
	public class StagePage {

		public StagePage(Page stagePage) {
			actions = stagePage.getActions();
			items = stagePage.getItems();
			lastPage = stagePage.getLastPage();
			page = stagePage.getPage();
			pageSize = stagePage.getPageSize();
			totalCount = stagePage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Stage> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("TripPage")
	public class TripPage {

		public TripPage(Page tripPage) {
			actions = tripPage.getActions();
			items = tripPage.getItems();
			lastPage = tripPage.getLastPage();
			page = tripPage.getPage();
			pageSize = tripPage.getPageSize();
			totalCount = tripPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Trip> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(StageResource stageResource)
		throws Exception {

		stageResource.setContextAcceptLanguage(_acceptLanguage);
		stageResource.setContextCompany(_company);
		stageResource.setContextHttpServletRequest(_httpServletRequest);
		stageResource.setContextHttpServletResponse(_httpServletResponse);
		stageResource.setContextUriInfo(_uriInfo);
		stageResource.setContextUser(_user);
	}

	private void _populateResourceContext(TripResource tripResource)
		throws Exception {

		tripResource.setContextAcceptLanguage(_acceptLanguage);
		tripResource.setContextCompany(_company);
		tripResource.setContextHttpServletRequest(_httpServletRequest);
		tripResource.setContextHttpServletResponse(_httpServletResponse);
		tripResource.setContextUriInfo(_uriInfo);
		tripResource.setContextUser(_user);
	}

	private static ComponentServiceObjects<StageResource>
		_stageResourceComponentServiceObjects;
	private static ComponentServiceObjects<TripResource>
		_tripResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private com.liferay.portal.kernel.model.Company _company;
	private com.liferay.portal.kernel.model.User _user;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private UriInfo _uriInfo;

}