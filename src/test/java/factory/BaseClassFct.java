package factory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
 
public class BaseClassFct {
 
		 public static WebDriver driver;
	     static Properties p;
	     static String browser;
	 
	     
	@BeforeTest
	public static WebDriver initilizeBrowser() throws IOException
	{
		//browser
//		Scanner sc=new Scanner(System.in);
//		System.out.println("Select a Browser");
//		browser=sc.nextLine();
		p=getProperties();
		browser=p.getProperty("browser");
		switch(browser) 
				{
				case "chrome":
			        driver=new ChromeDriver();
			        break;
			    case "edge":
			    	driver=new EdgeDriver();
			        break;
			    default:
			        System.out.println("No  matching browser");
			        driver=null;
				}
		 p=getProperties();
		 driver.get(p.getProperty("appURL"));
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().window().maximize();
		 return driver;
	}
	@AfterTest
	public void close_browser() {
		
		driver.quit();
	}
	public static Properties getProperties() throws IOException
	{		 
        FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
        p=new Properties();
		p.load(file);
		return p;
	}
	
	   public static String screenshot(String ssnum) throws IOException {
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File trg=new File("C:\\Users\\2303779\\OneDrive - Cognizant\\Desktop\\Hackathon_2303779\\Bikes\\Screenshots"+ssnum+".png");
			FileUtils.copyFile(src, trg);
			return "C:\\Users\\2303779\\OneDrive - Cognizant\\Desktop\\Hackathon_2303779\\Bikes\\Screenshots"+ssnum+".png";
		}

	
	

}