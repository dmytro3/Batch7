package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class EtsyAppSearchPage {

    public EtsyAppSearchPage(){
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div/ol/li/div/div/a/div[2]/h3")
    public List<WebElement> itemsNamesList;

    @FindBy(id = "search-filter-button")
    public WebElement allFiltersBtn;

    @FindBy(xpath = "//label[@for='price-input-4']")
    public WebElement over1500Radio;

    @FindBy(xpath = "//*[contains (text(), 'Apply' )]")
    public WebElement applyBtn;

    @FindBy(xpath = "//div[@class='wt-bg-white wt-display-block wt-pb-xs-2 wt-mt-xs-0']//span[@class='currency-value']")
    public List<WebElement> listOfPrices;

    
}
