import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public abstract class TestBase {

    @BeforeAll
    public static void setup() {
        Configuration.startMaximized = true;
    }
}
