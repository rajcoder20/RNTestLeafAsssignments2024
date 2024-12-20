//A web page that contains various fields, dropdowns and buttons. Your task is to automate interactions with these WebElement using Selenium WebDriver.

/*Precondition: - 
-Initialize the WebDriver (ChromeDriver). 
-Load the URL http://leaftaps.com/opentaps/ 
-Maximize the browser window.*/

package AssignmentsWeek2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountDropDown {

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

		// creating a new account with the use of dropdown (select keyword)
		driver.findElement(By.xpath("//a[contains(text(),'Accounts')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Create Account')]")).click();
		driver.findElement(By.xpath("(//input[@name= 'accountName'])[2]")).sendKeys("CLARA TELECOM INC3");
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Selenium Automation Tester.");

		WebElement industryDD = driver.findElement(By.name("industryEnumId"));
		Select industry = new Select(industryDD);
		industry.selectByIndex(3);

		WebElement ownershipDD = driver.findElement(By.name("ownershipEnumId"));
		Select ownership = new Select(ownershipDD);
		ownership.selectByVisibleText("S-Corporation");

		WebElement sourceDD = driver.findElement(By.id("dataSourceId"));
		Select source = new Select(sourceDD);
		source.selectByValue("LEAD_EMPLOYEE");

		WebElement marketngCmpgDD = driver.findElement(By.id("marketingCampaignId"));
		Select marketingCmpgn = new Select(marketngCmpgDD);
		marketingCmpgn.selectByIndex(6);

		WebElement stateProvinceDD = driver.findElement(By.id("generalStateProvinceGeoId"));
		Select stateProvince = new Select(stateProvinceDD);
		stateProvince.selectByValue("TX");

		driver.findElement(By.className("smallSubmit")).click();
		Thread.sleep(3000);
		
		String accountNameDisplay = driver.findElement(By.xpath("//span[contains(text(),'Account Name')]/following::span")).getText();
		
		if(accountNameDisplay.contains("CLARA")) {
			System.out.println(" Account name Verified");
		}else {
			System.out.println("Not verified");
		}
			
		driver.quit();

	}

}
