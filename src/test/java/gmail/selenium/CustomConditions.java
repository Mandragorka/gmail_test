package gmail.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CustomConditions {

    public static ExpectedCondition<Boolean> elementPresent(final By  locator) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver input) {
                WebElement element = ExpectedConditions.presenceOfElementLocated(locator).apply(input);
                return element != null;
            }
        };
    }

    public static ExpectedCondition<Boolean> sizeOf(final List<WebElement> elements, final int expectedSize) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver input) {
                return elements.size() == expectedSize;
            }
        };
    }
}
