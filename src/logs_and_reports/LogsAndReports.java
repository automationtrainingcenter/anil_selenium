package logs_and_reports;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utilities.BrowserHelper;

/*
 * 1. create a class which will implement all the abstract methods of the WebDriverEventListener interface
 * 2. create an object of the above class
 * 3. create an object of EventFiringWebDriver class
 * 4. register Listener class object (created in step2) to EventFiringWebDriver object
 * 5. perform every browser action using EventFiringWebDriver object
 */

public class LogsAndReports extends BaseClass{
	private WebDriver wdriver;
	private EventFiringWebDriver driver;
	ExtentReports reports;
	

	// launch browser
	public void launchBrowsertTest() {
		test = reports.createTest("launch browser test");
		System.out.println("***************Launch Browser Test******************");
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		wdriver = new ChromeDriver();

		// creating an object ReportsListener class
		ReportListener listener = new ReportListener();
		// create an object of EventFiringWebDriver class
		driver = new EventFiringWebDriver(wdriver);
		// register listener object to edriver object
		driver.register(listener);

		driver.get("http://primusbank.qedgetech.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		test.log(Status.PASS, "test passed");

	}

	// login
	public void loginTest() {
		test = reports.createTest("login test");
		System.out.println("***************Login Test******************");
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.id("txtPword")).sendKeys("Admin");
		driver.findElement(By.id("login")).click();
		test.log(Status.PASS, "test passed");
	}

	// role creation test
	public void roleCreationTest() {
		test = reports.createTest("role creation test");
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
		test.log(Status.PASS, "test passed");
	}

	// logout
	public void logoutTest() {
		test = reports.createTest("logout test");
		System.out.println("***************Logout Test******************");
		driver.findElement(By.cssSelector("a[href *= 'primus']")).click();
		test.log(Status.PASS, "test passed");
	}

	// close browser
	public void closeBrowserTest() {
		test = reports.createTest("close browser test");
		System.out.println("***************Close Browser******************");
		driver.close();
		test.log(Status.PASS, "test passed");
	}

	public static void main(String[] args) {

		LogsAndReports obj = new LogsAndReports();
		obj.reports = new ExtentReports();
		ExtentHtmlReporter report = new ExtentHtmlReporter(".//reports//logreport.html");
		obj.reports.attachReporter(report);
		obj.launchBrowsertTest();
		obj.loginTest();
		obj.roleCreationTest();
		obj.logoutTest();
		obj.closeBrowserTest();
		obj.reports.flush();

	}

}
