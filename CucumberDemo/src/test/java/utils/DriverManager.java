package utils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverManager {
    private static ThreadLocal<RemoteWebDriver> webDriver = new ThreadLocal<RemoteWebDriver>();
    private static Logger logger = LogManager.getLogger("DriverManager");
	
    public static void initDriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "chromedriver.exe");
		webDriver.set(new ChromeDriver());
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    public static WebDriver getDriver() {
    	return webDriver.get();
    }
    
    public static void shutdownDriver() {
        logger.info("Shutting Down Driver");
        if (getDriver() != null) {
            getDriver().quit();
        }
        else {
            logger.info("Nothing to shut down");
        }
    }
}
