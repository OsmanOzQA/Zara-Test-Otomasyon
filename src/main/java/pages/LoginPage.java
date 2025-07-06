package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {

    WebDriver driver;

    // Constructor
   public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Zara anasayfadaki "Giriş Yap" butonu
    @FindBy(css ="a[data-qa-id='layout-header-user-logon']")
    WebElement loginLink;
   //Zara login sayfasındaki "Giriş yap" butonu
    @FindBy(css ="button[data-qa-id='oauth-logon-button']" )
    WebElement SecondloginLink;

    // Login sayfasındaki email inputu
     @FindBy(css = "input[data-qa-input-qualifier='logonId']")
     WebElement emailInput;
    @FindBy(css = "input[name='password']")
    WebElement passwordInput;

    @FindBy(css = "button[data-qa-id='logon-form-submit']")
    WebElement loginButton;

    public void clickLoginLink() {
        loginLink.click();
        SecondloginLink.click();
    }

    public void enterEmail(String email) {
        try {
        Thread.sleep(10000);
     } catch (InterruptedException e) {
        e.printStackTrace();
    }
        emailInput.click();
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.click();
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}

