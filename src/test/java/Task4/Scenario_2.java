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
import java.util.List;
import java.util.Properties;

import static org.testng.AssertJUnit.assertEquals;

public class Scenario_2 {
    @Test
    public void DoveItems() throws IOException {
        Properties prop = new Properties();
        FileInputStream ip = new FileInputStream("C:\\Users\\anas.sohail_ventured\\Desktop\\Selenium-Project-main\\src\\test\\java\\Resources\\config.properties");
        prop.load(ip);
        if (prop.getProperty("browser").equals("chrome")) {
            WebDriver driver = new ChromeDriver();
            driver.navigate().to(prop.getProperty("url2"));
            WebElement loginLink = driver.findElement(By.xpath("//*[@id=\"customer_menu_top\"]/li/a"));
            loginLink.click();

            // Assuming there are input fields for username and password
            WebElement usernameInput = driver.findElement(By.xpath("//*[@id=\"loginFrm_loginname\"]"));
            WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"loginFrm_password\"]"));
            WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"loginFrm\"]/fieldset/button"));

            usernameInput.sendKeys("anas123");
            passwordInput.sendKeys("1234");
            loginButton.click();

            // Go to Apparel & Accessories > Tshirts
            /*WebElement apparelSection = driver.findElement(By.cssSelector("#categorymenu > nav > ul > li:nth-child(2) > a"));
            apparelSection.click();
            WebElement tShirtsLink = driver.findElement(By.cssSelector("#maincontainer > div > div > div > div > ul > li:nth-child(2) > div > a"));
            tShirtsLink.click();

            // Sort Tshirts by low to high rate
            WebElement sortByDropdown = driver.findElement(By.cssSelector("#sort"));
            sortByDropdown.click();
            WebElement lowToHighOption = driver.findElement(By.cssSelector("#sort > option:nth-child(4)"));
            lowToHighOption.click();

            // Select the top 3 lowest value Tshirts of medium size
            List<WebElement> tShirts = driver.findElements(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[3]"));
            for (int i = 0; i < 3; i++) {
                WebElement tShirt = tShirts.get(i);
                WebElement navigateTotshirt = tShirt.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[3]/div[6]/div[2]/a"));
                navigateTotshirt.click();

                // Ensure size is medium
                WebElement sizeDropdown = tShirt.findElement(By.cssSelector("#option351"));
                sizeDropdown.sendKeys("Medium");
                WebElement addToCart = tShirt.findElement(By.cssSelector("#product > fieldset > div:nth-child(6) > ul > li > a"));
                addToCart.click();*/

            // Go back to Apparel & Accessories > Shoes
            WebElement apparelSection = driver.findElement(By.cssSelector("#categorymenu > nav > ul > li:nth-child(2) > a"));
            apparelSection.click();
            WebElement shoesLink = driver.findElement(By.cssSelector("#maincontainer > div > div > div > div > ul > li:nth-child(1) > div > a"));
            shoesLink.click();

            // Add the highest value shoe to the cart with a quantity of 2
            WebElement highestValueShoe = driver.findElement(By.cssSelector("#maincontainer > div > div > div > div > div.thumbnails.grid.row.list-inline > div:nth-child(3) > div.thumbnail > a"));
            //WebElement addToCartButton = highestValueShoe.findElement(By.xpath("#product > fieldset > div:nth-child(5) > ul > li > a"));
            highestValueShoe.click();

            WebElement quantityInput = driver.findElement(By.cssSelector("#product_quantity"));
            quantityInput.clear();
            quantityInput.sendKeys("2");
            WebElement addToCartButton2 = driver.findElement(By.cssSelector("#product > fieldset > div:nth-child(5) > ul > li > a"));
            addToCartButton2.click();

            // Assert the selected items in the cart
            List<WebElement> cartItems = driver.findElements(By.cssSelector("#main_menu_top > li:nth-child(3) > a > span"));
            assertEquals("Assert the selected items in the cart", 1, cartItems.size());

            // Close the browser (you may want to keep the browser open for debugging)
            driver.quit();

        }
        if (prop.getProperty("browser").equals("firefox")) {
            WebDriver driver2 = new FirefoxDriver();
            driver2.navigate().to(prop.getProperty("url2"));
            WebElement loginLink = driver2.findElement(By.xpath("//*[@id=\"customer_menu_top\"]/li/a"));
            loginLink.click();

            // Assuming there are input fields for username and password
            WebElement usernameInput = driver2.findElement(By.xpath("//*[@id=\"loginFrm_loginname\"]"));
            WebElement passwordInput = driver2.findElement(By.xpath("//*[@id=\"loginFrm_password\"]"));
            WebElement loginButton = driver2.findElement(By.xpath("//*[@id=\"loginFrm\"]/fieldset/button"));

            usernameInput.sendKeys("anas123");
            passwordInput.sendKeys("1234");
            loginButton.click();

            // Go to Apparel & Accessories > Tshirts
            /*WebElement apparelSection = driver.findElement(By.cssSelector("#categorymenu > nav > ul > li:nth-child(2) > a"));
            apparelSection.click();
            WebElement tShirtsLink = driver.findElement(By.cssSelector("#maincontainer > div > div > div > div > ul > li:nth-child(2) > div > a"));
            tShirtsLink.click();

            // Sort Tshirts by low to high rate
            WebElement sortByDropdown = driver.findElement(By.cssSelector("#sort"));
            sortByDropdown.click();
            WebElement lowToHighOption = driver.findElement(By.cssSelector("#sort > option:nth-child(4)"));
            lowToHighOption.click();

            // Select the top 3 lowest value Tshirts of medium size
            List<WebElement> tShirts = driver.findElements(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[3]"));
            for (int i = 0; i < 3; i++) {
                WebElement tShirt = tShirts.get(i);
                WebElement navigateTotshirt = tShirt.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[3]/div[6]/div[2]/a"));
                navigateTotshirt.click();

                // Ensure size is medium
                WebElement sizeDropdown = tShirt.findElement(By.cssSelector("#option351"));
                sizeDropdown.sendKeys("Medium");
                WebElement addToCart = tShirt.findElement(By.cssSelector("#product > fieldset > div:nth-child(6) > ul > li > a"));
                addToCart.click();*/

            // Go back to Apparel & Accessories > Shoes
            WebElement apparelSection = driver2.findElement(By.cssSelector("#categorymenu > nav > ul > li:nth-child(2) > a"));
            apparelSection.click();
            WebElement shoesLink = driver2.findElement(By.cssSelector("#maincontainer > div > div > div > div > ul > li:nth-child(1) > div > a"));
            shoesLink.click();

            // Add the highest value shoe to the cart with a quantity of 2
            WebElement highestValueShoe = driver2.findElement(By.cssSelector("#maincontainer > div > div > div > div > div.thumbnails.grid.row.list-inline > div:nth-child(3) > div.thumbnail > a"));
            //WebElement addToCartButton = highestValueShoe.findElement(By.xpath("#product > fieldset > div:nth-child(5) > ul > li > a"));
            highestValueShoe.click();

            WebElement quantityInput = driver2.findElement(By.cssSelector("#product_quantity"));
            quantityInput.clear();
            quantityInput.sendKeys("2");
            WebElement addToCartButton2 = driver2.findElement(By.cssSelector("#product > fieldset > div:nth-child(5) > ul > li > a"));
            addToCartButton2.click();

            // Assert the selected items in the cart
            List<WebElement> cartItems = driver2.findElements(By.cssSelector("#main_menu_top > li:nth-child(3) > a > span"));
            assertEquals("Assert the selected items in the cart", 1, cartItems.size());

            // Close the browser (you may want to keep the browser open for debugging)
            driver2.quit();
        }
    }
}

