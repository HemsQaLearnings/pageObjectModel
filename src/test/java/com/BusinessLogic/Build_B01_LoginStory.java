package com.BusinessLogic;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.Generic_Utils.FileUtils;
import com.PomPages.Pom_loginPage;

public class Build_B01_LoginStory {

	@Test
	public void login_test() throws InterruptedException, IOException {
		// WebDriver driver=new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(8000);


		Pom_loginPage pl = new Pom_loginPage(driver);


	pl.loginToApp("Admin", "admin123");
	
		driver.navigate().refresh();
		Thread.sleep(3000);
		
		pl.loginToApp("Admin", "admin123");
		//pl.loginToApp(fut.read_data("LoginPage_Usn"), fut.read_data("LoginPage_Pass")); // pl.loginToApp("Admin",
																						// "admin123");
		Thread.sleep(3000);
		
		pl.getLogin_btn().click();
		Thread.sleep(3000);
		WebElement verify = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
		String text = verify.getText();
		System.out.println(text + "===> Home Page is Displayed");

		driver.quit();

	}
}
