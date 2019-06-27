package Runners;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/resources/java/Features", glue = "Steps",tags = { "" })
public class Runner extends AbstractTestNGCucumberTests {


	@BeforeSuite
	public void beforeSuite() throws Exception {

	}

	@BeforeClass
	public void beforClass() throws IOException {

	}

	@BeforeMethod
	public void beforMethod() throws IOException {

	}

	@AfterClass()
	public void afterTest() {

	}

	@AfterSuite
	public void afterSuite() {

	}

}
