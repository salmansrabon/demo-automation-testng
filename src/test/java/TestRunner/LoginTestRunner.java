package TestRunner;

import Pages.Login;
import Setup.Setup;
import Utils.Utils;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestRunner extends Setup {
    @Test(groups = "Login")
    public void doUserLogin() throws InterruptedException, IOException, ParseException {
        Login login = new Login(driver);
        driver.get("http://automationpractice.com");
        Utils utils = new Utils(driver);
        utils.readJSONArray(0);
        String username = login.doLogin(utils.getEmail(), utils.getPassword());
        Assert.assertTrue(username.contains("Test User"));
    }
    @Test
    public void loginWithInvalidEmail() throws InterruptedException, IOException, ParseException {
        Login login = new Login(driver);
        driver.get("http://automationpractice.com");
        Utils utils = new Utils(driver);
        utils.readJSONArray(1);
        String errorMessage = login.loginWithInvalidEmail(utils.getEmail(), utils.getPassword());
        Assert.assertTrue(errorMessage.contains("Invalid email address"));
    }
    @Test
    public void loginWithWrongPassword() throws InterruptedException, IOException, ParseException {
        Login login = new Login(driver);
        driver.get("http://automationpractice.com");
        Utils utils = new Utils(driver);
        utils.readJSONArray(2);
        String errorMessage = login.loginWithInvalidPassword(utils.getEmail(), utils.getPassword());
        Assert.assertTrue(errorMessage.contains("Authentication failed"));
    }
}
