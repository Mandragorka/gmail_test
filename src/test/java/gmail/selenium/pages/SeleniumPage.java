package gmail.selenium.pages;

import gmail.selenium.CustomConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.PageFactory.initElements;

public class SeleniumPage {

    protected WebDriver driver;

    public SeleniumPage(WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
    }

    public void open(String url) {
        driver.get(url);
    }

    public WebElement $(String cssSelector) {
        return $(By.cssSelector(cssSelector));
    }

    public WebElement $(By by) {
        waitUntil(CustomConditions.elementPresent(by), 10);
        return driver.findElement(by);
    }

//    public List<WebElement> $$(By by) {
//        return driver.findElements(by);
//    }

    public void waitUntil(ExpectedCondition<Boolean> expectedCondition, long timeout) {
        new WebDriverWait(driver, timeout).until(expectedCondition);
    }

    public void assertThat(ExpectedCondition<Boolean> expectedCondition, long timeout) {
        waitUntil(expectedCondition, timeout);
    }

    public void setValueAndEnter(WebElement element, String data) {
        element.sendKeys(data + Keys.ENTER);
    }
}
