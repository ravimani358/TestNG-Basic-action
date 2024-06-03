import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testcase {
	public static WebDriver driver;
	
	@BeforeSuite
	public void Launch_Browser() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
		driver.get("https://www.makemytrip.com/");
	}
	
	@Parameters({"from_city", "to_city"})
	@Test(priority = 1, invocationCount = 1, groups = "sanity", enabled = true)
	public void Testcase_01(String from_city, String to_city) throws InterruptedException {
		Thread.sleep(3000);
		WebElement frames_01 = driver.findElement(By.xpath("//iframe[contains(@title,'notification')]"));
		driver.switchTo().frame(frames_01);
		driver.findElement(By.className("close")).click();
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//input[@data-cy='fromCity']")).click();
		driver.findElement(By.xpath("//input[contains(@class,'react-autosuggest__input')]"));
		driver.findElement(By.xpath("//input[contains(@class,'react-autosuggest__input')]")).sendKeys(from_city);
		driver.findElement(By.xpath("//p[contains(text(),'New Delhi')]")).click();
		driver.findElement(By.id("toCity")).click();
		driver.findElement(By.xpath("//input[contains(@class,'react-autosuggest__input')]")).sendKeys(to_city);
		driver.findElement(By.xpath("//p[contains(text(),'Bengaluru')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//p[text()='20'])[1]")).click();
	}
	
	@AfterSuite
	public void close_Browser() {
		driver.close();
	}
	
}