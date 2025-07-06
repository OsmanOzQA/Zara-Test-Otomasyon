package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;

   // private By erkekMenu = By.xpath("//a[contains(text(),'Erkek')]");
   // private By tumunuGorButton = By.xpath("//button[contains(text(),'Tümünü Gör')]");


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[@aria-label='Menüyü aç']")
   // @FindBy(xpath = "/html/body/div[2]/div/div[1]/div/div/header/div/div/button")
    WebElement MenuLink;
    @FindBy(xpath = "//span[text()='ERKEK']")
    WebElement erkekMenu;
    @FindBy(xpath = "//span[text()='TÜMÜNÜ GÖR']")
    WebElement tumunuGorButton;

    public void clickErkekMenu() {
       /* WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.elementToBeClickable(MenuLink));
MenuLink.click();*/
         MenuLink.click();
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.elementToBeClickable(erkekMenu));
erkekMenu.click();
         erkekMenu.click();
    }
    public void clickTumunuGor() {
        tumunuGorButton.click();
    }
}
