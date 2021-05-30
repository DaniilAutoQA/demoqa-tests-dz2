package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class OutputFormPage {

    private static final String THANKS_FOR_SUBMITTIG_TEXT = "Thanks for submitting the form";

    SelenideElement thanksForSubmitting = $("#example-modal-sizes-title-lg"),
            studentNameLine = $x("//td[text()='Student Name']").parent(),
            emailLine = $x("//td[text()='Student Email']").parent(),
            genderLine = $x("//td[text()='Gender']").parent(),
            phoneNumberLine = $x("//td[text()='Mobile']").parent(),
            dateOfBirthLine = $x("//td[text()='Date of Birth']").parent(),
            subjectLine = $x("//td[text()='Subjects']").parent(),
            hobbiesLine = $x("//td[text()='Hobbies']").parent(),
            pictureLine = $x("//td[text()='Picture']").parent(),
            addressLine = $x("//td[text()='Address']").parent(),
            stateAndCity = $x("//td[text()='State and City']").parent();

    public OutputFormPage checkThisIsRegistrationConfirmationPage() {
        thanksForSubmitting.shouldHave(text(THANKS_FOR_SUBMITTIG_TEXT));
        return this;
    }

    public OutputFormPage checkNameLine(String firstName, String lastName) {
        studentNameLine.shouldHave(text(firstName + " " + lastName));
        return this;
    }

    public OutputFormPage checkEmailLine(String email) {
        emailLine.shouldHave(text(email));
        return this;
    }

    public OutputFormPage checkGenderLine(String gender) {
        genderLine.shouldHave(text(gender));
        return this;
    }

    public OutputFormPage checkPhoneNumberLine(String phoneNumber) {
        phoneNumberLine.shouldHave(text(phoneNumber));
        return this;
    }

    public OutputFormPage checkDateOfBirthLine(String dayOfBirth, String monthOfBirth, String yearOfBirth) {
        dateOfBirthLine.shouldHave(text(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth));
        return this;
    }

    public OutputFormPage checkSubjectLine(String subject) {
        subjectLine.shouldHave(text(subject));
        return this;
    }

    public OutputFormPage checkHobbiesLine(String hobby) {
        hobbiesLine.shouldHave(text(hobby));
        return this;
    }

    public OutputFormPage checkPictureLine(String picture) {
        pictureLine.shouldHave(text(picture));
        return this;
    }

    public OutputFormPage checkAddressLine(String address) {
        addressLine.shouldHave(text(address));
        return this;
    }

    public OutputFormPage checkStateAndCity(String state, String city) {
        stateAndCity.shouldHave(text(state + " " + city));
        return this;
    }
}
