package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class DriverInstance  {
	
	public static WebDriver getDriver() throws IOException
	{
		return DriverClass.getDriverInstance();
	}
	
	
	public void  getCloseDriverInstance() throws IOException
	{
		getDriver().quit();
	}

}
