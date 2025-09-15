package xpressway_HDFC_Prod;

import org.openqa.selenium.WebDriver;

public class MainMethod {

	public static void main(String[] args) throws Exception {
		ProductsPage01 product=new ProductsPage01();
		WebDriver driver=product.homepage();
		Thread.sleep(3000);
		//driver.close();
	}
}
