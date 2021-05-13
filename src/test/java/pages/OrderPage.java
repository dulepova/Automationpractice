package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class OrderPage extends BasePage {
    private static final String URL = "http://automationpractice.com/index.php?controller=order";
    private static final By ADDRESS_NAME_TEXT = By.xpath("//li[@class='address_firstname address_lastname']");
    private static final By ADDRESS_STREET_TEXT = By.xpath("//li[@class='address_address1 address_address2']");
    private static final By ADDRESS_PHONE_TEXT = By.xpath("//li[@class='address_phone_mobile']");
    private static final By SUBMIT_SUMMARY_BUTTON = By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']");
    private static final By SUBMIT_ADDRESS_BUTTON = By.name("processAddress");
    private static final By CGV_CHECKBOX = By.id("cgv");
    private static final By SUBMIT_SHIPPING_BUTTON = By.name("processCarrier");
    private static final By PAY_BY_BANK_WIRE_BUTTON = By.className("bankwire");
    private static final By CONFIRM_ORDER_BUTTON = By.xpath("//button[@class='button btn btn-default button-medium']");
    private static final By ORDER_SUCCESSFUL_TEXT = By.xpath("//div[@class='box']//strong[@class='dark']");

    @Step("Get Address Name")
    public String getAddressName() {
        String result = $(ADDRESS_NAME_TEXT).text().trim();
        log.info("Address Name: " + result);
        return result;
    }

    @Step("Get Address street")
    public String getAddressStreet() {
        String result = $(ADDRESS_STREET_TEXT).text().trim();
        log.info("Address street: " + result);
        return result;
    }


    @Step("Get Address Phone")
    public String getAddressPhone() {
        String result = $(ADDRESS_PHONE_TEXT).text().trim();
        log.info("Address Phone: " + result);
        return result;
    }

    @Step("Click Proceed to Checkout(Summary) button")
    public void clickProceedToCheckoutSummaryButton(){
        $(SUBMIT_SUMMARY_BUTTON).click();
        log.info("Click Proceed to Checkout(Summary) button");
    }
    @Step("Click Proceed to Checkout(Address) button")
    public void clickProceedToCheckoutAddressButton(){
        $(SUBMIT_ADDRESS_BUTTON).click();
        log.info("Click Proceed to Checkout(Address) button");
    }

    @Step("Set CGV checkbox")
    public void setCgvCheckbox() {
        $(CGV_CHECKBOX).click();
        log.info("Set CGV checkbox");
    }
    @Step("Click Proceed to Checkout(Shipping) button")
    public void clickProceedToCheckoutShippingButton(){
        $(SUBMIT_SHIPPING_BUTTON).click();
        log.info("Click Proceed to Checkout(Shipping) button");
    }

    @Step("Click Pay by Bank Wire button")
    public void clickPayByBankWireButton() {
        $(PAY_BY_BANK_WIRE_BUTTON).click();
        log.info("Click Pay by Bank Wire button");
    }

    @Step("Click Confirm Order button")
    public void clickConfirmOrderButton() {
        $(CONFIRM_ORDER_BUTTON).click();
        log.info("Click Confirm Order button");
    }

    @Step("Get Order Successful text")
    public String getOrderSuccessfulText() {
        return $(ORDER_SUCCESSFUL_TEXT).text().trim();
    }
}
