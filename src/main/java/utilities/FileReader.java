package utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileReader {

	String configValue = "";
	

	public String getPropValue() throws IOException
	{
		String result="";
		InputStream inputStream;
		
		try{
			
			Properties prop = new Properties();
			String propFileName = "config.properties";

			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

			if (inputStream != null)
			{
				prop.load(inputStream);
			}
			else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}

			result = prop.getProperty("browser");

			//System.out.println("browser name : " + result);

		}
		catch (Exception e)
		{
			System.out.println("Exception: " + e);
		}

		return result;
	}
	
	public String fetchPropValue()
	{
		//String propValue = null;

		try{

			configValue = getPropValue();
		}
		catch(Exception e)
		{
			System.out.println("Exception: " + e);
		}

		return configValue;
	}


	public int setValue()
	{
		int abc=1;
		return abc;
	}
	
}
