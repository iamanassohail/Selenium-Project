package Task3;

import Driver.Globaldriver;
import Elements.Web_elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class Scenario1 {
    public static WebElement ErrorMsg;
    public static String usernameToSend = "standard_user";
    public static String passwordToSend = "secret123";
    @Test
    public void login_invalid() throws IOException {
        WebDriver driver = Globaldriver.StartWebDriver();
        Web_elements.username(driver).sendKeys(usernameToSend);
        Web_elements.password(driver).sendKeys(passwordToSend);
        Web_elements.login_btn(driver).click();
        ErrorMsg = Web_elements.Error_msg(driver);
        Assert.assertTrue(ErrorMsg.isDisplayed(), "Error message is not displayed");
        driver.quit();
    }
}
