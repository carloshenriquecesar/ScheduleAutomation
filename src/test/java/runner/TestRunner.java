package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "C:/Users/carlo/Desktop/Desafio/ScheduleAutomation/src/test/resources/features",
        tags = "@mainFlow",
        glue = ""
)

public class TestRunner extends AbstractTestNGCucumberTests {
    //@DataProvider(parallel = true)
    @DataProvider(parallel = false)
    @Override
    public Object[][] scenarios(){
            return super.scenarios();
    }

}
