package logs_and_reports;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utilities.BrowserHelper;

/*
 * These steps for extent reports 3 or 4
 * 1. create ExetentReports class object
 * 2. create ExtentHtmlReporter class object by providing file path where we want to save reports
 * 3. attach reporter type object (created in step 2) to ExtentReports class object
 * 4. create an ExtentTest object for every test case using createTest() of ExtentReports class
 * 5. save your entire report using flush() of ExtentReports class
 */
public class ReportsDemo extends BrowserHelper{
	ExtentReports reports;
	ExtentTest test;
	
	public void launchBrowser() {
		test = reports.createTest("launch browser test");
		System.out.println("launching browser");
		test.log(Status.INFO, "launching chrome browser");
		test.log(Status.INFO, "navigated to url");
		test.log(Status.PASS, "test passed");
	}

	public void login() {
		test = reports.createTest("login test");
		System.out.println("login test");
		test.log(Status.INFO, "located username and filled Admin");
		test.log(Status.INFO, "loated password and filled Admin");
		test.log(Status.INFO, "locate login button and clicked");
		test.log(Status.PASS, "test passed");
	}

	public void roleCreation() {
		test = reports.createTest("role creation test");
		System.out.println("role creation test");
		test.log(Status.INFO, "located roles button and clicked");
		test.log(Status.INFO, "located new role button and clicked");
		test.log(Status.INFO, "located role name and filled with someNewRoleData");
		test.log(Status.INFO, "located role type and selected E");
		test.log(Status.INFO, "located submit button and clicked");
		test.log(Status.INFO, "alert came and click on ok button");
		test.log(Status.INFO, "alert screenshot ");
		try {
			test.addScreenCaptureFromPath(getFilePath("screenshots", "alert.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.FAIL, "test failed");
	}

	public void roleCreationReset() {
		test = reports.createTest("role creation reset test");
		System.out.println("role creation reset");
		test.log(Status.INFO, "located roles button and clicked");
		test.log(Status.INFO, "located new role button and clicked");
		test.log(Status.INFO, "located role name and filled with someNewRoleData");
		test.log(Status.INFO, "located role type and selected E");
		test.log(Status.INFO, "located reset button and clicked");
		test.log(Status.PASS, "test passed");
		
	}

	public void logout() {
		test = reports.createTest("logout test");
		System.out.println("logout test");
		test.log(Status.INFO, "located logout button and clicked");
		test.log(Status.SKIP, "test skipped");
	}

	public void tearDown() {
		test = reports.createTest("close browser test");
		System.out.println("close browser test");
		test.log(Status.INFO, "browser closed");
		test.log(Status.PASS, "test passed");
	}

	public static void main(String[] args) {
		
		ReportsDemo obj = new ReportsDemo();;
		// create ExtentReports class object
		obj.reports = new ExtentReports();
		// create ExtentHtmlReporter class object
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(".//reports//reports.html");
		// create ExtentHtmlReporter class object to ExtentReports class object
		obj.reports.attachReporter(reporter);
		
		
		obj.launchBrowser();
		obj.login();
		obj.roleCreation();
		obj.roleCreationReset();
		obj.logout();
		obj.tearDown();
		// save all the reports using flush()
		obj.reports.flush();
	}

}
