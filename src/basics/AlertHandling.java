package basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*In Selenium we have Alert interface

this Interface provides several methods to handle alerts

1. accept() - it will click on OK button of the alert

2. dismiss() - it will click on Cancel button of the alert

3. sendKeys(String arg) - it will type some data we are passing as an argument to the alert text field

4. getText() - returns a string value which is the text of alert


How to create Alert interface Object reference
In webdriver interface we have switchTo() which return TargetLocator interface reference
In TartgetLocator interface we have several methods to switch driver focus
alert() is the method which will switch driver focus from main page to alert in the page.

TargetLocator tl = driver.switchTo();
Alert alert = tl.alert();

using the above reference we can call alert interface methods
*/
public class AlertHandling {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		
		
		// locate enter your name text box
		WebElement enterNameTB = driver.findElement(By.id("name"));
		// type some data in above text box
		enterNameTB.sendKeys("surya");
		Thread.sleep(3000);
		
		
		
		// locate alert button and click on it, then it will open an alert in web page
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(2000);
		
		// handle the alert
		// switch the driver focus from page to alert
		Alert alert = driver.switchTo().alert();
		// get alert text and print on the console
		System.out.println("alert text is "+alert.getText());
		// click on OK button of the alert
		alert.accept();
		Thread.sleep(2000);
		
		//send some data in above text box
		enterNameTB.sendKeys("sunshine");
		Thread.sleep(3000);
		
		
		// locate confirm button and click on it, then it will open an alert in web page
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(2000);
		
		
		// handle the alert
		// switch the driver focus from main page to alert
		Alert alert2 = driver.switchTo().alert();
		
		// get alert text and print on the console
		System.out.println("confirm alert text is "+alert2.getText());
		
		// click on cancel button of the alert
		alert.dismiss();
		
		
		driver.close();	
	}
}
