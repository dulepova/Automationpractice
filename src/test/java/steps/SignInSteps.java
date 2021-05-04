package steps;
import io.qameta.allure.Step;
import models.User;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;

public class SignInSteps extends BaseSteps{
    @Step("Open SignIn page")
    public SignInSteps openPage() {
        signInPage.openPage();
        return this;
    }

    @Step("Fill SignIn Data")
    public SignInSteps fillSignIn(User user) {
        signInPage.setEmail(user.getEmail()).setPassword(user.getPassword());
        return this;
    }

    @Step("Click SignIn button")
    public SignInSteps clickSignInButton() {
        signInPage.clickLoginButton();
        return this;
    }

    @Step("Check Login successful")
    public void checkLoginSuccessful() {
        signInPage.signInSuccessful();
    }

    @Step("Check not-successful Login error message")
    public void checkNotSuccessfulLogin() {
        signInPage.isErrorSectionVisible();
    }
}
