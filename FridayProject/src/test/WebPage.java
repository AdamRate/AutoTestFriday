package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebPage {

		@FindBy (xpath ="")
		private WebElement A;
		
		public WebElement getA(){
			return A;
		}
	
	
}
