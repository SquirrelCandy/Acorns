package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		tags="@dropdown",								//Scenario @tags in feature file
		features="src/test/java/features/",				//feature files location
		glue= {"steps"},								//Step definition files location
		plugin= {"html:target/cucumber-report.html"})	//reporting plugin and output location
public class CucumberRunner {

}
