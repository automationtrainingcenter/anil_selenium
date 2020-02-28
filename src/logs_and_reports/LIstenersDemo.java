package logs_and_reports;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

/*
 * 1. create a class which will implement all the abstract methods of the WebDriverEventListener interface
 * 2. create an object of the above class
 * 3. create an object of EventFiringWebDriver class
 * 4. register Listener class object (created in step2) to EventFiringWebDriver object
 * 5. perform every browser action using EventFiringWebDriver object
 */

public class LIstenersDemo {
	private WebDriver wdriver;
	private EventFiringWebDriver driver;

	// launch browser
	public void launchBrowsertTest() {
		System.out.println("***************Launch Browser Test******************");
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		wdriver = new ChromeDriver();

		// creating an object MyListener class
		MyListener listener = new MyListener();
		// create an object of EventFiringWebDriver class
		driver = new EventFiringWebDriver(wdriver);
		// register listener object to edriver object
		driver.register(listener);

		driver.get("http://primusbank.qedgetech.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	// login
	public void loginTest() {
		System.out.println("***************Login Test******************");
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.id("txtPword")).sendKeys("Admin");
		driver.findElement(By.id("login")).click();

	}

	// role creation test
	public void roleCreationTest() {
		System.out.println("***************Role Creation Test******************");
		driver.findElement(By.cssSelector("a[href *= '_Roles']")).click();
		driver.findElement(By.id("btnRoles")).click();
		driver.findElement(By.id("txtRname")).sendKeys("newAdminRole");
		WebElement roleTypeEle = driver.findElement(By.id("lstRtypeN"));
		Select roleSelect = new Select(roleTypeEle);
		roleSelect.selectByVisibleText("E");
		driver.findElement(By.id("btninsert")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
	}

	// logout
	public void logoutTest() {
		System.out.println("***************Logout Test******************");
		driver.findElement(By.cssSelector("a[href *= 'primus']")).click();

	}

	// close browser
	public void closeBrowserTest() {
		System.out.println("***************Close Browser******************");
		driver.close();

	}

	public static void main(String[] args) {

		LIstenersDemo obj = new LIstenersDemo();
		obj.launchBrowsertTest();
		obj.loginTest();
		obj.roleCreationTest();
		obj.logoutTest();
		obj.closeBrowserTest();

	}

}
