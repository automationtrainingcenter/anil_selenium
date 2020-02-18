package webtables_calendars;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.BrowserHelper;

//1. locate table body

//2. locate number of rows in the table body using tr tag

//3. iterate over each row and find the columns using td tag

//4. iterate over each column or cell and get the table cell
public class WebTableDemo extends BrowserHelper {

	public static void main(String[] args) {
		openBrowser("chrome", "https://learn.letskodeit.com/p/practice");
		sleep(3000);

		// locate webtable tbody tag
		WebElement tbody = driver.findElement(By.cssSelector("#product>tbody"));

		// locate all the rows with table body using tr tag
		List<WebElement> rows = tbody.findElements(By.tagName("tr"));

		// iterate over each row
		for (int i = 1; i < rows.size(); i++) {
			// locate all the columns in every row
			List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
			// iterate over every column
			for(WebElement cell : cells) {
				System.out.print(cell.getText()+"\t");
			}
			
			System.out.println();
		}
		
		closeBrowser();
	}

}
