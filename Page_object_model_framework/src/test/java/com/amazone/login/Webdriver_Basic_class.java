package com.amazone.login;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webdriver_Basic_class {

	private WebDriver driver = null;
	private WebDriverWait wait = null;

	
	public WebDriver loadDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();

		} else {
			driver = new ChromeDriver();

		}

		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		driver.manage().window().maximize();

		driver.get("https://www.amazon.in/");

		return driver;
	}
}
