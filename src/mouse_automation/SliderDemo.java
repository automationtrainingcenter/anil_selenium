package mouse_automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utilities.BrowserHelper;

public class SliderDemo extends BrowserHelper {

	public static void main(String[] args) {
		openBrowser("chrome", "https://www.axisbank.com/retail/calculators/personal-loan-emi-calculator");
		sleep(5000);
		// locate slider head
		WebElement sliderHead = driver.findElement(By.xpath("(//span[@class='irs-single'])[1]"));

		// create Actions class object
		Actions actions = new Actions(driver);
		actions.clickAndHold(sliderHead).moveByOffset(200, 0).release().build().perform();
		
		sleep(3000);
		
		actions.dragAndDropBy(sliderHead, -100, 0).build().perform();
		sleep(3000);
		
		closeBrowser();
		
	}

}
