package gmail.selenide;

import com.codeborne.selenide.Configuration;
import gmail.Config;
import gmail.selenide.pages.LoginPage;
import gmail.selenide.pages.MainPage;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class GmailTest {

    private LoginPage loginPage = new LoginPage();
    private MainPage mainPage = new MainPage();

    @Before
    public void setUp(){
        open("https://gmail.com");
        Configuration.timeout = 15000;
    }

    @Test
    public void testGmailSendAndSearch() {
        String subject = "Hello" + System.currentTimeMillis();

        loginPage.login(Config.email, Config.password);
        mainPage.sendEmail(Config.email, subject);
        mainPage.goToInbox();
        mainPage.emailList.get(0).shouldHave(text(subject));
        mainPage.searchForEmailBySubject(subject);
        mainPage.emailList.shouldHave(texts(subject));
    }
}
