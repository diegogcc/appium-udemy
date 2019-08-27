package android_appium_tests;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/*
	 * TC4:
	 * Validate the total amount displayed in the checkout page matches the sum of selected product prices
	 */
public class ECommerceTC4 extends Capabilities{

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> androidDriver = capabilities("Pixel_2_API_25");
		androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		validateCheckoutItems(androidDriver, "Air Jordan 4 Retro", "Air Jordan 1 Mid SE", 280.97);
	}

	public static void validateCheckoutItems(AndroidDriver<AndroidElement> driver, String prod1,
			String prod2, double totalExpected) {
		double totalSum = 0;
		ECommerceTC1.enterTheShop(driver);
		ECommerceTC2.addToCart(driver, prod1);
		totalSum += getProductPrice(driver, prod1);
		ECommerceTC2.addToCart(driver, prod2);
		totalSum += getProductPrice(driver,prod2);
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		String sc = driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
		System.out.println(sc.substring(1) + ">>>> Checkout Page");
		System.out.println(totalExpected + " >>>> Expected");
		System.out.println(totalSum + " >>>> Actual");
	}

	private static double getProductPrice(AndroidDriver<AndroidElement> driver, String prod) {
		// TODO Auto-generated method stub
		double price;
		List<AndroidElement> displayedProducts = driver.findElementsById("com.androidsample.generalstore:id/productName");
		for (int i = 0; i < displayedProducts.size(); i++) {
			String product = displayedProducts.get(i).getText();
			if (product.equals(prod)) {
				String sp = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(i).getText();
				sp = sp.substring(1);
				return Double.parseDouble(sp);
			}
		}
		return 0.0;
	}

}
