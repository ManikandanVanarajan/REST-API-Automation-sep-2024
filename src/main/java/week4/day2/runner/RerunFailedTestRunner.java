package week4.day2.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = {"@failed-test.txt"},
		glue = "week4/day2/stepDefinitions",
		dryRun = false,
		monochrome = true,
		plugin = {"html:reports/result.html",
				  "pretty",
				  "rerun:failed-test.txt"
				  }
				
		)



public class RerunFailedTestRunner extends AbstractTestNGCucumberTests{

}
