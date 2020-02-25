package waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BrowserHelper;

public class ImplicitWaitDemo extends BrowserHelper{
	
	public static void main(String[] args) {
		openBrowser("chrome", "https://rahulshettyacademy.com/seleniumPractise/#/");
		
		// pageLoadTimeOut() it will wait until the complete page is loaded
//		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		// setScriptTimeout() it will wait until javascript code executes
//		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		
		// implicitlyWait() : it will wait for amount of time we specified for each and every element we are locating 
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//button[text()='ADD TO CART'])[2]")).click();
		driver.findElement(By.cssSelector(".cart-icon")).click();
		driver.findElement(By.cssSelector(".cart-preview button")).click();
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("promocode123");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		
		
		// WebDriverWait is used for specific conditions
		// create WebDriverWait class object
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement promoInfoEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		System.out.println(promoInfoEle.getText());
		
		closeBrowser();
	}
 
}
