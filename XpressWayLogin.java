
package xpresswayPackage;

import java.awt.im.InputContext;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;

public class XpressWayLogin {
//below line code is used to use this class in any main method present in different tab
//public WebDriver can be used in any different tab and Login() is the method 
//In short you have to add this line and in the end have to add return driver; : to use this class method in another tab
//	@Test
//	
//	 public void testngLogin() throws Exception {
//	    WebDriver driver = Login();
//	 }
	
	public WebDriver Login() throws Exception {
		WebDriver driver= new ChromeDriver();
		driver.get("https://applyonlineuat01.hdfcbank.com/xpressway.html?LGCODE=AYUS12&LCCODE=7738");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='guideContainer-rootPanel-panel_1995127749_cop-panel-panel_1370118956-panel-panel_1152171751-panel_604161407-panel-panel_copy_copy-panel-guidetextbox___widget']")).sendKeys("4");
		Thread.sleep(2000);
		driver.findElement(By.name("guideContainer-rootPanel-panel_1995127749_cop-panel-panel_1370118956-panel-panel_1152171751-panel_604161407-panel-panel_copy_copy-panel-guidetextbox___jqName")).sendKeys("8566788523");
		driver.findElement(By.xpath("//input[@placeholder=' DD ']")).sendKeys("01");
		driver.findElement(By.xpath("//input[@placeholder=' MM ']")).sendKeys("01");
		WebElement year=driver.findElement(By.xpath("//input[@placeholder=' YYYY']"));
		int age = 0;
		if (age<18 || age<=118)
		{
			year.clear();
			System.out.println("An error message was shown because the entered age was below 18 or above 118 during login.");
		}
		year.sendKeys("1800");
		Thread.sleep(3000);
		year.clear();
		
		driver.findElement(By.cssSelector("input.numericInput[placeholder=' YYYY']")).sendKeys("2000");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Request OTP >>']")).click();
		Thread.sleep(3000);
		//Entering incorrect OTP
		WebElement otp= driver.findElement(By.xpath("//input[@name='guideContainer-rootPanel-panel_1995127749_cop-panel-panel_1370118956-panel-panel_1152171751-panel_2079927398_cop-panel-guidetextbox___jqName']"));
		otp.sendKeys("457890");
		Thread.sleep(2000);
		WebElement submit=driver.findElement(By.id("guideContainer-rootPanel-panel_1995127749_cop-panel-panel_1370118956-panel-panel_1152171751-panel_295710100-guidebutton_12616455___widget"));
		submit.click();
		Thread.sleep(2000);
		//Clearing the OTP field to enter correct OTP
		otp.clear();
		//Entering correct OTP
		otp.sendKeys("123456");
		Thread.sleep(2000);
			submit.click();
			Thread.sleep(4000);
		//driver.close();
			return driver; 
// we write this: to keep using the same browser in another class or method
//basically if there is no main method in any class we have to write this so that another class and call it

	}

}