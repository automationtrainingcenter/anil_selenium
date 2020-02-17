package mouse_automation;
// drag an element to some location

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.BrowserHelper;

public class DragDemo extends BrowserHelper{
	public static void main(String[] args) {
		openBrowser("chrome", "https://jqueryui.com/draggable/");
		sleep(3000);
		
		// now driver focus is in main page switch the driver focus to the frame which contains drag element
		driver.switchTo().frame(0);
		
		// after the above line driver focus is in frame
		// locate drag me around element
		WebElement dragEle = driver.findElement(By.id("draggable"));
		
		
		// create an Actions class object
		Actions actions = new Actions(driver);
		
		// drag the above element to some location
//		actions.clickAndHold(dragEle).moveByOffset(120, 120).release().build().perform();
		actions.dragAndDropBy(dragEle, 100, 100).build().perform();
		
		sleep(4000);
		
		closeBrowser();
		
		
	}
}
