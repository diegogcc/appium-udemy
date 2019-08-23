package ios_appium_tests;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class SteppersDemo extends Capabilities{

	public static void main(String[] args) throws MalformedURLException {
		IOSDriver<IOSElement> iosDriver = capabilities("iPhone 8", "9D9E3338-58FE-4696-9F17-3963CE170ED5");
		iosDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		ScrollGestureDemo.scrollDown(iosDriver);
		iosDriver.findElementByAccessibilityId("Steppers").click();
		incrementStepper1Count(iosDriver, 5);
		int s1 = getStepper1Count(iosDriver);
		decrementStepper1Count(iosDriver,2);
		Assertions.assertEquals(2, s1);
	}

	public static int getStepper1Count(IOSDriver<IOSElement> driver) {
		String count = driver.findElementsByClassName("XCUIElementTypeStaticText").get(0).getText();
		return Integer.parseInt(count);
	}

	public static void incrementStepper1Count(IOSDriver<IOSElement> driver, int count) {
//		By default only the first stepper is used
		for (int i = 0; i < count; i++) {
			driver.findElementByXPath("(//XCUIElementTypeButton[@name=\"Increment\"])[1]").click();
		}
	}
	
	public static void decrementStepper1Count(IOSDriver<IOSElement> driver, int count) {
//		By default only the first stepper is used
		for (int i = 0; i < count; i++) {
			driver.findElementByXPath("(//XCUIElementTypeButton[@name=\"Decrement\"])[1]").click();
		}
	}
}
