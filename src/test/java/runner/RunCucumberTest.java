package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {
                "pretty",
                "json:target/reports/cucucmberReport.json",
                "html:target/reports/cucucmberReport.html"
        },
        features = "src/test/resources/feature",
        glue = "steps",
        tags = "@Cadastro"
)
public class RunCucumberTest extends RunBase {

    @AfterClass
    public static void stop() {
        driver.quit();
    }
}
