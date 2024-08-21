package POMpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseClass;

public class PomLogin extends BaseClass {

	// object repositoy
	@FindBy(css = "#email_address")
	WebElement Username;
	@FindBy(id = "password")
	WebElement Password;
	@FindBy(id = "login_button")
	WebElement LoginBtn;

	// initiate page element
	public PomLogin() {
		PageFactory.initElements(driver, this);
	}

	// all the methods for the test cases
	public void typUsernamed(String username) {
		Username.sendKeys(username);
	}

	public void typePassword(String password) {
		Password.sendKeys(password);
	}

	public void clickBtn() {
		LoginBtn.click();
	}
	public String verifyTitle() {
		return  driver.getTitle(); 
	}

}
