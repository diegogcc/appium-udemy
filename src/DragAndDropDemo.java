import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class DragAndDropDemo extends Capabilities{

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> androidDriver = capabilities("Nexus_6P");
		androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		androidDriver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		androidDriver.findElementByAndroidUIAutomator("text(\"Drag and Drop\")").click();;
		
		AndroidTouchAction t = new AndroidTouchAction(androidDriver);
		WebElement dot1 = androidDriver.findElementById("io.appium.android.apis:id/drag_dot_1");
		WebElement dot3 = androidDriver.findElementById("io.appium.android.apis:id/drag_dot_3");
		t.longPress(longPressOptions().withElement(element(dot1))).moveTo(element(dot3)).release().perform();
		t.longPress(element(dot3)).moveTo(element(dot1)).release().perform(); //Other option
		
	}

}
