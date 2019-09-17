package test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
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
	public void testAndroidEmulator() throws IOException {
		AndroidDriver<AndroidElement> androidDriver = androidEmulatorCapabilities("Pixel_2_API_25","GeneralStoreApp");
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
	
	@Test(enabled=false) // TestNG will skip this test
	public void testMobileLogin() {
//		does nothing
	}
	
	@Test(groups= {"Smoke"})
	public void testMobileDetailPage() {
//		does nothing
	}
	
	@Test(dependsOnMethods= {"testWebLogin"})
	public void testWebHome() {
//		does nothing
	}
	
	@Test(timeOut=15000) // Timeout set for this method (set in millis)
	public void testWebLogin() {
//		does nothing
	}
	
	@Test(dependsOnMethods= {"testWebLogin", "testWebHome"})
	public void testWebDetailPage() {
//		does nothing
	}
	
	@Parameters({"URL", "APIKey"})
	@Test
	public void parameterMethod(String url, String apiKey) {
//		does nothing
	}
	
	@Test(dataProvider="getData")
	public void useDataSets(String letter, int number) {
//		does nothing
	}
	
	@DataProvider
	public Object[][] getData() {
		/*
		 * Running the same test with different data sets
		 */
//		Create a multidimensional array
		Object[][] data = new Object[3][2]; // It should run 3 times with 2 values
//		Initialize the array for each set
		data[0][0] = "a"; // set 1
		data[0][1] = 1;
		data[1][0] = "b"; // set 2
		data[1][1] = 2;
		data[2][0] = "c"; // set 3
		data[2][1] = 3;
		return data;
	}
	
}
