package xpresswayPackage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.Test;

public class XpresswayHomePage {
	
//	@Test
//	
//	 public void testngHomePage() throws Exception {
//		WebDriver driver= homepage();
//	 }

    public WebDriver homepage() throws Exception {

        XpressWayLogin loginPage = new XpressWayLogin(); // Calling class creating "loginPage" object
        WebDriver driver = loginPage.Login(); // calling method of previous code
        Thread.sleep(2000); 
//Validate: User is NTB or ETB
        WebElement heading= driver.findElement(By.xpath("//*[@id='guideContainer-rootPanel-panel_1995127749_cop-panel_1128491847-panel_copy_copy_copy-guidetextdraw_601767___guide-item']"));
        String headingText= heading.getText();
        if(headingText.contains("Dear Customer"))
        {
        	System.out.println("User:New To Bank (NTB)");
        }
        else
        {
        	System.out.println("User: Existing To Bank (ETB)");
        }
        Thread.sleep(2000);
//    To validate newly added festive logo
        WebElement festiveLogo= driver.findElement(By.xpath("//*[@class='cmp-logo-link']"));
       if (festiveLogo.isDisplayed())
       {
    	   System.out.println("To validate festive Logo: It is visible");
       }
       else {
    	   System.out.println("To validate festive Logo: It is not visible");
       }
       // Locate all 'Claim Now' CTA elements
//As we have multiple offers which have same id and class; it's like a list of offers;  so let's take a list,
 //and locate all the common element in that....
        
      List<WebElement> claimNowList = driver.findElements(By.xpath("//div[@id='offerCardLink--cta']/div/p/a")); //all cta common id 
  //Once we locate all the list now take the "Index" for the specific tile/offer to locate, i.e.,2  
           WebElement FD = claimNowList.get(4); //locator of FD using HDFC Bank 
          

//Let's use Actions class to hover that CTA(FD), as only visible text click
    Actions fdCTA= new Actions(driver); //creating object for CTA
    fdCTA.moveToElement(FD).perform(); //hover to respective element
   //If the locator text is not visible directly, i.e., if it is down than use below code to go there: ALternate way
           // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", FD);
         Thread.sleep(3000); // Let scroll settle
            FD.click();
            Thread.sleep(8000); // Wait for redirect
               
 //Post click it will redirect to another tab, so we have to use method getWindowHandle();
 
  ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles()); //Creating ArrayList<string> and storing all tabs in that
//Now use index for specific tab; so overhere it will go to SSO url page, 
  driver.switchTo().window(tabs.get(1)); //Once you navigate SSO url page, you can validate SSO url page  

            //Now Verifying SSO URL
        	String actualSSOUrl=driver.getCurrentUrl();	

            if (actualSSOUrl.contains("SSO_AUTHENTICATION_SUCCESS")) {
                System.out.println("Fixed Deposit using Funds from HDFC Bank SSO Test: SSO login successful");
            } else 
            {
                System.out.println("Fixed Deposit using Funds from HDFC Bank SSO Test:SSO login failed. Correct URL should be: " + actualSSOUrl);
            }
            Thread.sleep(8000);
            driver.switchTo().window(tabs.get(0)); //Again it will redirect to Home page(Offers Screen)
            Thread.sleep(5000);
    
 //Scrolling from top to bottom code
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
            Thread.sleep(500);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            long scrollHeight = (long) js.executeScript("return document.body.scrollHeight");

            for (int i = 0; i <= scrollHeight; i += 300) {
                js.executeScript("window.scrollTo(0, arguments[0]);", i);
                Thread.sleep(500); // Adjust speed as needed
            }
//Checking To Top cta working
 WebElement toTop= driver.findElement(By.className("scrolltotop_desktop")); 
 toTop.click();
 if(toTop.isDisplayed()) {
 System.out.println("To Top CTA Working:" +toTop.isDisplayed());
 }
 else {
	 System.out.println("To Top CTA not Working:" +toTop.isDisplayed());
 }
 Thread.sleep(2000);
 
        // Click on 'Services' tab after SSO test
    WebElement services = driver.findElement(By.linkText("Services"));
// ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);"); 
  //This above line will scroll on extreme top of the page if "To Top" CTA is not present,you can use this line of code
//      Thread.sleep(4000);
       services.click();
      Thread.sleep(3000);
     

	 return driver;
}}
