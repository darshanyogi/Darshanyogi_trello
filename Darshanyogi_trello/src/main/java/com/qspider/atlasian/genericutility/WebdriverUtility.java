package com.qspider.atlasian.genericutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {

	public WebDriverWait explictWait(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait;
	}

	public Boolean explictWaitForCompleteTitle(WebDriver driver, String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Boolean checking = wait.until(ExpectedConditions.titleIs(title));
		return checking;
	}

	public Boolean explictWaitForCompleteUrl(WebDriver driver, String url) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Boolean urlWait = wait.until(ExpectedConditions.urlContains(url));
		return urlWait;
	}

	public Boolean explictWaitForBoardsPageTitle(WebDriver driver, String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Boolean waitBoardspage = wait.until(ExpectedConditions.titleIs(title));
		return waitBoardspage;

	}

	public WebElement explicitWaitForDomElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement waitDom = wait.until(ExpectedConditions.visibilityOf(element));
		return waitDom;
	}

	public WebElement explicitWaitForElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public boolean explicitWaitForTitleContains(WebDriver driver, String titlecontains) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.titleContains(titlecontains));
	}

	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public Actions action(WebDriver driver) {
		Actions action = new Actions(driver);
		return action;
	}
}
