package autoIT_selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowPopup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\home\\Desktop\\seleni\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		// window authentication popup display - handled by selenium
		//driver.get("http://admin:admin@the-internet.herokuapp.com/");
		
		// window authentication popup display - handled manually
		driver.get("http://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[normalize-space()='Basic Auth']")).click();
	}

}
