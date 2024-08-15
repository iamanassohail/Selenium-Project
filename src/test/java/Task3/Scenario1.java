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
import io.percy.selenium.Percy;

public class Scenario1 {

    public Percy percy;
    @Test
    public void login_invalid() throws IOException {
        Properties prop = new Properties();
        FileInputStream ip = new FileInputStream("C:\\Users\\anas.sohail_ventured\\Desktop\\Selenium-own-framework\\src\\test\\java\\Resources\\config.properties");
        prop.load(ip);
        if(prop.getProperty("browser").equals("chrome")){
            WebDriver driver = new ChromeDriver();
            driver.navigate().to(prop.getProperty("url"));
            percy = new Percy(driver);
            //percy.screenshot("Screenshot_1");
            percy.snapshot("Screenshot_1");
            Web_elements.username(driver).sendKeys("standard_user");
            Web_elements.password(driver).sendKeys("secret123");
            Web_elements.login_btn(driver).click();
            //percy.screenshot("Screenshot_2");
            percy.snapshot("Screenshot_2");
        }
        if(prop.getProperty("browser").equals("firefox")){
            WebDriver driver2 = new FirefoxDriver();
            driver2.navigate().to(prop.getProperty("url"));
            percy = new Percy(driver2);
            //percy.screenshot("Screenshot_1");
            percy.snapshot("Screenshot_1");
            Web_elements.username(driver2).sendKeys("standard_user");
            Web_elements.password(driver2).sendKeys("secret123");
            Web_elements.login_btn(driver2).click();
            //percy.screenshot("Screenshot_2");
            percy.snapshot("Screenshot_2");
        }
    }
}
