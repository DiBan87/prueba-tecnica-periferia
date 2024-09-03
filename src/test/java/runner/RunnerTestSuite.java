package runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features ="src/test/resources/features/",
        glue = "stepdefinations",
        tags = "@FrameAndForm"
)

public class RunnerTestSuite {
    @BeforeClass
    public static void setUp() {
        OnStage.setTheStage(new OnlineCast());
    }

}
