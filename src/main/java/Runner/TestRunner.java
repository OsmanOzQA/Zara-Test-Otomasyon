package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import utilities.Driver;


import java.time.Duration;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="C:/Users/osmi/IdeaProjects/ZARA_test_otomasyon/src/main/java/features",
        glue = "stepdefinitions",
        plugin = {"pretty", "html:target/cucumber-html-report"}
)

public class TestRunner {
    private static WebDriver driver ;
        @BeforeClass
        public static void setUpClass() {
            driver = Driver.getDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        @AfterClass
        public static void tearDownClass() {
           // driver.quit();
        }


}

