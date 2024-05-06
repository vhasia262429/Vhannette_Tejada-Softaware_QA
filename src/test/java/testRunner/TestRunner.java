package testRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports/cucumber.html", "json:target/cucumber.json",
        },
        features = {"src/test/java/features"},
        glue = {"utility", "stepDefinitions"},
        monochrome = true

)
public class TestRunner {
}
