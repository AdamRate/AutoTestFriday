package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutoTraderHomePage {

		@FindBy (xpath ="//*[@id='js-header-nav']/ul/li[5]/div[2]/a")
		private WebElement signInButton;
		
		public WebElement getSignInButton(){
			return signInButton;
		}
	
	
}
