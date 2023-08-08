package com.qspider.atlasian.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloLogoutAtlassianAccount {
	WebDriver driver;
	public TrelloLogoutAtlassianAccount(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
}
	@FindBy(id = "logout-submit")
	private WebElement logoutButton;
	public WebElement getLogoutButton() {
		return logoutButton;
	}
}