package Task3;

import Elements.Web_elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Scenario1 {
    @Test
    public void login_invalid() throws IOException {
        Properties prop = new Properties();
        FileInputStream ip = new FileInputStream("/home/vend/IdeaProjects/Selenium_Assignment/src/test/java/Resources/config.properties");
        prop.load(ip);
        if(prop.getProperty("browser").equals("chrome")){
            WebDriver driver = new ChromeDriver();
            driver.navigate().to(prop.getProperty("url"));
            Web_elements.username(driver).sendKeys("standard_user");
            Web_elements.password(driver).sendKeys("secret123");
            Web_elements.login_btn(driver).click();
        }
        if(prop.getProperty("browser").equals("firefox")){
            WebDriver driver2 = new FirefoxDriver();
            driver2.navigate().to(prop.getProperty("url"));
            Web_elements.username(driver2).sendKeys("standard_user");
            Web_elements.password(driver2).sendKeys("secret123");
            Web_elements.login_btn(driver2).click();
        }
    }
}
