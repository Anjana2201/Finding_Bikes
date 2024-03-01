package POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsedCars extends BasePage {
	WebDriver driver;
	
	public UsedCars(WebDriver driver) {
		super(driver);
	}
	
	// WebElements for used cars page
	
	@FindBy(xpath = "//a[normalize-space()='Used Cars']")
	WebElement usedCarsMenu;
	
	@FindBy(xpath = "//span[@onclick=\"goToUrl('/used-car/Chennai')\"]")
	WebElement chennaiUsedCars;
	
	@FindBy(xpath="//h1[contains(.,'Used Cars in Chennai')]")
	WebElement chennaiCars;
	
	@FindBy(xpath="//div[.='Popular Models']")
	WebElement popModels;
	
	@FindBy(xpath = "//ul[@class='zw-sr-secLev usedCarMakeModelList popularModels ml-20 mt-10']/li")
	List<WebElement> modelName;
	
	public WebElement usedCarsMenu() {
		return usedCarsMenu;
	}
	
	public void selectChennaiUsedCars() {
		
		chennaiUsedCars.click();
	}
	
	public WebElement getChennaiCars() {
		return chennaiCars;
	}
	
	public WebElement getPopModels() {
		return popModels;
	}
	
	public List<WebElement> modelList(){
		return modelName;
	}
}
