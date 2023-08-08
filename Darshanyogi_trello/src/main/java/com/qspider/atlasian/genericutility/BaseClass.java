package com.qspider.atlasian.genericutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public WebDriver driver;
	public ExcelUtility excelUtil=new ExcelUtility();
	public FileUtility fileUtils=new FileUtility();
	public WebdriverUtility webdriverUtil=new WebdriverUtility();
	@BeforeMethod
	public void configureBeforeMethod() throws IOException {
		String browserName = fileUtils.readPropertyFileData("browser");
		if (browserName.equals("chrome")) {
			ChromeOptions co= new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
		     driver= new ChromeDriver(co);
			//driver=new ChromeDriver();
			
		}else if (browserName.equals("edge")) {
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(fileUtils.readPropertyFileData("mainurl"));
	}
	@AfterMethod
     public void congigureAfterMethod() {
    	 driver.manage().window().minimize();
    	 driver.quit();
    	 
     }
}
