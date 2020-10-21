package com.liferay.travels.rest.client.serdes.v1_0;

import com.liferay.travels.rest.client.dto.v1_0.Stage;
import com.liferay.travels.rest.client.dto.v1_0.Trip;
import com.liferay.travels.rest.client.json.BaseJSONParser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;

import javax.annotation.Generated;

/**
 * @author Javier de Arcos
 * @generated
 */
@Generated("")
public class TripSerDes {

	public static Trip toDTO(String json) {
		TripJSONParser tripJSONParser = new TripJSONParser();

		return tripJSONParser.parseToDTO(json);
	}

	public static Trip[] toDTOs(String json) {
		TripJSONParser tripJSONParser = new TripJSONParser();

		return tripJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Trip trip) {
		if (trip == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (trip.getDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(trip.getDescription()));

			sb.append("\"");
		}

		if (trip.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(trip.getId());
		}

		if (trip.getImage() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"image\": ");

			sb.append("\"");

			sb.append(_escape(trip.getImage()));

			sb.append("\"");
		}

		if (trip.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(trip.getName()));

			sb.append("\"");
		}

		if (trip.getStages() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"stages\": ");

			sb.append("[");

			for (int i = 0; i < trip.getStages().length; i++) {
				sb.append(String.valueOf(trip.getStages()[i]));

				if ((i + 1) < trip.getStages().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (trip.getStartingDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"startingDate\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(trip.getStartingDate()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		TripJSONParser tripJSONParser = new TripJSONParser();

		return tripJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Trip trip) {
		if (trip == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (trip.getDescription() == null) {
			map.put("description", null);
		}
		else {
			map.put("description", String.valueOf(trip.getDescription()));
		}

		if (trip.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(trip.getId()));
		}

		if (trip.getImage() == null) {
			map.put("image", null);
		}
		else {
			map.put("image", String.valueOf(trip.getImage()));
		}

		if (trip.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(trip.getName()));
		}

		if (trip.getStages() == null) {
			map.put("stages", null);
		}
		else {
			map.put("stages", String.valueOf(trip.getStages()));
		}

		if (trip.getStartingDate() == null) {
			map.put("startingDate", null);
		}
		else {
			map.put(
				"startingDate",
				liferayToJSONDateFormat.format(trip.getStartingDate()));
		}

		return map;
	}

	public static class TripJSONParser extends BaseJSONParser<Trip> {

		@Override
		protected Trip createDTO() {
			return new Trip();
		}

		@Override
		protected Trip[] createDTOArray(int size) {
			return new Trip[size];
		}

		@Override
		protected void setField(
			Trip trip, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "description")) {
				if (jsonParserFieldValue != null) {
					trip.setDescription((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					trip.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "image")) {
				if (jsonParserFieldValue != null) {
					trip.setImage((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					trip.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "stages")) {
				if (jsonParserFieldValue != null) {
					trip.setStages(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> StageSerDes.toDTO((String)object)
						).toArray(
							size -> new Stage[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "startingDate")) {
				if (jsonParserFieldValue != null) {
					trip.setStartingDate(toDate((String)jsonParserFieldValue));
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