package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffLoginPage {

	WebDriver driver;
	
	public RediffLoginPage(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	/*By username = By.xpath("//input[@id='login1']");
	By password = By.xpath("//input[@id='password']");
	By loginbtn = By.xpath("//input[@title='Sign in']");
	By HomeLink = By.linkText("Home");*/
	
	@FindBy(xpath="//input[@id='login1']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@title='Sign in']")
	WebElement loginbtn;
	
	@FindBy(linkText="Home")
	WebElement HomeLink;
	
	public WebElement Email()
	{
		return username;
	}
	public WebElement Password()
	{
		return password;
	}
	public WebElement PerformLogin()
	{
		return loginbtn;
	}
	public WebElement ClickHome()
	{
		return HomeLink;
	}
}
