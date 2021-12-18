import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TunisiaNetTests{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().setScriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		//driver.get("https://google.com");
		
		driver.get("https://www.tunisianet.com.tn");
		
		// User icon
		Thread.sleep(1500);
        WebElement element = driver.findElement(By.cssSelector("#_desktop_user_info > div > div > svg"));
        element.click();

        // Connexion option
        Thread.sleep(1500);
        element = driver.findElement(By.cssSelector(".user-down > li > a > span"));
        element.click();

        // Fill form
        element = driver.findElement(By.cssSelector(".form-group > div > input"));
        element.sendKeys("chadha.siala@gmail.com");
        element = driver.findElement(By.cssSelector(".form-group > div > div > input"));
        element.sendKeys("123456");
        
        // Submit form
        element = driver.findElement(By.id("submit-login"));
        element.click();

        // Search for Mac
        element = driver.findElement(By.className("search_query"));
        element.sendKeys("PC portable MacBook M1 13.3");
        element = driver.findElement(By.cssSelector("#sp-btn-search > button"));
        element.click();

        // Click on the first product
        List<WebElement> productsTitle = driver.findElements(By.className("product-title"));
        productsTitle.get(0).click();

        // Add product to cart
        element = driver.findElement(By.className("add-to-cart"));
        element.click();

        // Click to order
        element = driver.findElement(By.cssSelector("a.btn-block"));
        element.click();
        
        // Click Order
        element = driver.findElement(By.cssSelector(".checkout > div > a"));
        element.click();
        
        // Add address
        element = driver.findElement(By.name("address1"));
        element.sendKeys("Cité EL Khadra, Tunis");
        
        element = driver.findElement(By.name("postcode"));
        element.sendKeys("1003");
        
        element = driver.findElement(By.name("city"));
        element.sendKeys("Tunis");
        
        element = driver.findElement(By.name("phone"));
        element.sendKeys("25894788");
        
        element = driver.findElement(By.name("confirm-addresses"));
        element.click();
        
        // Confirm Delivery Option
        Thread.sleep(1500);
        element = driver.findElement(By.name("confirmDeliveryOption"));
        element.click();
        
        // Confirm Payment
        Thread.sleep(1500);
        element = driver.findElement(By.id("payment-option-1"));
        element.click();
        
        element = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        element.click();
        
        driver.quit();
	}

}
