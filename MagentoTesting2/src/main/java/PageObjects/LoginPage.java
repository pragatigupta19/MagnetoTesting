package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	    private WebDriver driver;

	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void enterEmail(String email) {
	        driver.findElement(By.id("email")).sendKeys(email);
	    }

	    public void enterPassword(String password) {
	        driver.findElement(By.id("pass")).sendKeys(password);
	    }

	    public void clickSignIn() {
	        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
	    }
	}

