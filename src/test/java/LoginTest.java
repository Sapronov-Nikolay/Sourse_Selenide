import locators.LoginPageLocators;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LoginTest {
    
    @Test
    public void loginTest() {
        try {
            open("https://www.saucedemo.com");
            $(LoginPageLocators.USERNAME_FIELD).setValue("standard_user");
            $(LoginPageLocators.PASSWORD_FIELD).setValue("secret_sauce");
            $(LoginPageLocators.LOGIN_BUTTON).click();
            $(LoginPageLocators.PRODUCTS_TITLE).shouldHave(text("Products"));
        } finally {
            closeWebDriver();
        }
    }
}
