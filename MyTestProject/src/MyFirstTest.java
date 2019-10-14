import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		driver.navigate().to("https://yahoo.com");
		driver.navigate().back();
		driver.navigate().forward();
		driver.quit();
		
		driver.get("https://facebook.com");
		driver.manage().window().maximize();
		driver.getPageSource();
		driver.findElement(By.id("email")).sendKeys("tes123");
		driver.findElement(By.id("pass")).sendKeys("abc");
		driver.findElement(By.xpath("//input[@id='u_0_3']")).click();
		driver.quit();
	}

}
