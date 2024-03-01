package regressionTestCases;

import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



import POM.GoogleSignIn;
import factory.BaseClassFct;
@Listeners(TestBase.extentReports.class)
public class GoogleLogin extends BaseClassFct{
	static Properties p;
	
	@Test(priority = 1)
	public void clickLogin() {
		GoogleSignIn signin = new GoogleSignIn(driver);
		
		signin.clickLogin();
		
		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(30));
	    waits.until(ExpectedConditions.elementToBeClickable(signin.googleSignIn()));
	    signin.googleSignIn().click();
	    
	}
	
	@Test(priority = 2)
	public void sendEmail() {
		Set<String> windows = driver.getWindowHandles();
		
		new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.numberOfWindowsToBe(2));
	    
		Iterator<String> iterator = windows.iterator();
		
		// Get the handle of the parent window
		String parent = iterator.next();
		
		// Get the handle of the child window
		String child = iterator.next();
		
		driver.switchTo().window(child);
		
		GoogleSignIn signin = new GoogleSignIn(driver);
		signin.sendMail("abc@abc");
		
		Actions action = new Actions(driver);
		action.moveToElement(signin.nextButton()).click().perform();
	}
	
	@Test(priority = 3)
	public void getMessage() {
		GoogleSignIn signin = new GoogleSignIn(driver);
		
		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(30));
	    waits.until(ExpectedConditions.elementToBeClickable(signin.errorMsg()));
	    
	    String msg=signin.errorMsg().getText();
	    System.out.println(msg);
	}
	
}
