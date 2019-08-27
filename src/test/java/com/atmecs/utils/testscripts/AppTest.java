package com.atmecs.utils.testscripts;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.atmecs.utils.orangehrm.App;
import com.atmecs.utils.orangehrm.Inputfetch;
import com.atmecs.utils.testdata.Baseclass;

/**
 * Unit test for simple App.
 */
@Listeners
public class AppTest extends Baseclass {
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */

	App app = new App();
	Inputfetch fetch = new Inputfetch();

	@Test
	public void AppTest1() throws IOException {
		File file = new File("./src/test/resources/testdata/config.properties");
		File file1 = new File("./src/test/resources/locators/testscripts.properties");
		Properties prop = property(file);
		Properties prop1 = property(file1);
		webdriver.manage().window().maximize();
		webdriver.get(prop.getProperty("url"));
		WebElement element = webdriver.findElement(By.xpath(prop1.getProperty("loc.navbutton.contactsales.xpath")));
		element.click();
		webdriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		WebElement firstname = webdriver.findElement(By.name(prop1.getProperty("loc.txtfield.firstname.name")));
		firstname.sendKeys("ajith");
		WebElement lastname = webdriver.findElement(By.name(prop1.getProperty("loc.txtfield.lastname.name")));
		lastname.sendKeys("periyasamy");
		WebElement company = webdriver.findElement(By.name(prop1.getProperty("loc.txtfield.companyname.name")));
		company.sendKeys("atmecs");
		WebElement noOfemp = webdriver.findElement(By.name(prop1.getProperty("loc.dropdown.noOfemp.name")));
		Select select = new Select(noOfemp);
		select.selectByIndex(6);
		WebElement phone = webdriver.findElement(By.name(prop1.getProperty("loc.txtfield.phonenumber.name")));
		phone.sendKeys("1356427576");
		WebElement job = webdriver.findElement(By.name(prop1.getProperty("loc.txtfield.jobtitle.name")));
		job.sendKeys("trainee");
		WebElement email = webdriver.findElement(By.name(prop1.getProperty("loc.txtfield.email.name")));
		email.sendKeys("trainee@gmail.com");
		WebElement country = webdriver.findElement(By.name(prop1.getProperty("loc.dropdown.country.name")));
		Select select1 = new Select(country);
		select1.selectByIndex(3);
		WebElement comment = webdriver.findElement(By.name(prop1.getProperty("loc.textarea.comment.name")));
		comment.sendKeys("tirupur");
		webdriver.quit();
	}

	/**
	 * Rigourous Test :-)
	 */

}
