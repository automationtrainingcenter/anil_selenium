package jsexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utilities.BrowserHelper;

public class BringElementToView extends BrowserHelper{
	
	public static void main(String[] args) {
		openBrowser("chrome", "http://www.amazon.in");
		sleep(3000);
		
		WebElement backToTop = driver.findElement(By.id("navBackToTop"));
		
		// create a JavascriptExecutor reference
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", backToTop);
		sleep(3000);
		
		js.executeScript("document.documentElement.scrollBy(0, -100)");
		sleep(3000);
		
		closeBrowser();
	}

}
