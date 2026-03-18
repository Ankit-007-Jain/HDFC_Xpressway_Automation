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

public class ProductsPage01 {

    public WebDriver homepage() throws Exception {

        XpresswayLoginPage loginPage = new XpresswayLoginPage();
        WebDriver driver = loginPage.login();

        Thread.sleep(5000);
        System.out.println("<<<<<<<<<<<<<<<<<PRODUCTS_PAGE VALIDATION>>>>>>>>>>>>>>>>>");

        // Validate User Type
        try {
            WebElement heading = driver.findElement(By.xpath("//*[@id='guideContainer-rootPanel-panel_1995127749_cop-panel_1128491847-panel_copy_copy_copy-guidetextdraw_601767___guide-item']"));

            String headingText = heading.getText();
            if (headingText.contains("Dear Customer")) {
                System.out.println("User Validation:: New To Bank (NTB) user");
            } else {
                System.out.println("User Validation:: Existing To Bank (ETB) user");
            }

        } catch (Exception e) {
            System.out.println("User Validation:: Heading element not found on the page");
        }

        ScreenshotUtil.takeScreenshot(driver, "ETB User");

        /////////////////////////////////////////////////////////////////////////
        // PERSONAL LOAN
        try {
            WebElement heading03 = driver.findElement(By.xpath("//p[normalize-space()='Personal Loan']"));

            new Actions(driver).moveToElement(heading03).perform();
            Thread.sleep(2000);

            WebElement button001 = driver.findElement(
                    By.xpath("(//p[normalize-space()='Personal Loan'])[1]/following::a[1]"));
            button001.click();

            Thread.sleep(9000);

            ArrayList<String> tabs001 = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs001.get(1));

            String actualSSOUrl001 = driver.getCurrentUrl();

            if (actualSSOUrl001.contains("SSO_AUTHENTICATION_SUCCESS")) {
                System.out.println("SSO Validation: Personal Loan SSO Test:: Pass");
            } else {
                System.out.println("SSO Validation: Personal Loan SSO Test:: Fail");
            }

            // Consent Flow
            driver.findElement(By.id("checkbox-609cf79d74")).click();
            Thread.sleep(2000);

            driver.findElement(By.className("go-to-bottom-btn")).click();
            Thread.sleep(2000);

            WebElement agreeBtn = driver.findElement(By.id("button-d780d15832"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", agreeBtn);
            Thread.sleep(2000);

            WebElement applyBtn = driver.findElement(By.id("button-287ab08488"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", applyBtn);
            Thread.sleep(2000);

            driver.close();
            driver.switchTo().window(tabs001.get(0));
            Thread.sleep(4000);

        } catch (Exception e) { 
            System.out.println("Personal Loan Flow :: FAIL");
            e.printStackTrace();
        }

  /////////////////////////////////////////////////////////////////////////////////
        // Fixed Deposit using funds using from HDFC Bank - SSO validation
        
        try {

            WebElement heading01 = driver.findElement(By.xpath("//p[contains(text(),'Fixed Deposit using Funds from HDFC Bank')]"));
            new Actions(driver).moveToElement(heading01).perform();
            Thread.sleep(2000);

            driver.findElement(By.xpath("//p[contains(text(),'Fixed Deposit using Funds from HDFC Bank')]/following::a[1]")).click();
            Thread.sleep(10000);

            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

            if (tabs.size() > 1) {
                driver.switchTo().window(tabs.get(1));
            } else {
                System.out.println("New tab not opened :: FAIL");
            }

            String actualSSOUrl = driver.getCurrentUrl();

            if (actualSSOUrl.contains("SSO_AUTHENTICATION_SUCCESS")) {
                System.out.println("Fixed Deposit SSO Validation :: PASS");
            } else {
                System.out.println("Fixed Deposit SSO Validation :: FAIL");
            }

            // Entering Amount
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement amountField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("numberinput-e9f4d6b2d8")));

            amountField.click();
            Thread.sleep(1000);

            // Proper clear
            amountField.sendKeys(Keys.CONTROL + "a");
            amountField.sendKeys(Keys.DELETE);
            Thread.sleep(1000);

            amountField.sendKeys("6000");

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].value='6000'; arguments[0].dispatchEvent(new Event('input'));",
                    amountField);

            // Continue button
            WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("button-070bcd2895")));

            new Actions(driver).moveToElement(continueBtn).perform();
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueBtn);

            Thread.sleep(5000);

            // Tenure button
            WebElement tenureBtn = driver.findElement(By.id("button-a942f55ce6"));
            new Actions(driver).moveToElement(tenureBtn).perform();
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", tenureBtn);
            Thread.sleep(4000);

            // Next Continue
            WebElement continueBtn01 = driver.findElement(By.id("button-be21b9cef9"));
            new Actions(driver).moveToElement(continueBtn01).perform();
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueBtn01);
            Thread.sleep(5000);
           // Navigating to top of the page
            JavascriptExecutor js12 = (JavascriptExecutor) driver;
            js12.executeScript("window.scrollTo(0, 0);");
            Thread.sleep(4000);
            // Checkboxes (safe handling)
            WebDriverWait wait01 = new WebDriverWait(driver, Duration.ofSeconds(10));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            System.out.println("Review Page: Able to Navigate:: Pass");
           
            // Checkbox 1
            try {
                WebElement checkbox1 = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.id("checkbox-034a17f714")));

                js.executeScript("arguments[0].scrollIntoView(true);", checkbox1);
                Thread.sleep(1000);

                if (!checkbox1.isSelected()) {
                    js.executeScript("arguments[0].click();", checkbox1);
                }

                System.out.println("Checkbox 1 clicked:: Pass");
            } 
            catch (Exception e) {
                System.out.println("Checkbox 1 not clickable :: FAIL");
            }
            // Checkbox 2
            try {
                WebElement checkbox2 = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.id("checkbox-142decba94")));

                js.executeScript("arguments[0].scrollIntoView(true);", checkbox2);
                Thread.sleep(1000);

                if (!checkbox2.isSelected()) {
                    js.executeScript("arguments[0].click();", checkbox2);
                    Thread.sleep(4000);
                }
                System.out.println("Checkbox 2 clicked:: Pass");
                System.out.println("----------------------------------------------------------------------------");
                Thread.sleep(5000);
                driver.close();
                driver.switchTo().window(tabs.get(0));
                Thread.sleep(4000);
            } 
            
            catch (Exception e) {
                System.out.println("Checkbox 2 not clickable :: FAIL");
            }
        } catch (Exception e) {
            System.out.println("FD Complete Flow :: FAILED");
            e.printStackTrace();
        }

        /////////////////////////////////////////////////////////////////////////
        // CREDIT CARD - SSO
        try {
            WebElement heading02 = driver.findElement(By.xpath("//p[contains(text(),'Credit Card Application')]"));
            new Actions(driver).moveToElement(heading02).perform();
            Thread.sleep(2000);

            driver.findElement(By.xpath("//p[contains(text(),'Credit Card Application')]/following::a[1]")).click();
            Thread.sleep(11000);

            ArrayList<String> tabs02 = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs02.get(1));

            String url = driver.getCurrentUrl();

            if (url.contains("SSO_AUTHENTICATION_SUCCESS")) {
                System.out.println("Credit Card Application SSO Validation :: PASS");
            } else {
                System.out.println("Credit Card Application SSO Validation:: FAIL");
            }

            driver.close();
            driver.switchTo().window(tabs02.get(0));

        } catch (Exception e) {
            System.out.println("Credit Card Application Offer :: FAIL");
            e.printStackTrace();
        }

        /////////////////////////////////////////////////////////////////////////
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

//To validate Explore More Banking Options

WebElement applyOnline= driver.findElement(By.xpath("//*[@id=\"guideContainer-rootPanel-panel_1995127749_cop-panel_1128491847-panel_1476744642-panel-panel_897830868_copy-panel_897830868_copy-guidetextdraw_57070726__\"]/p"));
Actions applyOnline01 = new Actions(driver);
applyOnline01.moveToElement(applyOnline).perform();
Thread.sleep(3000);

if (applyOnline.isDisplayed()) {
    System.out.println("To Validate: Explore More Banking Options:: Pass");
} else {
    System.out.println("To Validate: Explore More Banking Options:: Fail");
}
//////////////////////////////////////////////////////////////////////////////////////////////////////
// Clicking the FASTag offer
//try is used to run code that might throw an error/exception
try {
    WebElement fastTag = driver.findElement(By.xpath("//p[contains(text(),'FASTag')]"));
    
    if (fastTag.isDisplayed()) {
        // Move to the heading
        Actions fastTag01 = new Actions(driver);
        fastTag01.moveToElement(fastTag).perform();
        Thread.sleep(2000);

        // Now, below locator will click the Button next to the text
        WebElement fastagCTA = driver.findElement(By.xpath("//p[contains(text(),'FASTag')]/following::a[1]"));
        fastagCTA.click();
        Thread.sleep(10000);

        // Post click it will redirect to another tab
        ArrayList<String> anotherTab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(anotherTab.get(1));

        String currentUrl = driver.getCurrentUrl();

        // Check if the URL contains LCCode=7738&LGCode=AYUS12
        if (currentUrl.contains("LCCode=7738&LGCode=AYUS12")) {
            System.out.println("To Validate: FASTag URL Contains LG and LC code:: Pass");
        } else {
            System.out.println("To Validate: FASTag URL Does Not Contain LG and LC code:: Fail");
        }

        driver.close();
        driver.switchTo().window(anotherTab.get(0)); // switch back to home tab
    }
}
//catch is used to handle that error so the program doesn’t stop
 catch (Exception e) {
	 	System.out.println("To Validate: FASTag offer is NOT visible on the page:: Fail");
}
Thread.sleep(2000);
//driver.switchTo().window(anotherTab.get(0)); //tabs.get(0):: what we fixed for the first window above
//Scrolling on top of the page

JavascriptExecutor js11 = (JavascriptExecutor) driver;
js11.executeScript("window.scrollTo(0, 0);");
Thread.sleep(2000);
   
 
 return driver;
}}
