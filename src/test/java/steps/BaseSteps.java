package steps;

import pages.*;

public class BaseSteps {

    LoginPage loginPage;
    AccountPage accountPage;
//    HomePage homePage;
//    SearchResultPage searchResultPage;
    CreateAccountPage createAccountPage;
//    ProductPage productPage;
//    OrderPage orderPage;

    public BaseSteps() {

        loginPage = new LoginPage();
//        homePage = new HomePage();
//        searchResultPage = new SearchResultPage();
        createAccountPage = new CreateAccountPage();
        accountPage = new AccountPage();
//        productPage = new ProductPage();
//        orderPage = new OrderPage();
    }
}
