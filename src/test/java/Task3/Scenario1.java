package Task3;

import Driver.Globaldriver;
import Elements.Web_elements;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class Scenario1 {
    @Test
    public void login_invalid() throws IOException {
        WebDriver driver = Globaldriver.StartWebDriver();
        Web_elements.username(driver).sendKeys("standard_user");
        Web_elements.password(driver).sendKeys("secret123");
        Web_elements.login_btn(driver).click();
    }
}
