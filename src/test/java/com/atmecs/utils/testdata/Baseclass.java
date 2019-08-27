package com.atmecs.utils.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners
public class Baseclass {

	protected WebDriver webdriver;

	@BeforeTest
	public void setup() throws IOException {
		File file = new File("./src/test/resources/testdata/webdriver.properties");
		Properties prop = property(file);
		switch (prop.getProperty("webdrivername")) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "./libs/chromedriver.exe");
			webdriver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "./libs/geckodriver.exe");
			webdriver = new FirefoxDriver();
			break;
		case "Ie":
			System.setProperty("webdriver.chrome.driver", "./libs/IEDriver.exe");
			webdriver = new InternetExplorerDriver();
			break;
		case "microsoftEdge":
			System.setProperty("webdriver.chrome.driver", "./libs/IEDriver.exe");
			webdriver = new InternetExplorerDriver();
			break;
		}
	}

	public Properties property(File file) throws IOException {
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream(file);
		prop.load(input);
		return prop;
	}
}
