package steps;

import io.qameta.allure.Step;
import models.User;

import static org.testng.Assert.assertEquals;

public class CreateAccountSteps extends BaseSteps {
    @Step("Open Create Account page")
    public CreateAccountSteps openPage(String email) {
        loginPage
                .openPage()
                .setEmailCreate(email)
                .clickCreateAccountButton();
        return this;
    }

    @Step("Click Register Button")
    public CreateAccountSteps register() {
        createAccountPage.clickRegisterButton();
        return this;
    }

    @Step("Fill Registration data")
    public CreateAccountSteps fillRegisterData(User user) {
        createAccountPage
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setPassword(user.getPassword())
                .setAddress(user.getAddress())
                .setCity(user.getCity())
                .setState(user.getState())
                .setPostalCode(user.getPostalCode())
                .setPhone(user.getPhone());
        return this;
    }

    @Step("Check Registration successful")
    public void checkRegistrationSuccessful(User user) {
        assertEquals(accountPage.getHeadingUserName(), user.getFirstName() + " " + user.getLastName());
    }

    @Step("Check Registration error")
    public void createAccountWithoutEmail() {
        createAccountPage.createAccountError();
    }

    @Step("Check error Registered user")
    public void createRegisteredEmail() {
        createAccountPage.createRegisteredUserError();
    }
}
