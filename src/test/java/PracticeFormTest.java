import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
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

        $("#subjectsInput").sendKeys("What is this?");
        $("[for=hobbies-checkbox-1]").click();
        $("[for=hobbies-checkbox-2]").click();
        $("[for=hobbies-checkbox-3]").click();

        $("#submit").click();
        
        $(".modal-body").shouldHave(text("Nata"), text("Svitlychna"), text("nata@mail.ma"),
                text("Female"), text("1234567890"));

        $(".modal-body").shouldHave(text("19"), text("May"), text("2021"));

        $(".modal-body").shouldHave(text("Sports"), text("Reading"), text("Music"));

    }
}
