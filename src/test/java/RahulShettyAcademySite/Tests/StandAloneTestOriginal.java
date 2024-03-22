package RahulShettyAcademySite.Tests;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;
import pageObjects.loginPage;
import pageObjects.productCataloguePage;

public class StandAloneTestOriginal {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:/Users/91956/selenium/drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//Creating Object for the loginPage PO Class
		loginPage lp=new loginPage(driver);
		productCataloguePage pc=new productCataloguePage(driver);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Declaring implicit wait globally to take care of any delays in loading
		
		//driver.get("https://rahulshettyacademy.com/client");
		lp.openSiteAction("https://rahulshettyacademy.com/client");
		
		//driver.manage().window().maximize();
		lp.maximizewindow();
		
		//driver.findElement(By.id("userEmail")).sendKeys("qatraineraj@example.com");
		//driver.findElement(By.id("userPassword")).sendKeys("Qatraineraj1!");
		//driver.findElement(By.id("login")).click();
		
		lp.loginAction("qatraineraj@example.com", "Qatraineraj1!");
		
		
		List<WebElement> products=pc.getProductsListAction();
		
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		
		//We are collecting the Web Elements of all the available products and storing them in a List
		//Scanning all the products in the page just as a practice
		
		//List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		
		//Now we are using Java Streams to select the desired product
		//For the below to work, make sure that the Java Compiler version is 1.8
		//Right click on project-->Properties-->Java Compiler
				
		WebElement prod=products.stream().filter(product-> product.
				findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		
		prod.findElement(By.xpath("//button[@Class='btn w-10 rounded']")).click();
		
		
		//Now we will have to verify if the Success message is getting displayed on the screen
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Product Added To Cart']")));
		
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		
		//Validation to see if the product got added to the cart as expected
		
		List<WebElement> cartproducts=driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		Boolean cartvalidation=cartproducts.stream().anyMatch(cartproduct-> cartproduct.
				getText().equalsIgnoreCase("ZARA COAT 3"));
		Assert.assertTrue(cartvalidation);
		
		driver.findElement(By.xpath("//li[@class='totalRow']/button")).click();
		
		Actions a=new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "India").build().perform();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
		
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		String confirmationmessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertEquals(confirmationmessage, "THANKYOU FOR THE ORDER.");
		
		driver.quit();
	}

}
