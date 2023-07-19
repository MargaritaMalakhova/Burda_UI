package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static pages.LoginPage.openLoginPage;

public class WebTests extends TestBase {
    String email = "draizermargot@yandex.ru";
    String password = "Pdtpljxrf12345";
    String userProfileInformation = "Margot Draiser\n" + "draizermargot@yandex.ru\n";
    String userFirstName = "Margot";
    String userLastName = "Draiser";
    String textForCheckInPDF = "burda style 04";
    String randomUserFirstName = randomUtils.createRandomFirstName();
    String randomUserLastName = randomUtils.createRandomLastName();
    public static String PRODUCT_NAME_FOR_ADD_TO_CART = "Cotton Hair Wrap 134";
    public static String PRODUCT_NAME_TO_BUY = "Cotton Cosmetics Bag 135";


    @Test
    @DisplayName("Positive Login test")
    void positiveLoggin() {
        openLoginPage()
                .acceptCookies()
                .successfulLogin(email, password);
        profilePage.verifyUserInformation(userProfileInformation);
    }

    @Test
    @DisplayName("Negative Login test")
    void negativeLoggin() {

        openLoginPage()
                .acceptCookies()
                .unsuccessfulLogin(email)
                .checkMessageUnsuccessfulLogin();
    }

    @Test
    @DisplayName("DownLoad PDF test")
    // TODO: переделать с учетом того, что в разделе может быть много файлов для скачивания
    void positiveDownloadFile() throws Exception {
        open("https://www.burdastyle.com/customer/account/login");
//        loginPage.acceptCookies()
//                .setEmailInput(email)
//                .setPasswordInput(password)
//                .clickOnLoginButton();
        profilePage.verifyUserInformation(userProfileInformation);

        $$("li.nav").findBy(Condition.text("My Downloadable Products")).click();
        downloadableProductsPage.downloadFile();
        downloadableProductsPage.createPDF();
        downloadableProductsPage.checkPDF(textForCheckInPDF);
    }

    @Test
    @DisplayName("Change user profile test")
    void changeUserProfile() {
        open("https://www.burdastyle.com/customer/account/login");
//        loginPage.acceptCookies()
//                .setEmailInput(email)
//                .setPasswordInput(password)
//                .clickOnLoginButton();
        profilePage.verifyUserInformation(userProfileInformation);

        profilePage.changeUserName(randomUserFirstName, randomUserLastName)
                .verifyUserInformation(randomUserFirstName + " " + randomUserLastName+ "\n" + email)
                .changeBackUserName(userFirstName, userLastName);
    }
    @Test
    @DisplayName("Add pattern to cart test")
    void addToCartTest() {
        open("https://www.burdastyle.com/customer/account/login");
//        loginPage.acceptCookies()
//                .setEmailInput(email)
//                .setPasswordInput(password)
//                .clickOnLoginButton();
        profilePage.verifyUserInformation(userProfileInformation);

        $x("//a[@title='Sewing patterns']").hover();
        $x("//a[@title='Free sewing patterns']").should(Condition.appear).click();
        $x("//a[contains(text(),'"+ PRODUCT_NAME_FOR_ADD_TO_CART +"')]").click();
        $x("//button[@title='Add to Cart']").should(Condition.appear).click();
        $x("//div[@data-bind='html: message.text']").should(Condition.appear);
        $x("//a[text()='cart']").click();
        $("div.cart-container").shouldHave(Condition.text(PRODUCT_NAME_FOR_ADD_TO_CART));
        cartPage.deleteItemInCart();
    }
    @Test
    @DisplayName("Buy pattern test")
    void buyPatternTest() {
        open("https://www.burdastyle.com/customer/account/login");
//        loginPage.acceptCookies()
//                .setEmailInput(email)
//                .setPasswordInput(password)
//                .clickOnLoginButton();
        profilePage.verifyUserInformation(userProfileInformation);

        $x("//a[@title='Sewing patterns']").hover();
        $x("//a[@title='Free sewing patterns']").should(Condition.appear).click();
        sewingPatternsPage.clickOnProduct();
        productPage.addProductToCart();
        productPage.moveToCart();
        cartPage.checkProductInCart(PRODUCT_NAME_TO_BUY);
        cartPage.clickOnCheckout();
        $x("//*[@id=\"agreement_free_5\"]").click();
        $x("//button[@title='Place Order']").should(Condition.appear).click();
    }


}
