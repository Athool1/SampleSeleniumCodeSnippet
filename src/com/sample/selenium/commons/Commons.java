package com.sample.selenium.commons;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Commons {

	public static WebDriver driver;
	public static WebElement element, myDynamicElement;
	
	public void chooseDriver(String browser){
		if(browser == "chrome"){
			System.setProperty("webdriver.chrome.driver", "C:/Users/Ashay/workspace/SeleniumCatalogPageObject/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Chrome Driver Active");
		}else if(browser =="firefox"){
			driver =new FirefoxDriver();
			System.out.println("FireFox Driver Active");
		}else if(browser =="ie"){
			driver =new InternetExplorerDriver();
			System.out.println("IE Driver Active");
		}
	}
	
	
	public void openBrowser(){
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Open and Maximize the Browser");
	}
	
	public void openUrl(String sURL){
		driver.get(sURL);
		System.out.println("Opening the URL");
	}
	
	public void closeBrowser(){
		driver.quit(); 
		System.out.println("close browser");
	}
	
	public void verifyText(String expected){
		try{
			driver.findElement(By.xpath("//*[contains(text(),'"+expected.trim()+"')]"));
			System.out.println("On Page" +driver.getTitle()+". Expected Text \""+expected+"\"verified");
		}catch(NoSuchElementException e){
			System.out.println("On Page" +driver.getTitle()+". Expected Text \""+expected+"\"not found");
			Assert.fail("On Page" +driver.getTitle()+". Expected Text \""+expected+"\"not found");
		}
	}
	
	public void clickByXpath(String sxpath){
		try{
			driver.findElement(By.xpath(sxpath)).click();
			System.out.println(sxpath+"=found");
		}catch(Exception e){
			System.out.println(sxpath+"=not found");
			Assert.fail("Link not found");
		}
	}
	
	public void clickByLinkText(String text){
		try{
			driver.findElement(By.linkText(text)).click();
			System.out.println(text+"=clicked");
		}catch(Exception e){
			System.out.println(text+"=not clicked");
			Assert.fail("Text not found");
		}
	}
	
	public void setValueByName(String sname, String svalue){
		try{
			driver.findElement(By.name(sname)).sendKeys(svalue);
			System.out.println(svalue+"=entered");
		}catch(Exception e){
			System.out.println(sname+"=not found");
			Assert.fail("Not Found");
		}
	}
	
	public void ifElementExists(String name){
		System.out.println("Checking if Element Exist");
		if(driver.findElements(By.name(name)).size()!=0){
			System.out.println("Element Exists!!");
		}	
		else{
				System.out.println("Doesn't Exists!");
			}
	}
	
	public void checkElementVisiblebyDriver(String name){
		element  = driver.findElement(By.name(name));
		if(element instanceof WebElement) {
			System.out.println("Element visible");
		} else {
			System.out.println("Element Not visible");
		}
	}
	
	public void selectDropDownElement(String listPath, String value){
		try{
			Select select = new Select(driver.findElement(By.xpath(listPath)));
			select.selectByValue(value);
		}catch(Exception e){
			System.out.println("Element not exists.");
			Assert.fail("Not Found!!!");
		}	
	}
	
	//List all the weblinks on webpage
	public void allLinksOnWebPage(String tag){
		List<WebElement> allLinks = (List<WebElement>)driver.findElements(By.tagName(tag));
		System.out.println(allLinks.size());
	    
		//Iterate through List and print all Links.
		for(WebElement s : allLinks){
			System.out.println(s.getText());
		}
	}
	
	//Find Element Using ID
	public void clickByIdSearchBox(String idPath, String value){
		try{
			driver.findElement(By.id(idPath)).sendKeys(value);
			System.out.println(idPath+"=found");
		}catch(Exception e){
			System.out.println(idPath+"=not found");
			Assert.fail("Link not found");
		
		}
	}
	
	//Below method is used to get the main window handle. we will the driver as parameter.
	public String getMainWindowHandle() {
		String mainWindow = driver.getWindowHandle();
		System.out.println("ParentWindow -> " +mainWindow);
		return mainWindow;
	}
	
	public Set<String> getHandles(){
		return driver.getWindowHandles();
	}
	
	//Below method is used to get the current window title
	public void getCurrentWindowTitle() {
		driver.getTitle();
	}
	
	public void switchToWindow(String cwindow){
		driver.switchTo().window(cwindow);
	}
}

