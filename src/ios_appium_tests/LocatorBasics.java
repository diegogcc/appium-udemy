package ios_appium_tests;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class LocatorBasics extends Capabilities{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		IOSDriver<IOSElement> iosDriver = capabilities("iPhone 8", "9D9E3338-58FE-4696-9F17-3963CE170ED5");
		iosDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		iosDriver.findElementByAccessibilityId("Alert Views").click();
		iosDriver.findElementByXPath("//*[@value='Text Entry']").click();
		iosDriver.findElementByClassName("XCUIElementTypeTextField").sendKeys("Hello"); //classname = type
		iosDriver.findElementByName("OK").click();
	}

}
