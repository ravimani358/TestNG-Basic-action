import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class javascriptexecutor_handson {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		WebElement targetElement = driver.findElement(By.xpath("//textarea[@title='Search']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].click();", targetElement);
		// enter value
		js.executeScript("arguments[0].value='ravisankar';", targetElement);
		
		//alert message
		js.executeScript("alert('Hi...');");
		
		// refresh page
		js.executeScript("history.go(0);");
		
		// clear value
		js.executeScript("arguments[0].value='';", targetElement);
		
		// scroll page
		js.executeScript("window.scroll(0, 350);");
		// --> to find this scroll screen using -> window.scroll(0, 350) in inspect window and navigate to console to execute this code
		
		// capture the title of the page
		String pageTitle = (String) js.executeScript("return document.title;");
		String title_page = (String) js.executeScript("return document.title;");
		System.out.println(title_page);
		
		// Boardar of the element
		js.executeScript("arguments[0].style.border='3px solid red';", targetElement);
		
		//flashing element -> but not necessary in automation
		String originalStyle = targetElement.getAttribute("style");
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", targetElement);
        Thread.sleep(500);
        js.executeScript("arguments[0].setAttribute('style', '" + originalStyle + "');", targetElement);
       
	}



}
