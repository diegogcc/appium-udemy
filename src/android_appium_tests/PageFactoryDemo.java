package android_appium_tests;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.HomePage;
import pageObjects.Preference;

public class PageFactoryDemo extends Capabilities{

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> androidDriver = capabilities("Pixel_2_API_25");
		androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		HomePage homePage = new HomePage(androidDriver);
		Preference preferencePage = new Preference(androidDriver);
		homePage.PREFERENCE.click();
		preferencePage.PREFERENCE_DEPENDENCIES.click();
	}

}
