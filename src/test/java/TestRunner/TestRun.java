package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {".//FeatureFiles"},  //all features files executed
		glue="stepDefinitions",  //to specify package name...glue-gerkin keyword
		plugin= {"pretty","html:reports/myreports.html",
				 "rerun:target/rerun.txt", //to rerun failure test
			 	 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				},  //to generate extent report
		//to generate reports and executing failure scenarios
		
		
		dryRun=false, 
		//to verify every step in the scenario is having corresponding method in the step definition or not
		//when dryRun=true,actual execution willnot happen,only the association will check(only check mapping),, false will check execution also
		monochrome=true,
		//to avoid junk characters in output
		publish=true //it publish report to the cucumber server,false it wont 
		)
public class TestRun {

}
