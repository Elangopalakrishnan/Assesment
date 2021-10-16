package testRunners;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
			features = {"src/test/java/webAppTestFeatures"},
			glue = {"stepDefinitions", "MyHooks"},
			tags = "@SmokeTests and @AddCart",
			plugin = {"pretty",
					"json:target/MyReports/report.json",
					"junit:target/MyReports/report.xml",
					"html:target/MyReports/report.html",},
			monochrome = false, //Since cucumber itslef giving colorful logs :)
			//publish = true //Publishing reports on Cloud
			dryRun = false
		)

public class Runner {
	
	

}
