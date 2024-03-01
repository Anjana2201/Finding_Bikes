package stepDefinitions;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.util.Assert;

import POM.UpcomingBikes;
import factory.BaseClassFct;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpcomingBikesCC extends BaseClassFct {
	static Properties p;
	
	@Given("The user is navigated to ZigWheels Home Page")
	public void the_user_is_navigated_to_zig_wheels_home_page() {
	    UpcomingBikes ub = new UpcomingBikes(driver);
		Assert.notNull(ub.getLogo(), "ZigWheels Home Page is present");
	}

	@Given("New Bikes dropdown is present")
	public void new_bikes_dropdown_is_present_with_upcoming_bikes_option() throws Exception {
		UpcomingBikes ub = new UpcomingBikes(driver);
		Assert.notNull(ub.newBikesMenu(), "New Bikes menu is present");
	}

	@When("The user hover cursor on New Bikes and navigate to Upcoming Bikes")
	public void the_user_hover_cursor_on_new_bike_and_navigate_to_upcoming_bikes() throws Exception {
		UpcomingBikes ub = new UpcomingBikes(driver);
		
		Actions action = new Actions(driver);
		action.moveToElement(ub.newBikesMenu()).perform();
		
		ub.selectUpcomingBike();
	}

	@Then("The user should be redirected to Upcoming Bikes page")
	public void the_user_should_be_redirected_to_upcoming_bikes_page() {
		UpcomingBikes ub = new UpcomingBikes(driver);
		Assert.notNull(ub.getUBPage(), "Redirected to Upcoming Bikes page successfully");
	}

	@Given("The option to select manufacturer is present")
	public void the_option_to_select_manufacturer_is_present() {
		UpcomingBikes ub = new UpcomingBikes(driver);
		Assert.notNull(ub.manufacturer(), "The option to select manufacturer is present");
	}

	@When("The user selects {string} as the manufacturer and clicks View More Bikes option")
	public void the_user_selects_as_the_manufacturer_and_clicks_view_more_bikes_option(String string) {
		UpcomingBikes ub = new UpcomingBikes(driver);
		
		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(30));
	    waits.until(ExpectedConditions.elementToBeClickable(ub.manufacturer()));
	    
	    Select select = new Select(ub.manufacturer());
		select.selectByVisibleText(string);
		
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", ub.viewMoreBikes());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	@Then("Export the data of diplayed bikes to console and excel")
	public void export_the_data_on_bikes_to_console_and_excel() throws Exception {
		UpcomingBikes ub=new UpcomingBikes(driver);
		ub.bikeModels();
		
		p=BaseClassFct.getProperties();
		driver.get(p.getProperty("appURL"));
	}

}
