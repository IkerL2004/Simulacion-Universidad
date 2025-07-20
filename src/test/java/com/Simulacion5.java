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



public class Simulacion5 {

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
	    public void quintaTest() {
	       
			WebElement botonMenu = driver.findElement(By.className("bm-burger-button"));
			botonMenu.click();

	       
			WebElement logoutLink = driver.findElement(By.id("logout_sidebar_link"));

	       
			assertFalse("El enlace de logout es visible", logoutLink.isDisplayed());
	        
	    }

	    @After
	    public void close() {
	        driver.quit();
	    }
	
}
