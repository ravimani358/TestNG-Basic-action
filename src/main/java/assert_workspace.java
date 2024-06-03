import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class assert_workspace {
		
	public static int condition1(int num1, int num2) {
		int num = num1+num2;
		return num;
	}
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
        String value = "Ravi";
        Boolean value1 = true;
        //assert_workspace assert_workspace = new assert_workspace();
        condition1(2, 3);
		
		Assert.assertEquals(condition1(2,3), 0,"testing");
        
        //Assert.assertEquals(value, "Ravi", "Check this is a expected values");
        //Assert.assertEquals(value1, true, "check this is correct");
        //Assert.assertTrue(true);
        //Assert.assertFalse(true);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
    }
}
