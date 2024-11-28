package com.kun.cucumbertest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.security.PrivilegedExceptionAction;

/**
 * ClassName: LoginPages
 * Package: com.kun.cucumbertest.pages
 * Description:
 *
 * @Author KunJiang
 * @Create 11/28/24 3:39 PM
 * @Version 1.0
 */

public class LoginPages {
    WebDriver driver;
    private By userName = By.name("username");
    private By passWord = By.id("password");
    private By logInBtn = By.cssSelector("button[type='submit']");
    private By passwordChangePopout = By.id("change-password-popup");

    public LoginPages(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserName(String username){
        driver.findElement(userName).sendKeys(username);
    }

    public void enterPassWord(String password){
        driver.findElement(passWord).sendKeys(password);
    }

    public void submitButton(){
        driver.findElement(logInBtn).click();
    }
    public boolean isPasswordChangePopoutDisplayed() {
        WebElement popout = driver.findElement(passwordChangePopout);
        return popout.isDisplayed();
    }
}
