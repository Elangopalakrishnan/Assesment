package PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilities.BaseClass;


public class CartPageObjects extends BaseClass {
	public CartPageObjects(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div/h1[@class='product_title entry-title']]")
    @CacheLookup
    private WebElement productName;
    
    
    public String VerifyProductName() 
    {		
		return productName.getText();
    }
}
