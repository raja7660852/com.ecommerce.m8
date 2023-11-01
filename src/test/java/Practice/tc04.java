package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class tc04 {	public static void main(String[] args) throws Throwable {


	WebDriverManager.firefoxdriver().setup();
	WebDriver driver = new FirefoxDriver();
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get("http://localhost:8888/");
	driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin", Keys.ENTER);
	driver.findElement(By.xpath("//td[.='Organizations']")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("TCckS");
	 WebElement industry = driver.findElement(By.name("industry"));
	 industry.click();
	Thread.sleep(1000);
	Select sel = new Select(industry);
	sel.selectByVisibleText("Energy");
	
	WebElement type = driver.findElement(By.name("accounttype"));
	type.click();
	Thread.sleep(1000);
	Select sel1 = new Select(type);
	sel1.selectByVisibleText("Customer");
	driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
	Thread.sleep(4000);
	WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions act=new Actions(driver);
	act.moveToElement(ele).perform();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

}
}
