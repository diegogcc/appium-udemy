package ios_appium_tests;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.ios.IOSTouchAction;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.PointOption.point;


public class ScrollGestureDemo extends Capabilities{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		IOSDriver<IOSElement> iosDriver = capabilities("iPhone 8", "9D9E3338-58FE-4696-9F17-3963CE170ED5");
		iosDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		Scroll:
		scrollDown(iosDriver);
		
		iosDriver.findElementByAccessibilityId("Steppers").click();
		iosDriver.navigate().back();
	}

	public static void scrollDown(IOSDriver<IOSElement> driver) {
		
		Dimension size = driver.manage().window().getSize();
		int x = size.getWidth() / 2;
		int y0 = (int)(size.getHeight() * 0.8);
		int y1 = (int)(size.getHeight() * 0.1);
		
		IOSTouchAction swipe = new IOSTouchAction(driver);
		swipe.longPress(longPressOptions().withPosition(point(x, y0))).moveTo(point(x, y1)).release().perform();
	}
	
	

}
