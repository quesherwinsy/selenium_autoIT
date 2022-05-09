package autoIT_selenium;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class fileUpload {

	public static void main(String[] args) throws InterruptedException, IOException {
		// Get project directory
		String downloadPath = System.getProperty("user.dir");
		System.out.println(downloadPath);

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\home\\Desktop\\seleni\\chromedriver_win32\\chromedriver.exe");

		// set chrome download path. See chrome official documentation
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);

		// Chrome option to set download path and accept SSL certificate
		ChromeOptions chromeOp = new ChromeOptions();
		chromeOp.setExperimentalOption("prefs", chromePrefs);
		chromeOp.setAcceptInsecureCerts(true);

		WebDriver driver = new ChromeDriver(chromeOp);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://www.freepdfconvert.com/pdf-to-jpg");
		driver.findElement(By.xpath("//a[@class='btn-wrapper upload-btn']")).click();
		Thread.sleep(3000);

		// Java - run external autoIT exe file in system
		Runtime.getRuntime().exec("C:\\Users\\home\\Downloads\\rahul_autoit\\fileupload.exe");
		Thread.sleep(5000);

		// Explicit wait for 10 sec apply button to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Apply Changes']")));
		driver.findElement(By.xpath("//button[normalize-space()='Apply Changes']")).click();
		Thread.sleep(5000);

		// Explicit wait for 10 sec download button to appear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn-wrapper download-btn']")));
		driver.findElement(By.xpath("//a[@class='btn-wrapper download-btn']")).click();
		Thread.sleep(3000);

		// Check if file exist in download and delete
		// File f = new File("C:\\Users\\home\\Downloads\\rahulshetty_autoit.jpg");
		File f = new File(downloadPath + "/rahulshetty_autoit.jpg");
		if (f.exists()) {
			Assert.assertTrue(f.exists());
			if (f.delete()) {
				System.out.println("file exist and deleted");
			}
		}
		driver.quit();
	}

}
