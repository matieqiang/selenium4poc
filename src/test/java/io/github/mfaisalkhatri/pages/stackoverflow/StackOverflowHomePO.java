package io.github.mfaisalkhatri.pages.stackoverflow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = https://stackoverflow.com/
public class StackOverflowHomePO {
    @FindBy(css = "a[data-gps-track='login.click']")
    public WebElement linkLoginClick;

//    public WebElement

    public StackOverflowHomePO(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}