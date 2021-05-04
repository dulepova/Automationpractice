package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class SignInPage extends BasePage{
    private static final String URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    private static final By ERROR_SIGN_IN = By.xpath("//div['Authentication failed.']//ol//li");
    private static final By ERROR_LIST = By.xpath("//div[@class='alert alert-danger']");
    private static final By EMAIL_CREATE_INPUT = By.id("email_create");
    private static final By CREATE_ACCOUNT_BUTTON = By.id("SubmitCreate");
    private static final By EMAIL_INPUT = By.id("email");
    private static final By PASSWORD_INPUT = By.id("passwd");
    private static final By LOGIN_BUTTON = By.id("SubmitLogin");
    private static final By MY_ACCOUNT = By.className("navigation_page");

    public SignInPage openPage() {
        open(URL);
        return this;
    }

    public SignInPage setEmail(String email) {
        $(EMAIL_INPUT).scrollTo().sendKeys(email);
        return this;
    }

    public SignInPage setPassword(String password) {
        $(PASSWORD_INPUT).sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        $(LOGIN_BUTTON).click();
    }

    public SignInPage setEmailCreate(String email) {
        $(EMAIL_CREATE_INPUT).sendKeys(email);
        return this;
    }

    public SignInPage clickCreateAccountButton() {
        $(CREATE_ACCOUNT_BUTTON).click();
        return new SignInPage();
    }

    public String getCreateErrorText() {
        return $$(ERROR_LIST).first().text();
    }
    public SignInPage isErrorSectionVisible() {
        $(ERROR_SIGN_IN).shouldBe(Condition.visible);
        return this;
    }
    public SignInPage signInSuccessful() {
        $(MY_ACCOUNT).shouldBe(Condition.visible);
        return this;
    }
}
