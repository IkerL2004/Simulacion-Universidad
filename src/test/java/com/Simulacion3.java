package com;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import java.util.List;
import org.openqa.selenium.WebElement;

public class Simulacion3 {

	private WebDriver driver;

	@Before
	public void SetUp() {
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		System.getProperty("webdriver.chrome.driver", "-/src/test/resources/Driver/chromedriver.exe");
		driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/v1");
		
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

	}
	
	@Test
    public void tercerTest() {
        List<WebElement> productos = driver.findElements(By.className("inventory_item"));
        assertEquals("La cantidad de productos no es la esperada", 6, productos.size());
    }

    @After
    public void close() {
        driver.quit();
    }
	
	
}
