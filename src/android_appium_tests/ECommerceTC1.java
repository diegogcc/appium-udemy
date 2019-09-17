package android_appium_tests;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/*
 * TC1:
 * Fill the form details and verify Toast error messages displayed appropriately for wrong inputs
 */

public class ECommerceTC1 extends Capabilities{

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> androidDriver = capabilities("Pixel_2_API_25","General-Store.apk");
		androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		enterTheShop(androidDriver);
		enterTheShopError(androidDriver);
	}
	
	@Test
	private static void enterTheShopError(AndroidDriver<AndroidElement> driver) {
		// TODO Auto-generated method stub
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		String toastMessage = driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
		Assert.assertEquals("Please enter your name", toastMessage);
	}

	public static void enterTheShop(AndroidDriver<AndroidElement> driver){
		driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Belgium\"));");
//		driver.findElementByAndroidUIAutomator("new UiScrollable(newUiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Colombia\").instance(0));");
		driver.findElementByAndroidUIAutomator("text(\"Belgium\")").click();
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Name001");
//		Hide keyboard
		driver.hideKeyboard();
		driver.findElementByXPath("//android.widget.RadioButton[@text='Female']").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
	}

}
