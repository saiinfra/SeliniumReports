package com.ontestautomation.selenium.ci;

import java.io.File;

import org.junit.Test;

public class TestRunner {
	@Test
	public void test() {
		File file = new File(
				"/var/lib/jenkins/jobs/TestFramework2/workspace/repor/allclasses-frame.html");
		System.out.println("AbsolutePath" +file.getAbsolutePath());

	}

}
