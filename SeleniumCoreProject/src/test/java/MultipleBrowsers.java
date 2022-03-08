import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleBrowsers {
	WebDriver driver = null;
	@BeforeTest
	@Parameters("browserName")
	public void setup(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}	
		
	}
	@Test
     public void driverload() throws InterruptedException {
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
     }
	
	@AfterTest
	public void Teardown() {
		driver.quit();
	}
}
