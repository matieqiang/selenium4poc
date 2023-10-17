package io.github.mfaisalkhatri.tests.stackoverflow;

import io.github.mfaisalkhatri.pages.stackoverflow.StackOverflowHomePO;
import io.github.mfaisalkhatri.pages.stackoverflow.StackoverflowNavigationPO;
import io.github.mfaisalkhatri.pages.stackoverflow.StackoverflowUsersLoginPO;
import io.github.mfaisalkhatri.tests.base.BaseSuiteSetup;
import io.github.mfaisalkhatri.utilities.Helper;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;

@Slf4j
public class ReadMessageTestCase extends BaseSuiteSetup {
    private WebDriverWait wait;
    private static String HOME_URL = "https://stackoverflow.com/";
    private static String EMAIL = "matieqiang@gmail.com";
    private static String PASSWORD = "mtq@tong0";
    private StackOverflowHomePO homePO;
    private StackoverflowUsersLoginPO loginPO;
    private StackoverflowNavigationPO navigationPO;

    @BeforeClass(alwaysRun = true)
    public void setupTest() {
        log.info("ReadMessage setupTest");
        getDriver().get(HOME_URL);
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        homePO = new StackOverflowHomePO(getDriver());
    }

    @Test
    public void login() {
        homePO.getLinkLoginClick().click();
        switchWindow();
        loginPO = new StackoverflowUsersLoginPO(getDriver());
        loginPO.getInputEmail().sendKeys(EMAIL);
        loginPO.getInputPassword().sendKeys(PASSWORD);
        loginPO.getButtonSubmit().click();

        switchWindow();
        Assert.assertEquals(getDriver().getTitle(),"Stack Overflow - Where Developers Learn, Share, & Build Careers");
    }
/*

    @Test
    public void openTagPage() {
    }

    @Test
    public void searchSelenium() {
    }

    @Test
    public void selectTag() {
    }

    @Test
    public void readQuestion() {
    }
*/


    @AfterClass(alwaysRun = true)
    public void tearDown() {
        log.info("ReadMessage tearDown");
    }

    private void switchWindow() {

        String handle = getDriver().getWindowHandle();
        getDriver().switchTo().window(handle);
    }
}
