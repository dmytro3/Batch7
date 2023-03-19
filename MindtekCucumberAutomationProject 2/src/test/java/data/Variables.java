package data;

public class Variables {

    private String WebOrdersURL = "http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx";
    private String EtsyAppURL = "https://www.etsy.com/";
    private String PizzaAppURL = "file:/Users/mindtek/IdeaProjects/MindtekCucumberAutomationProject/PizzaApp.html";
    private String browser = "chrome";
    private String AmazonURL = "https://www.amazon.com/";

    public String getWebOrdersURL() {
        return WebOrdersURL;
    }

    public void setWebOrdersURL(String webOrdersURL) {
        WebOrdersURL = webOrdersURL;
    }

    public String getEtsyAppURL() {
        return EtsyAppURL;
    }

    public void setEtsyAppURL(String etsyAppURL) {
        EtsyAppURL = etsyAppURL;
    }

    public String getPizzaAppURL() {
        return PizzaAppURL;
    }

    public void setPizzaAppURL(String pizzaAppURL) {
        PizzaAppURL = pizzaAppURL;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getAmazonURL() {
        return AmazonURL;
    }

    public void setAmazonURL(String amazonURL) {
        AmazonURL = amazonURL;
    }
}
