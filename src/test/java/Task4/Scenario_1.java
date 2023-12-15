package Task4;

import Elements.Web_elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Scenario_1 {
    @Test
    public void DoveItems() throws IOException {
        Properties prop = new Properties();
        FileInputStream ip = new FileInputStream("C:\\Users\\anas.sohail_ventured\\Desktop\\Selenium-Project-main\\src\\test\\java\\Resources\\config.properties");
        prop.load(ip);
        if(prop.getProperty("browser").equals("chrome")){
            WebDriver driver = new ChromeDriver();
            driver.navigate().to(prop.getProperty("url2"));
            WebElement loginLink = driver.findElement(By.xpath("//*[@id=\"customer_menu_top\"]/li/a"));
            loginLink.click();

            // Assuming there are input fields for username and password
            WebElement usernameInput = driver.findElement(By.xpath("//*[@id=\"loginFrm_loginname\"]"));
            WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"loginFrm_password\"]"));
            WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"loginFrm\"]/fieldset/button"));

            usernameInput.sendKeys("anas12345");
            passwordInput.sendKeys("1234");
            loginButton.click();

            WebElement Home = driver.findElement((By.xpath("//*[@id=\"categorymenu\"]/nav/ul/li[1]/a")));
            Home.click();
            WebElement brandsSection = driver.findElement(By.xpath("//*[@id=\"brandcarousal\"]/li[7]/div[1]/a"));
            brandsSection.click();

            // Scroll to DOVE items and select the newest item
            WebElement doveItem = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[2]/div[1]/div[2]/div[3]/a"));
            doveItem.click();

            // Add the item to the cart
            WebElement addToCartButton = driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div/div[3]/ul/li/a"));
            addToCartButton.click();

            WebElement cartItem = driver.findElement(By.xpath("//*[@id=\"cart\"]/div/div[1]/table/tbody/tr[2]/td[4]"));
            String cartItemText = cartItem.getText();
            Assert.assertEquals(cartItemText,"$7.20");

            // Close the browser (you may want to keep the browser open for debugging)
            driver.quit();

        }
        if(prop.getProperty("browser").equals("firefox")){
            WebDriver driver2 = new FirefoxDriver();
            driver2.navigate().to(prop.getProperty("url2"));
            WebElement loginLink = driver2.findElement(By.xpath("//*[@id=\"customer_menu_top\"]/li/a"));
            loginLink.click();

            // Assuming there are input fields for username and password
            WebElement usernameInput = driver2.findElement(By.xpath("//*[@id=\"loginFrm_loginname\"]"));
            WebElement passwordInput = driver2.findElement(By.xpath("//*[@id=\"loginFrm_password\"]"));
            WebElement loginButton = driver2.findElement(By.xpath("//*[@id=\"loginFrm\"]/fieldset/button"));

            usernameInput.sendKeys("anas12345");
            passwordInput.sendKeys("1234");
            loginButton.click();

            WebElement Home = driver2.findElement((By.xpath("//*[@id=\"categorymenu\"]/nav/ul/li[1]/a")));
            Home.click();
            WebElement brandsSection = driver2.findElement(By.xpath("//*[@id=\"brandcarousal\"]/li[7]/div[1]/a"));
            brandsSection.click();

            // Scroll to DOVE items and select the newest item
            WebElement doveItem = driver2.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[2]/div[1]/div[2]/div[3]/a"));
            doveItem.click();

            // Add the item to the cart
            WebElement addToCartButton = driver2.findElement(By.xpath("/html/body/div[1]/header/div[2]/div/div[3]/ul/li/a"));
            addToCartButton.click();

            WebElement cartItem = driver2.findElement(By.xpath("//*[@id=\"cart\"]/div/div[1]/table/tbody/tr[2]/td[4]"));
            String cartItemText = cartItem.getText();
            Assert.assertEquals(cartItemText,"$7.20");

            // Close the browser (you may want to keep the browser open for debugging)
            driver2.quit();
        }
    }
}
