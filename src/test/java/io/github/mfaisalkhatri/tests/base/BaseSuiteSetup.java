package io.github.mfaisalkhatri.tests.base;

import io.github.mfaisalkhatri.enums.Browsers;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static io.github.mfaisalkhatri.drivers.DriverManager.createDriver;
import static io.github.mfaisalkhatri.drivers.DriverManager.quitDriver;

/**
 * Created By Faisal Khatri on 24-07-2022
 */
@Slf4j
public class BaseSuiteSetup {

    @Parameters ("browser")
    @BeforeClass (alwaysRun = true)
    public void setupTest (final String browser) {
        System.setProperty("headless","false");
        createDriver (Browsers.valueOf (browser.toUpperCase ()));
        log.info("driver create complete.");
    }

    @AfterClass (alwaysRun = true)
    public void tearDown () {
        quitDriver ();
    }
}