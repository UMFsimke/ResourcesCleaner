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

package com.slick.cleaner.model;

import java.io.File;

/**
 * Defines single resource that may be found in an Android
 * project.
 */
public abstract class Resource {

	public enum Type {
		DRAWABLE,
		UNKNOWN
	}
	
	/**
	 * Key for given resource
	 */
	protected String mKey;
	
	/**
	 * Resource type
	 */
	protected Type mType;
	
	public Resource() {
	}
	
	/**
	 * Sets the key of the resource
	 * @param resourceKey Resource key
	 */
	protected void setResourceKey(String resourceKey) {
		mKey = resourceKey;
	}
	
	/**
	 * Sets the resource type
	 * @param type Resource {@link Type}
	 */
	protected void setResourceType(Type type) {
		mType = type;
	}
	
	/**
	 * Returns resource access class
	 * @return Access class of a resource
	 */
	protected abstract String getResourceAccessClass();
	
	/**
	 * Finds resource {@link Type} to which file belongs  
	 * @param file File to check
	 * @return {@link Type} where resource belongs
	 */
	public static Type getResourceType(File file) {
		if (Drawable.isDrawable(file)) {
			return Type.DRAWABLE;
		}
		
		return Type.UNKNOWN;
	}
}