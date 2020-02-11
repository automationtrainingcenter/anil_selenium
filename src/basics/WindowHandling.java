package basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 * Handling windows is same as handling multiple tabs 
 */

public class WindowHandling {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		
		
		// locate open window button and click on it, then it will open a new window
		driver.findElement(By.id("openwindow")).click();
		Thread.sleep(4000);
		
		
		// window handle
		Set<String> windowHandles = driver.getWindowHandles();
		// convert the set to list so that we can access window ids using index number
		List<String> windowIds = new ArrayList<>(windowHandles);
//		System.out.println(windowIds.size());
		// in index 0 contains id of parent window or main window, index 1 contains id of first child window,
		// index 2 contains id of second child window .. etc
		
		// now driver focus is in main window
		// switch the driver focus from main window to first child window
		driver.switchTo().window(windowIds.get(1));
		
		// after the above line driver focus is in first child window
		// locate search a course text box in child window or new window and type some data
		driver.findElement(By.id("search-courses")).sendKeys("ruby");
		Thread.sleep(3000);
		
		// window handle
		// now focus is in child window
		// switch that focus from child window to parent window
		driver.switchTo().window(windowIds.get(0));
		
	
		// after the above line driver focus is in main window
		// locate enter your name text box in parent window or main window and type some data
		driver.findElement(By.id("name")).sendKeys("sunshine");
		Thread.sleep(2000);
		
		// close both the windows
		driver.quit();
		
		
	}

}
