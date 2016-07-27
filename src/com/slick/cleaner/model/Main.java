package com.slick.cleaner.model;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		String projectPath = "C:/Projects/Udacity/PopMovies/PopMovies/app/src/main";
		List<Resource> resources = Resources.loadResources(projectPath);
		System.out.println("Number of resources is: " + resources.size());
	}

}
