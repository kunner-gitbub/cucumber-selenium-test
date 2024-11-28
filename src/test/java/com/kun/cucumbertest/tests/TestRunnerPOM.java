package com.kun.cucumbertest.tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/loginPages.feature",
        glue = "com.kun.cucumbertest.steps",       // Path to step definition classes
        tags = "@smoke or @regression",
        plugin = {
                "pretty",                            // Console output
                "html:target/cucumber-reports.html",      // HTML report
                "json:target/cucumber.json",  // JSON report
                "junit:target/cucumber.xml" // XML report
        }
)
public class TestRunnerPOM {
}
