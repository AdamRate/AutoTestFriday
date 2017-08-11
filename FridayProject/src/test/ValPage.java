package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ValPage {

	@FindBy (xpath ="//*[@id='js-header-nav']/ul/li[2]/a")
	private WebElement sellMyCarTab;
	
	@FindBy (xpath ="//*[@id='sell-my']/li[3]/a")
	private WebElement valueMyCarButton;
	
	@FindBy (xpath = "//*[@class='js-vrm-input']")
	private WebElement regNoField;
	
	@FindBy (xpath = "//*[@class='js-mileage-input']")
	private WebElement mileageField;
	
	@FindBy (xpath = "//*[@data-label='get-valuation-initiation']")
	private WebElement valuationButton;
	
	@FindBy (xpath = "//*[@class='vehicle-info__value']")
	private WebElement carReg;
	
	public WebElement getSellMyCarTab(){
		return sellMyCarTab;
	}
	
	public WebElement getValueMyCar(){
		return valueMyCarButton;
	}
	
	public WebElement getRegNoField(){
		return regNoField;
	}
	
	public WebElement getMileageField(){
		return mileageField;
	}
	
	public WebElement getValuationButton(){
		return valuationButton;
	}
	
	public WebElement returnCarReg(){
		return carReg;
	}
}
