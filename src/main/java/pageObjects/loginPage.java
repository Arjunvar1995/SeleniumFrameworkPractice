package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.abstractComponentsClass;

public class loginPage extends abstractComponentsClass{
	
	static WebDriver driver;
	
	//Constructor has the same name as the class name and will be invoked first when the Class is run
	public loginPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		//To initialize all the elements and it requires the driver to be passed as an argument
		//This is how the annotation @FindBy will know about the driver
	}
	
	//WebElement username=driver.findElement(By.id("userEmail"));
	
	@FindBy(id="userEmail")
	WebElement usernamewe;
	
	//Another method to declare the WebElement and that's using PageFactory Class
	
	@FindBy(id="userPassword")
	WebElement userpasswordwe;
	
	@FindBy(id="login")
	WebElement loginbuttonwe;
	
	public void openSiteAction(String homepageurl) {
		
		driver.get(homepageurl);
		
	}
	
	public void loginAction(String mailid, String password) {
		
		usernamewe.sendKeys(mailid);
		userpasswordwe.sendKeys(password);
		loginbuttonwe.click();
		
	}

}
