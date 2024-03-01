package POM;

import java.io.IOException;
import java.text.NumberFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestBase.excel;
import factory.BaseClassFct;





public class UpcomingBikes extends BasePage {
	public WebDriver driver;
	static Properties p;
	
	//Constructor to initialize WebElements
	
	public UpcomingBikes(WebDriver driver) {
		super(driver);
	}
	
	// WebElements for Upcoming Bikes Page
		@FindBy(xpath= "//img[@data-track-label='zw-header-logo']")
		WebElement zigWheelsLogo;
	
		@FindBy(xpath= "//a[contains(text(),'New Bikes')]")
		WebElement newBikesMenu;
		
		@FindBy(xpath = "//span[contains(text(),'Upcoming Bikes')]")
		WebElement upcomingBikes;
		
		@FindBy(xpath = "//span[contains(normalize-space(),'Upcoming Bikes')]")
		WebElement upcomingBikesPage;
		
		@FindBy(id = "makeId")
		WebElement manufacturer;
		
		@FindBy(xpath = "//span[@class='zw-cmn-loadMore']")
		WebElement viewMore;
		
		@FindBy(xpath = "//*[@id='carModels']/ul")
		WebElement hondaBikeModels;
		
		// Hover over 'New Bikes' menu to view 'Upcoming Bikes'
		public WebElement getLogo() {
			return zigWheelsLogo;
		}
		
		public WebElement newBikesMenu() throws Exception {
			
			return newBikesMenu; 
		}
		
		public WebElement getUpcomingBikes() {
			return upcomingBikes;
		}
		
		public WebElement getUBPage() {
			return upcomingBikesPage;
		}
		public void selectUpcomingBike() throws Exception {

			upcomingBikes.click(); // Click 'Upcoming Bikes'
		}
		
		
		
		public WebElement manufacturer() {
			return manufacturer;
		}
		 
		// Click 'View More Bikes'
		
		public WebElement viewMoreBikes(){
			return viewMore;
		}

		// Get bike models, prices, and expected launch date
		
		public void bikeModels() throws Exception {
			
			// Get text of all bike models available on the page
			String bikeModels = hondaBikeModels.getText();
			
			// Split the text by new line character and store it in an ArrayList
			ArrayList<String> bikeModelsElements = new ArrayList<String>();
			Collections.addAll(bikeModelsElements, bikeModels.split("\n"));
	        
			// Initialize ArrayLists to store names, launch dates and prices of bikes
			ArrayList<String> nameList = new ArrayList<String>();
			ArrayList<String> dateList = new ArrayList<String>();
			ArrayList<String> priceList = new ArrayList<String>();
			String[] arr = null;
			
			// Iterate through the list of bike models and extract the required information
			for (int i = 0; i < bikeModelsElements.size(); i++) {
				String s = bikeModelsElements.get(i);
				if (s.contains("Honda")) {
					nameList.add(s);
				}
				if (s.contains("Rs. ")) {
					arr = s.split(" ");
					priceList.add(arr[1]);
				}
				if (s.contains("Launch Date : ")) {
					dateList.add(s);
				}
			}
			
			// Wait for page elements to load
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	        
			// Initialize an ArrayList to store upcoming bikes with price less than 4 Lakhs
			ArrayList<String> upcomingBikes = new ArrayList<String>();
			if(nameList.size()>0) {
				int row=0;
				for (int i = 0; i <nameList.size(); i++) {
				String temp = nameList.get(i);
				
				// Convert bike price to a double value
				NumberFormat format = NumberFormat.getInstance(Locale.FRANCE); // parse numbers in French-style format
				Number number = format.parse(priceList.get(i));
				double price = number.doubleValue();
				
				// Combine bike name, price and launch date to a single string
				String info = temp + "  " + priceList.get(i) + " Lakh  " + dateList.get(i);
				
				// Check if bike name is present in the string and price is less than 4 Lakhs
				if (info.contains(temp)) {
					if (Double.compare(price, 4d) < 0) {
						upcomingBikes.add(info);
						
						excel.setcelldata("Sheet1", nameList.get(i), row, 0);
						excel.setcelldata("Sheet1", priceList.get(i), row, 1);
						excel.setcelldata("Sheet1", dateList.get(i), row, 2);
						row+=1;
					}
				}
			  }
			}
			
			// Print the list of upcoming bikes to the console
			System.out.println("Upcoming Honda Bikes Below 4 Lakhs are as follows:");
			for (int i = 0; i < upcomingBikes.size(); i++) {
				System.out.println(upcomingBikes.get(i));
			}

		}


		
}
