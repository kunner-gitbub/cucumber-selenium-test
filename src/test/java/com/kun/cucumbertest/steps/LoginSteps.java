package com.kun.cucumbertest.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {
    WebDriver driver;

    @Given("I open the login page")
    public void openLoginPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://google.com");
        System.out.println(driver.getTitle());
    }

    @When("I enter valid credentials")
    public void enterCredentials() {
        // Use Selenium to interact with the page
        driver.findElement(By.name("q")).sendKeys("testUser");
        System.out.println("driver.getTitle() = " + driver.getTitle());
    }

    @Then("I should be logged in successfully")
    public void verifyLogin() {
        String pageTitle = driver.getTitle();
        System.out.println("pageTitle = " + pageTitle);
        driver.quit();
    }
}
