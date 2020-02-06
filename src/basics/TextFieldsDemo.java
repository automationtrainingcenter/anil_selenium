package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextFieldsDemo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		
		// locate first name field and type some data
//		WebElement firstNameEle = driver.findElement(By.name("firstname"));
//		firstNameEle.sendKeys("surya");
		driver.findElement(By.name("firstname")).sendKeys("surya");
		Thread.sleep(2000);
		
		
		// locate surname field an type some data
		driver.findElement(By.name("lastname")).sendKeys("prakash");
		Thread.sleep(2000);
		
		// locate email or phone field and type some data
		driver.findElement(By.name("reg_email__")).sendKeys("surya@gmail.com");
//		driver.findElement(By.name("reg_email__")).sendKeys("9876543210");
		Thread.sleep(2000);
		
		
		// locate reenter email field and type some data
		WebElement reenterEmailField = driver.findElement(By.name("reg_email_confirmation__"));
		if(reenterEmailField.isDisplayed()) {
			reenterEmailField.sendKeys("surya@gmail.com");
			Thread.sleep(2000);
		}
		
		
		// locate password field and type some data
		driver.findElement(By.name("reg_passwd__")).sendKeys("password");
		Thread.sleep(2000);
		
		
		driver.close();
		
		
		
	}

}
