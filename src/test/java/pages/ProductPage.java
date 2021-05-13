package pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class ProductPage extends BasePage {
    private static final By ADD_TO_CART_BUTTON = By.xpath("//div[@class='box-cart-bottom']//button[@name='Submit']//span");
    private static final By REMOVE_FROM_CART_BUTTON = By.className("icon-trash");
    private static final By CART_QUANTITY_TEXT = By.id("summary_products_quantity");
    private static final By QUANTITY_INPUT = By.id("quantity_wanted");
    private static final By CLOSE_POP_UP_BUTTON = By.className("cross");
    private static final By PROCEED_TO_CHECKOUT_BUTTON = By.xpath("//*[@title='Proceed to checkout']//span");
    private static final By SHOPPING_CART_BLOCK = By.className("shopping_cart");
    private static final By MESSAGE_EMPTY_CART = By.xpath("//*[text()='Your shopping cart is empty.']");

    @Step("Set Product quantity: {productQuantity}")
    public ProductPage setProductQuantity(int productQuantity) {
        $(QUANTITY_INPUT).clear();
        $(QUANTITY_INPUT).sendKeys(Integer.toString(productQuantity));
        log.info("Set Product quantity: " + productQuantity);
        return this;
    }

    @Step("Click Add to Cart button")
    public ProductPage clickAddToCartButton() {
        $(ADD_TO_CART_BUTTON).click();
        log.info("Click Add to Cart button");
        return this;
    }

    @Step("Click Proceed to checkout button")
    public ProductPage clickProceedToCheckoutButton() {
        $(PROCEED_TO_CHECKOUT_BUTTON).click();
        log.info("Click Proceed to checkout button");
        return this;
    }

    @Step("Get Cart Quantity")
    public String getCartQuantity() {
        String cartQuantity = $(CART_QUANTITY_TEXT).text();;
        log.info("Cart Quantity: " + cartQuantity);
        return cartQuantity;
    }

    @Step("Click Remove Product from Cart button")
    public ProductPage clickRemoveProductFromCartButton() {
        $(SHOPPING_CART_BLOCK).hover();
        $(REMOVE_FROM_CART_BUTTON).waitUntil(Condition.visible, 5000).click();
        log.info("Click Remove Product form Cart button");
        return this;
    }

    public ProductPage getMessageShoppingCartIsEmpty() {
        $(MESSAGE_EMPTY_CART).shouldBe(Condition.visible);
        return this;
    }

    public ProductPage clickAddToCart() {
        $(ADD_TO_CART_BUTTON).click();
        return this;
    }
}
