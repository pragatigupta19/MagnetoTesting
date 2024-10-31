package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.Before;

public class AccountPage {
	
	private WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String firstName) {
        driver.findElement(By.id("firstname")).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(By.id("lastname")).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        driver.findElement(By.id("email_address")).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    public void confirmPassword(String password) {
        driver.findElement(By.id("password-confirmation")).sendKeys(password);
    }

    public void clickCreateAccount() {
        driver.findElement(By.xpath("(//span[text()='Create an Account'])[1]")).click();
    }
    public void clickdropdowntologout() {
    	driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")).click();
    }
    public void clicklogout()
    {
    	driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")).click();
    	
    }
}