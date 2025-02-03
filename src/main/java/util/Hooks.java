package util;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Hooks {

    WebDriver driver;
    Properties properties;

    @Before
    public void before(){
        String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
        properties = ConfigReader.initialize_Properties();
        driver = DriverFactory.initiliaze_Driver(browser);
    }

    @After
    public void after(Scenario scenario){
        if(scenario.isFailed()){
            captureScreenShoot(scenario);
        }
        String reportname = generateUniqueReportName();
        renameReportFile(reportname);

        // Close the browser
        if (driver != null) {
            driver.quit();
        };
    }


    private void captureScreenShoot(Scenario scenario){
        if (scenario.isFailed()) {
            // Capture screenshot
            byte[] screenshot = ScreenShot.captureScreenshot(driver);

            // Attach screenshot to the Cucumber report
            if (screenshot != null) {
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
        }
    }

    private String generateUniqueReportName() {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return "cucumber-report_" + timeStamp + ".html";
    }

    private void renameReportFile(String newFileName) {
        File defaultReportFile = new File("Reports/CucumberReport/Reports.html");
        File newReportFile = new File("Reports/CucumberReport/" + newFileName);

        if (defaultReportFile.exists()) {
            boolean renamed = defaultReportFile.renameTo(newReportFile);
            if (renamed) {
                System.out.println("Report file renamed to: " + newFileName);
            } else {
                System.out.println("Failed to rename report file.");
            }
        } else {
            System.out.println("Default report file not found.");
        }
    }


}
