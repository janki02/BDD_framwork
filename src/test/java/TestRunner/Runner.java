package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)

@CucumberOptions(features = "{/BDDFramework/src/test/resources/Features}", 
glue = "Stepdefination", 
plugin = { "pretty","html:target/htmlReport.htmal" })

public class Runner extends AbstractTestNGCucumberTests {
}
