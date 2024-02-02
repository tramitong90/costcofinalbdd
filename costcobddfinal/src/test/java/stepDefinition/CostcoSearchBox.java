
package stepDefinition;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CostcoSearchBox {
	WebDriver driver = null;

	@Given("browser opens")
	public void browser_opens() {
		System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.costco.com/");
	}

	@When("I enter {string}")
	public void i_enter(String string) throws InterruptedException {
		WebElement element = driver.findElement(By.id("search-field"));
		element.sendKeys(string);
		element.submit(); 
		 //Thread.sleep(2000);

	}

	@Then("I am brought the {string} page")
	public void i_am_brought_the_page(String string) {
		WebDriverWait wait = new WebDriverWait(driver, 20); // 20 sec
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"category-name-header\"]/div/h1")));
		WebElement element1 = driver.findElement(By.xpath("//*[@id=\"category-name-header\"]/div/h1")); //
		//String title = driver.getTitle();
		assertEquals(element1.getText(), string);
		driver.quit();
	}

}
