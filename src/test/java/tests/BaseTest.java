package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.PropertyReader;
import java.util.HashMap;
import java.util.Map;
import static com.codeborne.selenide.Selenide.open;


/** Базовый класс для всех тестов. Настройка и закрытие браузера. */
public abstract class BaseTest {
    
    @BeforeMethod
    public void setUp() {
        // 1. Настройки Selenide — читаем из config.properties
        Configuration.browser = PropertyReader.getProperty("chrome");
        Configuration.headless = Boolean.parseBoolean(PropertyReader.getProperty("headless"));
        Configuration.baseUrl = PropertyReader.getProperty("base.url");
        Configuration.timeout = Long.parseLong(PropertyReader.getProperty("timeout"));
        
        // 2. Отключение менеджера паролей Chrome, (чтобы всплывающее окно не всплывало)
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        
        // 3. Передаём options в Selenide
        Configuration.browserCapabilities = options;
        open("/");
    }
    
    @AfterMethod
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
