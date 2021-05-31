package tests;

import io.qameta.allure.Description;
import models.User;
import org.testng.annotations.Test;
import utils.Retry;
import utils.data.TestDataGenerator;

public class LoginTest extends BaseTest {
    User registeredUser = TestDataGenerator.getRegisteredUser();
    User newUser = TestDataGenerator.getNewValidUser();

    @Test(retryAnalyzer = Retry.class)
    @Description("SignIn with not registered User")
    public void signInNotRegisterUser() {
        loginSteps
                .openPage()
                .fillSignIn(newUser)
                .clickSignInButton()
                .checkNotSuccessfulLogin();
    }

    @Test
    public void signInRegisteredUser() {
        loginSteps
                .openPage()
                .fillSignIn(registeredUser)
                .clickSignInButton()
                .checkLoginSuccessful();
    }
}
