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

import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Wraps logic of a single XML node
 */
public class XmlNode {

	/**
	 * Node name
	 */
	protected String mNodeName;

	/**
	 * Creates new instance of required XML node based on
	 * provided node
	 * @param xmlNode XML node
	 * @return XmlNode object
	 */
	public static XmlNode newInstance(Node xmlNode) {
		switch(xmlNode.getNodeName()) {
		case "color":
		case "string":
		case "style":
		case "integer":
		case "dimen":
		case "bool":
			ResourceXmlNode node = new ResourceXmlNode();
			node.setResourceKey(((Element) xmlNode).getAttribute("name"));
			node.setNodeName(xmlNode.getNodeName());
			return node;
		default:
			return null;
		}
	}
	
	public XmlNode() {
	}
	
	/**
	 * Returns node name
	 * @return Node name
	 */
	public String getNodeName() {
		return mNodeName;
	}
	
	/**
	 * Sets node name
	 * @param nodeName Node name
	 */
	public void setNodeName(String nodeName) {
		mNodeName = nodeName;
	}
}
