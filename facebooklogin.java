package selenium;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class facebooklogin {
	
	public WebDriver driver;
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\cheta\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test
	public void login_Page() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(2500);		
		String title = driver.getTitle();
		System.out.println(title);
		String source = driver.getPageSource();
		System.out.println(source);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		//driver.quit();
		driver.close();
	}	
	@Test
	public void navigate() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(2500);
		driver.navigate().to("https://www.Amazon.com/");
		Thread.sleep(2500);
		driver.navigate().back();
		Thread.sleep(2500);
		driver.navigate().refresh();
		Thread.sleep(2500);
		driver.navigate().forward();
		Thread.sleep(2500);
		driver.close();
	}	
	@Test
	public void locators() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.id("email"));
		element.sendKeys("Tushar");
		Thread.sleep(2500);
		element.clear();
		Thread.sleep(2500);
		element.sendKeys("tusharbadgujar0000@gmail.com");
		Thread.sleep(2500);
		driver.findElement(By.name("pass")).sendKeys("@Tushar*12");
		Thread.sleep(2500);
		driver.findElement(By.name("login")).click();
		driver.close();

	}
	@Test
	public void link() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Forgotten password?")).click();
		Thread.sleep(2500);
		driver.close();
	}
	
	@Test
	public void link_partial() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.partialLinkText("Forgotten")).click();
		Thread.sleep(2500);
		driver.close();
	}
	
	@Test
	public void css_selector() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.cssSelector("input[class='inputtext _55r1 _6luy']"));
	element.sendKeys("Tushar");
	Thread.sleep(3000);
        driver.close();
	}
	@Test
	public void web_elements() throws IOException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.id("email"));
		element.sendKeys("Tushar");
		WebElement element1 = driver.findElement(By.id("pass"));
		element1.sendKeys("123456789");
	} 
		//x-path
	@Test
	public void attribute() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='email'][@placeholder='Email address or phone number']")).sendKeys("Tushar Badgujar");
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("Tushar");
		Thread.sleep(2500);
		driver.close();		
}
	@Test
	public void Text() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		Thread.sleep(2000);
		driver.close();
}
	@Test
	public void contains() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
//		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Tushar Badgujar");
		driver.findElement(By.xpath("//button[contains(text(),'Log')]")).click();
		Thread.sleep(2500);
		driver.close();
}
	@Test
    public void getlocationmethod() throws InterruptedException {	 
		 driver.get("https://www.facebook.com/");	 
		 driver.manage().window().maximize();
    	  Point point = driver.findElement(By.xpath("//input[@id='email']")).getLocation();
    	System.out.println("The x co-orinate position :"+ point.x); 
    	System.out.println("The y co-orinate position : "+ point.y); 
    	Thread.sleep(2000);
    	driver.close();
}
	@Test
    	public void getSizeofSerchFiled() throws InterruptedException {
    	 driver.get("https://facebook.com/");	 
   		 driver.manage().window().maximize();
         Dimension dimension = driver.findElement(By.id("email")).getSize();
         System.out.println(dimension);       
         System.out.println("Height of the Serch Field  "+dimension.height);
         System.out.println("Width of the Serch Field  "+dimension.width);
         Thread.sleep(2000);
         driver.close();
	}
	
	@Test
	public void isDisplayMethod() throws InterruptedException {
		driver.get("https://www.facebook.com/");	 
      	 driver.manage().window().maximize();
      	System.out.println(driver.findElement(By.xpath("//input[@id='pass']")).isDisplayed());
      	Thread.sleep(2000);
      	driver.close();

	}
}