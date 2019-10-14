import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Note2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.qualitestgroup.com");
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//links in footer section
		WebElement footerdriver = driver.findElement(By.xpath("//div[@class='footer__main']"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		
		//links in column section
		WebElement columndriver = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/footer[1]/div[2]/div[1]/div[1]/div[1]"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
		for(int i=1;i<columndriver.findElements(By.tagName("a")).size();i++)
		{
			String ClickTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(ClickTab);
			Thread.sleep(2000L);
		}
		
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> itr = ids.iterator();
		while(itr.hasNext())
		{
			driver.switchTo().window(itr.next());
			System.out.println(driver.getTitle());
		}
	}
	

}
