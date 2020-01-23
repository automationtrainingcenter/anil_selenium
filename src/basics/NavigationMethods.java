package basics;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;

/*
	In WebDriver interface we have Navigation interface
which contains several methods to automate browser navigations
like forward, backward and refersh

WebDriver interface have navigate() which returns Navigation 
interface reference and we can use that reference to
call Navigation interface methods

Navigation interface methods
1. to(String arg): is used to navigate to a url specified as String value
2. to(URL arg) : is used to navigate to a url specified as  a URL class object
the first to method which accept url as string argument will not verify
the url format at compile time but 2nd method will verify url format
at compile time
3. back() is used to automate back button of the browser window
4. forward() is used to automate forward button of the browser window
5. refresh() is used to automate refersh button of the browser window 
 */
public class NavigationMethods {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// create an object of Navigation interface by calling navigate() of WebDriver interface
		Navigation navigate = driver.navigate();
		
		// navigate to a google 
		navigate.to("http://www.google.com");
//		driver.navigate().to("http://www.google.com");
		Thread.sleep(3000);
		
		
		// navigate to gmail
		try {
			navigate.to(new URL("http://www.gmail.com"));
//			driver.navigate().to(new URL("http://www.gmail.com"));
		} catch (MalformedURLException e) {
			System.out.println("incorrect url format");
		}
		Thread.sleep(3000);
		
		// back() is used to automate back button of browser window
		navigate.back();
//		driver.navigate().back();
		Thread.sleep(3000);
		
		
		// forward() is used to automate forward button of browser window
		navigate.forward();
//		driver.navigate().forward();
		Thread.sleep(3000);
		
		
		// refresh() is used to automate refresh button of browser window
		navigate.refresh();
		
//		driver.navigate().refresh();
		Thread.sleep(3000);
		
		driver.close();
	}

}
