package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.MindtekPizzaAppPage;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.Map;

public class MindtekPizzaAppSteps {

    String costValue="";

    WebDriver driver = Driver.getDriver();
    MindtekPizzaAppPage mindtekPizzaAppPage = new MindtekPizzaAppPage();

    @When("user creates pizza order")
    public void user_creates_pizza_order(DataTable dataTable) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V

        Map<String, Object> data = dataTable.asMap(String.class, Object.class);
        System.out.println(data.toString());
        BrowserUtils.selectValueByDropdown(mindtekPizzaAppPage.pizzaDropdown, data.get("Pizza"));
        BrowserUtils.selectValueByDropdown(mindtekPizzaAppPage.topping1Dropdown, data.get("Topping1"));
        BrowserUtils.selectValueByDropdown(mindtekPizzaAppPage.topping2Dropdown, data.get("Topping2"));
        mindtekPizzaAppPage.pizzaQtyBox.clear();
        mindtekPizzaAppPage.pizzaQtyBox.sendKeys(data.get("Quantity").toString());

        mindtekPizzaAppPage.nameBox.sendKeys(data.get("Name").toString());
        mindtekPizzaAppPage.emailBox.sendKeys(data.get("Email").toString());
        mindtekPizzaAppPage.phoneBox.sendKeys(data.get("Phone").toString());

        costValue=mindtekPizzaAppPage.pizzaCost.getAttribute("value"); //27

        if (data.get("Payment").equals("Cash on Pickup")) {
            mindtekPizzaAppPage.cashRadioButton.click();
        }else {
            mindtekPizzaAppPage.creditCardRadioButton.click();
        }


        mindtekPizzaAppPage.placeOrderButton.click();

    }


    @Then("user validates that order is created with message {string} {string} {string}")
    public void user_validates_that_order_is_created_with_message(String success, String quantity, String pizza) {

        String expectedMessage = success+costValue+" "+pizza;
                String actualMessage = mindtekPizzaAppPage.successMessage.getText();
        System.out.println(actualMessage);
        Assert.assertEquals(expectedMessage, actualMessage);

    }
}
