package com.kun.cucumbertest.webElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;

/**
 * ClassName: AlertTest
 * Package: com.kun.cucumbertest.webElements
 * Description:
 *
 * @Author KunJiang
 * @Create 11/28/24 5:55 PM
 * @Version 1.0
 */

public class AlertTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");
            //driver.findElement(By.name("username")).sendKeys("tomsmith");
            //driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
            //driver.findElement(By.xpath("//button[@class='radius' and @type='submit']")).click();
            driver.findElement(By.id("alertexamples")).click();
            Alert alert1 = driver.switchTo().alert();
            System.out.println("alert1.getText() = " + alert1.getText());
            alert1.accept();
            System.out.println("driver.getTitle() = " + driver.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }
}
