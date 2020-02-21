package webtables_calendars;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.BrowserHelper;

public class AutoSuggestionsDemo extends BrowserHelper{
	
	public static void main(String[] args) {
		openBrowser("chrome", "http://www.google.com");
		sleep(2000);
		driver.findElement(By.name("q")).sendKeys("selenium webdriver");
		sleep(1000);
		// retrieve all the suggestions for search word
		WebElement parentEle = driver.findElement(By.className("erkvQe"));
		// locate all the suggestion with in the above parent element
		List<WebElement> suggestions = parentEle.findElements(By.tagName("li"));
		for(WebElement suggestion : suggestions) {
//			System.out.println(suggestion.getText());
			if(suggestion.getText().equals("selenium webdriver architecture")) {
				suggestion.click();
				break;
			}
		}
		
		sleep(4000);
		closeBrowser();
		
		
	}

}
