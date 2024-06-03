import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenshot;
import io.github.bonigarcia.wdm.WebDriverManager;

public class screenshot {

	public static void getScreenShot(WebDriver driver, String screenshotType, String description) throws IOException {
	
		String timestamp = String.valueOf(java.time.LocalDateTime.now());
        
		//System.out.println(timestamp);
		
		String filename = String.format("screenshot_%s_%s_%s.png", timestamp, screenshotType, description).replace(":", "-");
		
		System.out.println(filename);
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		
		File fileDestinitation = new File("C:\\Users\\RavishankarN\\eclips_respace\\TestNG\\screenshots/" + filename);
		
		FileUtils.copyFile(sourceFile, fileDestinitation);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub 
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://web-locators-static-site-qa.vercel.app/Windows");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		wait.until(ExpectedConditions.urlToBe("https://web-locators-static-site-qa.vercel.app/Windows"));
		
		getScreenShot(driver, "fullPage", "description");
	}

}
