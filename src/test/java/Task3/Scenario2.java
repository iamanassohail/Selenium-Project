package Task3;

import Elements.Web_elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import io.percy.selenium.Percy;

public class Scenario2 {

    public Percy percy;
    @Test
    public void login_valid() throws IOException {
        Properties prop = new Properties();
        FileInputStream ip = new FileInputStream("C:\\Users\\anas.sohail_ventured\\Desktop\\Selenium-own-framework\\src\\test\\java\\Resources\\config.properties");
        prop.load(ip);
        if(prop.getProperty("browser").equals("chrome")){
            WebDriver driver = new ChromeDriver();
            percy = new Percy(driver);
            driver.navigate().to(prop.getProperty("url"));
            percy.snapshot("Screenshot_1");
            //percy.screenshot("Screenshot_1");
            Web_elements.username(driver).sendKeys("standard_user");
            Web_elements.password(driver).sendKeys("secret_sauce");
            Web_elements.login_btn(driver).click();
            percy.snapshot("Screenshot_2");
            //percy.screenshot("Screenshot_2");
        }
        if(prop.getProperty("browser").equals("firefox")){
            WebDriver driver2 = new FirefoxDriver();
            percy = new Percy(driver2);
            driver2.navigate().to(prop.getProperty("url"));
            percy.snapshot("Screenshot_1");
            //percy.screenshot("Screenshot_1");
            Web_elements.username(driver2).sendKeys("standard_user");
            Web_elements.password(driver2).sendKeys("secret_sauce");
            Web_elements.login_btn(driver2).click();
            percy.snapshot("Screenshot_1");
            //percy.screenshot("Screenshot_2");
        }
    }

}
