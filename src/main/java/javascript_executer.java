import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class javascript_executer {

	 public static void main(String[] args) throws InterruptedException {
	        // Set the path to your ChromeDriver executable
	        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

	        WebDriverManager.chromedriver().setup();
	        
	        // Create a new instance of the ChromeDriver
	        WebDriver driver = new ChromeDriver();

	        // Open Google homepage
	        driver.get("https://www.google.com");

	        // Locate the Google search input field using its name attribute (you can use other locators as well)
	        WebElement searchField = driver.findElement(By.xpath("//textarea[@title='Search']"));

	        
	        
	        // Initialize JavascriptExecutor
	        JavascriptExecutor js = (JavascriptExecutor) driver;

	        // Clear the value of the search field using JavascriptExecutor
	        //js.executeScript("arguments[0].value='';", searchField);

	        // Click on the cleared search field
	        js.executeScript("arguments[0].click();", searchField);
	        
	        js.executeScript("arguments[0].value='Ravisankar'", searchField);
	        
	        Thread.sleep(3000);
	        
	        js.executeScript("arguments[0].value=''",searchField);

	        // Close the browser
	        //driver.quit();
	    }
}
