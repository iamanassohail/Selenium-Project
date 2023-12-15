package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Globaldriver {
    @Test
    public static void StartWebDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream ip = new FileInputStream("C:\\Users\\anas.sohail_ventured\\Desktop\\Selenium-Project-main\\src\\test\\java\\Resources\\config.properties");
        prop.load(ip);
        if(prop.getProperty("browser").equals("chrome")){
            WebDriver driver = new ChromeDriver();
            driver.navigate().to(prop.getProperty("url"));
        }
        else{
            WebDriver driver = new FirefoxDriver();
            driver.navigate().to(prop.getProperty("url"));
        }
    }
}
