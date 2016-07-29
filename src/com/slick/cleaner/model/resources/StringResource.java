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
 * Defines string resource
 */
public class StringResource extends InlineResource {

	private static final String STRING_ACCESS_CLASS_NAME = "string";
	
	/**
	 * Creates new instance of {@link StringResource} resource from given node
	 * @param node {@link ResourceXmlNode} of resource
	 * @return {@link StringResource} generated from node
	 */
	public static StringResource newInstance(ResourceXmlNode node) {
		StringResource stringResource = new StringResource();
		stringResource.setResourceType(Type.STRING);
		stringResource.setResourceKey(node.getResourceKey());
		return stringResource;
	}
	
	protected StringResource() {
		super();
	}
	
	@Override
	protected String getResourceAccessClass() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
