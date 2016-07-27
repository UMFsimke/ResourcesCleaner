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

import org.apache.commons.io.FilenameUtils;

/**
 * Defines layout resource
 */
public class Layout extends Resource {

	private static final String LAYOUT_ACCESS_CLASS_NAME = "layout";
	
	/**
	 * Creates new instance of {@link Layout} resource from given file
	 * @param file {@link File} of resource
	 * @return {@link Layout} generated from file
	 */
	public static Layout newInstance(File file) {
		Layout layout = new Layout();
		layout.setResourceType(Type.LAYOUT);
		String fileName = FilenameUtils.getBaseName(file.getAbsolutePath());
		layout.setResourceKey(fileName);
		return layout;
	}
	
	protected Layout() {
		super();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getResourceAccessClass() {
		return LAYOUT_ACCESS_CLASS_NAME;
	}
	
	/**
	 * Checks if file is layout
	 * @param file File to check
	 * @return <b>true</b> if file is layout, <b>false</b> otherwise
	 */
	public static boolean isLayout(File file) {
		File parentDirectory = file.getParentFile();
		if (parentDirectory == null) return false;
		
		String parentDirectoryName = FilenameUtils.getBaseName(parentDirectory.getAbsolutePath());
		if (parentDirectoryName == null) return false;
		
		return parentDirectoryName.startsWith(LAYOUT_ACCESS_CLASS_NAME);
	}
}