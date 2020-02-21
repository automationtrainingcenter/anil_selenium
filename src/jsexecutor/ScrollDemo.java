package jsexecutor;

import org.openqa.selenium.JavascriptExecutor;

import utilities.BrowserHelper;

public class ScrollDemo extends BrowserHelper{
	
	
	public static void main(String[] args) {
		openBrowser("chrome", "http://www.facebook.com");
		sleep(3000);
		
		// create JavascriptExecutor interface reference
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.documentElement.scrollBy(arguments[0], arguments[1])", 0, 400);
		sleep(2000);
		js.executeScript("document.documentElement.scrollBy(arguments[0], arguments[1])", 0, -200);
		sleep(3000);
		
		closeBrowser();
	}

}
