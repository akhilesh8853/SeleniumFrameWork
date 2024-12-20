package com.actitime.testscript;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(com.actitime.generic.ListenersImplementation.class)
public class ProjectModule {
	@Test(priority=0)
	public void createProject() {
		Reporter.log("Creating Project", true);
	}
	
	
	@Test(priority=1)
	public void modifyProject() {
		Reporter.log("modifying Project", true);
	}
	
	
	@Test(priority=2)
	public void deleteProject() {
		Reporter.log("deleting Project", true);
	}	
}
