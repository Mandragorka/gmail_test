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

    public static ExpectedCondition<Boolean> firstElementHasText(final List<WebElement> element, final String text) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver input) {
                return ExpectedConditions.textToBePresentInElement(element.get(0), text).apply(input);
            }
        };
    }

    public static ExpectedCondition<Boolean> textOf(final LazyWebElement lazyWebElement, final String text) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver input) {
                return ExpectedConditions.textToBePresentInElement(lazyWebElement.get(), text).apply(input);
            }
        };
    }

    public interface LazyWebElement {
        WebElement get();
    }

    public static ExpectedCondition<Boolean> listNthElementHasText(final List<WebElement> elements, final int n, final String expectedText) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver input) {
                try {
                    return elements.get(n).getText().contains(expectedText);
                } catch (IndexOutOfBoundsException e) {
                    return false;
                }
            }
        };
    }
}
