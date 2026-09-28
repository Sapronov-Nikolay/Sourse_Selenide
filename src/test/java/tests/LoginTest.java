package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    
    @Test
    public void loginTest() {
        new LoginPage()
            .enterUsername("standard_user")
            .enterPassword("secret_sauce")
            .clickLogin()
            .checkProductsPageOpened();
    }
}
