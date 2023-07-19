package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.w3c.dom.Text;

import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {
    SelenideElement userProfileInformationField = $("div.box-information p"),
                    profileEditIcon = $("div.box-actions > a:nth-child(1)"),
                    userFirstNameInput = $("input#firstname"),
                    userLastNameInput = $("input#lastname"),
                    saveButton = $("button.save");

    public ProfilePage verifyUserInformation(String userProfileName) {
        userProfileInformationField.shouldHave(Condition.text(userProfileName));

        return this;
    }

    public ProfilePage changeUserName(String randomUserFirstName, String randomUserLastName) {
        profileEditIcon.click();
        userFirstNameInput.clear();
        userFirstNameInput.setValue(randomUserFirstName);
        userLastNameInput.clear();
        userLastNameInput.setValue(randomUserLastName);
        saveButton.click();

        return this;
    }

    public ProfilePage changeBackUserName(String userFirstName, String userLastName) {
        profileEditIcon.click();
        userFirstNameInput.clear();
        userFirstNameInput.setValue(userFirstName);
        userLastNameInput.clear();
        userLastNameInput.setValue(userLastName);
        saveButton.click();

        return this;
    }
}
