package android_appium_tests;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

	/*
	 * TC2:
	 * Shop the items in the cart by scrolling to specific product to verify scroll touch functionality
	 */
	
public class ECommerceTC2 extends Capabilities{
	
	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> androidDriver = capabilities("Pixel_2_API_25","General-Store.apk");
		androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ECommerceTC1.enterTheShop(androidDriver);
		addToCart(androidDriver, "Jordan 6 Rings");
	}

	public static void addToCart(AndroidDriver<AndroidElement> driver, String prod) {
		// TODO Auto-generated method stub
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"" + prod + "\").instance(0));");
		
		List<AndroidElement> displayedProducts = driver.findElementsById("com.androidsample.generalstore:id/productName");
		for (int i = 0; i < displayedProducts.size(); i++) {
			String product = displayedProducts.get(i).getText();
			if (product.equals(prod)) {
				driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
				break;
			}
		}
	}

}
