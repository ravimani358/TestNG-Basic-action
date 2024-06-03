import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class frame {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_iframe.asp");
		
		driver.switchTo().frame(1);
		
		WebElement Title = driver.findElement(By.xpath("//h1[text()='HTML']"));
		
		System.out.println(Title.getText());
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("(//a[text()='❮ Previous'])[1]")).click();
		
	}

}
