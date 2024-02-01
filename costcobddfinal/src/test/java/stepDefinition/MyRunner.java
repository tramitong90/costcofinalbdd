package stepDefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = {"stepDefinition"} , 
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"} , publish = false,
monochrome = true, //display the console output in a proper readable format
strict = true,
dryRun = false
)

public class MyRunner {

}
