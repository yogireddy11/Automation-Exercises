package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class DriverFactory {

   private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();


    public static WebDriver intiBrowser() {
        String getBrowser = ConfigData.getConfig("browser");

        if (getBrowser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            driver.set(new ChromeDriver(options));
        } else if (getBrowser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
           options.addArguments("--headless=new");
            driver.set(new FirefoxDriver(options));
        } else if (getBrowser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--headless=new");
            driver.set(new EdgeDriver(options));
        }

        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get().manage().deleteAllCookies();

        return driver.get();
    }
}
