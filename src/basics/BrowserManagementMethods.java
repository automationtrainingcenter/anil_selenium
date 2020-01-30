package basics;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserManagementMethods {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		
		// Window Interface methods
//		Options options = driver.manage();
//		Window window = options.window();
		Window window = driver.manage().window();
		
		
		// getPosition() returns Point class object
		// Point class contains getX() and getY() retuns x and y coordinate values respectively
		Point position = window.getPosition();
		System.out.println("window is at x = "+position.getX()+" and at y = "+position.getY());
		
		// getSize() returns Dimension class object
		// Dimension class cotains getWidth() and getHeight() which returns width and height of the browser window
		Dimension size = window.getSize();
		System.out.println("browser window width = "+size.getWidth()+" height = "+size.getHeight());
		
		// maximize() is used to maximize browser window
		window.maximize();
//		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		// fullscreen() is used to full screen (F11 mode) the browser window
		window.fullscreen();
		Thread.sleep(3000);
		
		
		// setSize(Dimension arg) is used to set browser window to the specified width and height
		window.setSize(new Dimension(400, 200));
		Thread.sleep(3000);
		
		// setPosition(Point arg) is used to set browser window height and width to a specified value
//		Point point = new Point(300, 150);
//		window.setPosition(point);
		window.setPosition(new Point(900, 450));
		Thread.sleep(3000);
		
		driver.close();
		
	}

}
