import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LoginTest {
    
    @Test
    public void loginTest() {
        open("https://www.saucedemo.com");
        $("#user-name").setValue("standard_user");
        $("#password").setValue("secret_sauce");
        $("#login-button").click();
        $("[data-test='title']").shouldHave(text("Products"));
    }
}
