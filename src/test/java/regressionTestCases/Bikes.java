package regressionTestCases;



import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POM.UpcomingBikes;
import factory.BaseClassFct;
@Listeners(TestBase.extentReports.class)
public class Bikes extends BaseClassFct {
	static Properties p;
	
	@Test(priority = 1)
	public void goToUpcomingBikes() throws Exception {
		UpcomingBikes ub=new UpcomingBikes(driver);
		
		Actions action = new Actions(driver);
		action.moveToElement(ub.newBikesMenu()).perform();
		
		ub.selectUpcomingBike();
	}
	
	@Test(priority = 2)
	public void displayBikes() throws Exception {
		UpcomingBikes ub=new UpcomingBikes(driver);
		
		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(30));
	    waits.until(ExpectedConditions.elementToBeClickable(ub.manufacturer()));
	    
		Select select = new Select(ub.manufacturer());
		select.selectByVisibleText("Honda");
		
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", ub.viewMoreBikes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test(priority = 3)
	public void getBikes() throws Exception {
		UpcomingBikes ub=new UpcomingBikes(driver);
		ub.bikeModels();
		
		p=BaseClassFct.getProperties();
		driver.get(p.getProperty("appURL"));
	}

}
