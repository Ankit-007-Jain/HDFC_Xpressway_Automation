package xpresswayPackage;

import org.openqa.selenium.WebDriver;

public class MainMethod {

	public static void main(String[] args) throws Exception {
		DigitalPlatform digital=new DigitalPlatform();
		WebDriver driver=digital.digital();
		Thread.sleep(3000);
		//driver.close();
	}

}
