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
 * Defines menu resource
 */
public class Menu extends Resource {

	private static final String MENU_ACCESS_CLASS_NAME = "menu";
	
	/**
	 * Creates new instance of {@link Menu} resource from given file
	 * @param file {@link File} of resource
	 * @return {@link Menu} generated from file
	 */
	public static Menu newInstance(File file) {
		Menu menu = new Menu();
		menu.setResourceType(Type.MENU);
		String fileName = FilenameUtils.getBaseName(file.getAbsolutePath());
		menu.setResourceKey(fileName);
		return menu;
	}
	
	protected Menu() {
		super();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getResourceAccessClass() {
		return MENU_ACCESS_CLASS_NAME;
	}
	
	/**
	 * Checks if file is menu
	 * @param file File to check
	 * @return <b>true</b> if file is menu, <b>false</b> otherwise
	 */
	public static boolean isMenu(File file) {
		File parentDirectory = file.getParentFile();
		if (parentDirectory == null) return false;
		
		String parentDirectoryName = FilenameUtils.getBaseName(parentDirectory.getAbsolutePath());
		if (parentDirectoryName == null) return false;
		
		return parentDirectoryName.startsWith(MENU_ACCESS_CLASS_NAME);
	}
}
