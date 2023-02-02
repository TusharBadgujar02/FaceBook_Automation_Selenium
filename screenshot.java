package selenium;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class screenshot {
	public WebDriver driver;
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\cheta\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
@Test
	public void screenshot() throws IOException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		File dfile = new File("C:\\Users\\cheta\\eclipse-workspace\\FB_Automation\\FaceBook_SS\\"+"FaceBook.png");
		FileHandler.copy(file, dfile);
	}
}
