package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class ProductPage {

    private WebDriver driver;

    @FindBy(xpath = "//li[contains(@class, 'product-grid-product')]")
    public List<WebElement> productList;

    @FindBy(xpath = "//h1[@class='product-detail-info__header-name' and @data-qa-qualifier='product-detail-info-name']")
    private WebElement productTitle;

    @FindBy(css = "div.price-formatted__price-amount .money-amount__main")
    private WebElement productPrice;

    @FindBy(css = "button[data-qa-action='add-to-cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//button[.//div[text()='M (US M)']]")
     private WebElement firstAvailableSizeButton;


    @FindBy(css = "button[data-qa-action='nav-to-cart']")
    private WebElement viewCartButton;

    @FindBy(css = "span.money-amount__main")
    private WebElement cartPriceElement;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectRandomProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(productList));

        if (productList == null || productList.isEmpty()) {
            throw new RuntimeException("Ürün bulunamadı!");
        }

        Random random = new Random();
        int index = random.nextInt(productList.size());
        productList.get(index).click();
    }

    public String getProductInfo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(productTitle));
        return productTitle.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

   public double getProductPriceValue() {
    String priceText = getProductPrice(); // Örn: "1.390,00 TL"
    priceText = priceText.replace(".", ""); // → "1390,00 TL"
    priceText = priceText.replace(",", "."); // → "1390.00 TL"
    priceText = priceText.replaceAll("[^0-9.]", ""); // Sadece sayıları ve '.' bırak
    return Double.parseDouble(priceText); // → 1390.00
}

   public void addToCart() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    try {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    } catch (Exception e) {
          }

   // wait.until(ExpectedConditions.elementToBeClickable(viewCartButton)).click();
}
    public void goToCartPage() {
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     wait.until(ExpectedConditions.elementToBeClickable(viewCartButton)).click();
}


   public double getCartPriceValue() {
    String priceText = cartPriceElement.getText(); // Örnek: "8.340,00 TL"
    priceText = priceText.replace(".", ""); // Binlik ayraç olan noktayı kaldır: "8340,00 TL"
    priceText = priceText.replace(",", "."); // Virgülü noktaya çevir: "8340.00 TL"
    priceText = priceText.replaceAll("[^0-9.]", ""); // Sadece sayı ve . bırak: "8340.00"
    return Double.parseDouble(priceText); // Başarıyla dönüştürür
}
    public void sizeSelect() {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
           try {
    // Beden butonunun görünmesini ve tıklanabilir hale gelmesini bekle
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[data-qa-action='size-in-stock']")));
    wait.until(ExpectedConditions.visibilityOf(firstAvailableSizeButton));
    wait.until(ExpectedConditions.elementToBeClickable(firstAvailableSizeButton)).click();

    // SPACE tuşu gönder
    firstAvailableSizeButton.sendKeys(Keys.SPACE);

} catch (Exception e) {
    System.out.println("Beden seçimi yapılamadı: " + e.getMessage());
}
    }

}
