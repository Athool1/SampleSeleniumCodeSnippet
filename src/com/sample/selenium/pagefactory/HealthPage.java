package com.sample.selenium.pagefactory;

import java.util.Set;

import com.sample.selenium.commons.Commons;

public class HealthPage {
	
	public String firstSearchResult = "//*[@id='SearchResultsList']/div[1]/div[1]/a";
	public String printerPath = "//*[@id='wppPageTool']/div[2]/a";
	public String closePrintWindowLink = "/html/body/div[1]/a";
	
	
	public Commons commons = new Commons();
	
	public void clickonLink(){
		commons.clickByXpath(firstSearchResult);
	}
	
	public void switchActionWindow(){
		//String parent_Window = driver.getWindowHandle();
		String parent_window  = commons.getMainWindowHandle();
		commons.getCurrentWindowTitle();
		//driver.findElement(By.xpath("//*[@id='wppPageTool']/div[2]/a")).click();
		commons.clickByXpath(printerPath);
	      // Switching from parent window to child window 
		 Set<String> allHandles = commons.getHandles();
	     for(String child_Window : allHandles){  
	    	 commons.switchToWindow(child_Window);
	    	 System.out.println("Inside Child Window");
	     }
	     //driver.findElement(By.xpath("/html/body/div[1]/a")).click();
	     commons.clickByXpath(closePrintWindowLink);
	     System.out.println("Window Handling Successful");
	     //driver.switchTo().window(parent_Window);
	     commons.switchToWindow(parent_window);
	     System.out.println("Back to Parent Window");
	}
	
	
}
