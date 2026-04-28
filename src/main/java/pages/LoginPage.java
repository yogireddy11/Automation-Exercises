package pages;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BaseClass {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToURL(String url) {
        driver.get(url);
    }

    public String getNaviagtedURL() {
        return driver.getCurrentUrl();
    }

    By loginSignup = By.xpath("//*[text()=' Signup / Login']");
    By emailAddress = By.xpath("(//input[@name=\"email\"])[1]");
    By password = By.xpath("(//input[@name=\"password\"])[1]");
    By submit = By.xpath("//button[text()='Login']");

    public void navigateToLoginPage() {
        //sleepTime(2500);
        jsClick(driver.findElement(loginSignup));
    }


    public void loginCredentials(String email, String pass) {
        sendText(driver.findElement(emailAddress), email);
        sendText(driver.findElement(password), pass);
        jsClick(driver.findElement(submit));
    }

    By verifyLogin = By.xpath("//*[contains(text(),' Logged in as')] ");

    public boolean verifyLoginSuccesfull() {

        waitForElement(driver.findElement(verifyLogin));
        WebElement loginText = driver.findElement(verifyLogin);
        System.out.println(loginText.getText());
        return loginText.isDisplayed();

    }

    private void sleepTime(int time) {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
