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
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FilenameUtils;

/**
 * Definition of all resources in a project and their properties
 */
public class Resources {

	private static final String RESOURCES_FOLDER_NAME = "res";
	
	/**
	 * Auto-generated directory names that should be ignored
	 */
	private static final String[] IGNORED_DIRECTORIES_NAMES = {
			"bin", "build", "gen"
	};
	
	/**
	 * List of all resources
	 */
	protected List<Resource> mResources;
	
	public static Resources newInstance(String projectPath) {
		Resources resources = new Resources();
		resources.loadResources(projectPath);
		return resources;
	}
	
	protected Resources() {
		mResources = new ArrayList<>();
	}
	
	/**
	 * Returns list of {@link Resource} in project
	 * @return List of resources in project
	 */
	public List<Resource> getResources() {
		return mResources;
	}
	
	/**
	 * Loads all resources in a project
	 * @param projectPath Path to the <b>root</b> of the project
	 */
	protected void loadResources(String projectPath) {
		File resourcesDirectory = getResourcesDirectory(projectPath);
		getAllResourceReferences(resourcesDirectory);
	}
	
	/**
	 * Finds resources directory in a project
	 * @param projectPath Path to the <b>root</b> of the project
	 * @return Resources directory file
	 */
	protected File getResourcesDirectory(String projectPath) {
		File projectDirectory = new File(projectPath);
		validateProjectDirectory(projectDirectory);
		return getResourcesDirectoryRecursively(projectDirectory);
	}
	
	/**
	 * Validates a project directory 
	 * @param projectDirectory Root directory of project
	 */
	protected void validateProjectDirectory(File projectDirectory) {
		if (!projectDirectory.exists()) {
			throw new InvalidParameterException("Given path is not pointing to existing project location");
		}
		
		if (!projectDirectory.isDirectory()) {
			throw new InvalidParameterException("Given path is not pointing to project directory");
		}
	}
	
	/**
	 * Finds resources directory recursively in a project directory
	 * @param projectDirectory Project directory
	 * @return Resources directory file
	 */
	protected File getResourcesDirectoryRecursively(File projectDirectory) {
		for (File file : projectDirectory.listFiles()) {
			if (isResourcesDirectory(file)) {
				return file;
			}
		}
		
		return null;
	}
	
	/**
	 * Checks if given file is resources directory
	 * @param file File to check
	 * @return <b>true</b> if given file is resources directory, 
	 * <b>false</b> otherwise
	 */
	protected boolean isResourcesDirectory(File file) {
		return file.isDirectory() && RESOURCES_FOLDER_NAME.equals(
				FilenameUtils.getBaseName(file.getAbsolutePath()));
	}
	
	/**
	 * Finds all resource references
	 * @param resourcesDirectory Resource directory
	 */
	protected void getAllResourceReferences(File resourcesDirectory) {
		for (File file : resourcesDirectory.listFiles()) {
			if (file.isDirectory()) {
				if (!shouldIgnoreDirectory(file)) {
					getAllResourceReferences(file);
				}
				
				continue;
			}
			
			Resource resource = Resource.newInstance(file);
			if (resource != null && !isResourceAdded(resource)) {
				mResources.add(resource);
			}
		}
	}
	
	/**
	 * Checks if directory should be ignored. Automatically generated directories
	 * should be ignored for assets list.
	 * 
	 * @param directory Directory to check
	 * @return <b>true</b> if directory should be ignored, <b>false</b> otherwise
	 */
	protected boolean shouldIgnoreDirectory(File directory) {
		String directoryName = FilenameUtils.getBaseName(directory.getAbsolutePath());
		for (String ignoredDirectoryName : IGNORED_DIRECTORIES_NAMES) {
			if (ignoredDirectoryName.equals(directoryName)) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Checks if resource is already added in resources list
	 * @param resource {@link Resource} to check
	 * @return <b>true</b> if resource is already added, <b>false</b> otherwise
	 */
	protected boolean isResourceAdded(Resource resource) {
		if (mResources == null) return false;
		
		for (Resource existingResource : mResources) {
			if (existingResource.compare(resource)) {
				return true;
			}
		}
		
		return false;
	}
}
