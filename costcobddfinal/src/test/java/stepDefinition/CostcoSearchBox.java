package stepDefinition;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CostcoSearchBox {
	WebDriver driver = null;
	
	@Given("I am on costco homepage")
	public void i_am_on_costco_homepage() {
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
		Thread.sleep(2000);
	    
	}

	@Then("I am brought the {string} page")
	public void i_am_brought_the_page(String string) {
		WebElement element1 = driver.findElement(By.xpath("//*[@id=\"category-name-header\"]/div/h1"));
//	    String title = driver.getTitle();
	    assertEquals(element1.getText(), string);
	    
	    driver.close();
	}

}
