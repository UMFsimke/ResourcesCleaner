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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Includes logic of resource XML file
 */
public class ResourceXmlFile extends XmlFile {

	private static final String INLINE_RESOURCE_ROOT_NODE = "resources";
	
	protected List<XmlNode> mNodes;
	
	/**
	 * Reads resource XML file
	 * @param file File to read
	 * @return Resource XML file object
	 */
	public static ResourceXmlFile readFile(File file) {
		ResourceXmlFile xmlFile = new ResourceXmlFile();
		try {
			xmlFile.read(file);
			
			if (xmlFile.isResourceXml()) {
				xmlFile.readNodes();
			}
		} catch (SAXException | IOException | ParserConfigurationException e) {
			return null;
		}
		
		return xmlFile;
	}
	
	public ResourceXmlFile() {
		mNodes = new ArrayList<>();
	}
	
	public boolean isResourceXml() {
		return getRootNodeName().equals(INLINE_RESOURCE_ROOT_NODE);
	}
	
	protected void readNodes() {
		NodeList nodes = mDoc.getDocumentElement().getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeType() != Node.ELEMENT_NODE) continue;
			
			mNodes.add(XmlNode.newInstance(node));
		}
	}
	
	public List<XmlNode> getNodes() {
		return mNodes;
	}
}
