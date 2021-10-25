package org.example;

import org.junit.Test;
//import org.junit.jupiter.api.Assertions;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;
public class ValidarAccesoCarritoConArticuloAgregadoTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    //System.setProperty("webdriver.chrome.driver","C:\\tools\\chromedriver.exe");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void vaAccesoCarritoConArticuloAgregado() {
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);// espera 15 segundos en caso de que algo no se haya cargado al instante de necesitarlo
    driver.get("https://www.vaypol.com.ar/");
    driver.manage().window().setSize(new Dimension(1936, 1056));
    driver.findElement(By.cssSelector(".navbaritem_wrapper__DGwCq:nth-child(2) .navbaritem_icon__3hNI6")).click();
    {
      WebElement element = driver.findElement(By.linkText("Remeras"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.linkText("Camisetas")).click();
    driver.findElement(By.cssSelector(".product-item_container__3w84l:nth-child(1) .product-item_imageWrapper__G5Rsl")).click();
    driver.findElement(By.cssSelector(".size-item_item__1SnRA:nth-child(3)")).click();
    driver.findElement(By.cssSelector(".product_button__1wFyQ")).click();
    js.executeScript("window.scrollTo(0,192)");
    driver.findElement(By.cssSelector(".button_secondary__KDKID")).click();
    //WebElement element1 = driver.findElement(By.className("checkout-button_quantity__27d_M"));
    //Assertions.assertEquals("Productos en carrito\n1 producto", element1.getText());
    assertThat(driver.findElement(By.className("checkout-button_quantity__27d_M")).
            getText(), is("Productos en carrito\n1 producto"));
  }
}
