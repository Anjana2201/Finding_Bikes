package regressionTestCases;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POM.UsedCars;
import TestBase.excel;
import factory.BaseClassFct;
@Listeners(TestBase.extentReports.class)
public class Cars extends BaseClassFct{
	static Properties p;
	
	@Test(priority = 1)
	public void goToUsedCarsMenu() {
		UsedCars uc=new UsedCars(driver);
		
		Actions action = new Actions(driver);
		action.moveToElement(uc.usedCarsMenu()).perform();
		
		uc.selectChennaiUsedCars();
		
	}
	
	@Test(priority = 2)
	public void getModelList() throws IOException {
		UsedCars uc=new UsedCars(driver);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("scroll(0, 500)");
	    
	    WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(30));
	    waits.until(ExpectedConditions.visibilityOfAllElements(uc.modelList()));
	    
	    System.out.println("Following is the list of Popular models:");
		int row=0;
	    for (int i = 0; i < uc.modelList().size(); i++) {
			System.out.println(uc.modelList().get(i).getText());
			excel.setcelldata("Sheet2", uc.modelList().get(i).getText(), row, 0);
			row+=1;
		}
		
		p=BaseClassFct.getProperties();
		driver.get(p.getProperty("appURL"));
	}

}
