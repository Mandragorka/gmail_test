package gmail.selenide.pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    public ElementsCollection emailList = $$("[role=\"main\"] tr.zA");

    public void sendEmail(String email, String subjectText) {
        $("div[gh=\"cm\"]").click();
        $(By.name("to")).setValue(email);
        $(By.name("subjectbox")).setValue(subjectText);
        $(byText("Send")).click();
    }

    public void goToInbox() {
        $("a[title^=\"Inbox\"]").click();
    }

    public void searchForEmailBySubject(String text) {
        $(".gbqfif").setValue("subject: " + text).pressEnter();
    }
}
