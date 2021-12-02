/*
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.fhir2.api.translators.attributes.impl;

import com.google.common.reflect.TypeToken;
import org.hl7.fhir.instance.model.api.IAnyResource;
import org.openmrs.OpenmrsObject;
import org.openmrs.customdatatype.Customizable;
import org.openmrs.module.fhir2.api.translators.attributes.FhirAttributeHandler;

public abstract class BaseFhirAttributeHandler<T extends Customizable<?> & OpenmrsObject, U extends IAnyResource>
		implements FhirAttributeHandler<T, U> {
	
	@SuppressWarnings("UnstableApiUsage")
	protected final TypeToken<T> appliesToOpenmrsType;
	
	@SuppressWarnings("UnstableApiUsage")
	protected final TypeToken<U> appliesToFhirType;
	
	@SuppressWarnings({ "UnstableApiUsage", "unused" })
	public BaseFhirAttributeHandler() {
		// @formatter:off
		appliesToOpenmrsType = new TypeToken<T>(getClass()) {};
		appliesToFhirType = new TypeToken<U>(getClass()) {};
		// @formatter:on
	}
	
	@Override
	@SuppressWarnings({ "unchecked", "UnstableApiUsage" })
	public Class<T> getAppliesToOpenmrsType() {
		return (Class<T>) appliesToOpenmrsType.getRawType();
	}
	
	@Override
	@SuppressWarnings({ "unchecked", "UnstableApiUsage" })
	public Class<U> getAppliesToFhirType() {
		return (Class<U>) appliesToFhirType.getRawType();
	}
}
