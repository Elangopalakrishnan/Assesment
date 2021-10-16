package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.BaseClass;

public class productDetailsPage extends BaseClass {

	public productDetailsPage(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='header-wishlist']//i[1]")
    @CacheLookup
    private WebElement WishListButton;
    
    
    public void GoToWishListPage()
    {
    	WishListButton.isEnabled();
    	WaitUntilElementVisible(WishListButton);
    	WishListButton.click();
    }
}
