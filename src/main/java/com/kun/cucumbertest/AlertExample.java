package com.kun.cucumbertest;

/**
 * ClassName: AlertExample
 * Package: com.kun.cucumbertest
 * Description:
 *
 * @Author KunJiang
 * @Create 11/28/24 4:31 PM
 * @Version 1.0
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AlertExample {

    WebDriver driver = new ChromeDriver(); // 使用 Chrome 浏览器

    public void handleAlert() {
        // 打开测试网站
        driver.get("http://the-internet.herokuapp.com/js/foundation/foundation.alerts.js");

        // 等待弹窗出现
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        // 切换到弹窗
        Alert alert = driver.switchTo().alert();

        // 获取弹窗文本
        String alertText = alert.getText();
        System.out.println("Alert Text: " + alertText);

        // 验证弹窗文本
        if (alertText.contains("This is a Foundation alert.")) {
            System.out.println("The correct alert message is displayed.");
        } else {
            System.out.println("Alert message is different.");
        }

        // 关闭弹窗，点击 "OK"
        alert.accept();
    }

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        AlertExample example = new AlertExample();
        example.handleAlert();
    }
}
