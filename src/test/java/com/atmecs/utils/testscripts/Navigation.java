package com.atmecs.utils.testscripts;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.atmecs.utils.orangehrm.App;
import com.atmecs.utils.testdata.Baseclass;

public class Navigation extends Baseclass {
	App app = new App();

	@Test
	void navigation() throws IOException {
		File file1 = new File("./src/test/resources/locators/navigation.properties");
		File file = new File("./src/test/resources/testdata/config.properties");
		Properties prop1 = property(file1);
		Properties prop = property(file);
		webdriver.get(prop.getProperty("url"));
		webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement acceptcookies = webdriver.findElement(By.xpath(prop1.getProperty("loc.button.acceptcookies.xpath")));
		acceptcookies.click();
		WebElement feature = webdriver
				.findElement(By.linkText(app.returnLocator("loc.navigationbar.features.linkText")));
		feature.click();
		WebElement services = webdriver
				.findElement(By.className(prop1.getProperty("loc.navigationbar.services.className")));
		services.click();
		WebElement success = webdriver
				.findElement(By.linkText(prop1.getProperty("loc.navigationbar.successStories.linkText")));
		success.click();
		WebElement partners = webdriver.findElement(By.xpath(prop1.getProperty("loc.navigationbar.partners.xpath")));
		partners.click();
		WebElement blog = webdriver.findElement(By.linkText(prop1.getProperty("loc.navigationbar.blog.linkText")));
		blog.click();

		WebElement allcatagories = webdriver
				.findElement(By.xpath(prop1.getProperty("loc.dropdown.allcatagories.xpath")));
		Select w = new Select(allcatagories);
		w.selectByIndex(7);
		WebElement element = webdriver.findElement(By.xpath(prop1.getProperty("loc.navbutton.contactsales.xpath")));
		element.click();
		WebElement days30freetrail = webdriver
				.findElement(By.xpath(prop1.getProperty("loc.navbutton.30daysfreetrail.xpath")));
		days30freetrail.click();
		webdriver.close();
	}

}
