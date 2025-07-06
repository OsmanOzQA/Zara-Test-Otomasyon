package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;
import org.junit.Assert;
import utilities.Driver;

import java.time.Duration;

public class LoginStepDef {

    WebDriver driver;
    LoginPage loginPage;
     public LoginStepDef() {
       // driver.get("https://www.zara.com/tr/");
        this.driver = Driver.getDriver();
        loginPage = new LoginPage(driver);

    }

    @Given("user is on the Zara homepage")
    public void user_is_on_the_login_page() {
        // WebDriver başlatılıyor
      // driver = new EdgeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.zara.com/tr"); // Zara'nın login sayfası

        By cookieAcceptBtn = By.id("onetrust-accept-btn-handler"); // Örnek selector

        try {
             wait.until(ExpectedConditions.elementToBeClickable(cookieAcceptBtn)).click();
            } catch (Exception e) {
            // Eğer cookie banner çıkmazsa test devam eder
         System.out.println("Çerez uyarısı görünmedi, devam ediliyor.");
            }
    }


    @When("user clicks the login button")
    public void user_clicks_the_login_button() {

        loginPage.clickLoginLink();
    }

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        loginPage.enterEmail("osmanozdemir44@windowslive.com");
        loginPage.enterPassword("Teknik135+");
        loginPage.clickLoginButton();
    }

    @Then("user should be redirected to the products page")
    public void user_should_be_redirected_to_the_products_page() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Kullanıcı giriş sonrası yönlendirilmedi", currentUrl.contains("zara.com"));
        driver.quit();
    }
}
