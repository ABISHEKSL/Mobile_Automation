package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723 --session-override -dc \"{\"\"noReset\"\": \"\"false\"\"}\"\"");
        Thread.sleep(100000);

        UiAutomator2Options capabilities = new UiAutomator2Options();

        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Abi");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities.setApp("C:\\Users\\Abishek\\Pictures\\CAMION_MOBILE_APP-master\\APP\\TOI-8.4.2.8.apk");
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.toi.reader.activities");
       // capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.toi.reader.app.features.search.recentsearch.view.RecentSearchActivity");

        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723"), capabilities);

        driver.getCapabilities();

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//android.view.ViewGroup[@resource-id=\"com.toi.reader.activities:id/toolbarItems\"]")).click();

    }
}