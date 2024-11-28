package com.kun.cucumbertest.pages;

/**
 * ClassName: loginPages_PF
 * Package: com.kun.cucumbertest.pages
 * Description:
 *
 * @Author KunJiang
 * @Create 11/28/24 4:57 PM
 * @Version 1.0
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class LoginPages_PF {

    WebDriver driver;

    // 使用 @FindBy 注解来标识元素
    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "loginButton")
    WebElement loginButton;

    public LoginPages_PF(WebDriver driver) {
        this.driver = driver;
        // 使用 PageFactory 初始化元素
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public static void main(String[] args) {

    }
}

