package utilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.time.Duration;

public class ScrollUtil {
private WebDriver driver;
    private WebDriverWait wait;

    public ScrollUtil(WebDriver driver, int timeoutInSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }

    public void scrollDownWithWait(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long lastHeight = (long) js.executeScript("return window.pageYOffset;");
        js.executeScript("window.scrollBy(0," + pixels + ");");

        wait.until((ExpectedCondition<Boolean>) wd ->
                (Long) ((JavascriptExecutor) wd).executeScript("return window.pageYOffset;") > lastHeight
        );
    }

    public void scrollUpWithWait(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long lastHeight = (long) js.executeScript("return window.pageYOffset;");
        js.executeScript("window.scrollBy(0,-" + pixels + ");");

        wait.until((ExpectedCondition<Boolean>) wd ->
                (Long) ((JavascriptExecutor) wd).executeScript("return window.pageYOffset;") < lastHeight
        );
    }
}
