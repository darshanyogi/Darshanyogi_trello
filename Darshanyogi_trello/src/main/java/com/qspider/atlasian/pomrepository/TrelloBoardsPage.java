package com.qspider.atlasian.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloBoardsPage {
	WebDriver driver;
	public TrelloBoardsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
   	
}
	@FindBy(xpath = "//span[text()='Views' and not(@class)]")
	private WebElement viewsOption;
	public WebElement getViewsOption() {
		return viewsOption;
	}
	@FindBy(xpath ="//div[@role='presentation']/button[contains(@data-testid,'menu-button')]//span"  )
	private WebElement profileOption;
	public WebElement getProfileOption() {
		return profileOption;
	}
	@FindBy(xpath = "//span[text()='Log out']")
	private WebElement logoutOption;
	
    @FindBy(id = "logout-submit")
    private WebElement logoutButton;
    
    
	public WebElement getLogoutButton() {
		return logoutButton;
	}


	public WebElement getLogoutOption() {
		return logoutOption;
	}
}