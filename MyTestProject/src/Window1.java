import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Window1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://accounts.google.com/signup/v2/webcreateaccount?continue=https%3A%2F%2Faccounts.google.com%2Fb%2F0%2FAddMailService&dsh=S1644508287%3A1568185169541193&gmb=exp&biz=false&flowName=GlifWebSignIn&flowEntry=SignUp");
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//a[contains(text(),'Help')]")).click();
		Set<String>ids = driver.getWindowHandles();
		Iterator<String>itr = ids.iterator(); 
		String parent_id = itr.next();
		String child_id = itr.next();
		driver.switchTo().window(child_id);
		System.out.println(driver.getTitle());
		driver.switchTo().window(parent_id);
		System.out.println(driver.getTitle());
	}

}
