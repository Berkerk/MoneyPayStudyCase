package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    static WebDriver driver;
    static Properties properties;


    public static WebDriver initiliaze_Driver(String browser){
        properties = ConfigReader.getProperties();
        if(browser.equals("Chrome")){
            WebDriverManager.chromedriver().setup();
           ChromeOptions op = new ChromeOptions();
            op.addArguments("--remote-allow-origins=*");
            op.addArguments("--start-maximized");
            driver = new ChromeDriver(op);
        } else if (browser.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions fo = new FirefoxOptions();
            fo.setBinary("/Applications/Firefox.app/Contents/MacOS/firefox");
            driver= new FirefoxDriver(fo);
            driver.manage().window().maximize();
        }
        else{
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        String url = properties.getProperty("url");
        int pagewait = Integer.parseInt(properties.getProperty("pageLoadTimeout"));
        driver.get(url);

        driver.manage().timeouts().pageLoadTimeout(pagewait, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(pagewait,TimeUnit.SECONDS);

        return getDriver();
    }

    public static WebDriver getDriver(){
        return driver;
    }

}
