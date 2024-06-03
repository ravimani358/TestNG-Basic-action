import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class calendor {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		List<Integer> last_row_calendor = new ArrayList<Integer>();
		
		driver.get("https://web-locators-static-site-qa.vercel.app/calendar");
		
		driver.findElement(By.xpath("(//button[contains(@aria-label,'Choose date')])[1]")).click();
		
		int total_rows = driver.findElements(By.className("css-mvmu1r")).size();
		
		List<WebElement> Last_row = driver.findElements(By.xpath("(//div[@class='css-mvmu1r'])["+total_rows+"]"));

		for(WebElement rows : Last_row) {
			String calendor_date = rows.getText().trim();
			String[] calendor_dates = calendor_date.split("\n");
			
			for(String date : calendor_dates) {
				last_row_calendor.add(Integer.parseInt(date));
			}
		}
		
		int last_month_date =0;
		
		for(int lastday : last_row_calendor) {
			if(lastday == 30) {
				last_month_date=lastday;
			}
		}
		
		driver.findElement(By.xpath("//button[@aria-label='Jan "+last_month_date+", 2024']")).click();
		
	}

}
