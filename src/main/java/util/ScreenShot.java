package util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenShot {
    public static byte[] captureScreenshot(WebDriver driver) {
        if (driver instanceof TakesScreenshot) {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
        return null;
    }

    public static void saveScreenshot(byte[] screenshot, String filePath) {
        try {
            Path path = Paths.get(filePath);
            Files.write(path, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
