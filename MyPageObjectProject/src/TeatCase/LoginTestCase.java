package TeatCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ObjectRepo.RediffHomePage;
import ObjectRepo.RediffLoginPage;

public class LoginTestCase {

	@Test
	public void login()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		RediffLoginPage rd = new RediffLoginPage(driver);
		rd.Email().sendKeys("test123");
		rd.Password().sendKeys("password123");
		rd.PerformLogin().click();
		rd.ClickHome().click();
		
		RediffHomePage rd2 = new RediffHomePage(driver);
		
		rd2.ClickSearch().sendKeys("test");
		rd2.ClickSearchBtn().click();
	}
}
