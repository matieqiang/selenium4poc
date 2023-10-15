package io.github.mfaisalkhatri.pages.douban;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://movie.douban.com/
public class MovieHome {
    public MovieHome(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}