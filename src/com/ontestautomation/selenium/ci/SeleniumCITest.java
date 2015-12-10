package com.ontestautomation.selenium.ci;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumCITest {
	
	static WebDriver driver;
	
	@Before
	public void setup() {
		
	
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);				
	}
	
	@Test
	public void successfulLoginLogout() {
		
		driver.get("http://parabank.parasoft.com");
		Assert.assertEquals(driver.getTitle(), "ParaBank | Welcome | Online Banking");
		driver.findElement(By.name("username")).sendKeys("john");
		driver.findElement(By.name("password")).sendKeys("demo");
		driver.findElement(By.cssSelector("input[value='Log In']")).click();
		Assert.assertEquals(driver.getTitle(), "ParaBank | Accounts Overview");
		driver.findElement(By.linkText("Log Out")).click();
		Assert.assertEquals(driver.getTitle(), "ParaBank | Welcome | Online Banking");
	}

	@Test
	public void incorrectLogin() {
		
		driver.get("http://parabank.parasoft.com");
		Assert.assertEquals(driver.getTitle(), "ParaBank | Welcome | Online Banking");
		driver.findElement(By.name("username")).sendKeys("john");
		driver.findElement(By.name("password")).sendKeys("incorrectpassword");
		driver.findElement(By.cssSelector("input[value='Log In']")).click();
		Assert.assertEquals(driver.getTitle(), "ParaBank | Error");
		String errorText = driver.findElement(By.cssSelector("p[class='error']")).getText();
		Assert.assertEquals(errorText, "The username and password could not be verified.");
	}
	
	@Test
	public void thisTestShouldFail() {
		
		driver.get("http://parabank.parasoft.com");
		Assert.assertEquals(driver.getTitle(), "ParaBank | How are you today? | Online Banking");
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
	
}
