package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class GlobalVariables {

	public WebDriver driver = null;
	@Test
	public void login() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\sree\\TestNGProject\\src\\test\\datadrive.properties");
		prop.load(fis);	
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
		if(prop.getProperty("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(prop.getProperty("browser").equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			driver = new InternetExplorerDriver();
		}
		driver.get(prop.getProperty("url"));
	}

}
