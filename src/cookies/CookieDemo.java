package cookies;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import utilities.BrowserHelper;

public class CookieDemo extends BrowserHelper {

	// login
	public static void login() {
		driver.findElement(By.cssSelector(".login")).click();
		driver.findElement(By.id("email")).sendKeys("test@sunshine.com");
		driver.findElement(By.id("passwd")).sendKeys("selenium");
		driver.findElement(By.id("SubmitLogin")).click();
		storeCookieDetails("cookie_data", "cookie.txt");
	}

	// store the cookie details
	public static void storeCookieDetails(String folderName, String fileName) {
		Set<Cookie> cookies = driver.manage().getCookies();
		try {
			FileWriter fw = new FileWriter(getFilePath(folderName, fileName));
			BufferedWriter bw = new BufferedWriter(fw);
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				Date expiry = cookie.getExpiry();
				String domain = cookie.getDomain();
				String path = cookie.getPath();
				String value = cookie.getValue();
				bw.write(name + ";" + value + ";" + domain + ";" + path + ";" + expiry + "\n");
				bw.flush();
				bw.close();
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	// load cookie data
	public static void loadCookieData(String folderName, String fileName) {
		try {
			FileReader fr = new FileReader(getFilePath(folderName, fileName));
			BufferedReader reader = new BufferedReader(fr);
			String line = reader.readLine();
			while(line != null) {
				String[] words = line.split(";");
				String name = words[0];
				String value = words[1];
				String domain = words[2];
				String path = words[3];
				String expiry = words[4];
				// Wed Mar 18 08:57:00 IST 2020 --- E MMM dd HH:mm:ss z yyyy
				DateFormat df = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
				Date date = df.parse(expiry);
				Cookie cookie = new Cookie(name, value, domain, path, date);
				driver.manage().addCookie(cookie);
				line = reader.readLine();	
			}
			fr.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	public static void main(String[] args) {

//			http://automationpractice.com/index.php?controller=my-account
		openBrowser("chrome", "http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		login();
		loadCookieData("cookie_data", "cookie.txt");
		driver.get("http://automationpractice.com/index.php?controller=my-account");
		sleep(5000);
		closeBrowser();
	}

}
