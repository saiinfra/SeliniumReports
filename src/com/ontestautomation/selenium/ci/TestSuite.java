package com.ontestautomation.selenium.ci;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestOne.class,TestTwo.class,SeleniumCITest.class,TestRunner.class})

public class TestSuite{
}