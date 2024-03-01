package stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.util.Assert;

import POM.UpcomingBikes;
import POM.UsedCars;
import TestBase.excel;
import factory.BaseClassFct;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UsedCarsCC extends BaseClassFct {
	static Properties p;
	
	@Given("the user is navigated to ZigWheels Home Page again")
	public void the_user_is_navigated_to_zig_wheels_home_page_again() {
		UpcomingBikes ub = new UpcomingBikes(driver);
		Assert.notNull(ub.getLogo(), "ZigWheels Home Page is present");
	}

	@Given("Used Cars dropdown is present")
	public void used_cars_dropdown_is_present() throws Exception {
		UsedCars uc = new UsedCars(driver);
		Assert.notNull(uc.usedCarsMenu(), "Used Cars menu is present");
	}

	@When("the user hover cursor on Used Cars and navigate to Chennai")
	public void the_user_hover_cursor_on_used_cars_and_navigate_to_chennai() {
		UsedCars uc=new UsedCars(driver);
		
		Actions action = new Actions(driver);
		action.moveToElement(uc.usedCarsMenu()).perform();
		
		uc.selectChennaiUsedCars();
	}

	@Then("the user should be redirected to Used Cars in Chennai page")
	public void the_user_should_be_redirected_to_used_cars_in_chennai_page() {
		UsedCars uc = new UsedCars(driver);
		Assert.notNull(uc.getChennaiCars(), "Redirected to Used Cars in Chennai page successfully");
	}

	@Given("the Popular Models list is present")
	public void the_popular_models_list_is_present() {
		UsedCars uc = new UsedCars(driver);
		Assert.notNull(uc.getPopModels(), "Popular Models list is present");
	}

	@When("the user scrolls for visibility of list")
	public void the_user_scrolls_for_visibility_of_list() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("scroll(0, 500)");
	}

	@Then("Export the list of data to console and excel")
	public void export_the_list_of_data_to_console_and_excel() throws IOException {
		UsedCars uc=new UsedCars(driver);
		
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
