package webtables_calendars;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.BrowserHelper;

public class NSEIndiaTable extends BrowserHelper {

	public static void main(String[] args) {
		openBrowser("chrome",
				"https://www1.nseindia.com/live_market/dynaContent/live_watch/pre_open_market/pre_open_market.htm");

		sleep(3000);
		// locate table body
		WebElement tbody = driver.findElement(By.cssSelector("#preOpenNiftyTab>tbody"));

		// locate all the rows inside the table body using tr tag
		List<WebElement> rows = tbody.findElements(By.tagName("tr"));

		// iterate over every row
		for (int i = 2; i < rows.size(); i++) {
			// in every row locate columns using td tag
			List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));
			// retrieve company code (in cell 1) and share price (in cell 4)
			String companyCode = cells.get(0).getText();
			if (companyCode.equals("NTPC")) {
				String sharePrice = cells.get(3).getText();
				System.out.println(companyCode + " " + sharePrice);
				
				break; // rows
			}
		}

		closeBrowser();

	}

}
