import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class HomeWork {

    @Test
    void checkGitHubMenuTest() {
        open("https://github.com/");
        $(withText("Solutions")).hover();
        $(withText("Enterprise")).click();
        $("h1").shouldHave(text("Build like the best"));
    }

    @Test
    void dragAndDropTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-b").shouldHave(text("A"));
        $("#column-a").shouldHave(text("B"));
    }

    @Test
    void selenideActionDragAndDropTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        /* Эти так же не сработали (
        actions().dragAndDropBy($("#column-a"), 250, 0).perform();
        actions().dragAndDrop($("#column-a"), $("#column-b")).perform();
        */

        actions().moveToElement($("#column-a")).clickAndHold()
                .moveToElement($("#column-b")).release().perform();

        $("#column-b").shouldHave(text("A"));
        $("#column-a").shouldHave(text("B"));

    }
}
