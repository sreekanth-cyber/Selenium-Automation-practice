package PageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class CarBookingAsExistingUser {

	WebDriver driver;
	Properties prop;
	
	public CarBookingAsExistingUser(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By Cookie = By.xpath("//button[@class='cc-btn cc-dismiss']");
	By SignIn = By.xpath("//a[@id='signintab']");
	By Email = By.xpath("//input[@id='username']");
	By Password = By.xpath("//input[@id='password']");
	By Extra_ChildSeat = By.xpath("//tr[2]//td[4]//label[1]");
	By Extra_GPS = By.xpath("//tr[3]//td[4]//label[1]");
	By ConfirnBook = By.xpath("//button[@name='guest']");
	
	public void BookTheCar() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\sree\\MyProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.findElement(Cookie).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(SignIn).click();
		driver.findElement(Email).sendKeys(prop.getProperty("email"));
		driver.findElement(Password).sendKeys(prop.getProperty("password"));
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(Extra_ChildSeat).click();
		driver.findElement(Extra_GPS).click();
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(ConfirnBook).click();
		
	}
}
