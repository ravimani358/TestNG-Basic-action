import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class javascriptexecuter_1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Open a website
            driver.get("https://www.google.com/");

            // Locate an element
            WebElement targetElement = driver.findElement(By.xpath("//textarea[@title='Search']"));

            // Initialize JavascriptExecutor
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Flashing an element (changing background color)
            flashElement(js, targetElement);

            // Drawing a border around the element
            //drawBorder(js, targetElement);

            // Capture title of the page
            //capturePageTitle(js);

            // Clicking on an element using JavaScript
            //clickElement(js, targetElement);

            // Generate an alert
            //generateAlert(js, "This is an alert!");

            // Refresh the page
            refreshPage(js);

            // Scroll the page
            //scrollPage(js, 0, 500);

        } finally {
            // Close the browser
            driver.quit();
        }
    }

    // Flashing an element
    private static void flashElement(JavascriptExecutor js, WebElement element) {
        String originalStyle = element.getAttribute("style");
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
        sleep(500);
        js.executeScript("arguments[0].setAttribute('style', '" + originalStyle + "');", element);
    }

    // Drawing a border around the element
    private static void drawBorder(JavascriptExecutor js, WebElement element) {
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    // Capture title of the page
    private static void capturePageTitle(JavascriptExecutor js) {
        String pageTitle = (String) js.executeScript("return document.title;");
        System.out.println("Page Title: " + pageTitle);
    }

    // Clicking on an element using JavaScript
    private static void clickElement(JavascriptExecutor js, WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }

    // Generate an alert
    private static void generateAlert(JavascriptExecutor js, String message) {
        js.executeScript("alert('" + message + "');");
    }

    // Refresh the page
    private static void refreshPage(JavascriptExecutor js) {
        js.executeScript("history.go(0);");
    }

    // Scroll the page
    private static void scrollPage(JavascriptExecutor js, int scrollFrom, int scrollTo) {
        js.executeScript("window.scrollBy(0, " + (scrollTo - scrollFrom) + ");");
    }

    // Helper method to sleep for a specified time
    private static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

	}

