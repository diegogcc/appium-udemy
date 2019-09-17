package android_appium_tests;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;

	/*
	 * TC5:
	 * Validate if mobile gestures are working for links and navigate to a webview
	 */
public class ECommerceTC5 extends Capabilities{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> androidDriver = capabilities("Pixel_2_API_25","General-Store.apk");
		androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String prod = "Air Jordan 4 Retro";
		ECommerceTC1.enterTheShop(androidDriver);
		ECommerceTC2.addToCart(androidDriver, prod);
		ECommerceTC3.verifyCheckoutPage(androidDriver, prod);
		seeTermsOfConditions(androidDriver);
		closeTermsOfConditions(androidDriver);
		tapMarketingCheckbox(androidDriver);
	}
	
	@Test
	public void runTC6() throws InterruptedException, MalformedURLException {
		AndroidDriver<AndroidElement> androidDriver = capabilities("Pixel_2_API_25","General-Store.apk");
		androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String prod = "Air Jordan 4 Retro";
		ECommerceTC1.enterTheShop(androidDriver);
		ECommerceTC2.addToCart(androidDriver, prod);
		ECommerceTC3.verifyCheckoutPage(androidDriver, prod);
		seeTermsOfConditions(androidDriver);
		closeTermsOfConditions(androidDriver);
		tapMarketingCheckbox(androidDriver);
	}

	public static void tapMarketingCheckbox(AndroidDriver<AndroidElement> driver) {
		// TODO Auto-generated method stub
		AndroidTouchAction t = new AndroidTouchAction(driver);
		WebElement checkbox = driver.findElementByClassName("android.widget.CheckBox");
		t.tap(tapOptions().withElement(element(checkbox))).perform();
	}

	public static void closeTermsOfConditions(AndroidDriver<AndroidElement> driver) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(2000); //Sleep added so TC modal is visible
		driver.findElementByXPath("//android.widget.Button[@text='CLOSE']").click();
	}

	public static void seeTermsOfConditions(AndroidDriver<AndroidElement> driver) {
		// TODO Auto-generated method stub
		AndroidTouchAction t = new AndroidTouchAction(driver);
		WebElement tc = driver.findElementById("com.androidsample.generalstore:id/termsButton");
		t.longPress(longPressOptions().withElement(element(tc)).withDuration(ofSeconds(3))).release().perform();
	}

}
