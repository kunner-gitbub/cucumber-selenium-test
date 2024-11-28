package com.kun.cucumbertest.steps;

import com.kun.cucumbertest.pages.LoginPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * ClassName: LoginPagesSteps
 * Package: com.kun.cucumbertest.steps
 * Description:
 *
 * @Author KunJiang
 * @Create 11/28/24 3:51 PM
 * @Version 1.0
 */

public class LoginPagesSteps {
    WebDriver driver = null;
    LoginPages loginPage;

    @Before
    public void setup() {
        // Initialize WebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void teardown() {
        // Quit WebDriver
        if (driver != null) {
            driver.quit();
        }
    }
    
    @Given("The user is given user login page")
    public void the_user_is_given_user_login_page() {
        driver.get("http://the-internet.herokuapp.com/login");
        loginPage = new LoginPages(driver);
    }

    //@When("The user enters the username and password")
    @When("the user enters username {string} and password {string}")
    public void the_user_enters_the_username_and_password(String username, String password) {
        loginPage.enterUserName(username);
        loginPage.enterPassWord(password);
        loginPage.submitButton();
    }
    @Then("The user should go to next secure page")
    public void the_user_should_go_to_next_secure_page() {
        if (driver.getCurrentUrl().contains("/secure")) {
            System.out.println("Login successful: Secure area displayed.");
        } else {
            System.out.println("Login failed: Secure area not displayed.");
        }
    }
    @And("the user should see the password change alert")
    public void the_user_should_see_the_password_change_alert() {
        System.out.println("do it later");
    }
    }

