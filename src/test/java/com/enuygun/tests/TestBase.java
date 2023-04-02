package com.enuygun.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.enuygun.utilities.BrowserUtils;
import com.enuygun.utilities.ConfigurationReader;
import com.enuygun.utilities.Driver;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IReporter;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
   protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest extentLogger;

    @BeforeTest
    public void setUpTest(){
        //initialize the class
        report = new ExtentReports();

        //create a report path
        String projectPath = System.getProperty("user.dir");
        //to take dynamic report
        // String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // String reportPath = projectPath + "/test-output/report"+date+".html";
        String reportPath = projectPath + "/test-output/report.html";

        //initialize the html report with the reportPath
        htmlReporter = new ExtentHtmlReporter(reportPath);

        //attach the html report to the report object
        report.attachReporter(htmlReporter);

        //title in report
        htmlReporter.config().setReportName("Batch 3 Smoke Test");

        report.setSystemInfo("Environment", "Test");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer", "Eren");
    }

    @AfterTest
    public void tearDownTest(){
        report.flush();
    }

    @BeforeMethod
    public void setUp(){
        driver= Driver.get();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        wait=new WebDriverWait(driver, 7);
        actions= new Actions(driver);

    }
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if(result.getStatus()==ITestResult.FAILURE){
            extentLogger.fail(result.getName());
            String screenShotPath= BrowserUtils.getScreenshot(result.getName());
            extentLogger.addScreenCaptureFromPath(screenShotPath);
            extentLogger.fail(result.getThrowable());
        }
        //Driver.closeDriver();
    }

}
