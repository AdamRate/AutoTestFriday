package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	@FindBy (xpath = "//*[@id='js-social__signup-tab']/span")
	private WebElement signUpButton;
	
	@FindBy (xpath = "//*[@id='email']")
	private WebElement usernameField;
	
	@FindBy (xpath = "//*[@id='password']")
	private WebElement passwordField;
	
	@FindBy (xpath = "//*[@id='social--signup--submit']")
	private WebElement signUpSubmitButton;
	
	@FindBy (xpath = "//*[@id='js-header-nav']/ul/li[5]/div[1]/a/i")
	private WebElement myAccountButton;
	
	public WebElement getSignUpButton(){
		return signUpButton;
	}
	
	public WebElement getUsernameField(){
		return usernameField;
	}
	
	public WebElement getPasswordField(){
		return passwordField;
	}
	
	public WebElement getsignUpSubmitButton(){
		return signUpSubmitButton;
	}
	
	public WebElement getMyAccount(){
		return myAccountButton;
	}
	

}
