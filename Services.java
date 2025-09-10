
package xpresswayPackage;

import java.awt.Desktop.Action;
import java.awt.Window;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Services {

	public WebDriver services() throws Exception {
		XpresswayHomePage homey=new XpresswayHomePage(); //calling previous tab class
		WebDriver driver=homey.homepage(); //calling method from created object
		Thread.sleep(3000);
		List<WebElement> servicesOffersList = driver.findElements(By.xpath("//a[@class='xpressway_imagewithtext_rightSection-cta']/p"));
		WebElement panUpdation= servicesOffersList.get(18);
		Actions panUpdationText= new Actions(driver);
		panUpdationText.moveToElement(panUpdation).build().perform();
		Thread.sleep(4000);
		panUpdation.click();
		Thread.sleep(3000);
		
//Validate: LGCODE AND LCCODE IN THE URL
		String actualURL=driver.getCurrentUrl();
		
		if(actualURL.contains("LGCODE=AYUS12&LCCODE=7738"))
		{
			System.out.println("Pan Updation Service URL Link Contains LG and LC code");
		}
		else
		{
			System.out.println("Pan Updation Service URL Link does not contains LG and LC code");
		}
		Thread.sleep(3000);
		
		
		ArrayList<String> tabs= new ArrayList<String>(driver.getWindowHandles());
		Thread.sleep(2000);
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(2000);
	//	To scroll back to the top of the page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");  // Scroll to top of the page
		Thread.sleep(2000);		
	//To click on Explore tab
		WebElement explore= driver.findElement(By.id("guideContainer-rootPanel-panel_1995127749_cop-panel_1128491847-panel_1476744642-panel_1876474291-panel_606864485-guidebutton_12888279___widget"));
		explore.click();                                 
		Thread.sleep(2000);

		//	Clicking Whatsapp CTA
		WebElement whatsappCTA = driver.findElement(By.xpath("//*[@id=\"guideContainer-rootPanel-panel_1995127749_cop-panel_1128491847-panel_1476744642-panel_1876474291-panel_1430560025-panel_2108029993-imagewithtext_151866___guide-item\"]/div/div/div/div/div[2]/a/p"));
		Thread.sleep(2000);
		Actions action =new Actions(driver);
		action.moveToElement(whatsappCTA).perform();
		Thread.sleep(2000);
		whatsappCTA.click();
		Thread.sleep(4000);
	//Redirecting again to Services tab
		ArrayList<String> tabs1=new ArrayList<>(driver.getWindowHandles());  
		  driver.switchTo().window(tabs1.get(0));
	//Clicking on To Top cta	
		Thread.sleep(2000);
		WebElement toTopCTA = driver.findElement(By.xpath("//*[@class='scrolltotop_desktop']"));
		toTopCTA.click();
		Thread.sleep(2000);
		return driver;		
	}
	}

