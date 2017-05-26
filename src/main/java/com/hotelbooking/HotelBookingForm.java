package com.hotelbooking;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utilities.DriverInstance;

public class HotelBookingForm extends DriverInstance {
	
	public HotelBookingForm() 
	{
		System.out.println("HotelBookingForm.HotelBookingForm()");
	}
	
	public void openHotelBookingForm() throws IOException
	{
		getDriver().navigate().to("http://hotel-test.equalexperts.io/");
	}
	
	public String verifyHotelBookingFormTitle() throws IOException
	{
		String pageTitle = getDriver().findElement(By.xpath("//div[@class='container']//h1")).getText();
		return pageTitle;
	}
	
	
	public static void enterFirstName(String firstName) throws IOException
	{
		getDriver().findElement(By.id("firstname")).sendKeys(firstName);
	}
	
	public static void enterSurName(String surName) throws IOException
	{
		getDriver().findElement(By.id("lastname")).sendKeys(surName);
	}
	
	public static void enterPrice(String price) throws IOException
	{
		getDriver().findElement(By.id("totalprice")).sendKeys(price);
	}
	
	public static void selectDepositOption(String depositOption) throws IOException
	{
		 WebElement select = getDriver().findElement(By.id("depositpaid"));
		    List<WebElement> options = select.findElements(By.tagName("option"));
		    for(WebElement option : options){
		        if(option.getText().equals(depositOption)) {
		            option.click();
		            break;
		        }
		    }
	}
	
	public static void enterCheckInDate(String checkInDate) throws IOException
	{
		getDriver().findElement(By.id("checkin")).sendKeys(checkInDate);
	}
	
	public static void enterCheckOutDate(String checkOutDate) throws IOException
	{
		getDriver().findElement(By.id("checkout")).sendKeys(checkOutDate);
	}
	
	public void enterHotelBookingFormData(String firstName, String surName, String price, 
			String depositOption, String checkInDate, String checkOutDate) throws IOException
	{
		enterFirstName(firstName);
		enterSurName(surName);
		enterPrice(price);
		selectDepositOption(depositOption);
		enterCheckInDate(checkInDate);
		enterCheckOutDate(checkOutDate);
		
	}
	
	public void saveRecord() throws IOException
	{
		getDriver().findElement(By.xpath("//div[@id='form']//div[@class='row']//div//input[contains(@value,'Save')]")).click();
	}
	
	public void deleteLastRecord() throws IOException, InterruptedException
	{
		
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		Thread.sleep(1000);
		int idCount =  Integer.parseInt(js.executeScript("return document.getElementById('bookings').getElementsByClassName('row').length;").toString());
		
		//Thread.sleep(1000);
		//int maxRecord = getDriver().findElements(By.xpath("//div[@class='container']//div[@id='bookings']/div")).size();
		
		if (idCount > 1)
		{
			getDriver().findElement(By.xpath("//div[@class='container']//div[@id='bookings']"
					+ "/div["+ idCount +"]//div//input[contains(@value,'Delete')]")).click();
			
		}
		
		else
		{
			System.out.println("No Records To Delete");
		}
		
	}
	
	public void closeWebPage() throws IOException, InterruptedException
	{
		Thread.sleep(3000);
		getCloseDriverInstance();
	}
	
	
}
