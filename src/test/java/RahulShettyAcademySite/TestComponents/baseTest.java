package RahulShettyAcademySite.TestComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.loginPage;
import pageObjects.productCataloguePage;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class baseTest {
	
	static WebDriver driver;
	
	public static WebDriver initializeDriver() throws IOException {
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\91956\\eclipse-workspace\\SeleniumFrameworkPractice\\src\\main\\java\\resources\\Global.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver","C:/Users/91956/selenium/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("firefox")) {
		//code to initialize firefox driver
		}
		
		else if(browserName.equalsIgnoreCase("ie")) {
		//code to initialize ie driver
		}
		return driver;
		
		
		
	}
	
	public void launchApplication() throws IOException {
		
		driver=initializeDriver();

		
	}

}
