package com.qspider.atlasian.test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.qspider.atlasian.genericutility.BaseClass;
import com.qspider.atlasian.pomrepository.TrelloBoardsPage;
import com.qspider.atlasian.pomrepository.TrelloCreateBoard;
import com.qspider.atlasian.pomrepository.TrelloCreatelist;
import com.qspider.atlasian.pomrepository.TrelloDeleteboard;
import com.qspider.atlasian.pomrepository.TrelloHomePage;
import com.qspider.atlasian.pomrepository.TrelloLoginPage;
import com.qspider.atlasian.pomrepository.TrelloLoginToContinuePage;

public class TrelloScriptTest extends BaseClass {
	@Test(priority = 1)
	public void TrelloHomePageCheck() throws EncryptedDocumentException, IOException {
		String actualHomePageTitle = driver.getTitle();
		if (actualHomePageTitle.equals(excelUtil.readStringData("testdata", 0, 1))) {
			Reporter.log("Home page is displayed and verfied upon its title");
		} else {
			Reporter.log("Home page is not displayed and verfied upon its title");
		}
	}

	@Test( priority = 2)
	public void TrelloLoginPageCheck() throws EncryptedDocumentException, IOException {
		TrelloHomePageCheck();
		TrelloHomePage homePage = new TrelloHomePage(driver);
		homePage.getLoginOption().click();
		if (webdriverUtil.explictWaitForCompleteTitle(driver, excelUtil.readStringData("testdata", 1, 1))) {
			Reporter.log("Login Page is displayed  and it is verified upon the title");
		} else {
			Reporter.log("Login Page is not displayed  and it is verified upon the title");
		}
		if (driver.getCurrentUrl().equals(excelUtil.readStringData("testdata", 2, 1))) {
			Reporter.log("Login Page is displayed And it is Verified upon the url");
		} else {
			Reporter.log("Login Page is not displayed And it is Verified upon the url");
		}
	}

	@Test(priority = 3)
	public void TrelloBoardspage() throws IOException {
		TrelloLoginPageCheck();
		TrelloLoginPage loginPage = new TrelloLoginPage(driver);
		webdriverUtil.implicitWait(driver);
		webdriverUtil.explicitWaitForElement(driver, loginPage.getUserNameTextField());
		//driver.switchTo().activeElement().sendKeys(fileUtils.readPropertyFileData("username"));
		webdriverUtil.action(driver).click(loginPage.getUserNameTextField()).sendKeys(fileUtils.readPropertyFileData("username")).pause(2000).perform();
		loginPage.getCountinueButton().submit();
		if (webdriverUtil.explictWaitForCompleteTitle(driver, excelUtil.readStringData("testdata", 3, 1))) {
			Reporter.log("Login with Atlassian account page is displyed and it is verified upon the title");
		} else {
			Reporter.log("Login with Atlassian account page is not displyed and it is verified upon the title");
		}
		if (webdriverUtil.explictWaitForCompleteUrl(driver, excelUtil.readStringData("testdata", 4, 1))) {
			Reporter.log("Login with Atlassian account page is displyed and it is verified upon the Url");
		} else {
			Reporter.log("Login with Atlassian account page is not displyed and it is verified upon the Url");
		}
		TrelloLoginToContinuePage loginToContinuePage = new TrelloLoginToContinuePage(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(loginToContinuePage.getPasswordTextfield()));
		webdriverUtil.explicitWaitForElement(driver, loginToContinuePage.getPasswordTextfield());
		webdriverUtil.action(driver).click(loginToContinuePage.getPasswordTextfield()).sendKeys(fileUtils.readPropertyFileData("password")).pause(2000).perform();
		//driver.switchTo().activeElement().sendKeys(fileUtils.readPropertyFileData("password"));
		// loginToContinuePage.getPasswordTextfield().sendKeys(fileUtils.readPropertyFileData("password"));
		webdriverUtil.action(driver).click(loginToContinuePage.getFlutteredButton()).pause(2000).perform();
		//loginToContinuePage.getFlutteredButton().click();
		loginToContinuePage.getLoginButton().submit();
		TrelloBoardsPage boardsPage = new TrelloBoardsPage(driver);
		webdriverUtil.explicitWaitForDomElement(driver, boardsPage.getViewsOption());
		if (driver.getCurrentUrl().contains(fileUtils.readPropertyFileData("urlcontains"))) {
			Reporter.log("Board profile page is displyed and it is verified upon the Url");
		} else {
			Reporter.log("Board profile page is not displyed and it is verified upon the Url");
		}
		if (driver.getTitle().equals(excelUtil.readStringData("testdata", 5, 1))) {
			Reporter.log("Board profile page is displyed and it is verified upon the title");
		} else {
			Reporter.log("Board profile page is not displyed and it is verified upon the title");
		}
		TrelloLogOut();
	}

	@Test(priority = 4)
	public void TrelloCreateAndDeleteBoard() throws IOException, InterruptedException {
		TrelloLoginPageCheck();
		TrelloLoginPage loginPage = new TrelloLoginPage(driver);
		webdriverUtil.implicitWait(driver);
		webdriverUtil.explicitWaitForElement(driver, loginPage.getUserNameTextField());
		driver.switchTo().activeElement().sendKeys(fileUtils.readPropertyFileData("username"));
		loginPage.getCountinueButton().submit();
		if (webdriverUtil.explictWaitForCompleteTitle(driver, excelUtil.readStringData("testdata", 3, 1))) {
			Reporter.log("Login with Atlassian account page is displyed and it is verified upon the title");
		} else {
			Reporter.log("Login with Atlassian account page is not displyed and it is verified upon the title");
		}
		if (webdriverUtil.explictWaitForCompleteUrl(driver, excelUtil.readStringData("testdata", 4, 1))) {
			Reporter.log("Login with Atlassian account page is displyed and it is verified upon the Url");
		} else {
			Reporter.log("Login with Atlassian account page is not displyed and it is verified upon the Url");
		}
		TrelloLoginToContinuePage loginToContinuePage = new TrelloLoginToContinuePage(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(loginToContinuePage.getPasswordTextfield()));
		webdriverUtil.explicitWaitForElement(driver, loginToContinuePage.getPasswordTextfield());
		driver.switchTo().activeElement().sendKeys(fileUtils.readPropertyFileData("password"));
		// loginToContinuePage.getPasswordTextfield().sendKeys(fileUtils.readPropertyFileData("password"));
		loginToContinuePage.getFlutteredButton().click();
		loginToContinuePage.getLoginButton().submit();
		TrelloBoardsPage boardsPage = new TrelloBoardsPage(driver);
		webdriverUtil.explicitWaitForDomElement(driver, boardsPage.getViewsOption());
		if (driver.getCurrentUrl().contains(fileUtils.readPropertyFileData("urlcontains"))) {
			Reporter.log("Board profile page is displyed and it is verified upon the Url");
		} else {
			Reporter.log("Board profile page is not displyed and it is verified upon the Url");
		}
		if (driver.getTitle().equals(excelUtil.readStringData("testdata", 5, 1))) {
			Reporter.log("Board profile page is displyed and it is verified upon the title");
		} else {
			Reporter.log("Board profile page is not displyed and it is verified upon the title");
		}
		
		TrelloCreateBoard createBoard = new TrelloCreateBoard(driver);
		createBoard.getCreateButton().click();
		createBoard.getCreateBoardOption().click();
		createBoard.getBoardsTitleTextfield().sendKeys(fileUtils.readPropertyFileData("board1"));
		createBoard.getCreateBoardbutton().click();
		webdriverUtil.implicitWait(driver);
		if (webdriverUtil.explicitWaitForTitleContains(driver, excelUtil.readStringData("testdata", 11, 1))) {
			Reporter.log("Created Boards page is displayed and it is verified upon its title");
		} else {
			Reporter.log("Created Boards page is not displayed and it is verified upon its title");
		}
		TrelloDeleteBoard();
		TrelloLogOut();
	}
	
	@Test(priority=5)
	public void CreateBoardAndCreate2ListInTheBoard() throws IOException, InterruptedException {
		TrelloLoginPageCheck();
		TrelloLoginPage loginPage = new TrelloLoginPage(driver);
		webdriverUtil.implicitWait(driver);
		webdriverUtil.explicitWaitForElement(driver, loginPage.getUserNameTextField());
		driver.switchTo().activeElement().sendKeys(fileUtils.readPropertyFileData("username"));
		loginPage.getCountinueButton().submit();
		if (webdriverUtil.explictWaitForCompleteTitle(driver, excelUtil.readStringData("testdata", 3, 1))) {
			Reporter.log("Login with Atlassian account page is displyed and it is verified upon the title");
		} else {
			Reporter.log("Login with Atlassian account page is not displyed and it is verified upon the title");
		}
		if (webdriverUtil.explictWaitForCompleteUrl(driver, excelUtil.readStringData("testdata", 4, 1))) {
			Reporter.log("Login with Atlassian account page is displyed and it is verified upon the Url");
		} else {
			Reporter.log("Login with Atlassian account page is not displyed and it is verified upon the Url");
		}
		TrelloLoginToContinuePage loginToContinuePage = new TrelloLoginToContinuePage(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(loginToContinuePage.getPasswordTextfield()));
		webdriverUtil.explicitWaitForElement(driver, loginToContinuePage.getPasswordTextfield());
		driver.switchTo().activeElement().sendKeys(fileUtils.readPropertyFileData("password"));
		// loginToContinuePage.getPasswordTextfield().sendKeys(fileUtils.readPropertyFileData("password"));
		loginToContinuePage.getFlutteredButton().click();
		loginToContinuePage.getLoginButton().submit();
		TrelloBoardsPage boardsPage = new TrelloBoardsPage(driver);
		webdriverUtil.explicitWaitForDomElement(driver, boardsPage.getViewsOption());
		if (driver.getCurrentUrl().contains(fileUtils.readPropertyFileData("urlcontains"))) {
			Reporter.log("Board profile page is displyed and it is verified upon the Url");
		} else {
			Reporter.log("Board profile page is not displyed and it is verified upon the Url");
		}
		if (driver.getTitle().equals(excelUtil.readStringData("testdata", 5, 1))) {
			Reporter.log("Board profile page is displyed and it is verified upon the title");
		} else {
			Reporter.log("Board profile page is not displyed and it is verified upon the title");
		}
		TrelloCreateBoard createBoard = new TrelloCreateBoard(driver);
		createBoard.getCreateButton().click();
		createBoard.getCreateBoardOption().click();
		createBoard.getBoardsTitleTextfield().sendKeys(fileUtils.readPropertyFileData("board1"));
		createBoard.getCreateBoardbutton().click();
		webdriverUtil.implicitWait(driver);
		if (webdriverUtil.explicitWaitForTitleContains(driver, excelUtil.readStringData("testdata", 11, 1))) {
			Reporter.log("Created Boards page is displayed and it is verified upon its title");
		} else {
			Reporter.log("Created Boards page is not displayed and it is verified upon its title");
		}
		TrelloCreatelist createList = new TrelloCreatelist(driver);
		driver.switchTo().activeElement().sendKeys(fileUtils.readPropertyFileData("list1"));
		createList.getAddListButton().click();
		driver.switchTo().activeElement().sendKeys(fileUtils.readPropertyFileData("list2"));
		// createList.getAddListButton().click();
		webdriverUtil.action(driver).click(createList.getAddListButton()).pause(3000).perform();
		
		TrelloDeleteBoard();
		TrelloLogOut();
	}
	
	@Test(priority=6)
	public void CreateBoardAndSwapThe2CreatedListInTheBoard() throws IOException, InterruptedException {
		TrelloLoginPageCheck();
		TrelloLoginPage loginPage = new TrelloLoginPage(driver);
		webdriverUtil.implicitWait(driver);
		webdriverUtil.explicitWaitForElement(driver, loginPage.getUserNameTextField());
		driver.switchTo().activeElement().sendKeys(fileUtils.readPropertyFileData("username"));
		loginPage.getCountinueButton().submit();
		if (webdriverUtil.explictWaitForCompleteTitle(driver, excelUtil.readStringData("testdata", 3, 1))) {
			Reporter.log("Login with Atlassian account page is displyed and it is verified upon the title");
		} else {
			Reporter.log("Login with Atlassian account page is not displyed and it is verified upon the title");
		}
		if (webdriverUtil.explictWaitForCompleteUrl(driver, excelUtil.readStringData("testdata", 4, 1))) {
			Reporter.log("Login with Atlassian account page is displyed and it is verified upon the Url");
		} else {
			Reporter.log("Login with Atlassian account page is not displyed and it is verified upon the Url");
		}
		TrelloLoginToContinuePage loginToContinuePage = new TrelloLoginToContinuePage(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(loginToContinuePage.getPasswordTextfield()));
		webdriverUtil.explicitWaitForElement(driver, loginToContinuePage.getPasswordTextfield());
		driver.switchTo().activeElement().sendKeys(fileUtils.readPropertyFileData("password"));
		// loginToContinuePage.getPasswordTextfield().sendKeys(fileUtils.readPropertyFileData("password"));
		loginToContinuePage.getFlutteredButton().click();
		loginToContinuePage.getLoginButton().submit();
		TrelloBoardsPage boardsPage = new TrelloBoardsPage(driver);
		webdriverUtil.explicitWaitForDomElement(driver, boardsPage.getViewsOption());
		if (driver.getCurrentUrl().contains(fileUtils.readPropertyFileData("urlcontains"))) {
			Reporter.log("Board profile page is displyed and it is verified upon the Url");
		} else {
			Reporter.log("Board profile page is not displyed and it is verified upon the Url");
		}
		if (driver.getTitle().equals(excelUtil.readStringData("testdata", 5, 1))) {
			Reporter.log("Board profile page is displyed and it is verified upon the title");
		} else {
			Reporter.log("Board profile page is not displyed and it is verified upon the title");
		}
		TrelloCreateBoard createBoard = new TrelloCreateBoard(driver);
		createBoard.getCreateButton().click();
		createBoard.getCreateBoardOption().click();
		createBoard.getBoardsTitleTextfield().sendKeys(fileUtils.readPropertyFileData("board1"));
		createBoard.getCreateBoardbutton().click();
		webdriverUtil.implicitWait(driver);
		if (webdriverUtil.explicitWaitForTitleContains(driver, excelUtil.readStringData("testdata", 11, 1))) {
			Reporter.log("Created Boards page is displayed and it is verified upon its title");
		} else {
			Reporter.log("Created Boards page is not displayed and it is verified upon its title");
		}
		TrelloCreatelist createList = new TrelloCreatelist(driver);
		driver.switchTo().activeElement().sendKeys(fileUtils.readPropertyFileData("list1"));
		createList.getAddListButton().click();
		driver.switchTo().activeElement().sendKeys(fileUtils.readPropertyFileData("list2"));
		// createList.getAddListButton().click();
		webdriverUtil.action(driver).click(createList.getAddListButton()).pause(3000).perform();
		

		// webdriverUtil.action(driver).clickAndHold(createList.getListHeader1()).dragAndDrop(createList.getListHeader1(),
		// createList.getListHeader2()).pause(2000).release(createList.getListHeader1()).perform();
		webdriverUtil.action(driver).clickAndHold(createList.getListHeader1()).pause(2000)
		.moveByOffset(250, 40).pause(3000).release(createList.getListHeader1()).perform();
		
		TrelloDeleteBoard();
		TrelloLogOut();
	}
	
	@Test(priority=7)
	public void CreateBoardAndArrangeTheCardsInTheAlphabeticalOrder() throws IOException, InterruptedException {
		TrelloLoginPageCheck();
		TrelloLoginPage loginPage = new TrelloLoginPage(driver);
		webdriverUtil.implicitWait(driver);
		webdriverUtil.explicitWaitForElement(driver, loginPage.getUserNameTextField());
		driver.switchTo().activeElement().sendKeys(fileUtils.readPropertyFileData("username"));
		loginPage.getCountinueButton().submit();
		if (webdriverUtil.explictWaitForCompleteTitle(driver, excelUtil.readStringData("testdata", 3, 1))) {
			Reporter.log("Login with Atlassian account page is displyed and it is verified upon the title");
		} else {
			Reporter.log("Login with Atlassian account page is not displyed and it is verified upon the title");
		}
		if (webdriverUtil.explictWaitForCompleteUrl(driver, excelUtil.readStringData("testdata", 4, 1))) {
			Reporter.log("Login with Atlassian account page is displyed and it is verified upon the Url");
		} else {
			Reporter.log("Login with Atlassian account page is not displyed and it is verified upon the Url");
		}
		TrelloLoginToContinuePage loginToContinuePage = new TrelloLoginToContinuePage(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(loginToContinuePage.getPasswordTextfield()));
		webdriverUtil.explicitWaitForElement(driver, loginToContinuePage.getPasswordTextfield());
		driver.switchTo().activeElement().sendKeys(fileUtils.readPropertyFileData("password"));
		// loginToContinuePage.getPasswordTextfield().sendKeys(fileUtils.readPropertyFileData("password"));
		loginToContinuePage.getFlutteredButton().click();
		loginToContinuePage.getLoginButton().submit();
		TrelloBoardsPage boardsPage = new TrelloBoardsPage(driver);
		webdriverUtil.explicitWaitForDomElement(driver, boardsPage.getViewsOption());
		if (driver.getCurrentUrl().contains(fileUtils.readPropertyFileData("urlcontains"))) {
			Reporter.log("Board profile page is displyed and it is verified upon the Url");
		} else {
			Reporter.log("Board profile page is not displyed and it is verified upon the Url");
		}
		if (driver.getTitle().equals(excelUtil.readStringData("testdata", 5, 1))) {
			Reporter.log("Board profile page is displyed and it is verified upon the title");
		} else {
			Reporter.log("Board profile page is not displyed and it is verified upon the title");
		}
		TrelloCreateBoard createBoard = new TrelloCreateBoard(driver);
		createBoard.getCreateButton().click();
		createBoard.getCreateBoardOption().click();
		createBoard.getBoardsTitleTextfield().sendKeys(fileUtils.readPropertyFileData("board1"));
		createBoard.getCreateBoardbutton().click();
		webdriverUtil.implicitWait(driver);
		if (webdriverUtil.explicitWaitForTitleContains(driver, excelUtil.readStringData("testdata", 11, 1))) {
			Reporter.log("Created Boards page is displayed and it is verified upon its title");
		} else {
			Reporter.log("Created Boards page is not displayed and it is verified upon its title");
		}
		TrelloCreatelist createList = new TrelloCreatelist(driver);
		driver.switchTo().activeElement().sendKeys(fileUtils.readPropertyFileData("list1"));
		createList.getAddListButton().click();
		driver.switchTo().activeElement().sendKeys(fileUtils.readPropertyFileData("list2"));
		// createList.getAddListButton().click();
		webdriverUtil.action(driver).click(createList.getAddListButton()).pause(3000).perform();
		
		createList.getAddCardButton().click();
		createList.getCreateCardTextfield().click();
		webdriverUtil.action(driver).sendKeys(fileUtils.readPropertyFileData("card1")).sendKeys(Keys.ENTER).perform();
		webdriverUtil.action(driver).sendKeys(fileUtils.readPropertyFileData("card2")).sendKeys(Keys.ENTER).perform();
		webdriverUtil.action(driver).sendKeys(fileUtils.readPropertyFileData("card3")).sendKeys(Keys.ENTER).perform();
		webdriverUtil.action(driver).sendKeys(fileUtils.readPropertyFileData("card4")).sendKeys(Keys.ENTER).perform();
		webdriverUtil.action(driver).sendKeys(fileUtils.readPropertyFileData("card5")).sendKeys(Keys.ENTER).perform();
		
		createList.getAddCardButton2().click();
		createList.getCreateCardTextfield().click();
		webdriverUtil.action(driver).sendKeys(fileUtils.readPropertyFileData("card6")).sendKeys(Keys.ENTER).perform();
		webdriverUtil.action(driver).sendKeys(fileUtils.readPropertyFileData("card7")).sendKeys(Keys.ENTER).perform();
		webdriverUtil.action(driver).sendKeys(fileUtils.readPropertyFileData("card8")).sendKeys(Keys.ENTER).perform();
		webdriverUtil.action(driver).sendKeys(fileUtils.readPropertyFileData("card9")).sendKeys(Keys.ENTER).perform();

		webdriverUtil.action(driver).click(createList.getListMoreOption()).pause(2000).perform();
		createList.getSortByListOption().click();
		webdriverUtil.action(driver).click(createList.getSortByAlphabetically()).pause(2000).perform();
		
		TrelloDeleteBoard();
		TrelloLogOut() ;
		
	}
	@Test(priority = 8)
	public void Create2BoardsAndCreateListIncludingCardsAndMoveTheFullyLoadedListToOneMoreBoard() throws IOException, InterruptedException {
		TrelloLoginPageCheck();
		TrelloLoginPage loginPage = new TrelloLoginPage(driver);
		webdriverUtil.implicitWait(driver);
		webdriverUtil.explicitWaitForElement(driver, loginPage.getUserNameTextField());
		driver.switchTo().activeElement().sendKeys(fileUtils.readPropertyFileData("username"));
		loginPage.getCountinueButton().submit();
		if (webdriverUtil.explictWaitForCompleteTitle(driver, excelUtil.readStringData("testdata", 3, 1))) {
			Reporter.log("Login with Atlassian account page is displyed and it is verified upon the title");
		} else {
			Reporter.log("Login with Atlassian account page is not displyed and it is verified upon the title");
		}
		if (webdriverUtil.explictWaitForCompleteUrl(driver, excelUtil.readStringData("testdata", 4, 1))) {
			Reporter.log("Login with Atlassian account page is displyed and it is verified upon the Url");
		} else {
			Reporter.log("Login with Atlassian account page is not displyed and it is verified upon the Url");
		}
		TrelloLoginToContinuePage loginToContinuePage = new TrelloLoginToContinuePage(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(loginToContinuePage.getPasswordTextfield()));
		webdriverUtil.explicitWaitForElement(driver, loginToContinuePage.getPasswordTextfield());
		driver.switchTo().activeElement().sendKeys(fileUtils.readPropertyFileData("password"));
		// loginToContinuePage.getPasswordTextfield().sendKeys(fileUtils.readPropertyFileData("password"));
		loginToContinuePage.getFlutteredButton().click();
		loginToContinuePage.getLoginButton().submit();
		TrelloBoardsPage boardsPage = new TrelloBoardsPage(driver);
		webdriverUtil.explicitWaitForDomElement(driver, boardsPage.getViewsOption());
		if (driver.getCurrentUrl().contains(fileUtils.readPropertyFileData("urlcontains"))) {
			Reporter.log("Board profile page is displyed and it is verified upon the Url");
		} else {
			Reporter.log("Board profile page is not displyed and it is verified upon the Url");
		}
		if (driver.getTitle().equals(excelUtil.readStringData("testdata", 5, 1))) {
			Reporter.log("Board profile page is displyed and it is verified upon the title");
		} else {
			Reporter.log("Board profile page is not displyed and it is verified upon the title");
		}
		TrelloCreateBoard createBoard = new TrelloCreateBoard(driver);
		createBoard.getCreateButton().click();
		createBoard.getCreateBoardOption().click();
		createBoard.getBoardsTitleTextfield().sendKeys(fileUtils.readPropertyFileData("board1"));
		createBoard.getCreateBoardbutton().click();
		webdriverUtil.implicitWait(driver);
		if (webdriverUtil.explicitWaitForTitleContains(driver, excelUtil.readStringData("testdata", 11, 1))) {
			Reporter.log("Created Boards page is displayed and it is verified upon its title");
		} else {
			Reporter.log("Created Boards page is not displayed and it is verified upon its title");
		}
		TrelloCreatelist createList = new TrelloCreatelist(driver);
		driver.switchTo().activeElement().sendKeys(fileUtils.readPropertyFileData("list1"));
		createList.getAddListButton().click();
		driver.switchTo().activeElement().sendKeys(fileUtils.readPropertyFileData("list2"));
		// createList.getAddListButton().click();
		webdriverUtil.action(driver).click(createList.getAddListButton()).pause(3000).perform();
		
		createList.getAddCardButton().click();
		createList.getCreateCardTextfield().click();
		webdriverUtil.action(driver).sendKeys(fileUtils.readPropertyFileData("card1")).sendKeys(Keys.ENTER).perform();
		webdriverUtil.action(driver).sendKeys(fileUtils.readPropertyFileData("card2")).sendKeys(Keys.ENTER).perform();
		webdriverUtil.action(driver).sendKeys(fileUtils.readPropertyFileData("card3")).sendKeys(Keys.ENTER).perform();
		webdriverUtil.action(driver).sendKeys(fileUtils.readPropertyFileData("card4")).sendKeys(Keys.ENTER).perform();
		webdriverUtil.action(driver).sendKeys(fileUtils.readPropertyFileData("card5")).sendKeys(Keys.ENTER).perform();
	
		//createList.getListMoreOption().click();
		 webdriverUtil.action(driver).click(createList.getListMoreOption()).pause(2000).perform();
		 webdriverUtil.action(driver).click(createList.getMoveAllCardInTheListOption()).pause(2000).perform();
		 webdriverUtil.action(driver).click(createList.getSelectWhereToMoveButton()).pause(2000).perform();
	    Thread.sleep(3000);
	    TrelloDeleteBoard();
		TrelloLogOut() ;
	    
	}
	@Test(priority = 9)
	public void CreateBoardAndCreateTheListInTheBoardAndGetTheCardsListCount() throws EncryptedDocumentException, IOException {
		TrelloLoginPageCheck();
		TrelloLoginPage loginPage = new TrelloLoginPage(driver);
		webdriverUtil.implicitWait(driver);
		webdriverUtil.explicitWaitForElement(driver, loginPage.getUserNameTextField());
		driver.switchTo().activeElement().sendKeys(fileUtils.readPropertyFileData("username"));
		loginPage.getCountinueButton().submit();
		if (webdriverUtil.explictWaitForCompleteTitle(driver, excelUtil.readStringData("testdata", 3, 1))) {
			Reporter.log("Login with Atlassian account page is displyed and it is verified upon the title");
		} else {
			Reporter.log("Login with Atlassian account page is not displyed and it is verified upon the title");
		}
		if (webdriverUtil.explictWaitForCompleteUrl(driver, excelUtil.readStringData("testdata", 4, 1))) {
			Reporter.log("Login with Atlassian account page is displyed and it is verified upon the Url");
		} else {
			Reporter.log("Login with Atlassian account page is not displyed and it is verified upon the Url");
		}
		TrelloLoginToContinuePage loginToContinuePage = new TrelloLoginToContinuePage(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(loginToContinuePage.getPasswordTextfield()));
		webdriverUtil.explicitWaitForElement(driver, loginToContinuePage.getPasswordTextfield());
		driver.switchTo().activeElement().sendKeys(fileUtils.readPropertyFileData("password"));
		// loginToContinuePage.getPasswordTextfield().sendKeys(fileUtils.readPropertyFileData("password"));
		loginToContinuePage.getFlutteredButton().click();
		loginToContinuePage.getLoginButton().submit();
		TrelloBoardsPage boardsPage = new TrelloBoardsPage(driver);
		webdriverUtil.explicitWaitForDomElement(driver, boardsPage.getViewsOption());
		if (driver.getCurrentUrl().contains(fileUtils.readPropertyFileData("urlcontains"))) {
			Reporter.log("Board profile page is displyed and it is verified upon the Url");
		} else {
			Reporter.log("Board profile page is not displyed and it is verified upon the Url");
		}
		if (driver.getTitle().equals(excelUtil.readStringData("testdata", 5, 1))) {
			Reporter.log("Board profile page is displyed and it is verified upon the title");
		} else {
			Reporter.log("Board profile page is not displyed and it is verified upon the title");
		}
		TrelloCreateBoard createBoard = new TrelloCreateBoard(driver);
		createBoard.getCreateButton().click();
		createBoard.getCreateBoardOption().click();
		createBoard.getBoardsTitleTextfield().sendKeys(fileUtils.readPropertyFileData("board1"));
		createBoard.getCreateBoardbutton().click();
		webdriverUtil.implicitWait(driver);
		if (webdriverUtil.explicitWaitForTitleContains(driver, excelUtil.readStringData("testdata", 11, 1))) {
			Reporter.log("Created Boards page is displayed and it is verified upon its title");
		} else {
			Reporter.log("Created Boards page is not displayed and it is verified upon its title");
		}
		TrelloCreatelist createList = new TrelloCreatelist(driver);
		driver.switchTo().activeElement().sendKeys(fileUtils.readPropertyFileData("list1"));
		createList.getAddListButton().click();
		driver.switchTo().activeElement().sendKeys(fileUtils.readPropertyFileData("list2"));
		// createList.getAddListButton().click();
		webdriverUtil.action(driver).click(createList.getAddListButton()).pause(3000).perform();
		
		createList.getAddCardButton().click();
		createList.getCreateCardTextfield().click();
		webdriverUtil.action(driver).sendKeys(fileUtils.readPropertyFileData("card1")).sendKeys(Keys.ENTER).perform();
		webdriverUtil.action(driver).sendKeys(fileUtils.readPropertyFileData("card2")).sendKeys(Keys.ENTER).perform();
		webdriverUtil.action(driver).sendKeys(fileUtils.readPropertyFileData("card3")).sendKeys(Keys.ENTER).perform();
		webdriverUtil.action(driver).sendKeys(fileUtils.readPropertyFileData("card4")).sendKeys(Keys.ENTER).pause(2000).perform();
		webdriverUtil.action(driver).sendKeys(fileUtils.readPropertyFileData("card5")).sendKeys(Keys.ENTER).pause(3000).perform();
	
	   List<WebElement> createdCards = createList.getCardCount();
	   System.out.println(createdCards.size());
	   for (WebElement card : createdCards) {
		   Reporter.log("cardname :"+ card.getText());
		   System.out.println(card.getText());
	}
	  
	Reporter.log("cardsize :"+ createdCards.size());
	TrelloDeleteBoard();
	TrelloLogOut();
	
	}
	
	public void TrelloDeleteBoard() throws EncryptedDocumentException, IOException {
		TrelloDeleteboard deleteBoard = new TrelloDeleteboard(driver);
		TrelloBoardsPage boardsPage = new TrelloBoardsPage(driver);
		webdriverUtil.explicitWaitForElement(driver, deleteBoard.getThreeDotButton());
		deleteBoard.getThreeDotButton().click();
		deleteBoard.getMoreOption().click();
		webdriverUtil.explicitWaitForElement(driver, deleteBoard.getCloseBoardOption());
		deleteBoard.getCloseBoardOption().click();
		deleteBoard.getCloseButton().click();
		deleteBoard.getPermanentlyDeleteButton().click();
		deleteBoard.getDeleteButton().click();
		webdriverUtil.explicitWaitForDomElement(driver, boardsPage.getViewsOption());
		webdriverUtil.implicitWait(driver);
		if (webdriverUtil.explictWaitForCompleteTitle(driver, excelUtil.readStringData("testdata", 5, 1))) {
			Reporter.log("Board profile page is displyed and it is verified upon the title");
		} else {
			Reporter.log("Board profile page is displyed and it is verified upon the title");
		}
		if (driver.getCurrentUrl().equals(excelUtil.readStringData("testdata", 6, 1))) {
			Reporter.log("Board profile page is displyed and it is verified upon the url");
		} else {
			Reporter.log("Board profile page is not displyed and it is verified upon the url");
		}
	}

	public void TrelloLogOut() throws EncryptedDocumentException, IOException {
		TrelloBoardsPage boardsPage = new TrelloBoardsPage(driver);
		boardsPage.getProfileOption().click();
		boardsPage.getLogoutOption().click();
		if (webdriverUtil.explicitWaitForTitleContains(driver, excelUtil.readStringData("testdata", 8, 1))) {
			Reporter.log("Atlassian Logout page is displayed and it is verified upon the title");
		} else {
			Reporter.log("Atlassian Logout page is not displayed and it is verified upon the title");
		}
		webdriverUtil.explicitWaitForElement(driver, boardsPage.getLogoutButton());
		boardsPage.getLogoutButton().click();

		if (webdriverUtil.explicitWaitForTitleContains(driver, excelUtil.readStringData("testdata", 0, 1))) {
			Reporter.log("Home page is displayed and verfied upon its title");
		} else {
			Reporter.log("Home page is not displayed and verfied upon its title");
		}
		if (driver.getCurrentUrl().contains(excelUtil.readStringData("testdata", 10, 1))) {
			Reporter.log("Home page is displayed and verfied upon its url");
		} else {
			Reporter.log("Home page is displayed and verfied upon its url");
		}
	}

}
