package ios_appium_tests;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class BrowserDemo extends BrowserCapabilities{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		IOSDriver<IOSElement> iosDriver = capabilities("iPhone 8", "9D9E3338-58FE-4696-9F17-3963CE170ED5");
		iosDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		iosDriver.get("http://facebook.com");
		iosDriver.findElementByXPath("//*[@id=\"m_login_email\"]").sendKeys("holo-mail");
		iosDriver.findElementByXPath("//*[@id=\"m_login_password\"]").sendKeys("psssss");
		iosDriver.findElementByXPath("//*[@id=\"login_form\"]/div[4]/div/div[2]/div/div/div[2]").click();
	}

}
