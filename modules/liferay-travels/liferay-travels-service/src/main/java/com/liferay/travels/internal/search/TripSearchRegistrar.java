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

package com.liferay.travels.internal.search;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import com.liferay.travels.model.Trip;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Luis Miguel Barcos
 */
@Component(immediate = true)
public class TripSearchRegistrar {

	@Activate
	protected void activate(BundleContext bundleContext) {
		_serviceRegistration = modelSearchRegistrarHelper.register(
			Trip.class, bundleContext,
			modelSearchDefinition -> {
				modelSearchDefinition.setDefaultSelectedFieldNames(
					Field.ASSET_TAG_NAMES, Field.COMPANY_ID, Field.CONTENT,
					Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK,
					Field.GROUP_ID, Field.MODIFIED_DATE, Field.SCOPE_GROUP_ID,
					Field.TITLE, Field.UID, Field.CATEGORY_ID, Field.COMPANY_ID,
					Field.USER_ID, Field.ASSET_CATEGORY_IDS,
					Field.ASSET_CATEGORY_TITLE, Field.ASSET_VOCABULARY_IDS,
					Field.ROLE_ID, Field.GROUP_ROLE_ID);

				modelSearchDefinition.setModelIndexWriteContributor(
					modelIndexerWriterContributor);
				modelSearchDefinition.setModelSummaryContributor(
					modelSummaryContributor);
			});
	}

	@Deactivate
	protected void deactivate() {
		_serviceRegistration.unregister();
	}

	@Reference(target = "(indexer.class.name=com.liferay.travels.model.Trip)")
	protected ModelIndexerWriterContributor<Trip> modelIndexerWriterContributor;

	@Reference
	protected ModelSearchRegistrarHelper modelSearchRegistrarHelper;

	@Reference(target = "(indexer.class.name=com.liferay.travels.model.Trip)")
	protected ModelSummaryContributor modelSummaryContributor;

	private ServiceRegistration<?> _serviceRegistration;

}