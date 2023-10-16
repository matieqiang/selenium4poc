package io.github.mfaisalkhatri.tests.stackoverflow;

import io.github.mfaisalkhatri.pages.stackoverflow.StackOverflowHomePO;
import io.github.mfaisalkhatri.pages.stackoverflow.StackoverflowUsersLoginPO;
import io.github.mfaisalkhatri.tests.base.BaseSuiteSetup;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;

@Slf4j
public class LoginTest extends BaseSuiteSetup {

    private WebDriverWait wait;
    private StackoverflowUsersLoginPO loginPage;
//    private StackOverflowHomePO homePage;
    @BeforeClass
    public void setup() {
        getDriver().get("https://stackoverflow.com/users/login");
//        loginPage = PageFactory.initElements(getDriver(),StackoverflowUsersLoginPO.class);
        loginPage = new StackoverflowUsersLoginPO(getDriver());
//        homePage = new StackOverflowHomePO(getDriver());
        log.info(" LoginTest page initial complete.");
    }
    @Test
    public void testLogin() {
        loginPage.getInputEmail().sendKeys("matieqiang@gmail.com");
        loginPage.getInputPassword().sendKeys("mtq@tong0");
        loginPage.getButtonSubmit().click();
        String handle = getDriver().getWindowHandle();
        getDriver().switchTo().window(handle);

        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("svg[class$='iconStackExchange']")));
        Assert.assertEquals(getDriver().getTitle(),"Stack Overflow - Where Developers Learn, Share, & Build Careers");

    }
}
