package com.slick.cleaner.model;

import java.util.List;

import com.slick.cleaner.model.resources.Resource;
import com.slick.cleaner.model.resources.Resources;

public class Main {

	public static void main(String[] args) {
		String projectPath = "C:/Projects/Udacity/PopMovies/PopMovies/app/src/main";
		Resources resources = Resources.newInstance(projectPath);
		for (Resource resource : resources.getResources()) {
			System.out.println("Resource: " + resource.getResourceKey());
		}
	}

}
