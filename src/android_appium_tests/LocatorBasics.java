package android_appium_tests;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LocatorBasics extends Capabilities{

	public static void main(String[] args) throws MalformedURLException{
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement> androidDriver = capabilities("Nexus_6P");
		androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		/*
		 * XPath
		 * //tagName[@attribute='value']
		 */
		
		androidDriver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		androidDriver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		androidDriver.findElementById("android:id/checkbox").click();
		//click on second element found:
//		(//tagname[@attribute='value'])[2]
		androidDriver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		androidDriver.findElementByClassName("android.widget.EditText").sendKeys("wifitest");
		androidDriver.findElementsByClassName("android.widget.Button").get(1).click();
	}

}
