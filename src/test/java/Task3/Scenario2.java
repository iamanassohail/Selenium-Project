package Task3;

import Driver.Globaldriver;
import Elements.Web_elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class Scenario2 {
    @Test
    public void login_valid() throws IOException {
        WebDriver driver = Globaldriver.StartWebDriver();
        Web_elements.username(driver).sendKeys("standard_user");
        Web_elements.password(driver).sendKeys("secret_sauce");
        Web_elements.login_btn(driver).click();
        WebElement ProductsMsg = Web_elements.Products_msg(driver);
        Assert.assertTrue(ProductsMsg.isDisplayed(), "User is not on the home page");
        driver.quit();
    }

}
