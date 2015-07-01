package gmail.selenide.pages;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public void login(String email, String password) {
        $("#Email").setValue(email);
        $("#next").click();
        $("#Passwd").setValue(password);
        $("#signIn").click();
    }
}
