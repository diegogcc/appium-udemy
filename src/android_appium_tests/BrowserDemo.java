package android_appium_tests;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BrowserDemo extends BrowserCapabilities{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> androidDriver = capabilities("Pixel_2_API_25");
		androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		androidDriver.get("http://facebook.com");
//		androidDriver.findElementByXPath("//*[@id=\"m_login_email\"]").sendKeys("holo-mail");
//		androidDriver.findElementByXPath("//*[@id=\"m_login_password\"]").sendKeys("psssss");
//		androidDriver.findElementByXPath("//*[@id=\"login_form\"]/div[4]/div/div[2]/div/div/div[2]").click();
		
		androidDriver.get("http://m.cricbuzz.com");
		androidDriver.findElementByXPath("//*[@id=\"top\"]/div/div[3]/div[2]/a").click();
		androidDriver.findElementByXPath("//*[@id=\"top\"]/div/div[16]/table/tbody/tr[1]/td[1]/a").click();
		System.out.println(androidDriver.getCurrentUrl());
//		Steps to scroll using JS
		JavascriptExecutor jse = (JavascriptExecutor) androidDriver;
		jse.executeScript("window.scrollBy(0,480)", "");
		
		System.out.println(androidDriver.findElementByXPath("//*[@id=\"top\"]/div/div[10]/h4").getAttribute("class").contains("header"));
		
	}

}
