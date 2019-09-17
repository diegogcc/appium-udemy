package android_appium_tests;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/*
	 * TC3:
	 * Validate if the items selected in the page 2 match the items displayed on the checkout page.
	 */

public class ECommerceTC3 extends Capabilities{

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> androidDriver = capabilities("Pixel_2_API_25","General-Store.apk");
		androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String prod = "Jordan 6 Rings";
		ECommerceTC2.addToCart(androidDriver, prod);
		verifyCheckoutPage(androidDriver, prod);
	}

	public static void verifyCheckoutPage(AndroidDriver<AndroidElement> driver, String prod) {
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		String cart = driver.findElementById("com.androidsample.generalstore:id/productName").getText();
		System.out.println(prod + " >>>> Expected");
		System.out.println(cart + " >>>> Actual");
	}

}
