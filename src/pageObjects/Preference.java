package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Preference {
	
	public Preference(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"3. Preference dependencies\"]")
	public WebElement PREFERENCE_DEPENDENCIES;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc=\"6. Advanced preferences\"]")
	public WebElement ADVANCED_PREFERENCES;
}
