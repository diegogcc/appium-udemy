package android_appium_tests;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BrowserCapabilities {

	public static AndroidDriver<AndroidElement> capabilities(String device) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
//		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device"); // Any real device connected
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability("browserName", "chrome");
		
				
		AndroidDriver<AndroidElement> androidDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub") ,cap);
		return androidDriver;
//		AndroidUIAutomator
//		1. $ANDROID_HOME/tools/bin/uiautomatorviewer to run a scan of the emulator
	}
	
}
