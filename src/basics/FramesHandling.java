package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 * 
 * 	TargetLocator interface contains several methods to switch driver focus from 
	main page to alert, another web page in a window or tab, or to a frame inside the page
	or to an active element with in the page
 
 Frames handling methods
1. frame(int index) - used to switch driver focus from main page to any frame
based on index number of the frame

2. frame(String id\name) - used to switch driver focus from main page to any frame
based on frame id or name attribute value

3. frame(WebElement frameEle) - used to switch driver focus from main page to any frame
based on frame by locating that frame and storing in WebElement reference

4. parentFrame() - is used to switch driver focus from an inner frame or child frame
to parent frame 

5. defaultContent() - is used to switch driver focus from any frame to main page

// all the frame methods returns WebDriver reference
 * 
 * In webdriver interface we have switchTo() which returns TargetLocator interface reference
 * we can use this reference to call above methods
 * 
 * TargetLocator tl = driver.switchTo();
 * tl.frame(0);
 * 
 * driver.switchTo().frame(0);
 */

public class FramesHandling {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		
		// locate enter your name element with in the main page and send some data
		driver.findElement(By.id("name")).sendKeys("sunshine");
		Thread.sleep(3000);
		
		// now driver focus is in main page
		// switch that driver focus from main page to frame which contains search courses elment
		driver.switchTo().frame("iframe-name");
		
		// now driver is in frame
		// locate search courses element with in the frame and send some data
		driver.findElement(By.id("search-courses")).sendKeys("ruby");
		Thread.sleep(3000);
		
		
		// now driver focus is in frame
		// switch that driver focus back to main page 
		driver.switchTo().defaultContent();
		// locate hide/show text field and type some data
		driver.findElement(By.id("displayed-text")).sendKeys("selenium");
		Thread.sleep(3000);
		
		
		
		driver.close();
	}

}
