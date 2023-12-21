package Task3;

import Driver.Globaldriver;
import Elements.Web_elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Scenario2 {
    public static WebElement ProductsMsg;
    @Test
    public void login_valid() throws IOException {
        WebDriver driver = Globaldriver.StartWebDriver();
        Web_elements.username(driver).sendKeys("standard_user");
        Web_elements.password(driver).sendKeys("secret_sauce");
        Web_elements.login_btn(driver).click();
        ProductsMsg = Web_elements.Products_msg(driver);
        Assert.assertTrue(ProductsMsg.isDisplayed(), "User is not on the home page");
        driver.quit();
    }

}
