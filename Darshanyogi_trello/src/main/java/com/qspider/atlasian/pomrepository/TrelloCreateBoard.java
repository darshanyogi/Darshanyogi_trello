package com.qspider.atlasian.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloCreateBoard {
	WebDriver driver;
	public TrelloCreateBoard(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
}
	@FindBy(xpath = "//p[text()='Create']")
	private WebElement createButton;
	
	@FindBy(xpath = "//span[text()='Create board']")
	private WebElement createBoardOption;
	
	@FindBy(xpath = "//button[@data-testid='create-board-submit-button']")
	private WebElement createBoardbutton;
	
	@FindBy(xpath = "//input[@type='text']")
	private WebElement boardsTitleTextfield;
	
	public WebElement getCreateButton() {
		return createButton;
	}

	public WebElement getCreateBoardOption() {
		return createBoardOption;
	}

	public WebElement getCreateBoardbutton() {
		return createBoardbutton;
	}

	public WebElement getBoardsTitleTextfield() {
		return boardsTitleTextfield;
	}
	
}