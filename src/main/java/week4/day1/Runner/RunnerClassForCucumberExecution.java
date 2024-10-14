package week4.day1.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = {"src/main/java/week4/day1/features/incident.feature"},
		glue = {"week4/day1/stepDefinition"},
		dryRun = false,
		monochrome = true,
		plugin = {"html:reports/result.html","pretty"}
		)

public class RunnerClassForCucumberExecution extends AbstractTestNGCucumberTests {

}
