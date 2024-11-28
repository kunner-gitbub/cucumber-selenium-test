package com.kun.cucumbertest.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;
/**
 * ClassName: LoginValidateSteps
 * Package: com.kun.cucumbertest.steps
 * Description:
 *
 * @Author KunJiang
 * @Create 11/27/24 9:01 PM
 * @Version 1.0
 */

public class LoginValidateSteps {
    WebDriver driver = null;

    @Given("the user navigates to the login page")
    public void the_user_navigates_to_the_login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/login.html");
    }

    @When("the user enters the username {string} and password {string}")
    public void the_user_enters_the_username_and_password(String username, String password) {
        // 假设有输入框和登录按钮
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.className("login-btn")).click();
    }

    @Then("the user should be successfully logged in")
    public void the_user_should_be_successfully_logged_in() {
        // 假设登录成功后有一个欢迎信息
        String welcomeMessage = driver.findElement(By.id("welcomeMessage")).getText();
        assertTrue(welcomeMessage.contains("Welcome"));
    }

}
