package listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class Screenshot {

    public static String takeScreenshot(WebDriver driver, String testName) {


        String directoryPath;
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);

            directoryPath = System.getProperty("user.dir") + "/screenshots/" + testName;
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            String fileName = "Screenshot_" + System.currentTimeMillis() + ".png";
            File destination = new File(directory, fileName);

            FileHandler.copy(source, destination);

            System.out.println("📸 Screenshot saved at: " + destination.getAbsolutePath());

        } catch (IOException e) {
            throw new RuntimeException("Failed to capture screenshot", e);
        }
        return directoryPath;
    }
}
