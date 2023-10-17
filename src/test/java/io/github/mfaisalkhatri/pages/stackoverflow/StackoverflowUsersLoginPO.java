package io.github.mfaisalkhatri.pages.stackoverflow;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = https://stackoverflow.com/users/login
@Getter
public class StackoverflowUsersLoginPO {
    @FindBy(css = "input[id='email']")
    public WebElement inputEmail;

    @FindBy(css = "input[id='password']")
    public WebElement inputPassword;

    @FindBy(css = "button[id='submit-button']")
    public WebElement buttonSubmit;

    public StackoverflowUsersLoginPO(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}