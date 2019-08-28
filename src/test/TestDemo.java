package test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class TestDemo extends Capabilities{
	
	@BeforeMethod
	public void prerequisite() {
		/*
		 * Other basic annotations: (https://www.tutorialspoint.com/testng/testng_basic_annotations.htm)
		 * @BeforeSuite
		 * @AfterSuite
		 * @BeforeClass
		 * @AfterClass
		 * @BeforeTest
		 * @AfterTest
		 * @BeforeMethod
		 * @AfterMethod
		 * @DataProvider
		 * @Factory
		 * @Listeners
		 * @Parameters
		 * @Test
		 */
	}
	
	@Test(groups= {"Smoke"})
	public void testAndroidEmulator() throws MalformedURLException {
		AndroidDriver<AndroidElement> androidDriver = androidEmulatorCapabilities("Pixel_2_API_25");
		androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testIOSSimulator() throws MalformedURLException{
		IOSDriver<IOSElement> iosDriver = iosSimulatorCapabilities("iPhone 8","9D9E3338-58FE-4696-9F17-3963CE170ED5");
		iosDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(groups= {"Smoke"})
	public void testMobileHome() {
//		does nothing
	}
	
	@Test
	public void testMobileLogin() {
//		does nothing
	}
	
	@Test(groups= {"Smoke"})
	public void testMobileDetailPage() {
//		does nothing
	}
	
	@Test
	public void testWebHome() {
//		does nothing
	}
	
	@Test
	public void testWebLogin() {
//		does nothing
	}
	
	@Test
	public void testWebDetailPage() {
//		does nothing
	}
	
}
