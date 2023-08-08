package com.qspider.atlasian.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloHomePage {
    WebDriver driver;
    public TrelloHomePage(WebDriver driver) {
    this.driver=driver;
    PageFactory.initElements(driver, this);
   }
    @FindBy(xpath = "//a[text()='Log in' and not(@tabindex='-1')]")
    private WebElement loginOption;
	public WebElement getLoginOption() {
		return loginOption;
	}
    
}
