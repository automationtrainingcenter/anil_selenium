package webtables_calendars;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.BrowserHelper;

public class CalendarsDemo extends BrowserHelper{
	private static void selectDate(WebElement calendar, String date) {
		boolean flag = false;
		// locate all rows inside calendar table body
		List<WebElement> rows = calendar.findElements(By.tagName("tr"));
		// iterate over the rows
		for(WebElement row : rows) {
			// locate all the cell inside every row
			List<WebElement> cells = row.findElements(By.tagName("td"));
			// iterate over every cell
			for(WebElement cell : cells) {
				if(cell.getText().equals(date)) {
					cell.findElement(By.tagName("a")).click();
					flag = true;
					break; // breaks cells loop
				}
			}
			
			if(flag) {
				break; // breaks rows loop
			}
		}
	}
	
	public static void main(String[] args) {
		openBrowser("chrome", "https://www.abhibus.com/");
		sleep(2000);
		
		// lcoate data of journey element and click on it
		driver.findElement(By.id("datepicker1")).click();
		sleep(1000);
		
		WebElement currentMonthCal = driver.findElement(By.cssSelector(".ui-datepicker-group-first tbody"));
		WebElement nextMonthCal = driver.findElement(By.cssSelector(".ui-datepicker-group-last tbody"));
		
		selectDate(nextMonthCal, "21");
		sleep(3000);
		
		
		// locate date of return element and click on it
		driver.findElement(By.id("datepicker2")).click();
		sleep(1000);
		
		// locate current month and next month calendars
		currentMonthCal = driver.findElement(By.cssSelector(".ui-datepicker-group-first tbody"));
		nextMonthCal = driver.findElement(By.cssSelector(".ui-datepicker-group-last tbody"));
		
		selectDate(nextMonthCal, "18");
		
		sleep(3000);
		
		closeBrowser();
		
	}

}
