import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class SwipeGestureDemo extends Capabilities{

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> androidDriver = capabilities();
		androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		First go to the Date widget
		androidDriver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		androidDriver.findElementByAndroidUIAutomator("text(\"Date Widgets\")").click();
		androidDriver.findElementByXPath("//android.widget.TextView[@text='2. Inline']").click();
		
//		Now swipe / drag and drop
		AndroidTouchAction t = new AndroidTouchAction(androidDriver);
		WebElement hour = androidDriver.findElementByXPath("//*[@content-desc='9']");
		t.tap(tapOptions().withElement(element(hour))).perform();
		
//		WebElement minute = androidDriver.findElementByXPath("//*[@content-desc='45']");
		
		
		
	}

}
