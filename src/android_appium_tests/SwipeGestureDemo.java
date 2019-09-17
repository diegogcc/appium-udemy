package android_appium_tests;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

public class SwipeGestureDemo extends Capabilities{

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> androidDriver = capabilities("Nexus_6P","ApiDemos-debug.apk");
		androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		First go to the Date widget
		androidDriver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		androidDriver.findElementByAndroidUIAutomator("text(\"Date Widgets\")").click();
		androidDriver.findElementByXPath("//android.widget.TextView[@text='2. Inline']").click();
		
//		Now swipe / drag and drop
		AndroidTouchAction t = new AndroidTouchAction(androidDriver);
		WebElement hour = androidDriver.findElementByXPath("//*[@content-desc='9']");
		t.tap(tapOptions().withElement(element(hour))).perform();
		
		WebElement minuteInit = androidDriver.findElementByXPath("//*[@content-desc='15']");
		WebElement minuteEnd = androidDriver.findElementByXPath("//*[@content-desc='35']");
		t.longPress(longPressOptions().withElement(element(minuteInit)).withDuration(ofSeconds(1))).moveTo(element(minuteEnd)).release().perform();
		
	}

}
