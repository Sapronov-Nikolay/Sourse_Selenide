package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;
import static com.codeborne.selenide.Selenide.open;


/** Базовый класс для всех тестов. Настройка и закрытие браузера. */
public abstract class BaseTest {
    
    @BeforeMethod
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.headless = true;
        Configuration.baseUrl = "https://www.saucedemo.com";
        Configuration.timeout = 15000;
        
        // Отключение менеджера паролей Chrome, (чтобы всплывающее окно не всплывало)
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        open("/");
    }
    
    @AfterMethod
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
