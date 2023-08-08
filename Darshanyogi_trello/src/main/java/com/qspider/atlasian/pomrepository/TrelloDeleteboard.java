package com.qspider.atlasian.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloDeleteboard {
	WebDriver driver;
	public TrelloDeleteboard(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
}
	@FindBy(css = "[class='show-sidebar-button-react-root']")
	private WebElement threeDotButton;
	
	@FindBy(xpath = "//a[contains(@class,'link js-open-more')]")
	private WebElement moreOption;
	
	@FindBy(xpath = "//a[contains(@class,'link js-close-board')]")
	private WebElement closeBoardOption;
	
	@FindBy(xpath = "//input[@value='Close']")
	private WebElement closeButton;
	
	@FindBy(xpath = "//button[text()='Permanently delete board']")
	private WebElement permanentlyDeleteButton;
	
	@FindBy(xpath = "//button[text()='Delete']")
	private WebElement deleteButton;
	
	@FindBy(xpath = "//span[text()='Share']")
	private WebElement shareButton;
	
	
	public WebElement getShareButton() {
		return shareButton;
	}

	public WebElement getThreeDotButton() {
		return threeDotButton;
	}

	public WebElement getMoreOption() {
		return moreOption;
	}

	public WebElement getCloseBoardOption() {
		return closeBoardOption;
	}

	public WebElement getCloseButton() {
		return closeButton;
	}

	public WebElement getPermanentlyDeleteButton() {
		return permanentlyDeleteButton;
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}
	
	
	
	
}