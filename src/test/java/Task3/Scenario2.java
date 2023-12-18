package Task3;

import Driver.Globaldriver;
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

public class Scenario2 {
    @Test
    public void login_valid() throws IOException {
        WebDriver driver = Globaldriver.StartWebDriver();
        Web_elements.username(driver).sendKeys("standard_user");
        Web_elements.password(driver).sendKeys("secret_sauce");
        Web_elements.login_btn(driver).click();
        driver.quit();
    }

}
