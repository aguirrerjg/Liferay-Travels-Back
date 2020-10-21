package com.liferay.travels.rest.internal.resource.v1_0;

import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.travels.rest.dto.v1_0.Trip;
import com.liferay.travels.rest.resource.v1_0.TripResource;

import com.liferay.travels.service.TripService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Javier de Arcos
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/trip.properties",
	scope = ServiceScope.PROTOTYPE, service = TripResource.class
)
public class TripResourceImpl extends BaseTripResourceImpl {
	@Override
	public Page<Trip> getTripsPage() {
		List<com.liferay.travels.model.Trip> trips = tripService.getTrips();

		return Page.of(trips.stream().map(this::toTrip).collect(Collectors.toList()));
	}

	@Override
	public Trip getTrip(@NotNull Long tripId) throws Exception {
		return toTrip(tripService.getTrip(tripId));
	}

	@Override
	public Trip postTrip(Trip trip) throws Exception {
		return toTrip(tripService.addTrip(contextUser.getGroupId(), contextUser.getUserId(),
				trip.getName(), trip.getDescription(), trip.getStartingDate(), trip.getImage()));
	}

	@Override
	public Trip putTrip(@NotNull Long tripId, Trip trip) throws Exception {
		return toTrip(tripService.updateTrip(contextUser.getGroupId(), contextUser.getUserId(),
				tripId, trip.getName(), trip.getDescription(), trip.getStartingDate(), trip.getImage()));
	}

	@Override
	public void deleteTrip(@NotNull Long tripId) throws Exception {
		tripService.deleteTrip(tripId);
	}

	private Trip toTrip(com.liferay.travels.model.Trip trip) {
		Trip tripResource = new Trip();

		tripResource.setId(trip.getTripId());
		tripResource.setName(trip.getName());
		tripResource.setDescription(trip.getDescription());
		tripResource.setStartingDate(trip.getStartingDate());
		tripResource.setImage(trip.getImage());

		return tripResource;
	}

	@Reference
	private TripService tripService;
}