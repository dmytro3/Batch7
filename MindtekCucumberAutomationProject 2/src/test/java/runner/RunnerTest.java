package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","json:target/cucumber.json"}, //extra cucumber plugins
        features = "src/test/resources/features", // path for feature files
        glue = "steps", // providing path for the .feature file steps code definition
        tags = "@RTB-99", // running specific feature or scenario by tag(s). Can do with "and" "or" condition
        dryRun = false // true = run only undefined steps in .feature file
)

public class RunnerTest {


}
