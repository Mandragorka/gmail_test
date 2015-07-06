package gmail.selenium;

import gmail.Config;
import gmail.selenium.pages.GmailPage;
import gmail.selenium.pages.LoginPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static gmail.selenium.CustomConditions.sizeOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

public class GmailTest {

    public static WebDriver driver;

    @BeforeClass
    public static void setUpClass() {
        driver = new FirefoxDriver();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void testAtGmail() {
        String subject = "Hello" + System.currentTimeMillis();

        // User login to gmail account
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(Config.email, Config.password);

        // Send new message
        GmailPage gmailPage = new GmailPage(driver);
        gmailPage.sendEmail(Config.email, subject);

        // Make sure that email is received
        gmailPage.goToInbox();
        gmailPage.assertThat(textToBePresentInElement(gmailPage.getFirstEmail(), subject));

        // Search for email by subject
        gmailPage.searchForEmailBySubject(subject);
        // Make sure that there is only one email in search result with given subject
        gmailPage.waitUntil(sizeOf(gmailPage.getEmailList(), 1), 10);
        gmailPage.assertThat(textToBePresentInElement(gmailPage.getFirstEmail(), subject));
    }
}
