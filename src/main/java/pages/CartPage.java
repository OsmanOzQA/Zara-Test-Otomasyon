package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ScrollUtil;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CartPage {

    private final WebDriverWait wait;
    private WebDriver driver;

    @FindBy(css = "div[data-qa-id='add-order-item-unit']")
    private WebElement increaseQuantityButton;
    @FindBy(xpath = "//a[@data-qa-action='shop-navigation-link-Shopping_bag']//span/span")
    private WebElement quantityInput;

   @FindBy(css = "div[data-qa-id='remove-order-item-unit']")
    private WebElement removeButton;

   @FindBy(xpath = "//div[@class='zds-empty-state__title']/span[contains(text(), 'SEPETİNİZ BOŞ')]")
    private WebElement cartEmptyMessage;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("arguments[0].scrollIntoView(true);", element);
}

    public void setProductQuantity(int quantity) {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement increaseQuantityButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-qa-id='add-order-item-unit']")));

    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", increaseQuantityButton);

    // Butona JS ile tıklama (geleneksel click sorun çıkarsa)
    js.executeScript("arguments[0].click();", increaseQuantityButton);

}

public int getProductQuantity() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement quantityElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.cssSelector("a[data-qa-action='shop-navigation-link-Shopping_bag']")
    ));

    // Scroll yap
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", quantityElement);

    // Güncellenmesini bekle (örnek: text değişene kadar bekle)
    wait.until(driver -> {
        String innerText = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText;", quantityElement);
        // Parantez içindeki sayı 2 olana kadar bekle
        return innerText.contains("[2]");
    });

    // Güncellenen metni al
    String innerText = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText;", quantityElement);

    Pattern pattern = Pattern.compile("\\[(\\d+)\\]");
    Matcher matcher = pattern.matcher(innerText);

    if (matcher.find()) {
        return Integer.parseInt(matcher.group(1));
    }
    return 0;
}




 public void removeProduct() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    WebElement removeButton = wait.until(ExpectedConditions.elementToBeClickable(
        By.cssSelector("div[data-qa-id='remove-order-item-unit']")
    ));

    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", removeButton);

    // İlk tıklama
    js.executeScript("arguments[0].click();", removeButton);

    // Araya 2 saniye bekleme koy
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    // İkinci tıklama
    js.executeScript("arguments[0].click();", removeButton);
}
public boolean isCartEmpty() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement cartEmptyMessage = wait.until(ExpectedConditions.elementToBeClickable(
        By.xpath("//div[@class='zds-empty-state__title']/span[contains(text(), 'SEPETİNİZ BOŞ')]")
    ));

    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", cartEmptyMessage);

    if (cartEmptyMessage.isDisplayed()) {
        String text = cartEmptyMessage.getText();
        if(text.contains("SEPETİNİZ BOŞ")) {
            return true;
        }
    }
    // Burada false dönmüyoruz, istersen exception fırlatabilirsin.
    throw new RuntimeException("Sepet boş mesajı görünmüyor!");
}
}
