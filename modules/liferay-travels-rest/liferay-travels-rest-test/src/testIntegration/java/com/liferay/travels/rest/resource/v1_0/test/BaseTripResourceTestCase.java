package com.liferay.travels.rest.resource.v1_0.test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.petra.function.UnsafeTriConsumer;
import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.search.test.util.SearchTestRule;
import com.liferay.portal.test.log.CaptureAppender;
import com.liferay.portal.test.log.Log4JLoggerTestUtil;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;
import com.liferay.travels.rest.client.dto.v1_0.Trip;
import com.liferay.travels.rest.client.http.HttpInvoker;
import com.liferay.travels.rest.client.pagination.Page;
import com.liferay.travels.rest.client.pagination.Pagination;
import com.liferay.travels.rest.client.resource.v1_0.TripResource;
import com.liferay.travels.rest.client.serdes.v1_0.TripSerDes;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Level;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Javier de Arcos
 * @generated
 */
@Generated("")
public abstract class BaseTripResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_tripResource.setContextCompany(testCompany);

		TripResource.Builder builder = TripResource.builder();

		tripResource = builder.locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		Trip trip1 = randomTrip();

		String json = objectMapper.writeValueAsString(trip1);

		Trip trip2 = TripSerDes.toDTO(json);

		Assert.assertTrue(equals(trip1, trip2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		Trip trip = randomTrip();

		String json1 = objectMapper.writeValueAsString(trip);
		String json2 = TripSerDes.toJSON(trip);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Trip trip = randomTrip();

		trip.setDescription(regex);
		trip.setImage(regex);
		trip.setName(regex);

		String json = TripSerDes.toJSON(trip);

		Assert.assertFalse(json.contains(regex));

		trip = TripSerDes.toDTO(json);

		Assert.assertEquals(regex, trip.getDescription());
		Assert.assertEquals(regex, trip.getImage());
		Assert.assertEquals(regex, trip.getName());
	}

	@Test
	public void testGetTripsPage() throws Exception {
		Page<Trip> page = tripResource.getTripsPage(
			RandomTestUtil.randomString(), null, Pagination.of(1, 2), null);

		Assert.assertEquals(0, page.getTotalCount());

		Trip trip1 = testGetTripsPage_addTrip(randomTrip());

		Trip trip2 = testGetTripsPage_addTrip(randomTrip());

		page = tripResource.getTripsPage(null, null, Pagination.of(1, 2), null);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(trip1, trip2), (List<Trip>)page.getItems());
		assertValid(page);

		tripResource.deleteTrip(trip1.getId());

		tripResource.deleteTrip(trip2.getId());
	}

	@Test
	public void testGetTripsPageWithFilterDateTimeEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Trip trip1 = randomTrip();

		trip1 = testGetTripsPage_addTrip(trip1);

		for (EntityField entityField : entityFields) {
			Page<Trip> page = tripResource.getTripsPage(
				null, getFilterString(entityField, "between", trip1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(trip1), (List<Trip>)page.getItems());
		}
	}

	@Test
	public void testGetTripsPageWithFilterStringEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Trip trip1 = testGetTripsPage_addTrip(randomTrip());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Trip trip2 = testGetTripsPage_addTrip(randomTrip());

		for (EntityField entityField : entityFields) {
			Page<Trip> page = tripResource.getTripsPage(
				null, getFilterString(entityField, "eq", trip1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(trip1), (List<Trip>)page.getItems());
		}
	}

	@Test
	public void testGetTripsPageWithPagination() throws Exception {
		Trip trip1 = testGetTripsPage_addTrip(randomTrip());

		Trip trip2 = testGetTripsPage_addTrip(randomTrip());

		Trip trip3 = testGetTripsPage_addTrip(randomTrip());

		Page<Trip> page1 = tripResource.getTripsPage(
			null, null, Pagination.of(1, 2), null);

		List<Trip> trips1 = (List<Trip>)page1.getItems();

		Assert.assertEquals(trips1.toString(), 2, trips1.size());

		Page<Trip> page2 = tripResource.getTripsPage(
			null, null, Pagination.of(2, 2), null);

		Assert.assertEquals(3, page2.getTotalCount());

		List<Trip> trips2 = (List<Trip>)page2.getItems();

		Assert.assertEquals(trips2.toString(), 1, trips2.size());

		Page<Trip> page3 = tripResource.getTripsPage(
			null, null, Pagination.of(1, 3), null);

		assertEqualsIgnoringOrder(
			Arrays.asList(trip1, trip2, trip3), (List<Trip>)page3.getItems());
	}

	@Test
	public void testGetTripsPageWithSortDateTime() throws Exception {
		testGetTripsPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, trip1, trip2) -> {
				BeanUtils.setProperty(
					trip1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetTripsPageWithSortInteger() throws Exception {
		testGetTripsPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, trip1, trip2) -> {
				BeanUtils.setProperty(trip1, entityField.getName(), 0);
				BeanUtils.setProperty(trip2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetTripsPageWithSortString() throws Exception {
		testGetTripsPageWithSort(
			EntityField.Type.STRING,
			(entityField, trip1, trip2) -> {
				Class<?> clazz = trip1.getClass();

				String entityFieldName = entityField.getName();

				Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						trip1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						trip2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						trip1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						trip2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						trip1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						trip2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetTripsPageWithSort(
			EntityField.Type type,
			UnsafeTriConsumer<EntityField, Trip, Trip, Exception>
				unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		Trip trip1 = randomTrip();
		Trip trip2 = randomTrip();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(entityField, trip1, trip2);
		}

		trip1 = testGetTripsPage_addTrip(trip1);

		trip2 = testGetTripsPage_addTrip(trip2);

		for (EntityField entityField : entityFields) {
			Page<Trip> ascPage = tripResource.getTripsPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(trip1, trip2), (List<Trip>)ascPage.getItems());

			Page<Trip> descPage = tripResource.getTripsPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(trip2, trip1), (List<Trip>)descPage.getItems());
		}
	}

	protected Trip testGetTripsPage_addTrip(Trip trip) throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetTripsPage() throws Exception {
		GraphQLField graphQLField = new GraphQLField(
			"trips",
			new HashMap<String, Object>() {
				{
					put("page", 1);
					put("pageSize", 2);
				}
			},
			new GraphQLField("items", getGraphQLFields()),
			new GraphQLField("page"), new GraphQLField("totalCount"));

		JSONObject tripsJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/trips");

		Assert.assertEquals(0, tripsJSONObject.get("totalCount"));

		Trip trip1 = testGraphQLTrip_addTrip();
		Trip trip2 = testGraphQLTrip_addTrip();

		tripsJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/trips");

		Assert.assertEquals(2, tripsJSONObject.get("totalCount"));

		assertEqualsIgnoringOrder(
			Arrays.asList(trip1, trip2),
			Arrays.asList(
				TripSerDes.toDTOs(tripsJSONObject.getString("items"))));
	}

	@Test
	public void testPostTrip() throws Exception {
		Trip randomTrip = randomTrip();

		Trip postTrip = testPostTrip_addTrip(randomTrip);

		assertEquals(randomTrip, postTrip);
		assertValid(postTrip);
	}

	protected Trip testPostTrip_addTrip(Trip trip) throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteTrip() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Trip trip = testDeleteTrip_addTrip();

		assertHttpResponseStatusCode(
			204, tripResource.deleteTripHttpResponse(trip.getId()));

		assertHttpResponseStatusCode(
			404, tripResource.getTripHttpResponse(trip.getId()));

		assertHttpResponseStatusCode(404, tripResource.getTripHttpResponse(0L));
	}

	protected Trip testDeleteTrip_addTrip() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLDeleteTrip() throws Exception {
		Trip trip = testGraphQLTrip_addTrip();

		Assert.assertTrue(
			JSONUtil.getValueAsBoolean(
				invokeGraphQLMutation(
					new GraphQLField(
						"deleteTrip",
						new HashMap<String, Object>() {
							{
								put("tripId", trip.getId());
							}
						})),
				"JSONObject/data", "Object/deleteTrip"));

		try (CaptureAppender captureAppender =
				Log4JLoggerTestUtil.configureLog4JLogger(
					"graphql.execution.SimpleDataFetcherExceptionHandler",
					Level.WARN)) {

			JSONArray errorsJSONArray = JSONUtil.getValueAsJSONArray(
				invokeGraphQLQuery(
					new GraphQLField(
						"trip",
						new HashMap<String, Object>() {
							{
								put("tripId", trip.getId());
							}
						},
						new GraphQLField("id"))),
				"JSONArray/errors");

			Assert.assertTrue(errorsJSONArray.length() > 0);
		}
	}

	@Test
	public void testGetTrip() throws Exception {
		Trip postTrip = testGetTrip_addTrip();

		Trip getTrip = tripResource.getTrip(postTrip.getId());

		assertEquals(postTrip, getTrip);
		assertValid(getTrip);
	}

	protected Trip testGetTrip_addTrip() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetTrip() throws Exception {
		Trip trip = testGraphQLTrip_addTrip();

		Assert.assertTrue(
			equals(
				trip,
				TripSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"trip",
								new HashMap<String, Object>() {
									{
										put("tripId", trip.getId());
									}
								},
								getGraphQLFields())),
						"JSONObject/data", "Object/trip"))));
	}

	@Test
	public void testGraphQLGetTripNotFound() throws Exception {
		Long irrelevantTripId = RandomTestUtil.randomLong();

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"trip",
						new HashMap<String, Object>() {
							{
								put("tripId", irrelevantTripId);
							}
						},
						getGraphQLFields())),
				"JSONArray/errors", "Object/0", "JSONObject/extensions",
				"Object/code"));
	}

	@Test
	public void testPutTrip() throws Exception {
		Trip postTrip = testPutTrip_addTrip();

		Trip randomTrip = randomTrip();

		Trip putTrip = tripResource.putTrip(postTrip.getId(), randomTrip);

		assertEquals(randomTrip, putTrip);
		assertValid(putTrip);

		Trip getTrip = tripResource.getTrip(putTrip.getId());

		assertEquals(randomTrip, getTrip);
		assertValid(getTrip);
	}

	protected Trip testPutTrip_addTrip() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	protected Trip testGraphQLTrip_addTrip() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Trip trip1, Trip trip2) {
		Assert.assertTrue(
			trip1 + " does not equal " + trip2, equals(trip1, trip2));
	}

	protected void assertEquals(List<Trip> trips1, List<Trip> trips2) {
		Assert.assertEquals(trips1.size(), trips2.size());

		for (int i = 0; i < trips1.size(); i++) {
			Trip trip1 = trips1.get(i);
			Trip trip2 = trips2.get(i);

			assertEquals(trip1, trip2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Trip> trips1, List<Trip> trips2) {

		Assert.assertEquals(trips1.size(), trips2.size());

		for (Trip trip1 : trips1) {
			boolean contains = false;

			for (Trip trip2 : trips2) {
				if (equals(trip1, trip2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(trips2 + " does not contain " + trip1, contains);
		}
	}

	protected void assertValid(Trip trip) {
		boolean valid = true;

		if (trip.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (trip.getDescription() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("image", additionalAssertFieldName)) {
				if (trip.getImage() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (trip.getName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("stages", additionalAssertFieldName)) {
				if (trip.getStages() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("startingDate", additionalAssertFieldName)) {
				if (trip.getStartingDate() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<Trip> page) {
		boolean valid = false;

		java.util.Collection<Trip> trips = page.getItems();

		int size = trips.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (Field field :
				ReflectionUtil.getDeclaredFields(
					com.liferay.travels.rest.dto.v1_0.Trip.class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					ReflectionUtil.getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(Trip trip1, Trip trip2) {
		if (trip1 == trip2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						trip1.getDescription(), trip2.getDescription())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(trip1.getId(), trip2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("image", additionalAssertFieldName)) {
				if (!Objects.deepEquals(trip1.getImage(), trip2.getImage())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(trip1.getName(), trip2.getName())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("stages", additionalAssertFieldName)) {
				if (!Objects.deepEquals(trip1.getStages(), trip2.getStages())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("startingDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						trip1.getStartingDate(), trip2.getStartingDate())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}
		}

		return true;
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_tripResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_tripResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator, Trip trip) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("description")) {
			sb.append("'");
			sb.append(String.valueOf(trip.getDescription()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("image")) {
			sb.append("'");
			sb.append(String.valueOf(trip.getImage()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(trip.getName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("stages")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("startingDate")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(trip.getStartingDate(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(trip.getStartingDate(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(trip.getStartingDate()));
			}

			return sb.toString();
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected Trip randomTrip() throws Exception {
		return new Trip() {
			{
				description = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				id = RandomTestUtil.randomLong();
				image = StringUtil.toLowerCase(RandomTestUtil.randomString());
				name = StringUtil.toLowerCase(RandomTestUtil.randomString());
				startingDate = RandomTestUtil.nextDate();
			}
		};
	}

	protected Trip randomIrrelevantTrip() throws Exception {
		Trip randomIrrelevantTrip = randomTrip();

		return randomIrrelevantTrip;
	}

	protected Trip randomPatchTrip() throws Exception {
		return randomTrip();
	}

	protected TripResource tripResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(":");
					sb.append(entry.getValue());
					sb.append(",");
				}

				sb.setLength(sb.length() - 1);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(",");
				}

				sb.setLength(sb.length() - 1);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final Log _log = LogFactoryUtil.getLog(
		BaseTripResourceTestCase.class);

	private static BeanUtilsBean _beanUtilsBean = new BeanUtilsBean() {

		@Override
		public void copyProperty(Object bean, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value != null) {
				super.copyProperty(bean, name, value);
			}
		}

	};
	private static DateFormat _dateFormat;

	@Inject
	private com.liferay.travels.rest.resource.v1_0.TripResource _tripResource;

}