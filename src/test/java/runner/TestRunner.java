package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "C:/Users/carlo/Desktop/Desafio/ScheduleAutomation/src/test/resources/features",
        tags = "@mainFlow",
        glue = ""
)

public class TestRunner extends AbstractTestNGCucumberTests {
}
