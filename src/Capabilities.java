import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Capabilities {

	public static AndroidDriver<AndroidElement> capabilities(String device) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		File file = new File("src");
		File fapk = new File(file,"ApiDemos-debug.apk");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
//		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device"); // Any real device connected
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.APP, fapk.getAbsolutePath());
		/*		
		 * For real devices in which I don't have the *.apk but an already installed app:
		 * 
		 * You need to know the app's Package Name 
		 * You need to know the app's Main Activity
		 * 
		 * http://www.automationtestinghub.com/apppackage-and-appactivity-name/
		 * http://www.testingtools.co/appium/appium-how-to-find-android-mobile-app-package-name-and-launcher-activity
		 * https://www.guru99.com/introduction-to-appium.html
		 * 
		 * adb logcat | grep calendar
		 * 
		 * Calculator app:
		 * Package: com.samsung.android.calendar
		 * Activity: com.samsung.android.app.calendar.activity.MainActivity
		 * 
		 * cap.setCapability("appPackage", "com.samsung.android.calendar");
		 * cap.setCapability("appActivity", "com.samsung.android.app.calendar.activity.MainActivity");
		*/	
		
				
		AndroidDriver<AndroidElement> androidDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub") ,cap);
		return androidDriver;
//		AndroidUIAutomator
//		1. $ANDROID_HOME/tools/bin/uiautomatorviewer to run a scan of the emulator
	}
	
}
