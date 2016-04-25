package com.sample.selenium.pagefactory;

import com.sample.selenium.commons.Commons;

public class HomePage {

	public String locateOurService = ".//*[@id='kpNavLi4']/a";
	public String linkText = "Find doctors & locations";
	public String idName ="pageSearchString";
	public String buttonPath = "//*[@id='pageSearchBtn']";
	public String modalLink = "Choose your region";
	public String selectRegion = "//*[@id='region-switch-list']/li[1]/a";
	
	public Commons commons = new Commons();
	
	public void clickLocateOurService(){
		commons.clickByXpath(locateOurService);
	}
	
	public void clickLinkText(){
		commons.clickByLinkText(linkText);
	}
	
	public void getAllLinksOnPage(String byTag){
		commons.allLinksOnWebPage(byTag);
	}
	
	public void enterSearchBoxValue(String value){
		commons.clickByIdSearchBox(idName, value);
	}
	
	public void clickSearchButton(){
		commons.clickByXpath(buttonPath);
	}

	
}
