package com.qspider.atlasian.pomrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloCreatelist {

	WebDriver driver;
	public TrelloCreatelist(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@value='Add list']")
	private WebElement addListButton;
	
	@FindBy(xpath = "(//span[text()='Add a card'])[1]")
	private WebElement addCardButton;
	
	@FindBy(xpath = "//textarea[contains(@class,'list-card-composer')]")
	private WebElement createCardTextfield;
	
	@FindBy(xpath = "(//span[text()='Add a card'])[2]")
	private WebElement addCardButton2;
	
	@FindBy(xpath = "(//div[@class='list-header-extras'])[1]")
	private WebElement listMoreOption;
	
	@FindBy(xpath = "//a[text()='Move all cards in this list…']")
	private WebElement moveAllCardInTheListOption;
	
	@FindBy(xpath = "//div//ul[@class='pop-over-list']/li[2]")
	private WebElement selectWhereToMoveButton;
	
	public WebElement getMoveAllCardInTheListOption() {
		return moveAllCardInTheListOption;
	}

	public WebElement getSelectWhereToMoveButton() {
		return selectWhereToMoveButton;
	}
	@FindBy(xpath = "//a[text()='Sort by…']")
	private WebElement sortByListOption;
	
	@FindBy(xpath = "//a[text()='Card name (alphabetically)']")
	private WebElement sortByAlphabetically;
	
	@FindBy(xpath = "(//div[@class='list-header-extras'])[2]")
	private WebElement listMoreOption2;
	
	@FindBy(xpath ="(//div[contains(@class,'list-header-target js-editing-target')])[1]")
	private WebElement listHeader1;
	
	@FindBy(xpath ="(//div[contains(@class,'list-header-target js-editing-target')])[2]")
	private WebElement listHeader2;
	
	@FindBy (xpath = "(//div//div[@class='list js-list-content'])[1]//span[@class='list-card-title js-card-name']")
	private List<WebElement> cardCount;
	
	public List<WebElement> getCardCount() {
		return cardCount;
	}

	public WebElement getListHeader2() {
		return listHeader2;
	}

	public WebElement getListHeader1() {
		return listHeader1;
	}

	public WebElement getListMoreOption() {
		return listMoreOption;
	}

	public WebElement getSortByListOption() {
		return sortByListOption;
	}

	public WebElement getSortByAlphabetically() {
		return sortByAlphabetically;
	}

	public WebElement getListMoreOption2() {
		return listMoreOption2;
	}

	public WebElement getAddCardButton() {
		return addCardButton;
	}

	public WebElement getCreateCardTextfield() {
		return createCardTextfield;
	}

	public WebElement getAddCardButton2() {
		return addCardButton2;
	}

	public WebElement getAddListButton() {
		return addListButton;
	}
}
