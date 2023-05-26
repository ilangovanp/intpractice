package com.register;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class login {
	@Test
	public void reg() throws InterruptedException {
		for(int i=0;i<5;i++) {
			String rr=RandomStringUtils.randomAlphanumeric(7);
			String kv=RandomStringUtils.randomAlphabetic(5);
			WebDriverManager.chromedriver().setup();
			 ChromeOptions options = new ChromeOptions();
			  options.addArguments("--remote-allow-origins=*");
			  DesiredCapabilities capabilities = new DesiredCapabilities();
			  capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			  options.merge(capabilities);
			WebDriver driver = new ChromeDriver(options);
			driver.get("https://demoblaze.com/");
			driver.manage().window().maximize();
	        driver.findElement(By.id("signin2")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.id("sign-username")).sendKeys(rr);
	        System.out.println(rr);
	        driver.findElement(By.id("sign-password")).sendKeys(kv);
	        System.out.println(kv);
	        driver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")).click();
	        Thread.sleep(3000);
	        
	        String msgreg=driver.switchTo().alert().getText();
	        System.out.println(msgreg);
	        driver.switchTo().alert().accept();
	        //driver.navigate().refresh();
	        Thread.sleep(3000);
	        driver.findElement(By.id("login2")).click();
	        Thread.sleep(3000);
	        System.out.println(rr);
	        System.out.println(kv);
	        driver.findElement(By.id("loginusername")).sendKeys(rr);
	        driver.findElement(By.id("loginpassword")).sendKeys(kv);
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//button[text()='Log in']")).click();
	        
	        Thread.sleep(3000);
	        String text=driver.findElement(By.id("nameofuser")).getText();
	        System.out.println(text);
	        String[] b=text.split(" ");
	        String vc=b[1].trim();
	        System.out.println(b[1].trim());
	        System.out.println(text.substring(8));
	        Assert.assertEquals(rr, vc);
	        driver.findElement(By.id("logout2")).click();
	        

		
			}
	}
	
	     

		}
	
	
	


