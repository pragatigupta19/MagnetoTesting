package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import PageObjects.AccountPage;
import PageObjects.BeforeObjects;
import io.cucumber.java.After;
import io.cucumber.java.en.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import PageObjects.LoginPage;

public class StepDefinitions {
	
	WebDriver driver;
    AccountPage accountPage;
    LoginPage loginPage;
       
  @Given("launch the Browser and Open url")
  public void launch_the_browser_and_open_url() {
	  driver = BeforeObjects.getChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
        
    

    @When("Click on Create an Account button")
    public void click_on_createanaccount_button() {
        driver.findElement(By.linkText("Create an Account")).click();
        accountPage = new AccountPage(driver);
    }

    @When("Enter first name {string}, last name {string}, email {string}, and password {string}")
    public void enter_account_details(String firstName, String lastName, String email, String password) throws InterruptedException {
        accountPage.enterFirstName(firstName);
        accountPage.enterLastName(lastName);
        accountPage.enterEmail(email);
        accountPage.enterPassword(password);
        accountPage.confirmPassword(password);
        accountPage.clickCreateAccount();
        Thread.sleep(2000);
    }    
       @When("Click on Log out") 
       public void click_on_log_out() throws InterruptedException
       {
        accountPage.clickdropdowntologout();
        accountPage.clicklogout();
        Thread.sleep(3000);
        }
 

    @When("Click on Sign In button")
    public void click_on_sign_in_button() {
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();
        loginPage = new LoginPage(driver);
    }

    @When("Enter email {string} and password {string}")
    public void enter_login_details(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickSignIn();
    }

    @Then("User log out successfully")
    public void log_out_successfully() {
  		  String expected_url="https://magento.softwaretestingboard.com/customer/account/logoutSuccess/";
  		  Assert.assertEquals(driver.getCurrentUrl(), expected_url);
    }
    
    @Then("Enter invalid email showerror")
    public void enter_invalid_email_showerror()
    {
    	String actual_error="There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.";
    	String expected_error=driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")).getText();
    	Assert.assertEquals(actual_error, expected_error);
    }
    
    @Then("Enter invalid email login error")
    public void enter_invalid_email_login_error()
    {
    	String actual_error="The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
    	String expected_error=driver.findElement(By.xpath("//div[contains(text(),'The account sign-in was incorrect')]")).getText();
    	Assert.assertEquals(actual_error, expected_error);
    }
    
    @Then("User signed in successfully")
    public void user_signed_in_successfully() {
    	String expected_url="https://magento.softwaretestingboard.com/customer/account/";
		  Assert.assertEquals(driver.getCurrentUrl(), expected_url);
    }

//    @After
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}

