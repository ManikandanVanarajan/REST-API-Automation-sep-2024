package week4.day2.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
					features = {"src/main/java/week4/day2/features/incident3.feature"},
					glue = "week4/day2/stepDefinitions",
					dryRun = false,
					monochrome = true,
					plugin = {"html:reports/result.html",
							  "pretty",
							  "rerun:failed-test.txt"
							  }			
		
				)


public class IncidentTestRunner3 extends AbstractTestNGCucumberTests{
	
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
		
	}
}
