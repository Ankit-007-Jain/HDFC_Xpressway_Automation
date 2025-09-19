package xpressway_HDFC_Prod;

import org.openqa.selenium.WebDriver;

public class MainMethod {

	public static void main(String[] args) throws Exception {
		ServicesPage01 product=new ServicesPage01();
		WebDriver driver=product.services();
		Thread.sleep(3000);
		//driver.close();
	}
}
