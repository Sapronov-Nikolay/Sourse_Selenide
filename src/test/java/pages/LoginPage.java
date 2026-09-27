package pages;

import com.codeborne.selenide.SelenideElement;
import locators.LoginPageLocators;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

//** Page Object страницы логина */
public class LoginPage {
    private final SelenideElement usernameField = $(LoginPageLocators.USERNAME_FIELD);
    private final SelenideElement passwordField = $(LoginPageLocators.PASSWORD_FIELD);
    private final SelenideElement loginButton = $(LoginPageLocators.LOGIN_BUTTON);
    private final SelenideElement errorMessage = $(LoginPageLocators.ERROR_MESSAGE);
    private final SelenideElement productsTitle = $(LoginPageLocators.PRODUCTS_TITLE);
    
    public LoginPage enterUsername(String username) {
        usernameField.setValue(username);
        return this;
    }
    
    public LoginPage enterPassword(String password) {
        passwordField.setValue(password);
        return this;
    }
    
    public LoginPage clickLogin() {
        loginButton.click();
        return this;
    }
    
    public LoginPage Login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
        return this;
    }
    
    public LoginPage checkProductsPageOpened() {
        productsTitle.shouldBe(visible).shouldHave(text("Products"));
        return this;
    }
    
    public LoginPage checkErrorText(String expectedText) {
        errorMessage.shouldBe(visible).shouldHave(text(expectedText));
        return this;
    }
}
