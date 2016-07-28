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

package com.slick.cleaner.model.xml;

public class ResourceXmlNode extends XmlNode {

	protected String mResourceKey;
	
	public ResourceXmlNode() {
	}
	
	public String getResourceKey() {
		return mResourceKey;
	}
	
	public void setResourceKey(String resourceName) {
		mResourceKey = resourceName;
	}
}
