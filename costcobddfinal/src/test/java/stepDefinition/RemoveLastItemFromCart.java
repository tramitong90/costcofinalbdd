
package stepDefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RemoveLastItemFromCart {

	WebDriver driver = null;

	@Given("open browser")
	public void open_browser() {
		System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Given("User is on costco main page")
	public void user_is_on_costco_main_page() {
		driver.get("https://www.costco.com/quaker%2c-oats-old-fashioned-oatmeal%2c-10-lbs.product.100381521.html");
	}

	@When("User adds the product to the cart")
	public void user_adds_the_product_to_the_cart() {
		WebDriverWait wait = new WebDriverWait(driver, 10); // 20 sec
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-to-cart-btn")));
		driver.findElement(By.id("add-to-cart-btn")).click();
	}

	@When("shopping cart is open")
	public void shopping_cart_is_open() {
		WebDriverWait wait2 = new WebDriverWait(driver, 20); // 20 sec
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"costcoModalText\"]/div[2]/div[2]/a")));
		driver.findElement(By.xpath("//*[@id=\"costcoModalText\"]/div[2]/div[2]/a")).click();
	}

	@When("clicks remove link")
	public void clicks_remove_link() {
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.cssSelector("span[automation-id='removeItemLink_1']")).click();

	}

	@Then("cart is empty")
	public void cart_is_empty() {
		
		boolean notPresent;
		
		try {
			(driver.findElements(By.cssSelector("a [automation-id = 'productTitleLinks_1']"))).isEmpty();
			notPresent = true;
		} catch (NoSuchElementException e) {
			notPresent = false;
		}
		
		assertEquals(notPresent, true);
		
		

		try {
			WebDriverWait wait3 = new WebDriverWait(driver, 8); // 20 sec
			wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/div[3]/div[2]/div[4]/div[2]")));
			assertEquals(driver.findElement(By.xpath("/html/body/main/div[3]/div[2]/div[4]/div[2]")).getText().equalsIgnoreCase("Your shopping cart is empty. Please add at least one item to your cart before checking out."),true);

		} catch (Error e) {
			fail(e.toString());
		}
		driver.quit();
	}

	@AfterClass
	public void closebrowser() {
		try {

			System.out.println("Test 4 ");
			driver.close();
		} catch (Exception e) {
		}
	}

}
