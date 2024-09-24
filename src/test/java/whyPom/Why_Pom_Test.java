package whyPom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Why_Pom_Test {

	@Test
	public void refreshPage() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
	
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement usn = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		usn.sendKeys("Admin");
		
		WebElement pass = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		pass.sendKeys("admin123");
		
		driver.navigate().refresh();
		Thread.sleep(4000);
		
		usn.sendKeys("Admin");
		Thread.sleep(2000);
		pass.sendKeys("admin@123");
		Thread.sleep(2000);
		//once we refresh we cannot interact with the expired element address, then we come across stale element exception
		
		
		driver.quit();
		
		
	}

}
