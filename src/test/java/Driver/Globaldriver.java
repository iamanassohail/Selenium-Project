package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Globaldriver {
    public static WebDriver StartWebDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream ip = new FileInputStream("C:\\Users\\anas.sohail_ventured\\Desktop\\Selenium-Project-main\\src\\test\\java\\Resources\\config.properties");
        prop.load(ip);
        WebDriver driver;
        if(prop.getProperty("browser").equals("chrome")){
            ChromeOptions op = new ChromeOptions();
            op.addArguments("--start-maximized");
            op.addArguments("start-fullscreen");
            driver = new ChromeDriver(op);
            driver.navigate().to(prop.getProperty("url"));
        }
        else{
            FirefoxOptions op = new FirefoxOptions();
            op.addArguments("--start-maximized");
            op.addArguments("start-fullscreen");
            driver = new FirefoxDriver(op);
            driver.navigate().to(prop.getProperty("url"));
        }
        return driver;
    }
}
