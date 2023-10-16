package io.github.mfaisalkhatri.tests.douban;

import io.github.mfaisalkhatri.tests.base.BaseSuiteSetup;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.mfaisalkhatri.drivers.DriverManager.getDriver;
public class DoubanPracticeHome extends BaseSuiteSetup {


    @BeforeClass
    public void setupTest() {
        getDriver().navigate().to("http://www.douban.com");
    }
    @Test
    public void checkHomeInfo() {

    }
}
