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

import static org.testng.AssertJUnit.assertEquals;

public class Scenario_3 {
    @Test
    public void SkinCareSection() throws IOException {
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

            WebElement skinCareLink = driver.findElement(By.xpath("//*[@id=\"categorymenu\"]/nav/ul/li[4]/a"));
            skinCareLink.click();

            // Assuming there are elements representing sale and out-of-stock items
            List<WebElement> saleItems = driver.findElements(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[3]/div[position() <= 3]"));
            List<WebElement> outOfStockItems = driver.findElements(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[3]/div[1]/div[1]/div/a"));

            int numberOfSaleItems = saleItems.size();
            int numberOfOutOfStockItems = outOfStockItems.size();

            System.out.println("Number of items on sale: " + numberOfSaleItems);
            System.out.println("Number of items out of stock: " + numberOfOutOfStockItems);

            // Assuming you want to add the first sale item to the cart
            WebElement firstSaleItem = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[3]/div[2]/div[1]/div/a"));
            firstSaleItem.click();
            WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"product\"]/fieldset/div[4]/ul/li/a"));
            addToCartButton.click();

            try {
                // Assuming you have an element that shows the total items in the cart
                WebElement cartItemsCountElement = driver.findElement(By.xpath("//*[@id=\"cart_quantity65\"]"));
                int totalItemsInCart = Integer.parseInt(cartItemsCountElement.getText().trim());

                // Assuming you have an element that shows the amount of sale items in the cart
                WebElement saleItemsCountElement = driver.findElement(By.xpath("//*[@id=\"cart_quantity65\"]"));
                int saleItemsInCart = Integer.parseInt(saleItemsCountElement.getText().trim());

                // Assert the count of total items in cart and the amount of sale items
                assertEquals("Assert the total items in cart", 1, totalItemsInCart);
                assertEquals("Assert the sale items in cart", 1, saleItemsInCart);
            } catch (NumberFormatException e) {
                // Handle the exception (print a message, log, etc.)
                System.err.println("Error parsing numeric values: " + e.getMessage());
            } finally {
                // Close the browser (you may want to keep the browser open for debugging)
                driver.quit();
            }
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

            WebElement skinCareLink = driver2.findElement(By.xpath("//*[@id=\"categorymenu\"]/nav/ul/li[4]/a"));
            skinCareLink.click();

            // Assuming there are elements representing sale and out-of-stock items
            List<WebElement> saleItems = driver2.findElements(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[3]/div[position() <= 3]"));
            List<WebElement> outOfStockItems = driver2.findElements(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[3]/div[1]/div[1]/div/a"));

            int numberOfSaleItems = saleItems.size();
            int numberOfOutOfStockItems = outOfStockItems.size();

            System.out.println("Number of items on sale: " + numberOfSaleItems);
            System.out.println("Number of items out of stock: " + numberOfOutOfStockItems);

            // Assuming you want to add the first sale item to the cart
            WebElement firstSaleItem = driver2.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div[3]/div[2]/div[1]/div/a"));
            firstSaleItem.click();
            WebElement addToCartButton = driver2.findElement(By.xpath("//*[@id=\"product\"]/fieldset/div[4]/ul/li/a"));
            addToCartButton.click();

            try {
                // Assuming you have an element that shows the total items in the cart
                WebElement cartItemsCountElement = driver2.findElement(By.xpath("//*[@id=\"cart_quantity65\"]"));
                int totalItemsInCart = Integer.parseInt(cartItemsCountElement.getText().trim());

                // Assuming you have an element that shows the amount of sale items in the cart
                WebElement saleItemsCountElement = driver2.findElement(By.xpath("//*[@id=\"cart_quantity65\"]"));
                int saleItemsInCart = Integer.parseInt(saleItemsCountElement.getText().trim());

                // Assert the count of total items in cart and the amount of sale items
                assertEquals("Assert the total items in cart", 1, totalItemsInCart);
                assertEquals("Assert the sale items in cart", 1, saleItemsInCart);
            } catch (NumberFormatException e) {
                // Handle the exception (print a message, log, etc.)
                System.err.println("Error parsing numeric values: " + e.getMessage());
            } finally {
                // Close the browser (you may want to keep the browser open for debugging)
                driver2.quit();
            }
        }
    }
}
