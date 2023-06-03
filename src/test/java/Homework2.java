import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import javax.swing.*;
import java.time.Duration;
import java.util.*;

public class Homework2 {
    @Test
    public void task() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/Te\n" +
                "stComplete11/WebOrders/Login.aspx?");
        Assert.assertEquals(driver.getTitle(), "Web Orders Login");
        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");
        WebElement logIn = driver.findElement(By.cssSelector(".button"));
        logIn.click();
        Assert.assertEquals(driver.getTitle(), "Web Orders");
        Assert.assertEquals(BrowserUtils.getText(driver.findElement(By.tagName("h2"))), "List of All Orders");
    }

    @Test
    public void task2() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");// upperCase Test doesn't work
        WebElement logIn = driver.findElement(By.cssSelector(".button"));
        logIn.click();
        WebElement allProductsButton = driver.findElement(By.linkText("View all products"));
        allProductsButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Products.aspx");
// with current Url I'm checking if allProductButton was Selected. Not sure how to do it different way???
        Assert.assertEquals(BrowserUtils.getText(driver.findElement(By.tagName("h2"))), "List of Products");
        Assert.assertTrue(driver.getCurrentUrl().contains("Products"));
    }

    @Test
    public void task3() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");// upperCase Test doesn't work
        WebElement logIn = driver.findElement(By.cssSelector(".button"));
        logIn.click();
        WebElement allOrders = driver.findElement(By.linkText("View all orders"));
        WebElement allProducts = driver.findElement(By.linkText("View all products"));
        WebElement orders = driver.findElement(By.linkText("Order"));
        List<WebElement> all3links = driver.findElements(By.xpath("//ul[@class='menu']//a"));
        for (int i = 0; i < all3links.size(); i++) {
            System.out.println(all3links.get(i).getAttribute("href"));
        }
        Assert.assertTrue(allOrders.getAttribute("href").contains("Default.aspx"));
        Assert.assertTrue(allProducts.getAttribute("href").contains("Products.aspx"));
        Assert.assertTrue(orders.getAttribute("href").contains("Process.aspx"));
    }

    @Test
    public void task4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");// upperCase Test doesn't work
        WebElement logIn = driver.findElement(By.cssSelector(".button"));
        logIn.click();
        WebElement orders = driver.findElement(By.linkText("Order"));
        orders.click();
        WebElement selectDropDown = driver.findElement(By.xpath("//select"));
        Select select = new Select(selectDropDown);
        BrowserUtils.selectBy(selectDropDown, "ScreenSaver", "value");
        WebElement quantity = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity"));
        quantity.sendKeys("5");
        WebElement name = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));
        name.sendKeys("CodeFish It School");
        WebElement street = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2"));
        street.sendKeys("2200 E Devon");
        WebElement city = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3"));
        city.sendKeys("Des Plaines");
        WebElement state = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
        state.sendKeys("Illinois");
        WebElement zip = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
        zip.sendKeys("60018");
        WebElement card = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_cardList_1"));
        card.click();
        WebElement cardNumber = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6"));
        cardNumber.sendKeys("444993876233");
        WebElement expirationDate = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
        expirationDate.sendKeys("03/24");
        WebElement processButton = driver.findElement(By.cssSelector(".btn_light"));
        processButton.click();
        Thread.sleep(2000);
        WebElement popUpText = driver.findElement(By.xpath("//strong"));
        Assert.assertEquals(BrowserUtils.getText(popUpText), "New order has been successfully added.");
        WebElement allOrders = driver.findElement(By.linkText("View all orders"));
        allOrders.click();
        List<WebElement> allProducts = driver.findElements(By.xpath("//table[@class='SampleTable']//td"));
        List<WebElement> namesOfProducts = driver.findElements(By.xpath("//table[@class='SampleTable']//th"));
        Map<String, String> matching = new LinkedHashMap<>();
        Actions actions = new Actions(driver);
        for (int i = 1; i < allProducts.size(); i++) {
            actions.moveToElement(allProducts.get(i)).perform();
            matching.put(BrowserUtils.getText(namesOfProducts.get(i)), BrowserUtils.getText(allProducts.get(i)));
//            if (namesOfProducts.get(i).getText().equals("Name")) {
//                matching.put(BrowserUtils.getText(namesOfProducts.get(i)), BrowserUtils.getText(allProducts.get(i)));
//            }
            if(namesOfProducts.get(i).getText().equals("Exp")){
                matching.put(BrowserUtils.getText(namesOfProducts.get(i)), BrowserUtils.getText(allProducts.get(i)));
                break;
            }
        }
        System.out.println(matching);
    }
}
