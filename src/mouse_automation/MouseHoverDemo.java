package mouse_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.BrowserHelper;

public class MouseHoverDemo extends BrowserHelper{
	public static void main(String[] args) {
		openBrowser("chrome", "https://www.firstcry.com/");
		sleep(3000);
		
		// locate All categories
		WebElement allCatEle = driver.findElement(By.xpath("//a[text()=' All Categories']"));
		
		
		/*
		 * To perform any mouse even selenium provides Actions class
		 * These Actions class contains several methods to perform mouse events, to call these
		 * method we have to create an object of Actions class.
		 * whatever the event we are performing we have to call build() and perform() methods
		 * of Actions class after the event related method. 
		 */
		
		// create an object of Actions class
		Actions actions = new Actions(driver);
		
		// to move mouse to an element we can use moveToElement()
		actions.moveToElement(allCatEle).build().perform();
		sleep(2000);
		
		// locate toys element and 
		WebElement toysSubmenuEle = driver.findElement(By.xpath("//a[text()='TOYS']"));
		
		actions.moveToElement(toysSubmenuEle).build().perform();
		sleep(2000);
		
		// locate softtoys elements
		WebElement softToysEle = driver.findElement(By.xpath("(//a[@title='Soft Toys'])[1]"));
		
		actions.moveToElement(softToysEle).click().build().perform();
		
		sleep(4000);
		
		
		closeBrowser();
		
	}

}
