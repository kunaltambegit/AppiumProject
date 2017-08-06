import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class LaunchAppp {

	AndroidDriver driver;
	DesiredCapabilities caps;

	@BeforeTest(enabled = false)
	public void setUp() throws MalformedURLException {
		caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Android");
		// caps.setCapability("platformVersion", "6.0.1");
		caps.setCapability("appPackage", "de.stroetmann");
		caps.setCapability("appActivity", "de.stroetmann.views.activities.SplashActivity");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

		System.out.println("Thiesting");
	}

	@Test
	public void myMainTest() throws InterruptedException, IOException {
		System.out.println("Testing...");

		Runtime.getRuntime().exec("adb shell input keyevent 26");

		System.out.println("Turning Power ON.....");
		Thread.sleep(5000);
		Runtime.getRuntime().exec("adb shell input swipe 100 500 100 100 200");

		Thread.sleep(3000);
		Runtime.getRuntime().exec("adb shell settings put global airplane_mode_on 1");
		System.out.println("Turning Airoplance mode on..........");
		
		
		
	}

	@AfterTest(enabled = false)
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
