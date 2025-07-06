package stepdefinitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utilities.Driver;


public class NavigationStepDef {
    private WebDriver driver;
    private HomePage homePage;  // HomePage sayfası, menü işlemleri için

    public NavigationStepDef() {
       // driver.get("https://www.zara.com/tr/");
        this.driver = Driver.getDriver();
        homePage = new HomePage(driver);

    }

    @When("user navigates to Erkek > Tümünü Gör")
    public void user_navigates_to_erkek_tumunu_gor() {
        homePage.clickErkekMenu();
        homePage.clickTumunuGor();
    }
}

