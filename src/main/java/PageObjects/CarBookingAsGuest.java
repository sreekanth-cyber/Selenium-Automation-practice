package PageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CarBookingAsGuest {

	WebDriver driver;
	Properties prop;
	
	By Guest = By.xpath("//a[@id='guesttab']");
	By FirstName = By.xpath("//input[@placeholder='First Name']");
	By LastName = By.xpath("//input[@placeholder='Last Name']");
	By MobileNumber = By.xpath("//input[@placeholder='Contact Number']");
	By Email = By.xpath("//input[@placeholder='Email']");
	By ConfirmEmail = By.xpath("//input[@placeholder='Confirm Email']");
	By Address = By.xpath("//input[@placeholder='Address']");
	By Country = By.xpath("//div[@class='chosen-container chosen-container-single']");
	By Extra_ChildSeat = By.xpath("//tr[2]//td[4]//label[1]");
	By Extra_GPS = By.xpath("//tr[3]//td[4]//label[1]");
	By Cookie = By.xpath("//button[@class='cc-btn cc-dismiss']");
	By ConfirmBook = By.xpath("//button[@name='guest']");
	
	public CarBookingAsGuest(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void BookTheCar() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\sree\\MyProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		driver.findElement(Guest).click();
		driver.findElement(Cookie).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(FirstName).sendKeys(prop.getProperty("Guest_Fname"));
		driver.findElement(LastName).sendKeys(prop.getProperty("Guest_Lname"));
		driver.findElement(Email).sendKeys(prop.getProperty("Guest_Email"));
		driver.findElement(ConfirmEmail).sendKeys(prop.getProperty("Guest_ConfirmEmail"));
		driver.findElement(MobileNumber).sendKeys(prop.getProperty("Guest_Mobile_no"));
		driver.findElement(Address).sendKeys(prop.getProperty("Guest_Address"));
		driver.findElement(Country).click();
		driver.findElement(By.xpath("//input[@class='chosen-search-input']")).sendKeys("United Kingdom");
		driver.findElement(By.xpath("//input[@class='chosen-search-input']")).sendKeys(Keys.ENTER);
		driver.findElement(Extra_ChildSeat).click();
		driver.findElement(Extra_GPS).click();
		driver.findElement(ConfirmBook).click();
		
	}
}
