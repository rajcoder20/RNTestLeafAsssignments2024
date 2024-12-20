//To edit lead information on a web application using Selenium WebDriver.

/*Precondition: 
- Initialize the WebDriver (ChromeDriver). 
- Load the URL http://leaftaps.com/opentaps/. 
- Maximize the browser window.*/

/*Requirements: 
- Enter the Username as "DemoSalesManager" and the Password as "crmsfa". 
- Click on the Login Button. 
- Click on the CRM/SFA Link. 
- Click on the Leads Button. 
- Click on Create Lead. 
- Enter the CompanyName Field Using Xpath. 
- Enter the FirstName Field Using Xpath. 
- Enter the LastName Field Using Xpath. 
- Enter the FirstName (Local) Field Using Xpath. 
- Enter the Department Field Using any Locator of Your Choice. 
- Enter the Description Field Using any Locator of your choice. 
- Enter your email in the E-mail address Field using the locator of your choice. 
- Select State/Province as NewYork Using Visible Text. 
- Click on the Create Button. 
- Click on the edit button. 
- Clear the Description Field. 
- Fill the Important Note Field with Any text. 
- Click on the update button. 
- Get the Title of the Resulting Page. 
- Close the browser window.*/

package AssignmentsWeek2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditLeadDropDown {
	public static void main(String[] args) throws InterruptedException {
		// Preconditions - ChromeDriver initialized, URL loaded, Browser maximized
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");

		// logging to leaftaps portal and , verifying the title is correctly displayed
		driver.findElement(By.id("username")).sendKeys("demoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();

		// creating a new lead with the use of dropdown (select keyword)
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.xpath("(//input[@name='companyName'])[2]")).sendKeys("Panache Inc");
		//driver.findElement(By.xpath("(//input[@name='companyName'])[2]")).sendKeys("Pantaloons");
		//driver.findElement(By.xpath("(//input[@name='companyName'])[2]")).sendKeys("WestSide Clothing");
		//driver.findElement(By.xpath("(//input[@name='companyName'])[2]")).sendKeys("Peter England");
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Captain Miller");
		driver.findElement(By.xpath("(//input[@name='lastName'])[3]")).sendKeys("Tom");
		driver.findElement(By.xpath("//input[@name='firstNameLocal']")).sendKeys("Tommy Gunn");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Forensic Department");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Edit Lead Program Rajanathan");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("testleaf@raja.com");

		WebElement stateProvinceDD = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select stateprovince = new Select(stateProvinceDD);
		stateprovince.selectByVisibleText("New York");

		driver.findElement(By.xpath("//input[@type='submit']")).click();

		// Edit process
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.id("updateLeadForm_description")).clear();
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("updated Lead Program by Rajanathan");
		driver.findElement(By.xpath("//input[@value='Update']")).click();

		// get title
		String title = driver.getTitle();
		System.out.println("The title of the window is " + title);
		Thread.sleep(3000);
		driver.quit();

	}

}
