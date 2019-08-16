import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LocatorAndroidUIAutomator extends Capabilities {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> androidDriver = capabilities("Nexus_6P");
		androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		androidDriver.findElementByAndroidUIAutomator("attribute(value)")
		androidDriver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
//		Validate if a button is clickable (all buttons)
//		with properties and not attributes it should be "new UISelector().property(value)"
		int clickableButtons = androidDriver.findElementsByAndroidUIAutomator("clickable(true)").size();
		System.out.println(clickableButtons);
		
	}

}
