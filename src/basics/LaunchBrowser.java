package basics;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchBrowser {
	public static void main(String[] args) {
		// set system property 
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		// to launch chrome browser create an object of ChromeDriver class
		ChromeDriver cdriver = new ChromeDriver();
		
		// set system property for gecko driver
		System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
		// to launch firefox browser create an object of FirefoxDriver class
		FirefoxDriver fdriver = new FirefoxDriver();
		
	}

}
