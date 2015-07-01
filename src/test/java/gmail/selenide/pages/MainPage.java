package gmail.selenide.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    public ElementsCollection emailList = $$("div.oy8Mbf[role=\"main\"] tr.zA");

    public void composeNewMessage() {
        $("div[gh=\"cm\"]").click();
    }

    public void setReceiver(String email) {
        $("textarea.vO").setValue(email);
    }

    public void setSubject(String subjectText) {
        $("input.aoT").setValue(subjectText);
    }

    public void sendEmail() {
        $(byText("Send")).click();
    }

    public void goToInbox() {
        $("a[title^=\"Inbox\"]").click();
    }

    public void searchForEmailBySubject(String text) {
        $(".gbqfif").setValue(text).pressEnter();
    }
}
