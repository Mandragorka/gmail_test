package gmail.selenium;

import gmail.Config;
import gmail.selenium.pages.GmailPage;
import gmail.selenium.pages.LoginPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static gmail.selenium.CustomConditions.listNthElementHasText;
import static gmail.selenium.CustomConditions.textOf;

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

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(Config.email, Config.password);

        GmailPage gmailPage = new GmailPage(driver);
        gmailPage.sendEmail(Config.email, subject);

        gmailPage.goToInbox();
        CustomConditions.LazyWebElement lazyEmail = gmailPage.getFirstEmail();
        //gmailPage.assertThat(firstElementHasText((gmailPage.getEmailList()), subject));
        gmailPage.assertThat(textOf(gmailPage.getFirstEmail(), subject), 10);

        gmailPage.searchForEmailBySubject(subject);
        gmailPage.assertThat(listNthElementHasText(gmailPage.getEmailList(), 0, subject), 10);
        //gmailPage.waitUntil(sizeOf(gmailPage.getEmailList(), 1), 10);
        //gmailPage.assertThat(firstElementHasText(gmailPage.getEmailList(), subject));
        //gmailPage.assertThat(textOf(gmailPage.getFirstEmail(), subject), 10);
    }
}