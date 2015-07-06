package gmail.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage extends SeleniumPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        open("https://gmail.com");
    }

    public void login(String email, String password) {
        $(By.cssSelector("#Email")).sendKeys(email + Keys.ENTER);
        $(By.cssSelector("#Passwd")).sendKeys(password + Keys.ENTER);
    }
}
