package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSignIn extends BasePage {
	WebDriver driver;
	
	public GoogleSignIn(WebDriver driver) {
		super(driver);
	}
	
	 // page objects
	 
	 @FindBy(xpath = "//span[normalize-space()='Google']")
	 WebElement google;
	 
	 @FindBy(xpath ="//div[@id='forum_login_title_lg']")
	 WebElement signInButton;
	 
	 @FindBy(id = "identifierId")
	 WebElement email;
	 
	 @FindBy(xpath = "//span[contains(text(),'Next')]")
	 WebElement emailNextButton;
	 
	 @FindBy(xpath = "//div[@class='o6cuMc Jj6Lae' and contains(text(),'Enter a valid email or phone number')]")
	 WebElement errorMessage;
	 
	 @FindBy(id = "continue")
	 WebElement continueWithGoogle;	
	 
	 public WebElement getLogin() {
			return signInButton;
		}
	 
	 public void clickLogin() {
		 signInButton.click();
	 	}
	 
	 public WebElement googleSignIn() {
		return google;
	 	}
	 
	 public WebElement getMail() {
		return email;
		}
	 
	 public void sendMail(String mail) {
		email.sendKeys(mail);
	 	}
	 
	 public WebElement nextButton() {
		return emailNextButton;
	 	}
	 
	 public WebElement errorMsg() {
		return errorMessage;
	 	}
}
