package com.atmecs.utils.testscripts;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.atmecs.utils.testdata.Baseclass;

@Listeners
public class Freetrail extends Baseclass {
	@Test
	public void freetrail() throws IOException {
		File file = new File("./src/test/resources/testdata/config.properties");
		File file1 = new File("./src/test/resources/locators/freetrail30days.properties");
		Properties prop = property(file);
		Properties prop1 = property(file1);
		webdriver.get(prop.getProperty("url1"));
		WebElement days30freetrail = webdriver
				.findElement(By.xpath(prop1.getProperty("loc.navbutton.30daysfreetrail.xpath")));
		days30freetrail.click();
		WebElement url = webdriver.findElement(By.id(prop1.getProperty("loc.txtfield.url.id")));
		url.sendKeys("www.ajith.in");
		WebElement firstname1 = webdriver.findElement(By.name(prop1.getProperty("loc.txtfield.FirstName.name")));
		firstname1.sendKeys("moorthy");
		WebElement lastname1 = webdriver.findElement(By.id(prop1.getProperty("loc.txtfield.LastName.id")));
		lastname1.sendKeys("periyasamy");
		WebElement email1 = webdriver.findElement(By.id(prop1.getProperty("loc.txtfield.Email.id")));
		email1.sendKeys("trainee@gmail.com");
		WebElement job1 = webdriver.findElement(By.id(prop1.getProperty("loc.txtfield.JobTitle.name")));
		job1.sendKeys("trainee");
		WebElement noOfemp1 = webdriver.findElement(By.name(prop1.getProperty("loc.dropdown.NoOfEmp.name")));
		Select select2 = new Select(noOfemp1);
		select2.selectByIndex(4);
		WebElement company1 = webdriver.findElement(By.id(prop1.getProperty("loc.txtfield.CompanyName.id")));
		company1.sendKeys("atmecs");
		WebElement industry = webdriver.findElement(By.id(prop1.getProperty("loc.dropdown.industry.id")));
		Select set = new Select(industry);
		set.selectByIndex(3);
		WebElement phone1 = webdriver.findElement(By.id(prop1.getProperty("loc.txtfield.PhonenNumber.id")));
		phone1.sendKeys("1356427576");
		WebElement country1 = webdriver.findElement(By.id(prop1.getProperty("loc.DropDown.country.Id")));
		Select select3 = new Select(country1);
		select3.selectByIndex(3);
		webdriver.close();
	}

}
