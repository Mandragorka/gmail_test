package gmail.selenide;

import com.codeborne.selenide.Configuration;
import gmail.Config;
import gmail.selenide.pages.LoginPage;
import gmail.selenide.pages.MainPage;
import org.junit.Before;
import org.junit.Test;

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

        // User login to gmail account
        loginPage.login(Config.email, Config.password);

        // Send new message
        mainPage.sendEmail(Config.email, subject);

        // Make sure that email is received
        mainPage.goToInbox();
        mainPage.emailList.filter(text(subject)).get(0).shouldHave(text(subject));

        // Search for email by subject
        mainPage.searchForEmailBySubject(subject);
        // Make sure that there is only one email in search result with given subject
        mainPage.emailList.shouldHaveSize(1);
        mainPage.emailList.get(0).shouldHave(text(subject));
    }
}
