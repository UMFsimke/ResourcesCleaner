package com.slick.cleaner.model;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		String projectPath = "C:/Projects/Udacity/PopMovies/PopMovies/app/src/main";
		Resources resources = Resources.newInstance(projectPath);
		for (Resource resource : resources.mResources) {
			System.out.println("Resource : " + resource.mKey);
		}
	}

}
