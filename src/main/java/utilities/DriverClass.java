package utilities;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverClass {
	
	private static WebDriver driver;
	
	public static WebDriver getDriverInstance() throws IOException
	{
		
		FileReader config = new FileReader();
		
		String browser = config.getPropValue();
		
		//System.out.println("Print Browser value : " + browser);

		if ((browser.equals("Chrome")) && (driver==null))
		{
			//DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			//capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
			System.setProperty("webdriver.chrome.driver", "c://Tools//chromedriver.exe");
			
			driver=new ChromeDriver();

		}	
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();


		return driver;
	}

}
