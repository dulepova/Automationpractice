package tests;

import io.qameta.allure.Description;
import models.User;
import org.testng.annotations.Test;
import utils.Retry;
import utils.data.TestDataGenerator;

public class CreateAccountTest extends BaseTest {
    User newUser = TestDataGenerator.getNewValidUser();
    User registeredUser = TestDataGenerator.getRegisteredUser();

    @Test(retryAnalyzer = Retry.class)
    @Description("Creation New User With Valid Data")
    public void createNewAccount() {
        createAccountSteps
                .openPage(newUser.getEmail())
                .fillRegisterData(newUser)
                .register()
                .checkRegistrationSuccessful(newUser);
    }

    @Test(retryAnalyzer = Retry.class)
    @Description("Create Account Without Email")
    public void createAccountWithoutEmailError() {
        createAccountSteps
                .openPage(" ")
                .createAccountWithoutEmail();
    }

    @Test(retryAnalyzer = Retry.class)
    @Description("Create Account with already registered email")
    public void createNewUserWithRegisteredEmail() {
        createAccountSteps
                .openPage(registeredUser.getEmail())
                .createRegisteredEmail();
    }
}
