import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Captcha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/recaptcha/api2/demo");
		Click(driver);
	}
	public static void Click(WebDriver driver)
	{
		int framecount = driver.findElements(By.tagName("iframe")).size();
		for(int i=0;i<framecount;i++)
		{
			driver.switchTo().frame(i);
			int count = driver.findElements(By.xpath("//div[@class='recaptcha-checkbox-border']")).size();
			if(count>0)
			{
				driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
			}
			else
			{
				System.out.println("continue looping");
			}
		}
		driver.switchTo().defaultContent();
	}

}
