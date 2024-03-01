package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {".//FeatureFiles"},
		glue="stepDefinitions",
		plugin= {"pretty","html:reports/myreports.html",
				 "rerun:target/rerun.txt",
			 	 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				},
		
		
		dryRun=false,
		monochrome=true,
		publish=true
		)
public class TestRun {

}
