package TestPackage;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LogOut;
import PageObjects.LoginUser;
import junit.framework.Assert;
import resources.base;

public class ValidateLoginPage extends base{

	By MyAccount = By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/div[1]/a[1]");
	By Login = By.xpath("//a[@class='dropdown-item active tr']");
	By msg = By.xpath("//h3[@class='text-align-left']");
	
	@BeforeTest
	public void preConditions() throws Exception
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	@Test
	public void CheckLoginPage() throws Exception
	{
		LoginUser l = new LoginUser(driver);
		driver.findElement(MyAccount).click();
		driver.findElement(Login).click();
		l.LoginPage();
		Assert.assertEquals("Hi, Micheal Angel",driver.findElement(msg).getText());
		log.info("Successfully Logged in");
		Thread.sleep(3000);
		LogOut lo = new LogOut(driver);
		lo.BackToHomePage();
		log.info("Successfully verified LogOut Page");
	}
}
