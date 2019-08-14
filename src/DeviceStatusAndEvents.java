import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;



public class DeviceStatusAndEvents extends Capabilities{

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> androidDriver = capabilities();
		androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("Current Activity: " + androidDriver.currentActivity());
		System.out.println("Context: " + androidDriver.getContext());
//		Views - Native, Hybrid, Webview
		
		System.out.println("Orientation: " + androidDriver.getOrientation());
		System.out.println("Locked: " + androidDriver.isDeviceLocked());
		androidDriver.hideKeyboard();
		androidDriver.getKeyboard();
		
		androidDriver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		androidDriver.navigate().back();
	}

}
