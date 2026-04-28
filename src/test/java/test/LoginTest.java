package test;

import baseTestPack.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigData;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {


    @Test(priority = 1)
    public void openApplication(){
        loginPage.navigateToURL(ConfigData.getConfig("baseurl"));
        assertEquals(loginPage.getNaviagtedURL(),"https://automationexercise.com/");
    }

    @Test(priority = 2)
    public void openLoginPage(){
        loginPage.navigateToLoginPage();
    }

    @Test(priority = 3)
    public void submitLogin(){
        loginPage.loginCredentials(ConfigData.getConfig("emailAddress"),ConfigData.getConfig("password"));
    }
    @Test(priority = 4)
    public void verifyLoginPage(){
        assertTrue(loginPage.verifyLoginSuccesfull());
    }
}
