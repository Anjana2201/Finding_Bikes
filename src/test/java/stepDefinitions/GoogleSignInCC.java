package stepDefinitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.util.Assert;

import POM.GoogleSignIn;
import POM.UpcomingBikes;
import factory.BaseClassFct;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSignInCC extends BaseClassFct {
	@Given("The user is navigated to ZigWheels Home Page for Login Option")
	public void the_user_is_navigated_to_zig_wheels_home_page_for_login_option() {
		UpcomingBikes ub = new UpcomingBikes(driver);
		Assert.notNull(ub.getLogo(), "ZigWheels Home Page is present");
	}

	@Given("Login icon is present")
	public void login_icon_is_present() {
		GoogleSignIn signin = new GoogleSignIn(driver);
		Assert.notNull(signin.getLogin(), "Login icon is present");
	}

	@When("The user clicks on Login button")
	public void the_user_clicks_on_login_button() {
		GoogleSignIn signin = new GoogleSignIn(driver);
		signin.clickLogin();
	}

	@When("The user clicks on Google button")
	public void the_user_clicks_on_google_button() {
		GoogleSignIn signin = new GoogleSignIn(driver);
		
		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(30));
	    waits.until(ExpectedConditions.elementToBeClickable(signin.googleSignIn()));
	    signin.googleSignIn().click();
	}

	@Given("The user navigated to login window")
	public void the_user_navigated_to_login_window() {
Set<String> windows = driver.getWindowHandles();
		
		new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.numberOfWindowsToBe(2));
	    
		Iterator<String> iterator = windows.iterator();
		
		// Get the handle of the parent window
		String parent = iterator.next();
		
		// Get the handle of the child window
		String child = iterator.next();
		
		driver.switchTo().window(child);
	}

	@Given("Text field to be present")
	public void text_field_to_be_present() {
		GoogleSignIn signin = new GoogleSignIn(driver);
		Assert.notNull(signin.getMail(), "Text field is present");
	}

	@When("The user enters {string} as emailID")
	public void the_user_enters_as_email_id(String string) {
		GoogleSignIn signin = new GoogleSignIn(driver);
		signin.sendMail(string);
		
		Actions action = new Actions(driver);
		action.moveToElement(signin.nextButton()).click().perform();
	}

	@Then("Retrieve the Error Message")
	public void retrieve_the_error_message() {
GoogleSignIn signin = new GoogleSignIn(driver);
		
		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(30));
	    waits.until(ExpectedConditions.elementToBeClickable(signin.errorMsg()));
	    
	    String msg=signin.errorMsg().getText();
	    System.out.println(msg);
	}

}
