import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class table {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.get("https://web-locators-static-site-qa.vercel.app/Web%20Table");
		
		WebElement Topper = driver.findElement(By.xpath("//span[text()='Static Table - Subject Topper']"));
		
		wait.until(ExpectedConditions.elementToBeClickable(Topper));
		
		Topper.click();
		
		int col =0;
		
		List<WebElement> titles = driver.findElements(By.xpath("//thead/tr/th"));
		
		for(WebElement title : titles) {
			col++;
			
			if(title.getText().equals("Highest Marks")) {
				break;
			}
		}
		
		List<Integer> col_mark = new ArrayList<>();
		
		List<WebElement> marks = driver.findElements(By.xpath("//table/tbody/tr/td["+col+"]"));
		
		for(WebElement mark : marks) {
			col_mark.add(Integer.parseInt(mark.getText()));
		}
		
		int max_mark = Collections.max(col_mark);
		
		String max_student_name = driver.findElement(By.xpath("//td[text()="+max_mark+"]/following-sibling::td[1]")).getText();
		
		System.out.println("Max mark "+max_mark);
		System.out.println(max_student_name);
		
	}

}
