package io.github.mfaisalkhatri.tests.remote;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestRemoteDriver {


    @Test
    public void testChrome() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
        options.setCapability(CapabilityType.BROWSER_NAME, "chrome");
        options.setCapability(CapabilityType.BROWSER_VERSION, "115.0");
        WebDriver driver = new RemoteWebDriver(new URL("https://admin:admin@selenium-grid.advai.cn/wd/hub"), options);
        driver.get("http://google.com");

        System.out.println("chrome 115.0 Test executed successfully");
        driver.quit();
    }

    @Test
    public void testFirefox() throws MalformedURLException {
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
        options.setCapability(CapabilityType.BROWSER_NAME, "firefox");
        options.setCapability(CapabilityType.BROWSER_VERSION, "94.0");
        WebDriver driver = new RemoteWebDriver(new URL("http://admin:admin@selenium-grid.advai.cn/wd/hub"),options);

        driver.get("http://www.google.com");

        sleep();
        System.out.println("firefox 94.0 Test executed successfully");
        driver.quit();
    }

    @Test
    public void testEdge() throws MalformedURLException {
        EdgeOptions options = new EdgeOptions();
        options.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
        options.setCapability(CapabilityType.BROWSER_NAME, "MicrosoftEdge");
        options.setCapability(CapabilityType.BROWSER_VERSION, "100.0");
        WebDriver driver = new RemoteWebDriver(new URL("http://admin:admin@selenium-grid.advai.cn/wd/hub"),options);


        driver.get("http://google.com");
        System.out.println("Microsoft Edge 100.0 Test executed successfully");
        driver.quit();
    }

    private void sleep() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
