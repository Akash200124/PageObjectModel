package com.amazone.login;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Amzone_login_Test extends Webdriver_Basic_class {

	WebDriver driver = null;
	WebDriverWait wait = null;
	Amzone_loginpage home;

	// send browser from the testng.xml

	@Parameters("browser")
	@BeforeClass
	void launchbrowser( @Optional("chrome") String browser) {
		// calling webdriver_basic_class method
		driver = loadDriver(browser);
		// creating instance of loginpage
		home = new Amzone_loginpage(driver);
	}

	// close the browser after performing the test cases
	@AfterClass
	void closebrowser() {
		driver.close();
	}

	@Test( enabled = false ,priority = 1, description = "To validate the logo on home page ")
	public void testlogo_icon() {
		// calling homepage methods
		home.logoclick();
	}

	@Test(enabled = false, priority = 2, description = "This functionality is use for search the product ")
	public void searchproduct() {
		home.select_yourAddress();
	}

	@Test(priority = 3 , description = " search functionality ")
	public void search() throws IOException
	{
		home.serchProduct("watch");
		home.serachButton();
		
		
 // this will take the screen shot and store in this project with file name contentpage.png
		File ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ss, new File(".\\screenshots\\contetpage.png"));
	
	
	
	
	
	
	

	
	 }

}
