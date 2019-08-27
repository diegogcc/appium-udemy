package android_appium_tests;
import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

	/*
	 * TC6:
	 * Verify if user can go to the webview and back to the native app
	 */
public class ECommerceTC6 extends Capabilities{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> androidDriver = capabilities("Pixel_2_API_25");
		androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String prod = "Air Jordan 4 Retro";
		goToWebView(androidDriver, prod);
		goBackToNativeApp(androidDriver);
	}

	public static void goBackToNativeApp(AndroidDriver<AndroidElement> driver) {
		// TODO Auto-generated method stub
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Set<String> contextNames = driver.getContextHandles();
		for(String contextName : contextNames) {
			System.out.println(contextName);
		}
		driver.context((String) contextNames.toArray()[0]);
		System.out.println("Switching to:" + (String)contextNames.toArray()[0]);
	}

	public static void goToWebView(AndroidDriver<AndroidElement> driver, String prod) throws InterruptedException {
		// TODO Auto-generated method stub
		ECommerceTC1.enterTheShop(driver);
		ECommerceTC2.addToCart(driver, prod);
		ECommerceTC3.verifyCheckoutPage(driver, prod);
		driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
		Thread.sleep(2000);
		System.out.println("Web View Contexts:");
		Set<String> contextNames = driver.getContextHandles();
		for(String contextName : contextNames) {
			System.out.println(contextName);
		}
		driver.context((String) contextNames.toArray()[1]);
		driver.findElementByName("q").sendKeys("Success ");
		driver.findElementByName("q").sendKeys(Keys.ENTER);		
	}

}
