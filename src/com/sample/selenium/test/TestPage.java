package com.sample.selenium.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sample.selenium.commons.Commons;
import com.sample.selenium.pagefactory.HealthPage;
import com.sample.selenium.pagefactory.HomePage;
import com.sample.selenium.pagefactory.LocateServicePage;

public class TestPage {

	public String sURL="https://healthy.kaiserpermanente.org/html/kaiser/index.shtml";
	
	public HomePage homePage = new HomePage();
	public LocateServicePage locate = new LocateServicePage();
	public HealthPage health = new HealthPage();
	public Commons commons = new Commons();
	
	
	@BeforeMethod
	public void setUp(){
	 commons.chooseDriver("chrome");
	 commons.openBrowser();
	 commons.openUrl(sURL);
	}
	
	@AfterMethod
	public void tearDown(){
		commons.closeBrowser();
	}
	
	@Test
	public void test01() throws InterruptedException{
		homePage.getAllLinksOnPage("a");
		homePage.enterSearchBoxValue("AA");
		homePage.clickSearchButton();
		health.clickonLink();
		System.out.println("First link clicked");
		Thread.sleep(1000);
		health.switchActionWindow();
		System.out.println("Successfull");
	}
	
	//Get list of doctors in particular region.
	@Test
	public void test02() {
		homePage.clickLinkText();
		commons.verifyText("Find care");
		System.out.println("Text Found! Successfully");
		locate.linkDoctorandFacilities();
		System.out.println("Text Found! Successfully");
		locate.linkSearchDoctors();
		System.out.println("Link Successfully Clicked");
		locate.enterZip("94568");
		locate.clickSearch();
		System.out.println("Doctors List Successfully Generated.");
		locate.selectMedicalSpecality("string:Allergy, Asthma and Immunology");
		locate.selectCity("string:Pleasanton");
		System.out.println("Successfully Selected");		
		
	}
}
