import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tables1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/21759/leic-vs-nor-county-div-2-county-championship-division-two-2019");
		WebElement table = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
		int count = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();
		int sum = 0;
		for(int i=0;i<count-2;i++)
		{
			System.out.println(table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText());
			String value = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
			int valueint = Integer.parseInt(value);
			sum = sum + valueint; 
			
		}
		String extras = driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
		int extravalue = Integer.parseInt(extras);
		int total = sum + extravalue;
		System.out.println(total);
		String actualtotal = driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
		int actualvalue = Integer.parseInt(actualtotal);
		if(actualvalue == total)
			System.out.println("count matches");
	}

}
