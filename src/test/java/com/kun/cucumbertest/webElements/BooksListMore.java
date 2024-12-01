package com.kun.cucumbertest.webElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * ClassName: BooksList
 * Package: com.kun.cucumbertest.webElements
 * Description:
 *
 * @Author KunJiang
 * @Create 11/29/24 10:42 PM
 * @Version 1.0
 */

public class BooksListMore {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // 打开目标页面
            driver.get("sample.com");
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

            // 用于存储所有书籍标题，避免重复
            Set<String> uniqueBooks = new HashSet<>();

            // 滚动页面并加载所有书籍标题
            int lastBookCount = 0;
            while (true) {
                // 获取当前页面可见的书籍标题
                List<WebElement> bookList = driver.findElements(By.xpath("//span[@class='product-title-text']/bdi"));
                for (WebElement e : bookList) {
                    uniqueBooks.add(e.getText());
                }

                // 滚动到底部
                jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                Thread.sleep(10000); // 等待页面加载更多内容

                // 检查新书籍数量是否增加
                int currentBookCount = bookList.size();
                if (currentBookCount == lastBookCount) {
                    break; // 如果没有新内容加载，停止滚动
                }
                lastBookCount = currentBookCount;
            }

            // 打印所有收集到的书籍标题
            System.out.println("Total unique books found: " + uniqueBooks.size());
            for (String book : uniqueBooks) {
                System.out.println(book);
            }
        } finally {
            // 关闭浏览器
            driver.quit();
        }
    }
}
