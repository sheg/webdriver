package com.webdriver.qa.automation.framework;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class JsonFileCollector {

	private Set<File> systemJsonFiles = new HashSet<File>();

	public void populateAutomationJsonFiles(String root) throws Exception {
		File rootDirectory = new File(root);		
		if(!rootDirectory.isDirectory()) {
			throw new Exception("cannot populate automation Json files, root must be a directory - current root: " + root);
		}
		for(File file : rootDirectory.listFiles()) {
			if(file.isDirectory()) {
				populateAutomationJsonFiles(file.getPath());
			}
			else if(file.getName().endsWith(".json")) {
				systemJsonFiles.add(file);
			}
		}	
	}
	public Set<File> getSystemJsonFiles() {
		return this.systemJsonFiles;
	}
}