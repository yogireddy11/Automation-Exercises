package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseClass {

    public WebDriver driver;
    public WebDriverWait driverWait;
    public JavascriptExecutor executor;

    public BaseClass(WebDriver driver){
        this.driver=driver;
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        executor = (JavascriptExecutor) driver;
    }

    public void click(WebElement element){
        driverWait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void jsClick(WebElement element){
        executor.executeScript("arguments[0].click();",element);
    }
    public void sendText(WebElement element, String text){
        driverWait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    public void scrollToElement(WebElement element){
        executor.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public void waitForElement(WebElement element){
        driverWait.until(ExpectedConditions.visibilityOf(element));
    }

}
