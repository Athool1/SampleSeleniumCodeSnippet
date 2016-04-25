package com.sample.selenium.pagefactory;

import com.sample.selenium.commons.Commons;

public class LocateServicePage {
	
	public String linkText_01 = ".//*[@id='kp-footer-space']/ul/li[1]/a";
	public String linkText_02 = "/html/body/div[1]/div/div/div[1]/form/div/div[7]/div/a";
	public String code = "zipCode";
	public String search = "/html/body/div[1]/div/div/div[1]/form/div/div[8]/div[5]/input";
	public String specialityListPath = "//*[@id='Medical Specialty']";
	public String cityListPath = "//*[@id='City']";
	
	
	public Commons commons = new Commons();
	
	public void linkDoctorandFacilities(){
		commons.clickByXpath(linkText_01);
	}
	
	public void linkSearchDoctors(){
		commons.clickByXpath(linkText_02);
	}
	
	public void enterCode(String svalue){
		commons.setValueByName(code, svalue);
	}
	
	public void clickSearch(){
		commons.clickByXpath(search);
	}
	
	public void enterZip(String zipValue){
		enterCode(zipValue);
		System.out.println("Value entered Successfully");
		
	} 
	
	public void selectMedicalSpecality(String value){
		commons.selectDropDownElement(specialityListPath,value);
	}
	
	public void selectCity(String value){
		commons.selectDropDownElement(cityListPath, value);
	}
	

}
