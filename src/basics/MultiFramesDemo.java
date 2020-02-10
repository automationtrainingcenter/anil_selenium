package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiFramesDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///E:/SSTS/anil/SeleniumConcepts/frames/framesDemo.html");
		driver.manage().window().maximize();
		
		
		// now driver focus is in main page
		// Automate guru 99 frame which is a frame in frame 3
		// first switch the driver focus to frame 3, then switch that focus to frame4
		driver.switchTo().frame("fthree");
		// after the above the line driver focus is in frame3
		// so switch that focus to frame 4 or inner frame
		driver.switchTo().frame(0);
		// after the above line driver focus is in frame 4 which is guru99 page
		driver.findElement(By.id("gsc-i-id2")).sendKeys("selenium");
		Thread.sleep(3000);
		
	
		
		// Automate frame3 
		// now driver focus is in frame4
		// switch that driver focus to frame3
		// frame 3 is parent frame of frame 4
		// so we can switch from frame 4 to frame 3 using parentFrame()
		driver.switchTo().parentFrame();
		// after the above line driver focus is in frame 3
		driver.findElement(By.id("click")).click();
		Thread.sleep(3000);
		
		
		// Automate frame 2
		// now driver focus is in frame 3
		// switch the driver focus from frame 3 to main page using defaultContent()
		driver.switchTo().defaultContent();
		// after the above line driver focus is in main page
		// switch driver focus frome  main page to frame2
		driver.switchTo().frame("ftwo");
		// after the above line driver focus is in frame 2
		driver.findElement(By.linkText("selenium official site")).click();
		Thread.sleep(3000);
		
		
		// Automate frame 1
		// now driver focus is in frame 2
		// switch that driver focus to main page using defaultContent()
		driver.switchTo().defaultContent();
		// after the above line driver focus is in main page
		// switch that driver focus to frame1
		driver.switchTo().frame("fone");
		// now driver focus is in frame1
		driver.findElement(By.cssSelector("input[placeholder='Enter name']")).sendKeys("sunshine");
		Thread.sleep(3000);
		
		// Automate main page
		// now driver focus is in frame 1
		// siwtch that driver focus to main page using defaultContent()
		driver.switchTo().defaultContent();
		// after the above line driver focus is in main page
		driver.findElement(By.id("opentTab")).click();
		Thread.sleep(4000);
		
		driver.quit();
		
		
	}

}
