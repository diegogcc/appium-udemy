package android_appium_tests;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class AndroidGesturesBasics extends Capabilities{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> androidDriver = capabilities("Nexus_6P","ApiDemos-debug.apk");
		androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		androidDriver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		// Gesture 1 = tap
		
		AndroidTouchAction touch = new AndroidTouchAction(androidDriver);
		WebElement elist = androidDriver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")");
		touch.tap(tapOptions().withElement(element(elist))).perform();
		androidDriver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
		WebElement peopleNames = androidDriver.findElementByXPath("//android.widget.TextView[@text='People Names']");
		touch.longPress(longPressOptions().withElement(element(peopleNames)).withDuration(ofSeconds(2))).release().perform();
		
//		androidDriver.findElementsByClassName("android.widget.TextView").get(0)
	}

}
