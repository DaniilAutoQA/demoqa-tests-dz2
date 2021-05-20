import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void successfulSubmitFormTest() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Nata");
        $("#lastName").setValue("Svitlychna");
        $("#userEmail").setValue("nata@mail.ma");
        $("[for=gender-radio-2]").click();
        $("#userNumber").setValue("1234567890");
        $("#currentAddress").setValue("My Adress");

        //Date
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOption("1999");
        $("[aria-label='Choose Thursday, December 9th, 1999']").click();
        //Date

        $("#subjectsInput").setValue("What is this?");
        $("[for=hobbies-checkbox-1]").click();
        $("[for=hobbies-checkbox-2]").click();
        $("#hobbies-checkbox-3").parent().click();

        // select Picture
        $("#uploadPicture").uploadFile(new File("src/test/resources/cat.png"));

        // select state and city
        $("#state").click();
        $(byText("Rajasthan")).click();
        $("#city").click();
        $(byText("Jaipur")).click();


        $("#submit").click();

        $(".modal-body").shouldHave(text("Nata Svitlychna"),
                text("nata@mail.ma"), text("My Adress"),
                text("Female"), text("1234567890"),
                text("09 December,1999"),text("cat.png"),
                text("Sports"), text("Reading"), text("Music"),
                text("Rajasthan"), text("Jaipur")
        );
    }
}
