package sikuli_tool;

import org.openqa.selenium.By;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import utilities.BrowserHelper;
/*
 * Sikuli works based on Visual Image Match technology
 * Whatever the elements we want to automate, save those elements as images
 * Sikuli uses these images to locate elements on the screen and to automate
 * 
 * Sikuli can automate anything which is visible on the screen
 * 
 * Sikuli mainly contains two classes
 * 1. Screen : it is the main class which contains methods for all the operations
 * 2. Pattern : is is the class which is used to store images we want to automate
 * for each image we have to create one Pattern class object
 */

public class SikuliDemo extends BrowserHelper{
	public static void main(String[] args) {
		openBrowser("chrome", "https://smallpdf.com/word-to-pdf");
		
		driver.findElement(By.xpath("//span[text() = 'Choose Files']")).click();
		
		// create Screen class object
		Screen screen = new Screen();
		
		// create a Pattern class object for fileName filed
		Pattern fileName = new Pattern(getFilePath("images", "fileName.PNG"));
		
		// create a Pattern class object for open button
		Pattern openBtn = new Pattern(getFilePath("images", "openBtn.PNG"));
		
		try {
			// locate file name filed
			screen.find(fileName);
			// type the file path we want to upload in the above field
			screen.type(fileName, "E:\\selenium\\Notes\\sql.docx");
			sleep(3000);
			// locate open button and click on it
			screen.find(openBtn);
			// click on the open button
			screen.click(openBtn);

			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		sleep(3000);
		
		closeBrowser();
	}
	
	

}
