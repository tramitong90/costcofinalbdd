
package stepDefinition;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CostcoHomepage {
	WebDriver driver = null;

	@Given("browser is open")
	public void browser_is_open() {
		System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Given("User is on costco homepage")
	public void user_is_on_costco_homepage() {
		driver.get("https://www.costco.com/");
	}

	@When("user clicks on {string} menu")
	public void user_clicks_on_menu(String string) {
		driver.findElement(By.id(string)).click();
		;
	}

	@Then("user is brought to the  {string} page")
	public void user_is_brought_to_the_page(String string) throws InterruptedException {
		String currentPage = driver.getCurrentUrl(); // Thread.sleep(5000);
		assertEquals(currentPage, string);

		driver.quit();
	}

	@AfterClass
	public void closebrowser() {
		try {
			System.out.println("Test 2 ");
			driver.close();
		} catch (Exception e) {
		}
	}

}
