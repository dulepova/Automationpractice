package steps;

import io.qameta.allure.Step;
import models.User;

import static org.testng.Assert.assertEquals;

public class LoginSteps extends BaseSteps {
    @Step("Open SignIn page")
    public LoginSteps openPage() {
        loginPage.openPage();
        return this;
    }

    @Step("Fill SignIn Data")
    public LoginSteps fillSignIn(User user) {
        loginPage.setEmail(user.getEmail()).setPassword(user.getPassword());
        return this;
    }

    @Step("Click SignIn button")
    public LoginSteps clickSignInButton() {
        loginPage.clickLoginButton();
        return this;
    }

    @Step("Check Login successful")
    public void checkLoginSuccessful() {
        loginPage.signInSuccessful();
    }

    @Step("Check not-successful Login error message")
    public void checkNotSuccessfulLogin() {
        loginPage.isErrorSectionVisible();
    }
}
