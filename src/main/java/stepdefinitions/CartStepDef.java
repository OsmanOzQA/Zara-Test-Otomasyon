package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import utilities.Driver;




public class CartStepDef {

    private WebDriver driver;
    private CartPage cartPage;

    public CartStepDef() {
         driver = Driver.getDriver();
        cartPage = new CartPage(driver);
    }

    @When("user increases product quantity to {int}")
    public void user_increases_product_quantity_to(int quantity) {
        cartPage.setProductQuantity(quantity);
    }

    @Then("product quantity is verified as {int}")
    public void product_quantity_is_verified_as(int quantity) {
        int actualQty = cartPage.getProductQuantity();
        if (actualQty != quantity) {
            throw new AssertionError("Ürün adedi eşleşmiyor! Beklenen: " + quantity + ", Gerçek: " + actualQty);
        }
    }

    @When("user removes product from cart")
    public void user_removes_product_from_cart() {
        cartPage.removeProduct();
    }

    @Then("cart is verified as empty")
    public void cart_is_verified_as_empty() {
        if (!cartPage.isCartEmpty()) {
            throw new AssertionError("Sepet boş değil!");
        }
    }
}
