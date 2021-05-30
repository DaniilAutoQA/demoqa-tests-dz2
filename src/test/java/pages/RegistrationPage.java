package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            phoneInput = $("#userNumber"),
            pictureUpload = $("#uploadPicture"),
            subjectsInput = $("#subjectsInput"),
            hobbies = $("#hobbiesWrapper"),
            okButton = $("#submit")
    ;

    public RegistrationPage openForm(){
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage fillFirstName(String firstName){
        firstNameInput.val(firstName);
        return this;
    }

    public RegistrationPage fillLastName(String lastName){
        lastNameInput.val(lastName);
        return this;
    }

    public RegistrationPage fillEmail(String email){
        emailInput.val(email);
        return this;
    }

    public RegistrationPage selectGender(String gender){
        genderInput.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage fillPhone(String phone){
        phoneInput.val(phone);
        return this;
    }

    public RegistrationPage uploadPicture(String picture){
        pictureUpload.uploadFromClasspath(picture);
        return this;
    }

    public RegistrationPage selectHobby (String hobby){
        hobbies.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage fillSubject(String subject){
        subjectsInput.val(subject).pressEnter();
        return this;
    }

    public RegistrationPage fillAddress(String address, String state, String city){
        $("#currentAddress").val(address);
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        return this;
    }

    public void clickOk(){
        okButton.click();
    }
}
