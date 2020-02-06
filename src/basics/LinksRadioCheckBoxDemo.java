package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksRadioCheckBoxDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();
		
		// Radio buttons
		// locate bmw radio button and click on it
		driver.findElement(By.id("bmwradio")).click();
		Thread.sleep(2000);
		
		
		// locate honda radio button and click on it
		driver.findElement(By.id("hondaradio")).click();
		Thread.sleep(2000);
		
		// Check Boxes
		// locate benz check box and click on it
		driver.findElement(By.id("benzcheck")).click();
		Thread.sleep(2000);
		
		
		// locate honda check box and click on it
		driver.findElement(By.id("hondacheck")).click();
		Thread.sleep(2000);
		
		
		// buttons
		// locate hide button and click on it
		driver.findElement(By.id("hide-textbox")).click();
		Thread.sleep(3000);
		
		// locate show button and click on it
		driver.findElement(By.id("show-textbox")).click();
		Thread.sleep(3000);
		
		
		// links
		// locate login link and click on it
		driver.findElement(By.partialLinkText("Login")).click();
		Thread.sleep(8000);
		
		driver.close();
		
		
	}

}
