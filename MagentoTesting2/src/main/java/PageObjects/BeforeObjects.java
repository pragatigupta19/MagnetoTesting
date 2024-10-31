package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BeforeObjects {
	
	
	    public static ChromeDriver getChromeDriver() {
	        WebDriverManager.chromedriver().setup();
	        ChromeOptions chromeOptions = new ChromeOptions();
	        chromeOptions.addArguments("--start-maximized");
	        chromeOptions.addArguments("--remote-allow-origins=*");
	        return new ChromeDriver(chromeOptions);
	    }
	    
	    public void ScrollDown()
	    {
	    	JavascriptExecutor driver = null;
			JavascriptExecutor js = (JavascriptExecutor)driver;
	        js.executeScript("window.scrollBy(0, 200)"); 
	    }
	}
