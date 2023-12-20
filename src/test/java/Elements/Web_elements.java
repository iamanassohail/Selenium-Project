package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Web_elements {
    public static WebElement username(WebDriver driver){
        return driver.findElement(By.id("user-name"));
    }

    public static WebElement password(WebDriver driver){
        return driver.findElement(By.id("password"));
    }

    public static WebElement login_btn(WebDriver driver){
        return driver.findElement(By.id("login-button"));
    }
    public static WebElement Products_msg(WebDriver driver){
        return driver.findElement(By.className("title"));
    }
    public static WebElement Error_msg(WebDriver driver){
        return driver.findElement(By.className("error-button"));
    }
}
