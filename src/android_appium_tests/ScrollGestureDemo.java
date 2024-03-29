package android_appium_tests;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ScrollGestureDemo extends Capabilities{

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> androidDriver = capabilities("Nexus_6P","ApiDemos-debug.apk");
		androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		androidDriver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		
//		Scroll (Android)
		
		androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");
		//pending: How to scroll upwards!
	}

}
