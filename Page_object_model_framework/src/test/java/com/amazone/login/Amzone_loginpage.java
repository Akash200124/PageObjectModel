package com.amazone.login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amzone_loginpage implements Object_repo {

	WebDriver driver = null;
	WebDriverWait wait = null;

	public Amzone_loginpage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	}

	public void logoclick() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(homePage_logo)));
		driver.findElement(By.xpath(homePage_logo)).click();
	}

	public void select_yourAddress() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(HomePage_selectyourAddress)));
		driver.findElement(By.xpath(HomePage_selectyourAddress));

	}

	public void serchProduct(String s) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(search_bar)));
		driver.findElement(By.xpath(search_bar)).sendKeys(s);

	}

	public void serachButton() {
		driver.findElement(By.xpath(Search_button)).click();
	}

}
