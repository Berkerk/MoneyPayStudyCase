package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import util.DriverFactory;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"stepDefinations","util"},
        tags = "",
        plugin = {
                "summary","pretty","html:Reports/CucumberReport/Reports.html",
                "json:Reports/CucumberReport/Reports.json"
        }
)

public class Runner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios(){
        return super.scenarios();
    }
    static WebDriver driver = DriverFactory.getDriver();


}
