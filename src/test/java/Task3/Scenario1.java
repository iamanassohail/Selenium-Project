package Task3;

import Driver.Globaldriver;
import Elements.Web_elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Scenario1 {
    @Test
    public void login_invalid() throws IOException {
        WebDriver driver = Globaldriver.StartWebDriver();
        Web_elements.username(driver).sendKeys("standard_user");
        Web_elements.password(driver).sendKeys("secret123");
        Web_elements.login_btn(driver).click();
        driver.quit();
    }
}
