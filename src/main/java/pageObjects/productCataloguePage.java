package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.abstractComponentsClass;

public class productCataloguePage extends abstractComponentsClass{
	
	WebDriver driver;
	
	public productCataloguePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> productswe;
	
	By productsby=By.cssSelector(".mb-3");
	By addToCartBy=By.xpath("//button[@Class='btn w-10 rounded']");
	
	
	public List<WebElement> getProductsListAction(){
		
		explicitWaitForElementVisibility(productsby);
		return productswe;
	}
	
	public WebElement getProductByNameAction(String productname) {
		
		WebElement prod=productswe.stream().filter(product-> product.
				findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		return prod;
		
	}
	
	public void addProductToCartAction(String productname) {
		
		WebElement prod=getProductByNameAction(productname);
		prod.findElement(addToCartBy).click();
		
	}

}