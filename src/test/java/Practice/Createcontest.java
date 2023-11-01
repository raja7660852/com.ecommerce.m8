package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

  @Test
public class Createcontest extends BaseClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe\\");
		WebDriver driver=new ChromeDriver();
		/*
		 * WebDriverManager.firefoxdriver().setup(); WebDriver driver=new
		 * FirefoxDriver();
		 */
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Adya");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String text=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(text.contains("Adya"))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("Fail");
		}
		WebElement mouse=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(mouse).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		System.out.println("logout succesfull");
		
		

	}

}
