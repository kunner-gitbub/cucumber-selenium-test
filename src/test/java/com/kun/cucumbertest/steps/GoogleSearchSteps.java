package com.kun.cucumbertest.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.sql.Driver;
import java.time.Duration;

import static org.junit.Assert.assertTrue;

/**
 * ClassName: GoogleSearchSteps
 * Package: com.kun.cucumbertest.steps
 * Description:
 *
 * @Author KunJiang
 * @Create 11/27/24 8:14 PM
 * @Version 1.0
 */

public class GoogleSearchSteps {
    WebDriver driver = null;
    @Given("browser is open")
    public void browser_is_open() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }
    @And("user is on google search page")
    public void user_is_on_google_search_page() {
        driver.navigate().to("https:google.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @When("user enter a text in search box")
    public void user_enter_a_text_in_search_box() {
        driver.findElement(By.name("q")).sendKeys("Automation step by step");
    }
    @And("user click submit")
    public void user_click_submit() {
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }
    @Then("user is navigating to search page")
    public void user_is_navigating_to_search_page() {
        assertTrue("Login was not successful", driver.getPageSource().contains("Online Courses"));
        driver.quit();
    }
}
