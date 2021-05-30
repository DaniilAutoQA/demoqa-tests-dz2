import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import components.CalendarComponent;
import enm.Gender;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.OutputFormPage;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest extends TestBase {

    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = Gender.getRandom().toString(),
            mobile = faker.number().digits(10),
            monthOfBirth = "May",
            yearOfBirth = "2004",
            dayOfBirth = "27",
            subject = "Chemistry",
            hobby = "Sports",
            picture = "cat.png",
            currentAddress = faker.address().fullAddress(),
            state = "Uttar Pradesh",
            city = "Merrut";

    RegistrationPage registrationPage = new RegistrationPage();
    CalendarComponent birthDay = new CalendarComponent();
    OutputFormPage outputFormPage = new OutputFormPage();

    @Test
    void successfulSubmitFormTest() {

        registrationPage
                .openForm()
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .fillEmail(email)
                .selectGender(gender)
                .fillPhone(mobile);
        birthDay.setDate(dayOfBirth, monthOfBirth, yearOfBirth);
        registrationPage
                .fillSubject(subject)
                .selectHobby(hobby)
                .uploadPicture(picture)
                .fillAddress(currentAddress, state, city)
                .clickOk();


        outputFormPage.checkThisIsRegistrationConfirmationPage()
                .checkNameLine(firstName, lastName)
                .checkEmailLine(email)
                .checkGenderLine(gender)
                .checkPhoneNumberLine(mobile)
                .checkDateOfBirthLine(dayOfBirth, monthOfBirth, yearOfBirth)
                .checkSubjectLine(subject)
                .checkHobbiesLine(hobby)
                .checkPictureLine(picture)
                .checkAddressLine(currentAddress)
                .checkStateAndCity(state, city);
    }
}
