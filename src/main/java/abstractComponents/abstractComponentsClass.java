package abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class abstractComponentsClass {
	
	WebDriver driver;
	
	public abstractComponentsClass(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	public void maximizewindow() {
		
		driver.manage().window().maximize();
		
	}
	
	public void explicitWaitForElementVisibility(By findby) {
		
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(findby));
		
	}
	

}
