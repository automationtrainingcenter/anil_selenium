package basics;
/*In Selenium we have Alert interface

this Interface provides several methods to handle alerts

1. accept() - it will click on OK button of the alert

2. dismiss() - it will click on Cancel button of the alert

3. sendKeys(String arg) - it will type some data we are passing as an argument to the alert text field

4. getText() - returns a string value which is the text of alert


How to create Alert interface Object reference
In webdriver interface we have switchTo() which return TargetLocator interface reference
In TartgetLocator interface we have several methods to switch driver focus
alert() is the method which will switch driver focus from main page to alert in the page.

TargetLocator tl = driver.switchTo();
Alert alert = tl.alert();

using the above reference we can call alert interface methods
*/
public class AlertHandling {

}
