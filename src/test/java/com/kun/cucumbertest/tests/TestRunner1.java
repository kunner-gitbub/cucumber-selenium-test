package com.kun.cucumbertest.tests;

/**
 * ClassName: TestRunner1
 * Package: com.kun.cucumbertest.tests
 * Description:
 *
 * @Author KunJiang
 * @Create 11/27/24 9:12 PM
 * @Version 1.0
 */

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/LoginValidate.feature",
        glue = "com.kun.cucumbertest.steps",       // Path to step definition classes
        plugin = {
                "pretty",                            // Console output
                "html:target/cucumber-reports.html",      // HTML report
                "json:target/cucumber.json",  // JSON report
                "junit:target/cucumber.xml" // XML report
        }
)
public class TestRunner1 {
}

