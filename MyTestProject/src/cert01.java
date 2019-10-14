import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.apache.commons.io.FileUtils;


public class cert01 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Defining profile which accepts insecure certificates
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		//dc.acceptInsecureCerts();
		
		ChromeOptions c = new ChromeOptions();
		c.merge(dc);
		System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(c);
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		//second way
		
		/*dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		driver.manage().deleteAllCookies();
		driver.manage().addCookie(null);*/
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File ("C:\\sree\\Screenshot.png"));
		
		WindowsUtils.killByName("excel.exe");
	}

}
