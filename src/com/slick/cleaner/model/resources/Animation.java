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
 * Defines animation resource
 */
public class Animation extends Resource {

	private static final String ANIMATION_ACCESS_CLASS_NAME = "anim";
	
	/**
	 * Creates new instance of {@link Animation} resource from given file
	 * @param file {@link File} of resource
	 * @return {@link Animation} generated from file
	 */
	public static Animation newInstance(File file) {
		Animation animation = new Animation();
		animation.setResourceType(Type.ANIMATION);
		String fileName = FilenameUtils.getBaseName(file.getAbsolutePath());
		animation.setResourceKey(fileName);
		return animation;
	}
	
	protected Animation() {
		super();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getResourceAccessClass() {
		return ANIMATION_ACCESS_CLASS_NAME;
	}
	
	/**
	 * Checks if file is animation
	 * @param file File to check
	 * @return <b>true</b> if file is animation, <b>false</b> otherwise
	 */
	public static boolean isAnimation(File file) {
		File parentDirectory = file.getParentFile();
		if (parentDirectory == null) return false;
		
		String parentDirectoryName = FilenameUtils.getBaseName(parentDirectory.getAbsolutePath());
		if (parentDirectoryName == null) return false;
		
		return parentDirectoryName.startsWith(ANIMATION_ACCESS_CLASS_NAME);
	}
}