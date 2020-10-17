package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TestLoginPage {

	static AppiumDriver<MobileElement> driver;
	
	public static void main(String[] args) {
		try {
			DesiredCapabilities cap = new DesiredCapabilities();
			installDeviceSettings(cap);
			installApplicationSettings(cap);
			connectionToDevice(cap);
			
			waitToLoadPage();
			
			String login = "9081999409";
			String idLoginTextArea = "ru.tele2.mytele2:id/editText";
			sendInfoToTextAreaById(login, idLoginTextArea);
			
			String idLoginButtom = "ru.tele2.mytele2:id/login";
			clickTheButtom(idLoginButtom);		
			
			waitToLoadPage();
			
			String idOtherPaymentMethods = "ru.tele2.mytele2:id/otherWays";
			clickTheButtom(idOtherPaymentMethods);
			
			waitToLoadPage();
			
			String xpath = "/hierarchy/android.widget.FrameLayout/android.widget."+
					"LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/"+
					"android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout"+
					"/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/"+
					"android.widget.FrameLayout/android.widget.LinearLayout/androidx.appcompat.widget."+
					"LinearLayoutCompat[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget"+
					".LinearLayout/android.widget.EditText";
			String pass = "RhD651";
			sendInfoToTextAreaByXpath(pass, xpath);
			
			String idLoginButtom2 = "ru.tele2.mytele2:id/loginButton"; 
			clickTheButtom(idLoginButtom2);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}
	
	public static void installDeviceSettings(DesiredCapabilities cap) {
		cap.setCapability("deviceName", "realme 6");
		cap.setCapability("udid", "VKVG8LKF75SK8T7H");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "10");
	}
	
	public static void installApplicationSettings(DesiredCapabilities cap) {
		cap.setCapability("appPackage", "ru.tele2.mytele2");
		cap.setCapability("appActivity", "ru.tele2.mytele2.ui.splash.SplashActivity");
	}
	
	public static void connectionToDevice(DesiredCapabilities cap) throws MalformedURLException {
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);
	}
	
	private static void sendInfoToTextAreaByXpath(String msg, String xpath) {
		System.out.println("send info to " + xpath);
		MobileElement textArea = driver.findElement(By.xpath(xpath));
		textArea.sendKeys(msg);
	}
	
	private static void sendInfoToTextAreaById(String msg, String id) {
		System.out.println("send info to " + id);
		MobileElement textArea = driver.findElement(By.id(id));
		textArea.sendKeys(msg);
	}
	
	private static void clickTheButtom(String id) {
		System.out.println("clickTheButtom: " + id);
		MobileElement buttom = driver.findElement(By.id(id));
		buttom.click();
	}

	public static void waitToLoadPage() {
		System.out.println("waitToLoadPage");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
