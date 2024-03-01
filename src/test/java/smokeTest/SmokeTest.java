package smokeTest;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POM.GoogleSignIn;
import POM.UpcomingBikes;
import POM.UsedCars;
import factory.BaseClassFct;

@Listeners(TestBase.extentReports.class)
public class SmokeTest extends BaseClassFct {
	static Properties p;
	
	@Test(priority = 1)
	public void upComingBikes() throws Exception{
		
		UpcomingBikes ub = new UpcomingBikes(driver);
		
		Actions action = new Actions(driver);
		action.moveToElement(ub.newBikesMenu()).perform();
		
		ub.selectUpcomingBike();
		System.out.println("Upcoming Bikes submenu test passed");
		
		p=BaseClassFct.getProperties();
		driver.get(p.getProperty("appURL"));
	}
	
	@Test(priority = 2)
	public void usedCars() throws InterruptedException, IOException {
		
		UsedCars uc=new UsedCars(driver);
		
		Actions action = new Actions(driver);
		action.moveToElement(uc.usedCarsMenu()).perform();
		
		uc.selectChennaiUsedCars(); // Clicks on the Find Used Cars menu
		System.out.println("Find Used Cars submenu test passed");
		
		p=BaseClassFct.getProperties();
		driver.get(p.getProperty("appURL"));
	}
	
	@Test(priority = 3)
	public void testGoogleSignIn() throws InterruptedException, IOException {
		
		GoogleSignIn signin = new GoogleSignIn(driver);
		signin.clickLogin(); // Clicks on the Sign In button
		System.out.println("Sign In Button functionality passed");
		
		p=BaseClassFct.getProperties();
		driver.get(p.getProperty("appURL"));
	}
}
