package cucumber.kata;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Shane Hayes on 3/5/14.
 */
@RunWith(Cucumber.class)
@Cucumber.Options(format = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber-json-report.json"})
public class RunCukesTest {
}
