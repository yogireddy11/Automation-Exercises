package baseTestPack;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;
import utilities.DriverFactory;

public class BaseTest {

    public WebDriver driver;
    public LoginPage loginPage;
    @BeforeClass
    public void setup(){
        driver = DriverFactory.intiBrowser();
         loginPage = new LoginPage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }



}
