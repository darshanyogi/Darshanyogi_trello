package com.qspider.atlasian.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloLoginPage {
	WebDriver driver;
	public TrelloLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath = "//input[@id='user']")
	private WebElement userNameTextField;
	public WebElement getUserNameTextField() {
		return userNameTextField;
	}
	@FindBy(id ="login")
     private WebElement CountinueButton;
	public WebElement getCountinueButton() {
		return CountinueButton;
	}
	
	

}
