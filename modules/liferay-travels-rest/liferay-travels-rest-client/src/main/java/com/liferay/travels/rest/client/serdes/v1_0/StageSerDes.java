package com.liferay.travels.rest.client.serdes.v1_0;

import com.liferay.travels.rest.client.dto.v1_0.Stage;
import com.liferay.travels.rest.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author Javier de Arcos
 * @generated
 */
@Generated("")
public class StageSerDes {

	public static Stage toDTO(String json) {
		StageJSONParser stageJSONParser = new StageJSONParser();

		return stageJSONParser.parseToDTO(json);
	}

	public static Stage[] toDTOs(String json) {
		StageJSONParser stageJSONParser = new StageJSONParser();

		return stageJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Stage stage) {
		if (stage == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (stage.getDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(stage.getDescription()));

			sb.append("\"");
		}

		if (stage.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(stage.getId());
		}

		if (stage.getImage() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"image\": ");

			sb.append("\"");

			sb.append(_escape(stage.getImage()));

			sb.append("\"");
		}

		if (stage.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(stage.getName()));

			sb.append("\"");
		}

		if (stage.getPlace() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"place\": ");

			sb.append("\"");

			sb.append(_escape(stage.getPlace()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		StageJSONParser stageJSONParser = new StageJSONParser();

		return stageJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Stage stage) {
		if (stage == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (stage.getDescription() == null) {
			map.put("description", null);
		}
		else {
			map.put("description", String.valueOf(stage.getDescription()));
		}

		if (stage.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(stage.getId()));
		}

		if (stage.getImage() == null) {
			map.put("image", null);
		}
		else {
			map.put("image", String.valueOf(stage.getImage()));
		}

		if (stage.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(stage.getName()));
		}

		if (stage.getPlace() == null) {
			map.put("place", null);
		}
		else {
			map.put("place", String.valueOf(stage.getPlace()));
		}

		return map;
	}

	public static class StageJSONParser extends BaseJSONParser<Stage> {

		@Override
		protected Stage createDTO() {
			return new Stage();
		}

		@Override
		protected Stage[] createDTOArray(int size) {
			return new Stage[size];
		}

		@Override
		protected void setField(
			Stage stage, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "description")) {
				if (jsonParserFieldValue != null) {
					stage.setDescription((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					stage.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "image")) {
				if (jsonParserFieldValue != null) {
					stage.setImage((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					stage.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "place")) {
				if (jsonParserFieldValue != null) {
					stage.setPlace((String)jsonParserFieldValue);
				}
			}
			else {
				throw new IllegalArgumentException(
					"Unsupported field name " + jsonParserFieldName);
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\":");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(",");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}