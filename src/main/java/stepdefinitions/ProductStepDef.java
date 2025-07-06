package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.ProductPage;
import utilities.Driver;
import utilities.TxtUtil;


public class ProductStepDef {

    private WebDriver driver;
    private ProductPage productPage;
    private TxtUtil txtUtil;

    public ProductStepDef() {
        this.driver = Driver.getDriver();
        productPage = new ProductPage(driver);
    }

    @When("user selects a random product from results")
    public void user_selects_a_random_product_from_results() {
        this.txtUtil = new TxtUtil("C:\\Users\\osmi\\IdeaProjects\\ZARA_Test_Otomasyon\\src\\products.txt");
        productPage.selectRandomProduct();
    }

    @Then("product info and price are saved to txt file")
    public void product_info_and_price_are_saved_to_txt_file() {
        String info = productPage.getProductInfo();
        String price = productPage.getProductPrice();
        txtUtil.writeToFile("Product Info: " + info + "\nPrice: " + price);
    }


    @When("product is added to the cart")
    public void product_is_added_to_the_cart() {
        productPage.addToCart();
    }
        @When("product size select")
    public void product_size_select() {
        productPage.sizeSelect();
}

    @When("user navigates to the cart page")
    public void user_navigates_to_the_cart_page() {
    productPage.goToCartPage();
    }



    @Then("price in product page and cart match")
    public void price_in_product_page_and_cart_match() {
        double productPrice = productPage.getProductPriceValue();
        double cartPrice = productPage.getCartPriceValue();
        if (productPrice != cartPrice) {
            throw new AssertionError("Fiyatlar eşleşmiyor! Product: " + productPrice + " Cart: " + cartPrice);
        }
    }
}
