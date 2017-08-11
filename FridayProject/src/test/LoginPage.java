package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	@FindBy(xpath = "//*[@id='js-social__signup-tab']/span")
	private WebElement signUpButton;

	@FindBy(xpath = "//*[@id='email']")
	private WebElement signUpUserField;

	@FindBy(xpath = "//*[@id='password']")
	private WebElement signUpPassField;

	@FindBy(xpath = "//*[@id='social--signup--submit']")
	private WebElement signUpSubmitButton;

	@FindBy(xpath = "//*[@id='signin-email']")
	private WebElement signInUserField;

	@FindBy(xpath = "//*[@id='signin-password']")
	private WebElement signInPassField;

	@FindBy(xpath = "//input[@id='signInSubmit']")
	private WebElement signInSubmitButton;

	@FindBy(xpath = "//*[@id='js-header-nav']/ul/li[5]/div[1]/a/i")
	private WebElement myAccountButton;

	public WebElement getSignUpButton() {
		return signUpButton;
	}

	public WebElement getSignUpUserField() {
		return signUpUserField;
	}

	public WebElement getSignUpPassField() {
		return signUpPassField;
	}

	public WebElement getSignUpSubmitButton() {
		return signUpSubmitButton;
	}

	public WebElement getSignInUserField() {
		return signInUserField;
	}

	public WebElement getSignInPassField() {
		return signInPassField;
	}
	
	public WebElement getSignInSubmitButton(){
		return signInSubmitButton;
	}

	public WebElement getMyAccount() {
		return myAccountButton;
	}

}
