package test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class Capabilities {

	public static IOSDriver<IOSElement> iosSimulatorCapabilities(String device, String udid) throws MalformedURLException {
		// TODO Auto-generated method stub
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		cap.setCapability(MobileCapabilityType.UDID, udid);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
//		For iOS v > 10.2
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 5);
		cap.setCapability(MobileCapabilityType.APP, "/Users/diegocampo/Library/Developer/Xcode/DerivedData/UICatalog-eipfjklyxfhdczbxqhbpnbweuijw/Build/Products/Debug-iphonesimulator/UICatalog.app");
		IOSDriver<IOSElement> iosDriver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub") ,cap);
		return iosDriver;
	}
	
	public static AndroidDriver<AndroidElement> androidEmulatorCapabilities(String device) throws MalformedURLException {		
		File file = new File("src");
//		File fapk = new File(file,"ApiDemos-debug.apk");
		File fapk = new File(file,"General-Store.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
//		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device"); // Any real device connected
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 5);
		cap.setCapability(MobileCapabilityType.APP, fapk.getAbsolutePath());				
		AndroidDriver<AndroidElement> androidDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub") ,cap);
		return androidDriver;
	}
}
