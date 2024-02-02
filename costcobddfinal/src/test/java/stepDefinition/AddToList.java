
package stepDefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToList {
	WebDriver driver = null;

	@Given("User is on Costco main page")
	public void user_is_on_costco_main_page() {
		System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.costco.com");
	}

	@When("User performs a product search")
	public void user_performs_a_product_search() {
		driver.findElement(By.id("search-field")).click();
		driver.findElement(By.id("search-field")).clear();
		driver.findElement(By.id("search-field")).sendKeys("airpods pro (2nd generation)");
		driver.findElement(By.xpath("//form[@id='formcatsearch']/div[2]/button/i")).click();
	}

	@When("adds the item to the shopping cart")
	public void adds_the_item_to_the_shopping_cart() {
		WebDriverWait wait = new WebDriverWait(driver, 8); // 20 sec
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addbutton-0")));
		driver.findElement(By.id("addbutton-0")).click();
	}

	@When("opens shopping cart")
	public void opens_shopping_cart() {
		WebDriverWait wait2 = new WebDriverWait(driver, 15); // 20 sec
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='cart-d']/div/div")));
		driver.findElement(By.xpath("//a[@id='cart-d']/div/div")).click();
	}

	@When("clicks add to List link")
	public void clicks_add_to_list_link() {
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.xpath("//*[@id=\"order-item_1\"]/div/div[5]/div[1]/button[1]")).click();
	}

	@Then("Sign In window appears")
	public void sign_in_window_appears() {
		WebDriverWait w2 = new WebDriverWait(driver, 8);
		w2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"signInHeader\"]")));
		WebElement z = driver.findElement(By.xpath("//*[@id=\"signInHeader\"]"));
		try {
			assertEquals("Sign In", z.getText());
		} catch (Error e) {
			fail(e.toString());
		}
		driver.quit();
	}

	@AfterClass
	public void closebrowser() {
		try {
			System.out.println("Test 1 ");
			driver.close();
		} catch (Exception e) {
		}
	}

}
