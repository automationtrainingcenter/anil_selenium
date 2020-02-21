package jsexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utilities.BrowserHelper;
/*
 * to execute javascript code from selenium, we can use executeScript() of JavascriptExecutor interface
 */
public class GetTextBoxValue extends BrowserHelper{
	
	public static void main(String[] args) {
		openBrowser("chrome", "https://www.facebook.com/");
		sleep(2000);
		// locate email or phone text box
		WebElement emailOrPhoneEle = driver.findElement(By.id("email"));
//		emailOrPhoneEle.sendKeys("sunshine");
		
		
		// retrieve the text with in a text box
		// create a JavascriptExecutor object reference
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1]", emailOrPhoneEle, "sunshine");
		sleep(2000);
		String textBoxValue = js.executeScript("return arguments[0].value", emailOrPhoneEle).toString();
		System.out.println("text box value is "+textBoxValue);
		
		closeBrowser();
		
	}

}
