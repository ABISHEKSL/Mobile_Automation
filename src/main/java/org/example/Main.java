package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Main {
    public void swipe()
    {
        AndroidDriver driver = null;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        swipeObject.put("startX", 0.95);
        swipeObject.put("startY", 0.5);
        swipeObject.put("endX", 0.05);
        swipeObject.put("endY", 0.5);
        swipeObject.put("duration", 1.8);
        js.executeScript("mobile: swipe", swipeObject);
    }
    public static void main(String[] args) throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723 --session-override -dc \"{\"\"noReset\"\": \"\"false\"\"}\"\"");
        Thread.sleep(20000);

        UiAutomator2Options capabilities = new UiAutomator2Options();

        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Abi");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
        capabilities.setApp("C:\\Users\\Abishek\\IdeaProjects\\Mobile_Auto\\src\\main\\resources\\app-dev-release.apk");
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.yolo.field.force.dev");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.yolo.field.force.MainActivity");

        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723"), capabilities);

        driver.getCapabilities();

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Log In']")).click();
        Thread.sleep(9000);
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='username']")).sendKeys("gecitid994@jucatyo.com");
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='password']")).sendKeys("Test@1234");
        driver.findElement(By.xpath("//android.widget.Button[@text='Log in']")).click();
        Thread.sleep(9000);

        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        var start = new Point(122, 2001);
        var end = new Point (1015, 1997);
        var swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));




        driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.Button[2]")).click();
        driver.findElement(By.xpath("//android.view.View[@content-desc='Basic Information Organisation Name Business Type Business Category Opening Balance (Optional) Business Location']/android.widget.EditText[1]")).sendKeys("SK Stores");
        driver.findElement(By.xpath("//android.view.View[@content-desc='Basic Information Organisation Name Business Type Business Category Opening Balance (Optional) Business Location']/android.view.View[1]")).click();
        driver.findElement(By.xpath("//android.view.View[@content-desc='Retailer']")).click();
        driver.findElement(By.xpath("//android.view.View[@content-desc='Basic Information Organisation Name Business Type Business Category Opening Balance (Optional) Business Location']/android.view.View[2]")).click();
        driver.findElement(By.xpath("//android.view.View[@content-desc='E-commerce stores']")).click();
        driver.findElement(By.xpath("//android.view.View[@content-desc='Basic Information Organisation Name Business Type Business Category Opening Balance (Optional) Business Location']/android.widget.EditText[2]")).sendKeys("5000");
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Next']")).click();

        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Address']")).click();
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Use Current Location']")).click();
        driver.findElement(By.xpath("//android.view.View[@content-desc='Shipping Address Pick Location State City / Town Pin Code Address Line 1 Address Line 2 (Optional)']/android.widget.EditText[1]")).sendKeys("Nagapattinam");
        driver.findElement(By.xpath("//android.view.View[@content-desc='Shipping Address Pick Location State City / Town Pin Code Address Line 1 Address Line 2 (Optional)']/android.widget.EditText[2]")).sendKeys("611001");
        driver.findElement(By.xpath("//android.view.View[@content-desc='Shipping Address Pick Location State City / Town Pin Code Address Line 1 Address Line 2 (Optional)']/android.widget.EditText[3]")).sendKeys("21, new nort street");
        driver.findElement(By.xpath("//android.view.View[@content-desc='Shipping Address Pick Location State City / Town Pin Code Address Line 1 Address Line 2 (Optional)']/android.widget.EditText[4]")).sendKeys("mark street, new");
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Save']")).click();
        driver.findElement(By.xpath("//android.view.View[@content-desc='Contact Details Organization Phone Number Organisation Email Organization Address']/android.widget.EditText[1]")).sendKeys("9677428541");
        driver.findElement(By.xpath("//android.view.View[@content-desc='Contact Details Organization Phone Number Organisation Email Organization Address']/android.widget.EditText[2]")).sendKeys("Justxyz11@gmail.com");

        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Next']")).click();
        driver.findElement(By.xpath("//android.view.View[@content-desc='GST Treatment GST Status GST Number']/android.view.View[1]")).click();
        driver.findElement(By.xpath("//android.view.View[@content-desc='Registered']")).click();
        driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("24AAACC4175D1Z4");
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Next']")).click();












    }
}