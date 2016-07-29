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
import java.util.ArrayList;
import java.util.List;

import com.slick.cleaner.model.xml.ResourceXmlFile;
import com.slick.cleaner.model.xml.ResourceXmlNode;
import com.slick.cleaner.model.xml.XmlNode;

/**
 * Defines inline resource as string which is part of
 * content in XML usually saved in values directory of 
 * project
 */
public abstract class InlineResource extends Resource {
	
	/**
	 * Checks if file is one of the inline resources
	 * @param file File to check
	 * @return <b>true</b> if file has multiple resources, <b>false</b> otherwise
	 */
	public static boolean isInlineResource(File file) {
		if (file.isDirectory()) return false;
		
		ResourceXmlFile xmlFile = ResourceXmlFile.readFile(file);
		if (xmlFile == null) return false;
		
		return xmlFile.isResourceXml();
	}
	
	/**
	 * Loads all primitive resources from a given file if its XML resource file.
	 * @param file File to load primitive resources from
	 * @return List of resources
	 */
	public static List<Resource> loadPrimitivesFromFile(File file) {
		List<Resource> resources = new ArrayList<>();
		ResourceXmlFile xmlFile = ResourceXmlFile.readFile(file);
		if (xmlFile == null) return resources;
		
		List<XmlNode> nodes = xmlFile.getNodes();
		for (XmlNode node : nodes) {
			if (!(node instanceof ResourceXmlNode)) continue;
			
			switch(Type.fromString(node.getNodeName())) {
			case STRING:
				StringResource resource = StringResource.newInstance((ResourceXmlNode) node);
				resources.add(resource);
				break;
			default:
				break;
			}
		}
		
		return resources;
	}
}
