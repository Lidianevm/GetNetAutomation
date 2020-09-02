package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/Features"},
        glue = {"TestSteps"},
        plugin = {"pretty", "html:target/report-html/cucumber.html"},
        tags = "@TotalTest",
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class RunCucumberTest {

}
