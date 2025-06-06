package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import utils.PropReader;

import java.io.IOException;

public class LoginTest extends BaseTest {

    Login login;


    @BeforeClass
    public void initializeLogin() {
        login = new Login(driver);
    }


    @Test(priority = 1)
    public void testLogin() throws IOException, InterruptedException {
        driver.get(PropReader.getProp("loginURL"));
        test.info("Performing login");

        performLogin();
        test.pass("Logged in successfully");
    }


    @Test(priority = 2, dependsOnMethods = "testLogin")
    public void logoutAndLogin() throws IOException, InterruptedException {
        test.info("Logging out and performing login again");

        login.clickLogoutBtn();
        test.pass("Logged out ");
        Thread.sleep(1000);

        performLogin();
        test.pass("Re logged in successfully");
    }

    //helper login method
    public void performLogin() throws IOException {
        String mail = PropReader.getProp("mail");
        String pass = PropReader.getProp("pass");

        login.enterLoginMail(mail);
        login.enterLoginPass(pass);
        login.clickLoginBtn();
        login.checkFromLogin();
    }
}
