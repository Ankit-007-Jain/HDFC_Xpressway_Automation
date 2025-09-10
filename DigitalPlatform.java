package xpresswayPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DigitalPlatform {
@Test
	public void testngDigital() throws Exception
	{
	WebDriver driver= digital();
	driver.quit();
	}
	public WebDriver digital() throws Exception
	{
		Services service=new Services(); //calling previous tab class
		WebDriver driver=service.services(); //calling previous tab method from created object
		
		WebElement digitalPlatform= driver.findElement(By.xpath("//span[text()='Digital Platforms']"));
		digitalPlatform.click();
		Thread.sleep(3000);	
//write all digital platform functionalities
//lets consider this final tab/class and next lets create main method and call DigitalPlatform class	
		return driver;
		
	}

}
