import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {
	public static void main(String[] args) {
		//WebDriverManager.chromedriver().setup();
		//WebDriverManager.firefoxdriver().setup();
		//WebDriverM*n*ger.edgedriver().setup();
		//WebDriverManager.iedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "C:/Users/manoj/eclipse-workspace/SeleniumCoreProject/drivers/chromedriver/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\manoj\\eclipse-workspace\\SeleniumCoreProject\\drivers\\geckodriver\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		//driver.get("https://www.selenium.dev/");
		//List<WebElement> listofInputelements = driver.findElements(By.id("input"));
		//listofInputelements.size();
		//implicitWaits();
		//explicitWaits();
		//fluentWaits();
		headlessBrowsers();
		

	}
	public static void implicitWaits() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//250 ms is the deafault polling time
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://cosmocode.io/automation-practice/");
		WebElement age = driver.findElement(By.name("age"));
		Select ageSelect = new Select(age);
		ageSelect.selectByIndex(1);
		System.out.println("the number of elements in the dropdown are:"+ageSelect.getOptions().size());

	}
	public static void explicitWaits() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com/ncr");
		driver.findElement(By.name("q")).sendKeys("Selenium"+ Keys.ENTER );
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));
		System.out.println(firstResult.getText());
		firstResult.click();
		
	}
	public static void fluentWaits() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com/ncr");
		driver.findElement(By.name("q")).sendKeys("Selenium"+ Keys.ENTER );
		// Waiting 30 seconds for an element to be present on the page, checking
		   // for its presence once every 5 seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(30))
				  .pollingEvery(Duration.ofSeconds(5))
				  .ignoring(NoSuchElementException.class);

		   


		WebElement test = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a/h3")));
		
		test.click();
	}
	public static void headlessBrowsers() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://google.com/ncr");
		driver.findElement(By.name("q")).sendKeys("Selenium"+ Keys.ENTER );
		WebElement first = driver.findElement(By.xpath("//a/h3"));
		System.out.println(first.getText());
	}
}
