package TestPackage;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LogOut;
import PageObjects.SignUp;

import resources.base;

public class ValidateSignUpPage extends base{

	By MyAccount = By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/div[1]/a[1]");
	By SignUp = By.xpath("//a[@class='dropdown-item tr']");
	
	@BeforeTest
	public void preConditions() throws Exception
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	@Test
	public void CheckSignUpPage() throws Exception
	{
		SignUp su = new SignUp(driver);
		driver.findElement(MyAccount).click();
		driver.findElement(SignUp).click();
		su.RegistrationPage();
		log.info("Successfully Logged in");
		Thread.sleep(3000);
		LogOut l = new LogOut(driver);
		l.BackToHomePage();
		log.info("Successfully verified Logout Page");
	}

}
