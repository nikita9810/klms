package stepDefinations;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class assessment {
	
	 WebDriver driver;
	 	
	 @Given("^User land on the krademyLMS url$")
	    public void user_land_on_the_threatcop_url() throws Throwable {
	       
	    System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
		
		driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get("https://app.krademylms.com/login");
		driver.manage().window().maximize();
	 }
	    @When("^User will fill the correct userid and password$")
	    public void user_will_fill_the_correct_userid_and_password() throws Throwable {
	    	driver.findElement(By.xpath("//input[@id='email']")).click();
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("nikita.paliwal@kratikal.com");
			//driver.findElement(By.xpath("//button[@onclick=\"step2()\"]")).click();
			driver.findElement(By.xpath("//input[@id='password']")).click();
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Qwerty@12");
	    }

	    @Then("^User able to login with correct id and password$")
	    public void user_able_to_login_with_correct_id_and_password() throws Throwable {
	    	driver.findElement(By.xpath("//button[@onclick=\"rootLogin()\"]")).click();
	    }
	    @Given("^User able to click on courses and then click on the Create course$")
	    public void user_able_to_click_on_courses_and_then_click_on_the_create_course() throws Throwable {
	    	driver.findElement(By.xpath("//a[@href='/courses']")).click(); 
	    	driver.findElement(By.xpath("//a[@href=\"/create-course?type=streaming\"]")).click(); 

	    	
	    }

	    @When("^User able to fill all the details in course detail$")
	    public void user_able_to_fill_all_the_details_in_course_detail() throws Throwable {
	    	driver.findElement(By.xpath("//input[@id=\"courseName\"]")).click();
	    	
	    	 Random randomGenerator = new Random();
	    	 int randomInt = randomGenerator.nextInt(1000);
	    	 driver.findElement(By.xpath("//input[@id=\"courseName\"]")).sendKeys("test"+randomInt);
	    	
//	    	driver.findElement(By.xpath("//a[@class=\"create_sk\"]")).click(); 
//            driver.findElement(By.xpath("//input[@id=\"skillNewName\"]")).click();
//            Random randomGenerator1 = new Random();
//    		int randomInt1 = randomGenerator1.nextInt(1000);
//    		driver.findElement(By.xpath("//input[@id=\"skillNewName\"]")).sendKeys("Test"+randomInt);
//	    		    	
//	    	driver.findElement(By.xpath("//button[@onclick=\"addNewSkill()\"]")).click();
    	
	    	 driver.findElement(By.xpath("//div[@class=\"accor\"]")).click(); 
	    	//driver.findElement(By.xpath("//div[@class=\"accor\"]")).click();
	    	WebElement mutliSelect = driver.findElement(By.xpath("//li[@class=\"active\"]"));
	    	mutliSelect.findElements(By.xpath(".//li")).forEach(li -> 
	    	{   li.findElement(By.xpath(".//input[@onclick=\"setSelectedSkill()\"]")).click();
	    	});
	    	
//	    	WebElement multiSelect = driver.findElement(By.xpath("//span[@id=\"grp-51\"]"));
//	    	Object element = null;
//			((JavascriptExecutor)driver).executeScript("id=\"51\"", element);
//	    	multiSelect.findElements(By.xpath(".//li")).forEach(li -> {   
//	    		li.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
//	    	});
	    	
			driver.findElement(By.xpath("//input[@id=\"filePhoto\"]")).sendKeys("C:\\Users\\kratikal\\Desktop\\download.jpg");
	
	    }

	   
		@Then("^User will click on Next button $")
	    public void user_will_click_on_next_button() throws Throwable {
	    	driver.findElement(By.xpath("//a[@onclick=\"saveCourse()\"]")).click();
			Thread.sleep(2000);

			//WebElement element = driver.findElement(By.xpath("//a[@onclick=\\\"saveCourse()\\']"));
			//((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);

			
	    	//driver.findElement(By.xpath("//button[@onclick=\"saveCourse()\"]")).click();

	    }

}