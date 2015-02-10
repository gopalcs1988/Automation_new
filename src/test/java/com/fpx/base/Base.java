package com.fpx.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;

public class Base {
	public static String STATUS_PASS = "pass";
	public static String STATUS_FAIL = "fail";
	public static Properties props = null;
	public static WebDriverWait wait;
	public String username;
	public String password;
	public static WebDriver driver;
	public static Alert alert;
	public WebDriverBackedSelenium selenium;
	public String url1;
	public static String pageTitle = "";
	public String currentDir = System.getProperty("user.dir");
	public String website = "https://dv1.fpx.com/secure/login.html";

	public void openBrowser() throws Exception {
		browserAccess();
		selenium = new WebDriverBackedSelenium(driver, website);
		driver.get(website);
	}

	public void browserAccess() throws IOException, Exception {
		props = new Properties();
		try {
			props.load(new FileInputStream("src/test/resource/env.properties"));
			System.out.println("Browser :- " + props.getProperty("browser"));
			System.out.println("Username :-" + props.getProperty("username"));
			System.out.println("Password :-" + props.getProperty("password"));

			if (props.getProperty("browser").equals("firefox")) {
				driver = new FirefoxDriver();
				driver.manage().window().maximize();

			} else if (props.getProperty("BROWSER").equals("Chrome")) {
				System.setProperty("chromedriver",
						System.getProperty("user.dir")
								+ "\\src\\test\\resource\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			} else if (props.getProperty("BROWSER").equals("IE")) {
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
			}

		} catch (IOException e) {
			System.out.println("Exception Occurred" + e.getMessage());
		}
	}

	public void Wait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return;
	}

	public void applicationWait() {
		selenium.waitForPageToLoad("30000");
	}

	public void appExplictWaitByID(String id) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(By.id(id)));
	}
	
	public void appExplictWaitByXpathClickable(String id) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(id)));
	}

	public void appExplictWaitByClassName(String classname) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector(classname)));

	}

	public void appExplictWaitByXpath(String classname) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(classname)));

	}

	
	public String getStartOfDay() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String dateinstring = dateFormat.format(date);
		return dateinstring;

	}

	public static void htmlFileCreationForPass(String filename, WebDriver driver)
			throws IOException {
		try {
			System.out.println(filename);
			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(filename), true);
			System.out.println("snapshot done");
		} catch (Exception e) {
			System.out.println("Snapshot Error");
		}

	}

	public static void takeSnapshot(String directory, WebDriver driver)
			throws IOException {
		try {
			System.out.println(directory);
			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(directory), true);
			System.out.println("snapshot done");
		} catch (Exception e) {
			System.out.println("Snapshot Error");
		}
	}

	public static String fileCreation(String filename) throws IOException {
		String complete_filename = "";
		try {
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH-mm-ss");

			complete_filename = (dateFormat.format(date) + "_" + filename + ".png");
			System.out.println(complete_filename);
		} catch (Exception e) {
			System.out.println("Date format error");
		}
		return complete_filename;
	}

	public WebElement findById(String id) {
		try {
			WebElement element = driver.findElement(By.id(id));
			return element;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public WebElement findByName(String name) {
		try {
			WebElement element = driver.findElement(By.name(name));
			return element;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public WebElement findByXpath(String xpathExpression) {
		try {
			WebElement element = driver.findElement(By.xpath(xpathExpression));
			return element;
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}

	}

	public WebElement findByClass(String classExpression) {
		try {
			WebElement element = driver.findElement(By
					.className(classExpression));
			return element;
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}

	public WebElement findByCssSelector(String classExpression) {
		try {
			WebElement element = driver.findElement(By
					.cssSelector(classExpression));
			return element;
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}
}
