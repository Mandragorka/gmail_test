package gmail.selenium.pages;

import org.openqa.selenium.WebDriver;

public class LoginPage extends SeleniumPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        open("https://gmail.com");
    }

    public void login(String email, String password) {
        setValueAndEnter($("#Email"), email);
        setValueAndEnter($("#Passwd"), password);
    }
}
