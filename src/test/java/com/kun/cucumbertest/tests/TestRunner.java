package com.kun.cucumbertest.tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/LoginValidate.feature",
        //,"src/test/resources/features/GoogleSearch.feature" },  // Path to feature files
        glue = "com.kun.cucumbertest.steps.LoginValidateSteps",       // Path to step definition classes
        plugin = {
                "pretty",                            // Console output
                "html:target/cucumber-reports.html",      // HTML report
                "json:target/cucumber.json",  // JSON report
                "junit:target/cucumber.xml" // XML report
        }
        //LoginValidate.feature
)
public class TestRunner {
}
