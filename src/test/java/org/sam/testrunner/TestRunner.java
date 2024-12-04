package org.sam.testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src//test/resources/Feature"
        ,glue={"org.sam.stepdefinition"}
)


public class TestRunner {
}
