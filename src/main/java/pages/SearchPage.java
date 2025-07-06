package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {

    private WebDriver driver;

     @FindBy(xpath = "//a[@data-qa-id='header-search-text-link' and contains(., 'Ara')]")
     private WebElement searchInput;
     @FindBy(xpath = "//input[@id='search-home-form-combo-input']")
     private WebElement searchHelp;
     @FindBy(xpath = "//span[contains(@class, 'search-home-input-autocomplete-terms-part--is-highlighted') and text()='sort']")
     private WebElement span;
     @FindBy(xpath = "//input[@id='search-products-form-combo-input']")
     private WebElement clearSearchIcon;
     @FindBy(xpath = "//input[@id='search-products-form-combo-input']")
     private WebElement SearchIcon;


    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // WebElementleri initialize et
    }

   /* public void enterSearchKeyword(String keyword) {

        searchInput.click();
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(searchHelp));
        searchHelp.click();
        searchHelp.sendKeys(keyword);
            try {
        Thread.sleep(5000);
     } catch (InterruptedException e) {
        e.printStackTrace();
    }
        span.click();
    }*/
    public void enterSearchKeyword(String keyword) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // searchInput elementinin tıklanabilir olmasını bekle
    wait.until(ExpectedConditions.elementToBeClickable(searchInput)).click();

    // searchHelp alanı aktif olduğunda tıkla ve kelimeyi gönder
    wait.until(ExpectedConditions.elementToBeClickable(searchHelp)).click();
    searchHelp.sendKeys(keyword);

    // 5 saniye bekleme (isteğe bağlı olarak WebDriverWait ile değiştirilebilir)
    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    // span öğesine tıkla (arama önerisi vs. olabilir)
    wait.until(ExpectedConditions.elementToBeClickable(span)).click();
}


    public void clearSearchBox() {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(clearSearchIcon));
        clearSearchIcon.sendKeys(Keys.CONTROL + "a");
         clearSearchIcon.sendKeys(Keys.DELETE);


    }
    public void pressEnterKey() {

       clearSearchIcon.sendKeys(Keys.ENTER);
    }
    public void enterOtherSearchKeyword(String Keyword) {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(SearchIcon));
        SearchIcon.sendKeys(Keyword);
    }
}
