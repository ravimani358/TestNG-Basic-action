import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.apache.hc.core5.util.Asserts;


public class amazon {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get("https://www.amazon.in/");
		
		wait.until(ExpectedConditions.urlToBe("https://www.amazon.in/"));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement all_category = driver.findElement(By.id("searchDropdownBox"));
		
		Select dropdown = new Select(all_category);
		
		dropdown.selectByValue("search-alias=luggage");
		

	}

}
