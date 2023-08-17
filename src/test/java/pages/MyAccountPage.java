package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MyAccountPage {
    private final SelenideElement userProfileInformationField = $("div.box-information p"),
            profileEditIcon = $("div.box-actions > a:nth-child(1)"),
            userFirstNameInput = $("input#firstname"),
            userLastNameInput = $("input#lastname"),
            saveButton = $("button.save");

    @Step("Open My Account Page")
    public void openMyAccountPage() {
        open("/customer/account/");
    }

    @Step("Check User Name and email")
    public MyAccountPage verifyUserInformation(String userProfileName) {
        userProfileInformationField.shouldHave(Condition.text(userProfileName));

        return this;
    }

    @Step("Change User's First Name and Last Name")
    public MyAccountPage changeUserName(String randomUserFirstName, String randomUserLastName) {
        profileEditIcon.click();
        userFirstNameInput.clear();
        userFirstNameInput.setValue(randomUserFirstName);
        userLastNameInput.clear();
        userLastNameInput.setValue(randomUserLastName);
        saveButton.click();

        return this;
    }

    @Step("Change back User's First Name and Last Name")
    public MyAccountPage changeBackUserName(String userFirstName, String userLastName) {
        profileEditIcon.click();
        userFirstNameInput.clear();
        userFirstNameInput.setValue(userFirstName);
        userLastNameInput.clear();
        userLastNameInput.setValue(userLastName);
        saveButton.click();

        return this;
    }
}
