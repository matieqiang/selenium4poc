package io.github.mfaisalkhatri.pages.stackoverflow;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://stackoverflow.com/
public class StackOverflowHome {
    @FindBy(css = "a[data-gps-track='login.click']")
    public WebElement linkLoginClick;


}