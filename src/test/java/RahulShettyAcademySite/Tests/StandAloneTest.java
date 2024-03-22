package RahulShettyAcademySite.Tests;

import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import RahulShettyAcademySite.TestComponents.baseTest;

import org.openqa.selenium.interactions.Actions;
import pageObjects.loginPage;
import pageObjects.productCataloguePage;

public class StandAloneTest extends baseTest{

		public static void main(String[] args) throws IOException {
		
		//System.setProperty("webdriver.chrome.driver","C:/Users/91956/selenium/drivers/chromedriver.exe");
		//WebDriver driver=new ChromeDriver();
		WebDriver driver=initializeDriver();
		String productname="ZARA COAT 3";
		loginPage lp=new loginPage(driver);
		lp.openSiteAction("https://rahulshettyacademy.com/client");
		
		//loginPage lp=new loginPage(driver);
		//productCataloguePage pc=new productCataloguePage(driver);
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//lp.openSiteAction("https://rahulshettyacademy.com/client");
		
		//lp.maximizewindow();
		
		//lp.loginAction("qatraineraj@example.com", "Qatraineraj1!");
		
		//List<WebElement> products=pc.getProductsListAction();
		
		//pc.addProductToCartAction(productname);
		
	}

}
