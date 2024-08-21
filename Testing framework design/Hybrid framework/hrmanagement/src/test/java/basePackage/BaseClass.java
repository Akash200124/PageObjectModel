package basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.TimeUtilies;

public class BaseClass {

	// This is use to read the properties from config.properties file s
	public static Properties prop = new Properties();
	public static WebDriver driver;

	// step 1

	public BaseClass() {
		FileInputStream file;
		try {
			file = new FileInputStream(
					"D:\\New folder\\Testing framework design\\Hybrid framework\\hrmanagement\\src\\test\\java\\enviromentVariables\\config.properties");
			prop.load(file);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// setp 2
	public static void initialization() throws InterruptedException {
		// driver path
		// maximize . pageload , implicite , getting url
		String browserName = prop.getProperty("browser").trim();
//		System.out.println(browserName.toString());
//		WebDriverManager.chromedriver().setup();

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.safaridriver().setup();
			driver = new FirefoxDriver();
		}

		if (driver == null) {
			System.out.println("driver is not initialized to driver ");
		}

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
//		driver.manage().wait(TimeUtilies.timePage);

	}

	public static void screenshots(String fileName) {

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(file, new File(
					"D:\\New folder\\Testing framework design\\Hybrid framework\\hrmanagement\\src\\test\\java\\screenshots\\screenshot"
							+ fileName + ".jpg"));
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
