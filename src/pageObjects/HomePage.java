package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {
	
	public HomePage(AndroidDriver<AndroidElement> driver) {		
//		If compatibility across Android and iOS is needed then:
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc=\"Accessibility\"]")
	public WebElement ACCESSIBILITY;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc=\"Content\"]")
	public WebElement CONTENT;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc=\"Media\"]")
	public WebElement MEDIA;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc=\"Preference\"]")
	public WebElement PREFERENCE;
	
}
