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

import org.apache.commons.io.FilenameUtils;

public class Drawable extends Resource {

	private static final String DRAWABLE_ACCESS_CLASS_NAME = "drawable";
	
	public static Drawable newInstance(File file) {
		Drawable drawable = new Drawable();
		drawable.setResourceType(Type.DRAWABLE);
		String fileName = FilenameUtils.getBaseName(file.getAbsolutePath());
		drawable.setResourceKey(fileName);
		return drawable;
	}
	
	protected Drawable() {
		super();
	}
	
	@Override
	protected String getResourceAccessClass() {
		return DRAWABLE_ACCESS_CLASS_NAME;
	}
	
	public static boolean isDrawable(File file) {
		File parentDirectory = file.getParentFile();
		if (parentDirectory == null) return false;
		
		String parentDirectoryName = FilenameUtils.getBaseName(parentDirectory.getAbsolutePath());
		if (parentDirectoryName == null) return false;
		
		return parentDirectoryName.startsWith(DRAWABLE_ACCESS_CLASS_NAME);
	}
}
