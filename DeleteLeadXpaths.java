//Delete an existing lead on a web page using Selenium WebDriver to interact with web elements.

package AssignmentsWeek2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLeadXpaths {
	public static void main(String[] args) throws InterruptedException {
		// ChromeDriver initialized, URL loaded, Browser maximized
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");

		// logging to leaftaps portal
		driver.findElement(By.id("username")).sendKeys("demoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();

		// Find existing lead & delete it
		driver.findElement(By.linkText("Leads")).click();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// driver.findElement(By.xpath("//a[@class='selected']")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		// driver.findElement(By.xpath("//li[@id='ext-gen247__ext-gen261']")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("7904160870");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(5000);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		// capture first record
		String firstID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]"))
				.getText();
		System.out.println("The First record ID  " + firstID);
		// click the first record and apply delete
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]")).click();
		driver.findElement(By.linkText("Delete")).click();

		// verify delete
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("7904160870");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(5000);

		/*
		 * String newID = driver.findElement(By.
		 * xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]"))
		 * .getText(); System.out.println("The First record ID  " + newID);
		 * 
		 * // Verify the delete by comparing the first captured lead ID with the new
		 * lead ID and conclude the delete is success if both ID dont match if
		 * (firstID.equals(newID)) {
		 * System.out.println("The delete operation is failed " + firstID + " and " +
		 * newID + " are same");
		 * 
		 * } else { System.out.println("The delete operation is success " + firstID +
		 * " and " + newID + " are not same"); }
		 */
		// Verify the delete by checking the existance of message "No records to display"
		
		String message = driver.findElement(By.className("x-paging-info")).getText();
		if (message.equals("No records to display")) {
			System.out.println("The delete operation is success");

		} else {
			System.out.println("The delete operation is failed");
		}

	}

}
