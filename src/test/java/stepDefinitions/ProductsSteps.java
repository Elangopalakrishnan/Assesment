package stepDefinitions;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import MyHooks.baseHooks;
import PageObjects.CartPageObjects;
import PageObjects.productDetailsPage;
import Utilities.PropertiesReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class ProductsSteps {
	
	private WebDriver driver = baseHooks.driver;
    private WebDriverWait wait;
    private List<WebElement> eList;
    WebElement finalProductName = null;
    WebElement eligibleProducttoAddCart = null;
    
    public ProductsSteps() throws Exception {

        this.wait = new WebDriverWait(driver, PropertiesReader.getImplicitTimeout());
    }
	
	@Given("I add four products to my wish list")
	public void i_add_four_products_to_my_wish_list() throws InterruptedException {
	    
		for(int i = 1; i <= 4; i++)
		{
			WebElement element = driver.findElement(By.xpath("//*[@class=\"yith-wcwl-add-button\"]"));
			element.isEnabled();
			element.isDisplayed();
			element.click();
		}
		
		System.out.println("All 4 products Added");
	}

	@When("I view my wishlist table")
	public void i_view_my_wishlist_table() 
	{
		productDetailsPage pgObject = new productDetailsPage(driver, wait);
		pgObject.GoToWishListPage();
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);		
		Assert.assertEquals("Wishlist – TESTSCRIPTDEMO", pageTitle);
	}

	@Then("I find total four selected items in my Wishlist")
	public void i_find_total_four_selected_items_in_my_wishlist() 
	{
		
	    eList = driver.findElements(By.xpath("//*[@class='wishlist-items-wrapper']/tr"));
	    Assert.assertEquals(4,  eList.size());
	}

	@When("I search for lowest price product")
	public void i_search_for_lowest_price_product() throws Exception {
		
		try {
			int minPrice = 99999;
			
			WebElement htmltable=driver.findElement(By.xpath("//*[@class='wishlist-items-wrapper']"));
			List<WebElement> rows=htmltable.findElements(By.tagName("tr"));
			 
			for(int rnum=0;rnum<rows.size();rnum++)
			{
				List<WebElement> columns=rows.get(rnum).findElements(By.tagName("td"));
				
				WebElement addCart = rows.get(rnum).findElement(By.className("product-add-to-cart"));
				
				WebElement Price = rows.get(rnum).findElement(By.xpath("product-price"));
				
				WebElement ProductName = rows.get(rnum).findElement(By.xpath("product-price"));
				
				int temp = minPrice;
				String wholeText = Price.getText();
				
				String[] onlySplitedValue = wholeText.split("-");
				
				String onlyInteger = onlySplitedValue[1].replaceAll("[^A-Za-z0-9]","");
				
				int newPrice = Integer.parseInt(onlyInteger);
				minPrice = Math.min(minPrice, newPrice);
				
				if(temp != minPrice)
				{
					eligibleProducttoAddCart = addCart;
					finalProductName = ProductName;
				}
			}
		}
		catch(Exception ex)
		{
				throw new Exception("Error at calculating min price product");
		}
		
	}

	@When("I am able to add the lowest price item to my cart")
	public void i_am_able_to_add_the_lowest_price_item_to_my_cart() 
	{
		eligibleProducttoAddCart.click();
	}

	@Then("I am able to verify the item in my cart")
	public void i_am_able_to_verify_the_item_in_my_cart() 
	{
	    		
		Assert.assertEquals("",driver.getTitle());
		CartPageObjects cartPage = new CartPageObjects(driver, wait);		
		Assert.assertEquals(finalProductName.getText(), cartPage.VerifyProductName());		
	}	
}
