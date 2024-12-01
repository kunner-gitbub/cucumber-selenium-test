package com.kun.cucumbertest.webElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * ClassName: BooksList
 * Package: com.kun.cucumbertest.webElements
 * Description:
 *
 * @Author KunJiang
 * @Create 11/29/24 10:42 PM
 * @Version 1.0
 */

public class BooksList {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("sample.com");
        // 初始化 JavaScript 执行器和 Actions 对象
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);

        // 最大重试次数
        int retries = 0;
        int maxRetries = 3; // 当没有新内容加载时，最多尝试 3 次
        int previousCount = 0;

        while (retries < maxRetries) {
            // 获取当前加载的书籍列表
            List<WebElement> bookList = driver.findElements(By.xpath("//span[@class='product-title-text']/bdi"));
            int currentCount = bookList.size();
            System.out.println("当前抓取到的书籍数量: " + currentCount);

            // 滚动到页面底部
            actions.scrollToElement(bookList.get(bookList.size() - 1)).perform();

            // 等待页面加载
            Thread.sleep(3000); // 等待 3 秒确保内容加载完成
            // 检查书籍数量是否变化
            if (currentCount == previousCount) {
                retries++;
            } else {
                retries = 0;
                previousCount = currentCount;
            }
        }

        // 抓取所有书籍标题
        List<WebElement> finalBookList = driver.findElements(By.xpath("//span[@class='product-title-text']/bdi"));
        System.out.println("总共抓取到的书籍数量: " + finalBookList.size());
        // 打印所有书籍标题到控制台
        for (WebElement book : finalBookList) {
            System.out.println(book.getText());
        }

        // 写入结果到文本文件
        try (java.io.FileWriter writer = new java.io.FileWriter("books.txt")) {
            for (WebElement book : finalBookList) {
                writer.write(book.getText() + System.lineSeparator());
            }
            System.out.println("书籍列表已保存到 books.txt 文件中");
        } catch (Exception e) {
            System.err.println("写入文件时出错: " + e.getMessage());
        }

        // 关闭浏览器
        driver.quit();
    }
}