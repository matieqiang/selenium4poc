package io.github.mfaisalkhatri.tests.stackoverflow;

import io.github.mfaisalkhatri.tests.base.BaseSuiteSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;

public class Examples extends BaseSuiteSetup {

    @BeforeClass
    public void setup() {
        getDriver().get("https://stackoverflow.com/users/login");
    }

    @Test
    public void testLogin() {
        getDriver().findElement(By.cssSelector("input[id='email']")).sendKeys("matieqiang@gmail.com");
        getDriver().findElement(By.cssSelector("input[id='password']")).sendKeys("mtq@tong0");
        getDriver().findElement(By.cssSelector("button[id='submit-button']")).click();
        String handle =getDriver().getWindowHandle();
        getDriver().switchTo().window(handle);

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("svg[class$='iconStackExchange']")));
        Assert.assertEquals(getDriver().getTitle(),"Stack Overflow - Where Developers Learn, Share, & Build Careers");
    }
}
