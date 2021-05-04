package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.*;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BaseTest {
    LoginSteps loginSteps;
    CreateAccountSteps createAccountSteps;
//    OrderSteps orderSteps;
//    CartSteps cartSteps;
//    SearchSteps searchSteps;


    @BeforeMethod
    public void setUp() {
        Configuration.clickViaJs = false;
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.startMaximized = true;
        Configuration.timeout = 5000;

        loginSteps = new LoginSteps();
        createAccountSteps = new CreateAccountSteps();
//        orderSteps = new OrderSteps();
//        cartSteps = new CartSteps();
//        searchSteps = new SearchSteps();
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (getWebDriver() != null)
            getWebDriver().quit();
    }
}
