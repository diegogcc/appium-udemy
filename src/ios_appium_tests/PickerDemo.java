package ios_appium_tests;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class PickerDemo extends Capabilities{

	public static void main(String[] args) throws MalformedURLException {
		IOSDriver<IOSElement> iosDriver = capabilities("iPhone 8", "9D9E3338-58FE-4696-9F17-3963CE170ED5");
		iosDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		iosDriver.findElementByAccessibilityId("Picker View").click();
		moveGreenPicker(iosDriver, "180");
		moveRedPicker(iosDriver, "50");
		moveBluePicker(iosDriver,"100");
	}

	public static void moveBluePicker(IOSDriver<IOSElement> driver, String num) {
		driver.findElementByAccessibilityId("Blue color component value").sendKeys(num);
	}

	public static void moveRedPicker(IOSDriver<IOSElement> driver, String num) {
		driver.findElementByAccessibilityId("Red color component value").sendKeys(num);
	}

	public static void moveGreenPicker(IOSDriver<IOSElement> driver, String num) {
		driver.findElementByAccessibilityId("Green color component value").sendKeys(num);
	}

}
