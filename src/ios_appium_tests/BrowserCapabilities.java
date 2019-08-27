package ios_appium_tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class BrowserCapabilities {

	public static IOSDriver<IOSElement> capabilities(String device, String udid) throws MalformedURLException{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cap.setCapability(MobileCapabilityType.UDID, udid);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
//		For iOS v > 10.2
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 5);

		IOSDriver<IOSElement> iosDriver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub") ,cap);
		return iosDriver;
	}

}
