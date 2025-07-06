package stepdefinitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.SearchPage;
import utilities.Driver;
import utilities.ExcelUtil;


public class SearchStepDef {

    private WebDriver driver;
    private SearchPage searchPage;
    private ExcelUtil excelUtil;

    public SearchStepDef() {
        this.driver = Driver.getDriver();
        searchPage = new SearchPage(driver);

    }

    @When("user searches for product from excel row {int} column {int}")
    public void user_searches_for_product_from_excel(int row, int col) {
        ExcelUtil excelUtil = new ExcelUtil("C:\\Users\\osmi\\IdeaProjects\\ZARA_Test_Otomasyon\\src\\products.xlsx");
       String Keyword = excelUtil.getCellData(row, col);
         searchPage.enterSearchKeyword(Keyword);
    }

    @When("user clears the search box")
    public void user_clears_the_search_box() {
        searchPage.clearSearchBox();
    }
     @When("user searches for other product from excel row {int} column {int}")
    public void user_searches_for_other_product_from_excel(int row, int col) {
        ExcelUtil excelUtil = new ExcelUtil("C:\\Users\\osmi\\IdeaProjects\\ZARA_Test_Otomasyon\\src\\products.xlsx");
       String Keyword = excelUtil.getCellData(row, col);
         searchPage.enterOtherSearchKeyword(Keyword);
    }

    @When("user presses enter key")
    public void user_presses_enter_key() {
        searchPage.pressEnterKey();
    }
}
