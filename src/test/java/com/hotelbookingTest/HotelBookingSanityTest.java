package com.hotelbookingTest;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.hotelbooking.HotelBookingForm;

import java.io.IOException;

public class HotelBookingSanityTest  {

	HotelBookingForm testHotelBookingForm = new HotelBookingForm();

	@BeforeSuite
	public void openWebPage() throws IOException
	{
		testHotelBookingForm.openHotelBookingForm();
	}


	@Test(priority=1)
	public void verifyPageTitle() throws IOException, InterruptedException
	{
		String actualTitle = testHotelBookingForm.verifyHotelBookingFormTitle();
		try{
			Assert.assertEquals(actualTitle,"Hotel booking form");
			System.out.println("Page Title Verified Successfully");
		}
		catch(Exception e)
		{
			System.out.println("Verify Page Title Error" + e);
		}
	}

	@Test(priority=2)
	public void insertBookingData() throws IOException
	{
		try{
		testHotelBookingForm.enterHotelBookingFormData("TestFirstName1", "TestSurName1", "100.01", 
				"true", "2017-05-28", "2017-05-29");
		testHotelBookingForm.saveRecord();

		System.out.println("Insert Booking Successfully");
		//Yet to implement the record check for insertion
		}
		catch(Exception e)
		{
			System.out.println("Insert Booking Error" + e);
		}
	}


	@Test(priority=3)
	public void deleteLastrecord() throws IOException, InterruptedException
	{
		try{
			testHotelBookingForm.deleteLastRecord();
			//Yet to implement the record check for deletion
			System.out.println("Delete Last Record Successfully");
		}
		catch(Exception e)
		{
			System.out.println("Delete Last Record Error" + e);
		}
	}

	@AfterSuite
	public void closeWebPage() throws IOException, InterruptedException
	{
		testHotelBookingForm.closeWebPage();
	}

}
