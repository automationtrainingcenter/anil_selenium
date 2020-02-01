package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*WebElement interface methods
This interface contains methods to perform common actions on the element

1. click() is used to click on an element 

2. sendKeys(CharSequence arg) is used to type some data in a text field and text
area. This method will send data character by character.

3. clear() is used to clear existing data in the text field or text area.

4. getText() returns String value which is an inner text of the given element if any

5. submit() is used to submit a form to the server if that form submit button is
implemented using <input> tag

6. getAttribute(String att_name) returns a String which is attribute value of the given 
attribute name

7. getCssValue(String css_property_name) returns a String which is value of the 
given css property name

8. getSize() returns Dimension class object which is height and width of the given element

9. getLocation() returns Point class object which is x and y coordinate values of the element
in the web page from top left cornor

10. getTagName() returns name of the tag of given element

11. findElement(By arg) returns WebElement interface reference this method will
locate an element in the GIVEN ELEMENT based on the locating technique we
specified using 'By' class and stores in a WebElement reference. If no
element is present in the page with locating technique then this method will
throw NoSuchElementException

12. findElements(By arg) returns a java.util.List of WebElement type this method
will locate either zero or more elements in the GIVEN ELEMENT based on the
locating technique we specified using 'By' class and store in
List<WebElement>. if no element is present in the page with locating
technique then this method will return a List of size 0.

13. isDisplayed() returns true if given element is displayed in the web page

14. isEnabled() returns true if given element is in active mode or enabled mode

15. isSelected() returns true if given option of either dropdown list or list box or 
radio button or check box is selected.

*/


public class WebElementMethods {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		
		
		// sendKeys(String arg) - is used to type some data within a text box or a text area filed
		// locate first name field
		WebElement firstNameEle = driver.findElement(By.name("firstname"));
		firstNameEle.sendKeys("sunshine");
//		driver.findElement(By.name("firstname")).sendKeys("sunshine");
		Thread.sleep(2000);
		
		// clear() - is used to remove existing text with in the text box or text area field
		firstNameEle.clear();
		Thread.sleep(2000);
		
		// click() - is used to click on any element with in the web page
		// locate female radio button
		WebElement femaleRadioBtn = driver.findElement(By.cssSelector("input[value='1']"));
		femaleRadioBtn.click();
//		Thread.sleep(2000);
		
		// submit() - is used to submit a form to the server, we can submit a form from any element with in the form
		// locate password field in login form
		WebElement passEle = driver.findElement(By.id("pass"));
//		passEle.submit();
		
		
		// getText() - it returns a String value which is the inner text of given element
		WebElement signupBtn = driver.findElement(By.name("websubmit"));
		System.out.println("inner text of sign up button is "+signupBtn.getText());
		
		// getAttribute(String attName) - it returns value of the given attribute
		String ariaLableAttValue = firstNameEle.getAttribute("aria-label");
		System.out.println("first name field aria label attribute value is "+ariaLableAttValue);
		
		
		// getCssValue(String cssPropertyName) - returns value of the given css property
		String widthValue = passEle.getCssValue("width");
		System.out.println("password field width is "+widthValue);
		
		// getLocation() - returns a point class object which is x and y coordinate axis of the givne 
		// element with in the web page
		Point passEleLoc = passEle.getLocation();
		System.out.println("password element is at x = "+passEleLoc.getX()+" and y = "+passEleLoc.getY());
		
		// getSize() - returns a Dimension class object which is width and height and of the given elelment
		Dimension firstNameEleSize = firstNameEle.getSize();
		System.out.println("first name elment width is "+firstNameEleSize.getWidth()+" and height is "+firstNameEleSize.getHeight());
		
		//getTagName() - returns tag name of the given element
		String tagName = femaleRadioBtn.getTagName();
		System.out.println("female radio button tag name is "+tagName);
		
		// isDisplayed() - returns true if given element is visible on the view of the web page
		boolean renterEmaiDisplayed = driver.findElement(By.name("reg_email_confirmation__")).isDisplayed();
		System.out.println("re enter email address is displayed "+renterEmaiDisplayed);

		// isSelected() - returns true if a radio button or check box is selected
		boolean femaleSelected = femaleRadioBtn.isSelected();
		System.out.println("female radio button is selected "+femaleSelected);
		
		
		// isEnabled() - returns true if given element is in active state or or in enabled state
		boolean signupEnabled = signupBtn.isEnabled();
		System.out.println("signup button is active state "+signupEnabled);
		Thread.sleep(3000);
		driver.close();
		
	}

}
