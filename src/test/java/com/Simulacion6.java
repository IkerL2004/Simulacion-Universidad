package com;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class Simulacion6 {
	
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
    public void sextoTest() throws Exception {
   
		driver.findElement(By.className("bm-burger-button")).click();

		Thread.sleep(1200);
        driver.findElement(By.id("logout_sidebar_link")).click();
        Thread.sleep(2000);
        
        WebElement botonLogin = driver.findElement(By.id("login-button"));
        Thread.sleep(2000);
        assertTrue("No se redirigió a la pantalla de login", botonLogin.isDisplayed());
        Thread.sleep(2000);
        assertEquals("https://www.saucedemo.com/v1/index.html", driver.getCurrentUrl()); 
        
    }

    @After
    public void close() {
        driver.quit();
    }

}
