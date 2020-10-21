package com.liferay.travels.rest.resource.v1_0.test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

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
import com.liferay.portal.test.log.CaptureAppender;
import com.liferay.portal.test.log.Log4JLoggerTestUtil;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;
import com.liferay.travels.rest.client.dto.v1_0.Stage;
import com.liferay.travels.rest.client.http.HttpInvoker;
import com.liferay.travels.rest.client.pagination.Page;
import com.liferay.travels.rest.client.resource.v1_0.StageResource;
import com.liferay.travels.rest.client.serdes.v1_0.StageSerDes;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtilsBean;
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
public abstract class BaseStageResourceTestCase {

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

		_stageResource.setContextCompany(testCompany);

		StageResource.Builder builder = StageResource.builder();

		stageResource = builder.locale(
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

		Stage stage1 = randomStage();

		String json = objectMapper.writeValueAsString(stage1);

		Stage stage2 = StageSerDes.toDTO(json);

		Assert.assertTrue(equals(stage1, stage2));
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

		Stage stage = randomStage();

		String json1 = objectMapper.writeValueAsString(stage);
		String json2 = StageSerDes.toJSON(stage);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Stage stage = randomStage();

		stage.setDescription(regex);
		stage.setImage(regex);
		stage.setName(regex);
		stage.setPlace(regex);

		String json = StageSerDes.toJSON(stage);

		Assert.assertFalse(json.contains(regex));

		stage = StageSerDes.toDTO(json);

		Assert.assertEquals(regex, stage.getDescription());
		Assert.assertEquals(regex, stage.getImage());
		Assert.assertEquals(regex, stage.getName());
		Assert.assertEquals(regex, stage.getPlace());
	}

	@Test
	public void testGetTripStagesPage() throws Exception {
		Page<Stage> page = stageResource.getTripStagesPage(
			testGetTripStagesPage_getTripId());

		Assert.assertEquals(0, page.getTotalCount());

		Long tripId = testGetTripStagesPage_getTripId();
		Long irrelevantTripId = testGetTripStagesPage_getIrrelevantTripId();

		if ((irrelevantTripId != null)) {
			Stage irrelevantStage = testGetTripStagesPage_addStage(
				irrelevantTripId, randomIrrelevantStage());

			page = stageResource.getTripStagesPage(irrelevantTripId);

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantStage), (List<Stage>)page.getItems());
			assertValid(page);
		}

		Stage stage1 = testGetTripStagesPage_addStage(tripId, randomStage());

		Stage stage2 = testGetTripStagesPage_addStage(tripId, randomStage());

		page = stageResource.getTripStagesPage(tripId);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(stage1, stage2), (List<Stage>)page.getItems());
		assertValid(page);

		stageResource.deleteStage(stage1.getId());

		stageResource.deleteStage(stage2.getId());
	}

	protected Stage testGetTripStagesPage_addStage(Long tripId, Stage stage)
		throws Exception {

		return stageResource.postTripStage(tripId, stage);
	}

	protected Long testGetTripStagesPage_getTripId() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long testGetTripStagesPage_getIrrelevantTripId()
		throws Exception {

		return null;
	}

	@Test
	public void testPostTripStage() throws Exception {
		Stage randomStage = randomStage();

		Stage postStage = testPostTripStage_addStage(randomStage);

		assertEquals(randomStage, postStage);
		assertValid(postStage);
	}

	protected Stage testPostTripStage_addStage(Stage stage) throws Exception {
		return stageResource.postTripStage(
			testGetTripStagesPage_getTripId(), stage);
	}

	@Test
	public void testDeleteStage() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Stage stage = testDeleteStage_addStage();

		assertHttpResponseStatusCode(
			204, stageResource.deleteStageHttpResponse(stage.getId()));

		assertHttpResponseStatusCode(
			404, stageResource.getStageHttpResponse(stage.getId()));

		assertHttpResponseStatusCode(
			404, stageResource.getStageHttpResponse(0L));
	}

	protected Stage testDeleteStage_addStage() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLDeleteStage() throws Exception {
		Stage stage = testGraphQLStage_addStage();

		Assert.assertTrue(
			JSONUtil.getValueAsBoolean(
				invokeGraphQLMutation(
					new GraphQLField(
						"deleteStage",
						new HashMap<String, Object>() {
							{
								put("stageId", stage.getId());
							}
						})),
				"JSONObject/data", "Object/deleteStage"));

		try (CaptureAppender captureAppender =
				Log4JLoggerTestUtil.configureLog4JLogger(
					"graphql.execution.SimpleDataFetcherExceptionHandler",
					Level.WARN)) {

			JSONArray errorsJSONArray = JSONUtil.getValueAsJSONArray(
				invokeGraphQLQuery(
					new GraphQLField(
						"stage",
						new HashMap<String, Object>() {
							{
								put("stageId", stage.getId());
							}
						},
						new GraphQLField("id"))),
				"JSONArray/errors");

			Assert.assertTrue(errorsJSONArray.length() > 0);
		}
	}

	@Test
	public void testGetStage() throws Exception {
		Stage postStage = testGetStage_addStage();

		Stage getStage = stageResource.getStage(postStage.getId());

		assertEquals(postStage, getStage);
		assertValid(getStage);
	}

	protected Stage testGetStage_addStage() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetStage() throws Exception {
		Stage stage = testGraphQLStage_addStage();

		Assert.assertTrue(
			equals(
				stage,
				StageSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"stage",
								new HashMap<String, Object>() {
									{
										put("stageId", stage.getId());
									}
								},
								getGraphQLFields())),
						"JSONObject/data", "Object/stage"))));
	}

	@Test
	public void testGraphQLGetStageNotFound() throws Exception {
		Long irrelevantStageId = RandomTestUtil.randomLong();

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"stage",
						new HashMap<String, Object>() {
							{
								put("stageId", irrelevantStageId);
							}
						},
						getGraphQLFields())),
				"JSONArray/errors", "Object/0", "JSONObject/extensions",
				"Object/code"));
	}

	@Test
	public void testPutStage() throws Exception {
		Stage postStage = testPutStage_addStage();

		Stage randomStage = randomStage();

		Stage putStage = stageResource.putStage(postStage.getId(), randomStage);

		assertEquals(randomStage, putStage);
		assertValid(putStage);

		Stage getStage = stageResource.getStage(putStage.getId());

		assertEquals(randomStage, getStage);
		assertValid(getStage);
	}

	protected Stage testPutStage_addStage() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Stage testGraphQLStage_addStage() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Stage stage1, Stage stage2) {
		Assert.assertTrue(
			stage1 + " does not equal " + stage2, equals(stage1, stage2));
	}

	protected void assertEquals(List<Stage> stages1, List<Stage> stages2) {
		Assert.assertEquals(stages1.size(), stages2.size());

		for (int i = 0; i < stages1.size(); i++) {
			Stage stage1 = stages1.get(i);
			Stage stage2 = stages2.get(i);

			assertEquals(stage1, stage2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Stage> stages1, List<Stage> stages2) {

		Assert.assertEquals(stages1.size(), stages2.size());

		for (Stage stage1 : stages1) {
			boolean contains = false;

			for (Stage stage2 : stages2) {
				if (equals(stage1, stage2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				stages2 + " does not contain " + stage1, contains);
		}
	}

	protected void assertValid(Stage stage) {
		boolean valid = true;

		if (stage.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("actions", additionalAssertFieldName)) {
				if (stage.getActions() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (stage.getDescription() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("image", additionalAssertFieldName)) {
				if (stage.getImage() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (stage.getName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("place", additionalAssertFieldName)) {
				if (stage.getPlace() == null) {
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

	protected void assertValid(Page<Stage> page) {
		boolean valid = false;

		java.util.Collection<Stage> stages = page.getItems();

		int size = stages.size();

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
					com.liferay.travels.rest.dto.v1_0.Stage.class)) {

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

	protected boolean equals(Stage stage1, Stage stage2) {
		if (stage1 == stage2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("actions", additionalAssertFieldName)) {
				if (!equals(
						(Map)stage1.getActions(), (Map)stage2.getActions())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						stage1.getDescription(), stage2.getDescription())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(stage1.getId(), stage2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("image", additionalAssertFieldName)) {
				if (!Objects.deepEquals(stage1.getImage(), stage2.getImage())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(stage1.getName(), stage2.getName())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("place", additionalAssertFieldName)) {
				if (!Objects.deepEquals(stage1.getPlace(), stage2.getPlace())) {
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

		if (!(_stageResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_stageResource;

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
		EntityField entityField, String operator, Stage stage) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("actions")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("description")) {
			sb.append("'");
			sb.append(String.valueOf(stage.getDescription()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("image")) {
			sb.append("'");
			sb.append(String.valueOf(stage.getImage()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(stage.getName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("place")) {
			sb.append("'");
			sb.append(String.valueOf(stage.getPlace()));
			sb.append("'");

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

	protected Stage randomStage() throws Exception {
		return new Stage() {
			{
				description = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				id = RandomTestUtil.randomLong();
				image = StringUtil.toLowerCase(RandomTestUtil.randomString());
				name = StringUtil.toLowerCase(RandomTestUtil.randomString());
				place = StringUtil.toLowerCase(RandomTestUtil.randomString());
			}
		};
	}

	protected Stage randomIrrelevantStage() throws Exception {
		Stage randomIrrelevantStage = randomStage();

		return randomIrrelevantStage;
	}

	protected Stage randomPatchStage() throws Exception {
		return randomStage();
	}

	protected StageResource stageResource;
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
		BaseStageResourceTestCase.class);

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
	private com.liferay.travels.rest.resource.v1_0.StageResource _stageResource;

}