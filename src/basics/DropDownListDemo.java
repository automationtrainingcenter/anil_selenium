package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*
 * Selenium provides Select class to automate both drop down lists and list boxes
 * 
 * Select is a class in Selenium which is used to automate drop down list
or list boxes which are implmented using <select> tag

<select name="cars">
	<option value="car1">Audi</option>  index = 0
	<option value="car2">Benz</option>  index = 1
	<option value="car3">BMW</option>  index =2
	<option value="car4">Suziki</option>  index = 3
	<option value="car4">Honda</option>  index = 4
</select>

1. selectByIndex(int index): is used to select an option based on index number
of the option tag and this index starts from 0

2. selectByValue(String valueAttrValue): is used to select an option based on the
value of the value attribute of the option tag

3. selectByVisibleText(String innerTextOptionTag): is used to select an option based 
on the inner text of the option tag

4. getOptions() returns a List<WebElement>: this method returns all option tags of
the select tag as List of type web element

5. getFirstSelectedOption() returns WebElement: this is returns an option tag which
was selected by default.

6. isMultiple() returns true if given select class object is a list box i.e. which
allows multiple option selection

7. getAllSelectedOptions() returns a List<WebElement>: this method returns all option tags
which are selected

8. deselectByIndex(int index) is used to deselect an option based on index number

9. deselectByValue(String valueAttrValue) is used to deselect an option based on value
of the value attribute

10. deselectByVisibleText(String innerTextOptionTag) is used to deselect an 
option based on the inner text of the option tag

11. deselectAll() is used to deselect all the selected options of a list box

All these are instance metheds so we have create an object of the Select class to call these
methods
Syntax to create an object of Select class
	Select selectObj = new Select(WebElemnet select_tag_ele)
by above syntax first we have to locate Select tag and store in a WebElement reference
then pass that reference to the Select class constructor.

 * 
 */
public class DropDownListDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();

		// locate day drop down list Select tag
		WebElement dayEle = driver.findElement(By.id("day"));

		// create a Select class object
		Select daySelect = new Select(dayEle);

		// retrieve all the options from day select
		List<WebElement> dayOptions = daySelect.getOptions();
		System.out.println("number of day optios are " + dayOptions.size());

		// retreive default day option
		WebElement defaultDateOption = daySelect.getFirstSelectedOption();
		System.out.println("default date is " + defaultDateOption.getText());

		// select a date from day drop down list based on index
		daySelect.selectByIndex(21);

		Thread.sleep(3000);

		// locate month drop down list Select tag
		WebElement monthEle = driver.findElement(By.id("month"));

		// create Select class object for month ele
		Select monthSelect = new Select(monthEle);

		// retrieve all the options of month select
		List<WebElement> monthOptions = monthSelect.getOptions();
		System.out.println("nubmer of month options are " + monthOptions.size());

		// retrieve the default month option
		WebElement defaultMonthOption = monthSelect.getFirstSelectedOption();
		System.out.println("default month is " + defaultMonthOption.getText());

		// select an option based on value attribute value
		monthSelect.selectByValue("6");
		Thread.sleep(3000);

		// locate year drop down list Select tag
		WebElement yearEle = driver.findElement(By.id("year"));

		// create a Select class object for year ele
		Select yearSelect = new Select(yearEle);
		
		// retrieve all the options of the year select
		List<WebElement> yearOptions = yearSelect.getOptions();
		System.out.println("number of year options are "+yearOptions.size());
		
		
		// retrieve default year option
		WebElement defaultYearOption = yearSelect.getFirstSelectedOption();
		System.out.println("default year is "+defaultYearOption.getText());
		

		// select an option based on visible text (inner text of option tag)
		yearSelect.selectByVisibleText("2010");
		Thread.sleep(2000);
		
		// retrieve all the selected options
		List<WebElement> allSelectedYearOptions = yearSelect.getAllSelectedOptions();
		System.out.println(allSelectedYearOptions.size());
		
		
		// verify year select allow multiple selection or not
		System.out.println("year allows multiple selection "+yearSelect.isMultiple());

		driver.close();

	}

}
