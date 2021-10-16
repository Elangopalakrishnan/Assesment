package MyHooks;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import Utilities.PropertiesReader;

public class baseHooks {

	public static WebDriver driver;
	
	@Before(order = 1)
	public void launchBrowser(Scenario sc)  throws Exception
	{
		System.out.println("launchBrowser called for " + sc.getName());
		System.setProperty("webdriver.chrome.driver","/Users/pree/eclipse-workspace/Assessment/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(PropertiesReader.getImplicitTimeout(), TimeUnit.SECONDS);	
		System.out.println("GoToApplication called");
		driver.get(PropertiesReader.getValue("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	
		driver.manage().timeouts().pageLoadTimeout(PropertiesReader.getPageLoadTimeout(), TimeUnit.SECONDS);
		System.out.println("The Page Title is : " +driver.getTitle());
	}
	
	@After(order = 2)
	public void tearDown()
	{
		System.out.println("tearDown called");
		driver.close();
		driver.quit();
	}
	
	@After(order = 1)
    public void embedScreenshot(Scenario scenario) {

        if(scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            } catch (WebDriverException noSupportScreenshot) {
                System.err.println(noSupportScreenshot.getMessage());
            }
        }
    }
}
