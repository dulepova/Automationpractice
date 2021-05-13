package tests;

import io.qameta.allure.Description;
import models.User;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.Retry;
import utils.data.TestDataGenerator;

public class OrderTest extends BaseTest {
    User registeredUser = TestDataGenerator.getRegisteredUser();

    @Test(retryAnalyzer = Retry.class)
    @Description("Checkout process")
    public void orderAndPayment() {
        orderSteps
                .openPage()
                .login(registeredUser)
                .addProductToCart("Blouse", 2)
                .proceedToCheckout()
                .submitSummary()
                .checkDeliveryAddressInfo(registeredUser)
                .submitAddress()
                .acceptTermsOfService()
                .submitShipping()
                .payByBankWire()
                .confirmOrder()
                .checkOrderSuccessful();
    }
}
