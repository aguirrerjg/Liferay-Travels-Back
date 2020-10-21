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

package com.liferay.travels.internal.search.spi.model.index.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.liferay.travels.model.Trip;

import org.osgi.service.component.annotations.Component;

/**
 * @author Luis Miguel Barcos
 */
@Component(
	immediate = true,
	property = "indexer.class.name=com.liferay.travels.model.Trip",
	service = ModelDocumentContributor.class
)
public class TripModelDocumentContributor
	implements ModelDocumentContributor<Trip> {

	@Override
	public void contribute(Document document, Trip trip) {
		document.addText(Field.NAME, trip.getName());
		document.addText(Field.DESCRIPTION, trip.getDescription());
	}

}