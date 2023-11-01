package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScenariowithDdT {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String URL=p.getProperty("url");
		String USERNAME=p.getProperty("username");
		String PASSWORD=p.getProperty("password");
		String BROWSER=p.getProperty("browser");
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData1.xlsx");
		Workbook wb=WorkbookFactory.create(fise);
		String Lastname=wb.getSheet("contacts").getRow(1).getCell(2).getStringCellValue();
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println(BROWSER+" launched");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println(BROWSER+" launched");
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			System.out.println(BROWSER+" launched");
		}
		else 
		{
			System.out.println("invalid browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//step 2:load the url
		driver.get(URL);
		//step 3:login the application
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		//step 4:navigate to contact click
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		//step 5:click on create contact lookup image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		//step 6:create contact
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(Lastname);
		//step 7: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//step 8:validate
		String contactHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(contactHeader.contains(Lastname))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("fail");
		}
		//step 9:logout
	WebElement ele=	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions act=new Actions(driver);
	act.moveToElement(ele).perform();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	System.out.println("signout succesfull");	

	}

}
