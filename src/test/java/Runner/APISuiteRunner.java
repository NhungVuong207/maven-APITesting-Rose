package Runner;


import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/java/Feature/DeleteBooking.feature",
        glue = "StepDefinations"
//        tags = "@7"
)

public class APISuiteRunner {
}
