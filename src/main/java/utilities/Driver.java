package utilities;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.zh_tw.並且;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            String edgePath = "C:\\Users\\osmi\\IdeaProjects\\ZARA_Test_Otomasyon\\src\\edgedriver_win64\\msedgedriver.exe";
            System.setProperty("webdriver.edge.driver", edgePath);
            driver = new EdgeDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();

        }
    }
}
