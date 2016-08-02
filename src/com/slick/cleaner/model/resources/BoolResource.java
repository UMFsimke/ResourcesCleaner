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

import com.slick.cleaner.model.resources.Resource.Type;
import com.slick.cleaner.model.xml.ResourceXmlNode;

/**
 * Defines bool resource
 */
public class BoolResource extends InlineResource {

	private static final String BOOL_ACCESS_CLASS_NAME = "bool";
	
	/**
	 * Creates new instance of {@link BoolResource} resource from given node
	 * @param node {@link ResourceXmlNode} of resource
	 * @return {@link BoolResource} generated from node
	 */
	public static BoolResource newInstance(ResourceXmlNode node) {
		BoolResource boolResource = new BoolResource();
		boolResource.setResourceType(Type.BOOL);
		boolResource.setResourceKey(node.getResourceKey());
		return boolResource;
	}
	
	protected BoolResource() {
		super();
	}
	
	@Override
	protected String getResourceAccessClass() {
		return BOOL_ACCESS_CLASS_NAME;
	}	
}
