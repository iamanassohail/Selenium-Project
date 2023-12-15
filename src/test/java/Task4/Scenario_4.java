package Task4;

import Elements.Web_elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import static org.testng.AssertJUnit.assertTrue;

public class Scenario_4 {
    @Test
    public void addProductNameEndingWithM() throws IOException {
        Properties prop = new Properties();
        FileInputStream ip = new FileInputStream("C:\\Users\\anas.sohail_ventured\\Desktop\\Selenium-Project-main\\src\\test\\java\\Resources\\config.properties");
        prop.load(ip);
        if(prop.getProperty("browser").equals("chrome")){
            WebDriver driver = new ChromeDriver();
            driver.navigate().to(prop.getProperty("url2"));
            // Assuming there is a login link that opens a login form
            WebElement loginLink = driver.findElement(By.xpath("//*[@id=\"customer_menu_top\"]/li/a"));
            loginLink.click();

            // Assuming there are input fields for username and password
            WebElement usernameInput = driver.findElement(By.xpath("//*[@id=\"loginFrm_loginname\"]"));
            WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"loginFrm_password\"]"));
            WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"loginFrm\"]/fieldset/button"));

            usernameInput.sendKeys("anas123");
            passwordInput.sendKeys("1234");
            loginButton.click();

            // Go to Men section
//        WebElement Cart = driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div/div[3]/ul/li/a"));
//        Cart.click();
            WebElement menSection = driver.findElement(By.xpath("//*[@id=\"categorymenu\"]/nav/ul/li[6]/a"));
            menSection.click();

            // Add the product to the cart whose name ends with M
            List<WebElement> products = driver.findElements(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[2]/div[1]"));
            for (WebElement product : products) {
                WebElement productNameElement = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[2]/div[1]/div[1]/div/a"));
                String productName = productNameElement.getText();
                if (productName.endsWith("m")) {
                    WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[2]/div[1]/div[2]/div[3]/a"));
                    addToCartButton.click();
                    WebElement Add = driver.findElement(By.xpath("//*[@id=\"product\"]/fieldset/div[5]/ul/li/a"));
                    Add.click();
                    break;
                }
            }

            // Assert the item in the cart ends with the name M
            WebElement Cart = driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div/div[3]/ul/li/a"));
            Cart.click();
            WebElement cartItemName = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/form/div/div[1]/table/tbody/tr[2]/td[2]/a"));
            String itemNameInCart = cartItemName.getText();
            assertTrue("Assert the item in the cart should end with the name m", itemNameInCart.endsWith("m"));

            // Close the browser (you may want to keep the browser open for debugging)
            driver.quit();
        }
        if(prop.getProperty("browser").equals("firefox")){
            WebDriver driver2 = new FirefoxDriver();
            driver2.navigate().to(prop.getProperty("url2"));
            // Assuming there is a login link that opens a login form
            WebElement loginLink = driver2.findElement(By.xpath("//*[@id=\"customer_menu_top\"]/li/a"));
            loginLink.click();

            // Assuming there are input fields for username and password
            WebElement usernameInput = driver2.findElement(By.xpath("//*[@id=\"loginFrm_loginname\"]"));
            WebElement passwordInput = driver2.findElement(By.xpath("//*[@id=\"loginFrm_password\"]"));
            WebElement loginButton = driver2.findElement(By.xpath("//*[@id=\"loginFrm\"]/fieldset/button"));

            usernameInput.sendKeys("anas123");
            passwordInput.sendKeys("1234");
            loginButton.click();

            // Go to Men section
//        WebElement Cart = driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div/div[3]/ul/li/a"));
//        Cart.click();
            WebElement menSection = driver2.findElement(By.xpath("//*[@id=\"categorymenu\"]/nav/ul/li[6]/a"));
            menSection.click();

            // Add the product to the cart whose name ends with M
            List<WebElement> products = driver2.findElements(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[2]/div[1]"));
            for (WebElement product : products) {
                WebElement productNameElement = driver2.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[2]/div[1]/div[1]/div/a"));
                String productName = productNameElement.getText();
                if (productName.endsWith("m")) {
                    WebElement addToCartButton = driver2.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[2]/div[1]/div[2]/div[3]/a"));
                    addToCartButton.click();
                    WebElement Add = driver2.findElement(By.xpath("//*[@id=\"product\"]/fieldset/div[5]/ul/li/a"));
                    Add.click();
                    break;
                }
            }

            // Assert the item in the cart ends with the name M
            WebElement Cart = driver2.findElement(By.xpath("/html/body/div[1]/header/div[2]/div/div[3]/ul/li/a"));
            Cart.click();
            WebElement cartItemName = driver2.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/form/div/div[1]/table/tbody/tr[2]/td[2]/a"));
            String itemNameInCart = cartItemName.getText();
            assertTrue("Assert the item in the cart should end with the name m", itemNameInCart.endsWith("m"));

            // Close the browser (you may want to keep the browser open for debugging)
            driver2.quit();
        }
    }
}
