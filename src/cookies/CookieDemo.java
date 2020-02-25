package cookies;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import utilities.BrowserHelper;

public class CookieDemo extends BrowserHelper{
	
	public static void main(String[] args) {
		
//			http://automationpractice.com/index.php?controller=my-account
//		openBrowser("chrome", "http://automationpractice.com/index.php");
		openBrowser("chrome", "http://automationpractice.com/index.php?controller=my-account");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// locate signin button and click on it
//		driver.findElement(By.cssSelector(".login")).click();
//		driver.findElement(By.id("email")).sendKeys("test@sunshine.com");
//		driver.findElement(By.id("passwd")).sendKeys("selenium");
//		driver.findElement(By.id("SubmitLogin")).click();
		sleep(5000);
		closeBrowser();
	}

}
