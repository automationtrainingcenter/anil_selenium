package basics;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * In Selenium WebDriver is the main interface which contains all the methods to automate the browser
 * WebDriver -> RemoteWebDriver is the parent class of ChromeDriver, FirefoxDriver, OperaDriver ..etc
 * 
 * WebDriver commands are nothing but the methods inside the WebDriver interface
1. get(String url): this method is used to navigate to a URL
specified as string argument

2. getTitle(): returns title of the current web page as a String value
returns inner text of the <title> tag which is inside the <head> tag
inner text means the text in between opening(<tag>) and closing(</tag>) tags

3. getCurrentUrl(): returns url of the current web page as a string

4. getPageSource(): returns complete source code of the current
web page as a String value

5. getWindowHandle(): returns id of the current browser window as a String value
Note: webdriver maintains unique id for every window opened by
the driver instance.

6. getWindowHandles(): returns a set of String type which contains ids of the
browser windows opened by the driver instance

7. findElement(By arg): returns a WebElement reference this method will
locate an element in the current web page based on the locating technique we
specified using 'By' class and stores in a WebElement reference. If no
element is present in the page with locating technique then this method will
throw NoSuchElementException

8. findElements(By arg) returns a java.util.List of WebElement type this method
will locate either zero or more elements in the current web page based on the
locating technique we specified using 'By' class and store in
List<WebElement>. if no element is present in the page with locating
technique then this method will return a List of size 0.

9. close(): is used to close the current browser window

10. quit(): is used to close all the browser windows opened by driver instance
 * 
 */

public class WebDriverCommands {
	public static void main(String[] args) {
		// set the system property to the browser driver executable
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");

		// to launch a browser just create an object of browser driver class by giving
		// an object reference to the WebDriver interface
		WebDriver driver = new ChromeDriver();
		
		// get(String url) - is used to navigate to a url
		driver.get("http://facebook.com");
		
		// getTitle() -> String title of the web page
		String title = driver.getTitle();
		System.out.println("tilte of the webpage is "+title);
		
		// getCurrentUrl() -> return a String, which is url of the current web page
		String currentUrl = driver.getCurrentUrl();
		System.out.println("url of the web page is "+currentUrl);
		
		// getPageSource() -> returns a String, which is complete html code of current web pages
		String pageSource = driver.getPageSource();
		System.out.println(pageSource.contains("Facebook helps you connect and share with the people in your life."));
		
		// getWindowHandle() -> returns a String, which is a unique of the current window or tab
		String windowId = driver.getWindowHandle();
		System.out.println("window id = "+windowId);
		
		// getWindowHandles() -> returns a Set<String>, which contains all the ids of the browser windows or tabs opened by driver instance
		Set<String> windowIDs = driver.getWindowHandles();
		System.out.println("windows ids = "+windowIDs);
		
		
		// findElement(By arg) -> returns WebElement object 
//		By emailLoc = By.id("email");
//		WebElement emailEle = driver.findElement(emailLoc);
		WebElement emailEle = driver.findElement(By.id("email"));

		
		// findElements(By arg) -> returns List<WebElement>
		List<WebElement> inputTags = driver.findElements(By.tagName("input"));
		System.out.println("number of input tags = "+inputTags.size());
		
		
		// close() - is used to close the current browser window or tab
//		driver.close();
		
		// quit() - is used to close  all the browser windows or tabs opened by driver instance
		driver.quit();
		
		
	}

}
