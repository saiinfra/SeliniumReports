package com.ontestautomation.selenium.ci;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestOne.class,TestTwo.class,SeleniumCITest.class,RackspaceContactAutomation.class})

public class TestSuite{
}