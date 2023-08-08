package com.qspider.atlasian.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloLoginToContinuePage {
	
	WebDriver driver;
	public TrelloLoginToContinuePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
}
	@FindBy(id = "password")
	private WebElement passwordTextfield;
	
	@FindBy(id = "login-submit")
	private WebElement loginButton;
	
	@FindBy(xpath = "//div[@class='css-wwk9zm']//span[@class='css-g42x0s']")
	private WebElement flutteredButton;
	
	public WebElement getPasswordTextfield() {
		return passwordTextfield;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getFlutteredButton() {
		return flutteredButton;
	}
}