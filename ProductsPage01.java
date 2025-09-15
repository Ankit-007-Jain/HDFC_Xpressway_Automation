package xpressway_HDFC_Prod;

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

public class ProductsPage01 {
	
    public WebDriver homepage() throws Exception {

      XpresswayLoginPage loginPage = new XpresswayLoginPage(); // Calling class creating "loginPage" object
       WebDriver driver = loginPage.login(); // calling method of previous code
        Thread.sleep(2000); 
//Validate: User is NTB or ETB
        WebElement heading= driver.findElement(By.xpath("//*[@id='guideContainer-rootPanel-panel_1995127749_cop-panel_1128491847-panel_copy_copy_copy-guidetextdraw_601767___guide-item']"));
        String headingText= heading.getText();
        if(headingText.contains("Dear Customer"))
        {
        	System.out.println("User Validation:: New To Bank (NTB)");
        }
        else
        {
        	System.out.println("User Validation:: Existing To Bank (ETB)");
        }
        Thread.sleep(2000);
//    To validate newly added festive logo
        WebElement festiveLogo= driver.findElement(By.xpath("//*[@class='cmp-logo-link']"));
       if (festiveLogo.isDisplayed())
       {
    	   System.out.println("To validate festive Logo:: It is visible");
       }
       else {
    	   System.out.println("To validate festive Logo:: It is not visible");
    	   
       }
       Thread.sleep(3000);
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////      
  //Testing SSO: FD using Funds from HDFC Bank 
       
    // Locate heading by text
       WebElement heading01 = driver.findElement(By.xpath("//p[contains(text(),'Fixed Deposit using Funds from HDFC Bank')]"));

       // Move to the heading
       Actions actions = new Actions(driver);
       actions.moveToElement(heading01).perform();
       Thread.sleep(2000);
       
   //Now, below locator will click the Button next to the text; means it will click the button which is next to the
       // specified text you located
       WebElement button = driver.findElement(By.xpath("//p[contains(text(),'Fixed Deposit using Funds from HDFC Bank')]/following::a[1]"));
       // Click the button
       button.click();      
       Thread.sleep(8000); // Wait for redirect
               
 //Post click it will redirect to another tab, so we have to use method getWindowHandle();
 
  ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles()); //Creating ArrayList<string> and storing all tabs in that
//Now use index for specific tab; so overhere it will go to SSO url page, 
  driver.switchTo().window(tabs.get(1)); //Once you navigate SSO url page, you can validate SSO url page  

            //Now Verifying SSO URL
        	String actualSSOUrl=driver.getCurrentUrl();	

            if (actualSSOUrl.contains("SSO_AUTHENTICATION_SUCCESS")) {
                System.out.println("SSO Validation: Fixed Deposit using Funds from HDFC Bank SSO Test:: Pass");
            } else 
            {
                System.out.println("SSO Validation: Fixed Deposit using Funds from HDFC Bank SSO Test: Fail. Correct URL should be:: " + actualSSOUrl);
            }
            Thread.sleep(8000);
            driver.close();
            driver.switchTo().window(tabs.get(0)); //Again it will redirect to Home page(Offers Screen)
            Thread.sleep(5000);
  /////////////////////////////////////////////////////////////////////////////////
  
            //Testing SSO: Credit Card Application
            //Locating by text
               WebElement heading02 = driver.findElement(By.xpath("//p[contains(text(),'Credit Card Application')]"));

               // Move to the heading
               Actions actions1 = new Actions(driver);
               actions.moveToElement(heading02).perform();
               Thread.sleep(2000);
               
           //Now, below locator will click the Button next to the text; means it will click the button which is next to the
               // specified text you located
               WebElement button01 = driver.findElement(By.xpath("//p[contains(text(),'Credit Card Application')]/following::a[1]"));
               // Click the button
               button01.click();      
               Thread.sleep(8000); // Wait for redirect
                       
         //Post click it will redirect to another tab, so we have to use method getWindowHandle();
         
          ArrayList<String> tabs02=new ArrayList<>(driver.getWindowHandles()); //Creating ArrayList<string> and storing all tabs in that
        //Now use index for specific tab; so overhere it will go to SSO url page, 
          driver.switchTo().window(tabs02.get(1)); //Once you navigate SSO url page, you can validate SSO url page  
          Thread.sleep(3000);
                    //Now Verifying SSO URL
                	String actualSSOUrl01=driver.getCurrentUrl();	

                    if (actualSSOUrl01.contains("SSO_AUTHENTICATION_SUCCESS")) {
                        System.out.println("SSO Validation: Credit Card Application SSO Test:: Pass");
                    } else 
                    {
                        System.out.println("SSO Validation: Credit Card Application SSO Test: Fail. Correct URL should be:: " + actualSSOUrl);
                    }
                    Thread.sleep(10000);
                   driver.close();
                   driver.switchTo().window(tabs.get(0)); //Again it will redirect to Home page(Offers Screen)
                    Thread.sleep(2000);
    //Scrolling on top of the page                
                   
            
 //////////////////////////////////////////////////////////////////////////////   
 //Scrolling from top to bottom code
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
            Thread.sleep(500);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            long scrollHeight = (long) js.executeScript("return document.body.scrollHeight");

            for (int i = 0; i <= scrollHeight; i += 300) {
                js.executeScript("window.scrollTo(0, arguments[0]);", i);
                Thread.sleep(500); // Adjust speed as needed
            }
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////           
        
//Checking To Top cta working
 WebElement toTop= driver.findElement(By.className("scrolltotop_desktop")); 
 toTop.click();
 if(toTop.isDisplayed()) {
 System.out.println("To Top cta validation: To Top CTA Working:: Pass");
 }
 else {
	 System.out.println("To Top cta validation: To Top CTA not Working: Fail::" +toTop.isDisplayed());
 }
 Thread.sleep(3000);
 
 ////////////////////////////////////////////////////////////////////////////////////////////////////////
 
 //To validate Apply Online section and clicking FastTag offer
 
 WebElement applyOnline= driver.findElement(By.xpath("//*[@id=\"guideContainer-rootPanel-panel_1995127749_cop-panel_1128491847-panel_1476744642-panel-panel_897830868_copy-panel_897830868_copy-guidetextdraw_57070726__\"]/p"));
 Actions applyOnline01 = new Actions(driver);
 actions.moveToElement(applyOnline).perform();
 Thread.sleep(3000);
 
 if (applyOnline.isDisplayed()) {
	    System.out.println("Validate: Apply Online section visible:: Pass");
	} else {
	    System.out.println("Validate: Apply Online section not visible:: Fail");
	}
 
 // Clicking the FASTag offer
   WebElement fastTag = driver.findElement(By.xpath("//p[contains(text(),'FASTag')]"));
if(fastTag.isDisplayed())
{
    // Move to the heading
    Actions fastTag01 = new Actions(driver);
    actions.moveToElement(fastTag).perform();
    Thread.sleep(2000);
    
//Now, below locator will click the Button next to the text; means it will click the button which is next to the
    // specified text you located
    WebElement fastagCTA = driver.findElement(By.xpath("//p[contains(text(),'FASTag')]/following::a[1]"));
    // Click the button
    fastagCTA.click();   
    Thread.sleep(8000); // Wait for redirect
            
//Post click it will redirect to another tab, so we have to use method getWindowHandle();

ArrayList<String> anotherTab=new ArrayList<>(driver.getWindowHandles()); //Creating ArrayList<string> and storing all tabs in that

//Now use index for specific tab; so overhere it will go to SSO url page, 
driver.switchTo().window(tabs.get(0));
System.out.println("Validation: FASTag offer CTA redirection:: Pass");
Thread.sleep(2000); 
}
else {
	 System.out.println("Validation: FASTag offer is NOT visible on the page");
}
//Scrolling on top of the page

JavascriptExecutor js1 = (JavascriptExecutor) driver;
js.executeScript("window.scrollTo(0, 0);");
Thread.sleep(2000);
 
  
 //////////////////////////////////////////////////////////////////////////////
        // Click on 'Services' tab 
    WebElement services = driver.findElement(By.linkText("Services"));
// ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);"); 
  //This above line will scroll on extreme top of the page if "To Top" CTA is not present,you can use this line of code
//      Thread.sleep(4000);
       services.click();
      Thread.sleep(3000);
     
	 return driver;
}}
