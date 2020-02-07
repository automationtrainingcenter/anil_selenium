package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ListBoxDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://learn.letskodeit.com/p/practice");
		driver.manage().window().maximize();

		// locate fruits list box element
		WebElement fruitsEle = driver.findElement(By.id("multiple-select-example"));

		// create a Select class object
		Select fruitsSelect = new Select(fruitsEle);

		// get all options
		List<WebElement> options = fruitsSelect.getOptions();
		System.out.println("number of fruits options are "+options.size());
		
		// verify fruitsSelect allows multiple selection or not
		System.out.println("fruits select allows multiple selection  " + fruitsSelect.isMultiple());

		// select an option based on index
		fruitsSelect.selectByIndex(1);
		Thread.sleep(2000);

		// select an option based on value attribute value
		fruitsSelect.selectByValue("apple");
		Thread.sleep(2000);

		// select an option based on visible text of a option
		fruitsSelect.selectByVisibleText("Peach");
		Thread.sleep(2000);

		// retrieve all select options
		List<WebElement> allSelectedOptions = fruitsSelect.getAllSelectedOptions();
		System.out.println("number of options selected are " + allSelectedOptions.size());
		for (WebElement option : allSelectedOptions) {
			System.out.println(option.getText());
		}
		
		// de select all the options
//		fruitsSelect.deselectAll();
//		Thread.sleep(3000);
		
		// de select an option based on index
		fruitsSelect.deselectByIndex(2);
		Thread.sleep(2000);
		
		// de select an option based on value of the value attribute
		fruitsSelect.deselectByValue("orange");
		Thread.sleep(2000);
		
		// deselect an option based on visible text
		fruitsSelect.deselectByVisibleText("Apple");
		Thread.sleep(3000);
		
		driver.close();

	}

}
