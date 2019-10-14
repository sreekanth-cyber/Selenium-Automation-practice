package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffHomePage {

	WebDriver driver;
	
	public RediffHomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	By SearchField = By.xpath("//input[@id='srchword']");
	By SearchBtn = By.xpath("//input[@aria-label='Search']");
	
	public WebElement ClickSearch()
	{
		return driver.findElement(SearchField);
	}
	public WebElement ClickSearchBtn()
	{
		return driver.findElement(SearchBtn);
	}
}
