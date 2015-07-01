package gmail.selenide;

import com.codeborne.selenide.Configuration;
import gmail.selenide.pages.LoginPage;
import gmail.selenide.pages.MainPage;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class GmailTests {

    private LoginPage loginPage = new LoginPage();
    private MainPage mainPage = new MainPage();

    @Before
    public void setUp(){
        open("https://gmail.com");
        Configuration.timeout = 15000;
    }

    @Test
    public void sendAndSearchTest() {
        String subject = "Hello_" + System.currentTimeMillis();

        // User login to gmail account
        loginPage.login(Config.email, Config.password);

        // Send new message
        mainPage.composeNewMessage();
        mainPage.setReceiver(Config.email);
        mainPage.setSubject(subject);
        mainPage.sendEmail();

        // Make sure that email is received
        mainPage.goToInbox();
        mainPage.emailList.filter(text(subject)).shouldHaveSize(1);

        // Search for email by subject
        mainPage.searchForEmailBySubject("subject: " + subject);
        mainPage.emailList.filter(visible).shouldHaveSize(1);
    }
}
