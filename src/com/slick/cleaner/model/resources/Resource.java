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

import java.io.File;

/**
 * Defines single resource that may be found in an Android
 * project.
 */
public abstract class Resource {

	/**
	 * List of resource types that may be occurred in
	 * Android project
	 */
	public enum Type {
		/**
		 * Denotes drawable resource
		 */
		DRAWABLE,
		
		/**
		 * Denotes layout resource
		 */
		LAYOUT,
		
		/**
		 * Denotes menu resource
		 */
		MENU,
		
		/**
		 * Denotes if resource is not supported in project version
		 */
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
	
	/**
	 * Creates new instance of resource
	 * @param file File from resources
	 * @return Resource object
	 */
	public static Resource newInstance(File file) {
		Resource resource = null;
		switch(getResourceType(file)) {
		case DRAWABLE:
			resource = Drawable.newInstance(file);
			break;
		case LAYOUT:
			resource = Layout.newInstance(file);
			break;
		case MENU:
			resource = Menu.newInstance(file);
			break;
		default:
			break;
		}
		
		return resource;
	}
	
	protected Resource() {
	}
	
	/**
	 * Sets the key of the resource
	 * @param resourceKey Resource key
	 */
	protected void setResourceKey(String resourceKey) {
		mKey = resourceKey;
	}
	
	/**
	 * Returns resource key
	 * @return Resource key
	 */
	protected String getResourceKey() {
		return mKey;
	}
	
	/**
	 * Sets the resource type
	 * @param type Resource {@link Type}
	 */
	protected void setResourceType(Type type) {
		mType = type;
	}
	
	/**
	 * Returns resource type
	 * @return Resource type
	 */
	protected Type getResourceType() {
		return mType;
	}
	
	/**
	 * Returns resource access class
	 * @return Access class of a resource
	 */
	protected abstract String getResourceAccessClass();
	
	/**
	 * Compares with given resources 
	 * @param resource Resource to compare to
	 * @return <b>true</b> if resource name and type are same, <b>false</b> otherwise
	 */
	public boolean compare(Resource resource) {
		if (resource.getResourceKey() == null) return false;
		
		return resource.getResourceType() == mType &&
				resource.getResourceKey().equals(mKey);
	}
	
	/**
	 * Finds resource {@link Type} to which file belongs  
	 * @param file File to check
	 * @return {@link Type} where resource belongs
	 */
	public static Type getResourceType(File file) {
		if (Drawable.isDrawable(file)) {
			return Type.DRAWABLE;
		}
		
		if (Layout.isLayout(file)) {
			return Type.LAYOUT;
		}
		
		if (Menu.isMenu(file)) {
			return Type.MENU;
		}
		
		return Type.UNKNOWN;
	}
}
