package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.WebOrdersHomePage;
import pages.WebOrdersLoginPage;
import pages.WebOrdersOrderPage;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.Map;

public class WebOrdersSteps {

    WebDriver driver = Driver.getDriver();
    WebOrdersLoginPage webOrdersLoginPage = new WebOrdersLoginPage();
    WebOrdersHomePage webOrdersHomePage = new WebOrdersHomePage();
    WebOrdersOrderPage webOrdersOrderPage = new WebOrdersOrderPage();


    @When("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        System.out.println(username); // username = "Invalid";
        System.out.println(password); // password
        //sendKey to username box
        webOrdersLoginPage.username.sendKeys(username);
        //sendKey to password box
        webOrdersLoginPage.password.sendKeys(password);
    }


    @And("user clicks on the login button")
    public void user_clicks_on_the_login_button() {
        // click on the login button
        webOrdersLoginPage.loginButton.click();
    }


    @Then("user validates application is logged in")
    public void user_Validates_Application_Is_LoggedIn() {
        String expectedTitle = "Web Orders";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);


    }


    @Then("user validates an error message {string}")
    public void userValidatesAnErrorMessage(String expectedErrorMessage) { //expectedErrorMessage="Invalid Login or Password."
        String actualErrorMessage = webOrdersLoginPage.errorMessage.getText();
        System.out.println(actualErrorMessage);
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }


    @When("user clicks on the Order module")
    public void user_clicks_on_the_order_module() {
        webOrdersHomePage.orderModule.click();

    }


    @When("user selects {string} with {int} and clicks on calculate button")
    public void user_selects_with_quantity_and_clicks_on_calculate_button(String product, int quantity) {
        BrowserUtils.selectValueByDropdown(webOrdersOrderPage.productDropdown, product); // product = "ScreenSaver";
        webOrdersOrderPage.quantityBox.clear();
        webOrdersOrderPage.quantityBox.sendKeys(quantity + ""); // quantity = 25;
        webOrdersOrderPage.calculateBtn.click();

    }


    @Then("user validates total is calculated properly for {int}")
    public void user_validates_total_is_calculated_properly_for_quantity(int quantity) {
        int expectedTotal = 0;

        //storing my values for calculation as String
        String pricePerUnit = webOrdersOrderPage.pricePerUnitBox.getAttribute("value"); // pricePerUnit = 20;
        String discountAmount = webOrdersOrderPage.discountBox.getAttribute("value"); //discountAmount=10;

        //converting my String values for calculation to int
        int pricePerUnitInt = Integer.parseInt(pricePerUnit); // pricePerUnitInt = 20;
        int discountAmountInt = Integer.parseInt(discountAmount); // //discountAmountInt=10;

        if (discountAmountInt == 0) {
            expectedTotal = quantity * pricePerUnitInt;
        } else {
            expectedTotal = quantity * pricePerUnitInt; // 25 * 20 = 500;
            expectedTotal = expectedTotal - expectedTotal * discountAmountInt / 100; // 500 - 50 = 450;
        }

        String actualTotal = webOrdersOrderPage.totalBox.getAttribute("value"); // actualTotal = 450;
        int actualTotalInt = Integer.parseInt(actualTotal); // actualTotalInt = 450;

        Assert.assertEquals(expectedTotal, actualTotalInt); // expectedTotal = 450 = actualTotalInt = 450; // true
    }

    @When("user creates order with data")
    public void user_creates_order_with_data(DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>.

        Map<String, String> data = dataTable.asMap(String.class, String.class);
        System.out.println("DataTable as map: " + data);
        BrowserUtils.selectValueByDropdown(webOrdersOrderPage.productDropdown, data.get("product")); // returns "MyMoney" from dataTable, converted to
        webOrdersOrderPage.quantityBox.sendKeys(data.get("quantity"));
        webOrdersOrderPage.nameBox.sendKeys(data.get("name"));
        webOrdersOrderPage.streetBox.sendKeys(data.get("street"));
        webOrdersOrderPage.cityBox.sendKeys(data.get("city"));
        webOrdersOrderPage.stateBox.sendKeys(data.get("state"));
        webOrdersOrderPage.zipBox.sendKeys(data.get("zip"));

        if (data.get("cType").equals("Visa")) {
            webOrdersOrderPage.visaRadioButton.click();
        } else if (data.get("cType").equals("Master")) {
            webOrdersOrderPage.masterCard.click();
        } else if (data.get("cType").equals("American")) {
            webOrdersOrderPage.americanExpress.click();
        }else {
            System.out.println("There is no such card available. Please provide valid card type.");
        }

        webOrdersOrderPage.ccBox.sendKeys(data.get("cc"));
        webOrdersOrderPage.expDateBox.sendKeys(data.get("exp"));
        webOrdersOrderPage.processButton.click();

    }


    @Then("user validates success message {string}")
    public void user_validates_success_message(String expectedMessage) {
        String actualMessage = webOrdersOrderPage.successMessage.getText();

        Assert.assertEquals(expectedMessage,actualMessage);


    }


}
