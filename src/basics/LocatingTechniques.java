package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/*By class methods or Locating Techniques of selenium

Note 1: To locate any elemenet in the webpage right click on that 
element and click inspect, then that element will be highlighted
in the html source code
Note 2: Every html element is implemented using a tag and every 
element contains multiple attributes with values
eg:
	<input id="fname" 
	name = "firstName" 
	class = "inputtext _58mg _2ph-" 
	aria-label="Enter first name"
	aria-required = "true"></input>
Here <input ....> opening tag and </input> is closing tag.
id, name, class, aria-lable, aria-required are the attribute name
fname, firstName, inputtext _58mg _2ph- and true are the attribute values
Note 3: we can locate an element using any of the attribute and it's value

The following are the methods of By class as per the prioirty of locating 
an element. All these methods are static methods so we can call them using
class name itself. All these methods accepts string arg and returns By class
reference

1. id(String arg) : returns a By class reference
it is used to locate an element using it's id attribute value.
2. name(String arg) : it is used to locate an element using it's name 
attribute value.
Note: if an element contains a dynamic id or does not contains an id or
duplicate name attribute then we can't locate those elements using id 
or name. so we have to use below techniques.
Dynamic ids are id attribute values which will change when ever we refresh
a web page.

If we are locating a link and that link does not contains unique id or name 
attribute then we can locate those links using following techniques
3. linkText(String arg): is used to locate a link using link text
link text is the inner text of the <a> tag
inner text means the text in between opening and closing tag
linktext means the text in between <a> and </a>
4. partialLinkText(String arg): is used to locate a link using part of 
the link text instead of complete link text

To locate any element otherthan links which does not contains unique id
or name attribute we can use following techniques
5. cssSelector(String arg): is used to locate any element using any 
attribute value
syntax:
	tagName[att_name = 'att_value']

6. xpath(String arg): is also used to locate any element using any attribute
value
syntax: 
	"//tagName[@att_name = 'att_value']"

The below two methods are generally used to locate multiple elements
7. className(String arg) : is used to locate either single or multiple elements using
class name of the element.

Note: there is a probability a class attribute can have multiple class names
eg: in above element class attribute value is class = "inputtext _58mg _2ph-"
in above class attribute value we have 3 classes and we have to use any one class name
in className() argument, we are not allowed to use multiple class names in 
className() argument
	
	By.className("inputtext") is valid
	By.className("_58mg") is also valid
	By.className("_2ph-") is also valid
	By.className("inputtext _58mg") is invalid because the argument contains two class names

8. tagName(String arg): is used to locate either single or multiple elements using 
name of the tag.
*/
public class LocatingTechniques {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", ".//drivers//geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		
		
		// locate email or phone element using id attribute or id method
		By emailLoc = By.id("email");
		WebElement emailEle = driver.findElement(emailLoc);
//		WebElement emailEle = driver.findElement(By.id("email"));
		
		// locate first name element using name attribute or name method
		By firstNameLoc = By.name("firstname");
		WebElement firstNameEle = driver.findElement(firstNameLoc);
		
		// locate forgotten account? link using linkText method
		By forAccLoc = By.linkText("Forgotten account?");
		WebElement forAccEle = driver.findElement(forAccLoc);
		
		
		// locate create a page link using partialLinkText method
		By createAPageLoc = By.partialLinkText("Create");
		WebElement createAPageEle = driver.findElement(createAPageLoc);
		
		
		// locate female radio button using cssSelector method
		By femaleRadioBtnLoc = By.cssSelector("input[value='1']");
		WebElement femaleRadioBtnEle = driver.findElement(femaleRadioBtnLoc);
		
		
		// locate male radio button using xpath method
		By maleRadioBtnLoc = By.xpath("//input[@value='2']");
		WebElement maleRadioBtnEle = driver.findElement(maleRadioBtnLoc);
		
		// locate elements whose class name is inputtext using classname method
		By inputTextLoc = By.className("inputtext");
		List<WebElement> inputTextEles = driver.findElements(inputTextLoc);
		System.out.println("number of elements with inputtext as class name are "+inputTextEles.size());
		
		
		// locate elements whose tag name is a using tagName method
		By linksLoc = By.tagName("anchor");
		List<WebElement> linkEles = driver.findElements(linksLoc);
		System.out.println("number of links in page are "+linkEles.size());
		
		driver.close();
		
		
		
		
	}

}
