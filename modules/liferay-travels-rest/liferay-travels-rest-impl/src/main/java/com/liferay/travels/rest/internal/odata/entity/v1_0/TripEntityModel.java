package com.liferay.travels.rest.internal.odata.entity.v1_0;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.odata.entity.IdEntityField;
import com.liferay.portal.odata.entity.StringEntityField;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Luis Miguel Barcos
 */
public class TripEntityModel implements EntityModel {
    private final Map<String, EntityField> entityFieldsMap;

    public TripEntityModel() {
        entityFieldsMap = new HashMap<>();
        entityFieldsMap.put("id", new IdEntityField("id", locale -> Field.ENTRY_CLASS_PK, String::valueOf));
        entityFieldsMap.put(Field.NAME, new StringEntityField(Field.NAME, locale -> Field.NAME));
        entityFieldsMap.put(Field.DESCRIPTION,  new StringEntityField(Field.DESCRIPTION, locale -> Field.DESCRIPTION));
    }

    @Override
    public Map<String, EntityField> getEntityFieldsMap() {
        return entityFieldsMap;
    }
}