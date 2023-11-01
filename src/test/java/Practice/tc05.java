package Practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class tc05 {
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin", Keys.ENTER);
		
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("Mishra1");
		driver.findElement(By.xpath("(//img[@title='Select'])[1]")).click();
		
		Thread.sleep(2000);
		String mainwin=driver.getWindowHandle();
		System.out.println(mainwin);
		Set<String> allwin = driver.getWindowHandles();
		System.out.println(allwin);
		
		for(String a: allwin)
		{
			if(!mainwin.equals(a))
			{
				driver.switchTo().window(a);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[.='TCS']")).click();
			}
		}
		driver.switchTo().window(mainwin);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		Thread.sleep(4000);
		WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
	}
}
