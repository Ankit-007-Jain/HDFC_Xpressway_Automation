package xpressway_HDFC_Prod;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class DigitalPlatformPage01 {

	public WebDriver digital() throws Exception
	{
		ServicesPage01 service=new ServicesPage01(); //calling previous tab class
		WebDriver driver=service.services(); //calling previous tab method from created object
		
		WebElement digitalPlatform= driver.findElement(By.xpath("//span[text()='Digital Platforms']"));
		digitalPlatform.click();
		System.out.println("<<<<<<<<<<<<<<<<<DigitalPlatforms_PAGE VALIDATION>>>>>>>>>>>>>>>>>");
		Thread.sleep(3000);
///////////////////////////////////////////////////////////////////////////////////////////////////
//Validating HDFC SKY navigation
	WebElement hdfcSkyCTA=driver.findElement(By.xpath("//*[text()='HDFC Sky']"));
	Thread.sleep(2000);
//	Actions action=new Actions(driver);
//	action.moveToElement(hdfcSkyCTA).build().perform();
//To navigate to HDFCSky and clicking
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", hdfcSkyCTA);
	Thread.sleep(3000);
//	hdfcSkyCTA.click();
	
	ArrayList<String> tab= new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(tab.get(1));
	Thread.sleep(6000);
	String currentUrl03=driver.getCurrentUrl();
	if (currentUrl03.contains("LCCode=7738") && currentUrl03.contains("LGCode=AYUS12"))
	{
	        System.out.println("To Validate: HDFC Sky URL Contains LG and LC code:: Pass");
	    } else {
	        System.out.println("To Validate: HDFC Sky URL Does Not Contain LG and LC code:: Fail");
	    }
	driver.close();
	driver.switchTo().window(tab.get(0));
//////////////////////////////////////////////////////////////////////////////////////////////////////////
//CLICKING OFFERS
	
	Thread.sleep(3000);
	System.out.println("<<<<<<<<<<<<<<<<<Offers_PAGE VALIDATION>>>>>>>>>>>>>>>>>");
WebElement offers=driver.findElement(By.xpath("//span[text()='Offers']"));
if(offers.isDisplayed())
{
	offers.click();
	System.out.println("Offers redirection is working: Pass");
	Thread.sleep(6000);
	driver.close();
}
else {
	System.out.println("Offers redirection is not working: Fail");
}
Thread.sleep(4000);
driver.close();
//write all digital platform functionalities
//lets consider this final tab/class and next lets create main method and call DigitalPlatform class	
		return driver;		
	}

}
