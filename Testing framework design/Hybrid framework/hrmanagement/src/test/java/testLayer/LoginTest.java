package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import POMpackage.PomLogin;
import basePackage.BaseClass;
import testData.ExcelSheet;

public class LoginTest extends BaseClass {

	PomLogin login;

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void initialSetup() throws InterruptedException {
		initialization();
		login = new PomLogin();
	}
	
	@AfterMethod
	public void close() {
		screenshots("loginPage"+Math.random());
		driver.close(); 
	}

	@Test(priority = 1)
	public void title() {
		String actul = login.verifyTitle();
		System.out.println(actul);
		Assert.assertEquals("MobiHeal - Mobile Device Management & Security", actul);
	}
	
	@DataProvider 
	public Object [][] Details(){
		Object result[][]= ExcelSheet.readData("Sheet1");
		return result; 
	}
	
	@Test(priority = 2 , dataProvider = "Details")
	public void login(String userName ,String password) {
//		login.typUsernamed(prop.getProperty("username"));
		login.typUsernamed(userName);
//		login.typePassword(prop.getProperty("Admin@1234"));
		login.typePassword(password);
		login.clickBtn();
	}
	
	
}
