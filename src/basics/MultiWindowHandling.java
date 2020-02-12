package basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiWindowHandling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///E:/SSTS/anil/SeleniumConcepts/frames/framesDemo.html");
		driver.manage().window().maximize();

		// locate open windows button and click on it which will open multiple windows
		driver.findElement(By.id("opentTab")).click();
		Thread.sleep(5000);
		
		// the above click will open multiple windows
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowIds = new ArrayList<String>(windowHandles);
//		for (int i = 0; i < windowIds.size(); i++) {
//			driver.switchTo().window(windowIds.get(i));
//			System.out.println("window at index "+i+" is "+driver.getTitle());
//		}
		
		// automate google
		// now driver focus is in main window
		// switch that driver focus from main window to google window whose window id is in index 3
		String googleWindowId = windowIds.get(3);
		driver.switchTo().window(googleWindowId);
		// after the above line driver focus is in google window
		// locate search field and type some data
		driver.findElement(By.name("q")).sendKeys("selenium training in lingampally"+Keys.ENTER);
		Thread.sleep(3000);
		
		
		
		// automate youtube page
		// now driver focus is in google page
		// switch the driver focus from google page to youtube window whose window is is in index 2
		String youtubeWindowId = windowIds.get(2);
		driver.switchTo().window(youtubeWindowId);
		// after the above line driver focus is in youtube window
		// locate search field and type some data
		driver.findElement(By.id("search")).sendKeys("selenium webdriver architechture" + Keys.ENTER);
		Thread.sleep(3000);
		
		
		// automate facebook page
		// now driver focus is in youtube page
		// switch driver focus from youtube page to facebook window whose window id is in index 1
		String facebookWindowId = windowIds.get(1);
		driver.switchTo().window(facebookWindowId);
		// after the above line driver focus is in facebook page
		// automate login form
		// locate email or phone number field
		driver.findElement(By.id("email")).sendKeys("sunshine");
		// locate password field
		WebElement passwordEle = driver.findElement(By.id("pass"));
		passwordEle.sendKeys("aklfhajflak");
		Thread.sleep(2000);
		passwordEle.submit();
		Thread.sleep(2000);
		
		
		// automate main window
		// now driver focus is in facebook page
		// switch driver focus from facebook page to main window whose window id 0
		String mainWindowId = windowIds.get(0);
		driver.switchTo().window(mainWindowId);
		// after the above line driver focus is in main window
		// locate open tabs button and click on it
		driver.findElement(By.id("opentWin")).click();
		Thread.sleep(3000);
		
		
		driver.quit();
		
	}
}
