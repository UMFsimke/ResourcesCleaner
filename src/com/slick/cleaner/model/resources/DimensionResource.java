/*
 * Copyright (C) 2016 Slick Software.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.slick.cleaner.model.resources;

import com.slick.cleaner.model.xml.ResourceXmlNode;

/**
 * Defines dimension resource
 */
public class DimensionResource extends InlineResource {

	private static final String DIMEN_ACCESS_CLASS_NAME = "dimen";
	
	/**
	 * Creates new instance of {@link DimensionResource} resource from given node
	 * @param node {@link ResourceXmlNode} of resource
	 * @return {@link DimensionResource} generated from node
	 */
	public static DimensionResource newInstance(ResourceXmlNode node) {
		DimensionResource dimenResource = new DimensionResource();
		dimenResource.setResourceType(Type.DIMEN);
		dimenResource.setResourceKey(node.getResourceKey());
		return dimenResource;
	}
	
	protected DimensionResource() {
		super();
	}
	
	@Override
	protected String getResourceAccessClass() {
		return DIMEN_ACCESS_CLASS_NAME;
	}	
}
