package com.liferay.travels.rest.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.travels.rest.dto.v1_0.Stage;
import com.liferay.travels.rest.dto.v1_0.Trip;
import com.liferay.travels.rest.resource.v1_0.StageResource;
import com.liferay.travels.rest.resource.v1_0.TripResource;

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
public class Mutation {

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

	@GraphQLField
	public Stage createTripStage(
			@GraphQLName("tripId") Long tripId,
			@GraphQLName("stage") Stage stage)
		throws Exception {

		return _applyComponentServiceObjects(
			_stageResourceComponentServiceObjects,
			this::_populateResourceContext,
			stageResource -> stageResource.postTripStage(tripId, stage));
	}

	@GraphQLField
	public boolean deleteStage(@GraphQLName("stageId") Long stageId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_stageResourceComponentServiceObjects,
			this::_populateResourceContext,
			stageResource -> stageResource.deleteStage(stageId));

		return true;
	}

	@GraphQLField
	public Stage updateStage(
			@GraphQLName("stageId") Long stageId,
			@GraphQLName("stage") Stage stage)
		throws Exception {

		return _applyComponentServiceObjects(
			_stageResourceComponentServiceObjects,
			this::_populateResourceContext,
			stageResource -> stageResource.putStage(stageId, stage));
	}

	@GraphQLField
	public Trip createTrip(@GraphQLName("trip") Trip trip) throws Exception {
		return _applyComponentServiceObjects(
			_tripResourceComponentServiceObjects,
			this::_populateResourceContext,
			tripResource -> tripResource.postTrip(trip));
	}

	@GraphQLField
	public boolean deleteTrip(@GraphQLName("tripId") Long tripId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_tripResourceComponentServiceObjects,
			this::_populateResourceContext,
			tripResource -> tripResource.deleteTrip(tripId));

		return true;
	}

	@GraphQLField
	public Trip updateTrip(
			@GraphQLName("tripId") Long tripId, @GraphQLName("trip") Trip trip)
		throws Exception {

		return _applyComponentServiceObjects(
			_tripResourceComponentServiceObjects,
			this::_populateResourceContext,
			tripResource -> tripResource.putTrip(tripId, trip));
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

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
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
	private com.liferay.portal.kernel.model.Company _company;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private com.liferay.portal.kernel.model.User _user;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private UriInfo _uriInfo;

}