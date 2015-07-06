package gmail.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GmailPage extends SeleniumPage {

    @FindBy(css = "[role=\"main\"] tr.zA")
    List<WebElement> emailList;

    @FindBy(css = "[role=\"main\"] tr.zA:nth-child(1)")
    WebElement firstEmail;

    public GmailPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getEmailList() {
        return emailList;
    }

    public WebElement getFirstEmail() {
        return firstEmail;
    }

    public void sendEmail(String email, String subjectText) {
        $(By.cssSelector("div[gh=\"cm\"]")).click();
        $(By.name("to")).sendKeys(email);
        $(By.name("subjectbox")).sendKeys(subjectText);
        $(By.xpath("//div[text()='Send']")).click();
    }

    public void goToInbox() {
        $(By.cssSelector("a[title^=\"Inbox\"]")).click();
    }

    public void searchForEmailBySubject(String text) {
        $(By.cssSelector(".gbqfif")).sendKeys(("subject: " + text) + Keys.ENTER);
    }
}
