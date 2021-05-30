import com.codeborne.selenide.Configuration;
import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;
import components.CalendarComponent;
import enm.Gender;
import enm.Hobby;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.OutputFormPage;
import pages.RegistrationPage;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest extends TestBase {

    Faker faker = new Faker();
    SimpleDateFormat formatterMonth = new SimpleDateFormat("MMMM", Locale.ENGLISH);
    SimpleDateFormat formatterDay = new SimpleDateFormat("dd", Locale.ENGLISH);
    SimpleDateFormat formatterYear = new SimpleDateFormat("yyyy", Locale.ENGLISH);
    RegistrationPage registrationPage = new RegistrationPage();
    CalendarComponent birthDay = new CalendarComponent();
    OutputFormPage outputFormPage = new OutputFormPage();

    Date birthday = faker.date().birthday(1,100);
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = Gender.getRandom().toString(),
            mobile = faker.number().digits(10),
            monthOfBirth = formatterMonth.format(birthday),
            yearOfBirth = formatterYear.format(birthday),
            dayOfBirth = formatterDay.format(birthday),
            subject = "Chemistry",
            hobby = Hobby.getRandom().toString(),
            picture = "cat.png",
            currentAddress = faker.address().fullAddress(),
            state = "Uttar Pradesh",
            city = "Merrut";

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
