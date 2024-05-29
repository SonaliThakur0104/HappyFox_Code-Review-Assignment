package com.HappyFox;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;



public class Testcase101 {

	//In Place of main method, we can add @Test annotation method which is given by TestNG
	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Johny\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");
		// In place of System.setProperty, we can use WebDriverManager.geckodriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://interview.supporthive.com/staff/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeUnit));
		driver.manage().window().maximize();
		driver.findElement(By.id("id_username")).sendKeys("Agent");
		driver.findElement(By.id("id_password")).sendKeys("Agent@123");
		driver.findElement(By.id("btn-submit")).click();
		WebElement tickets = driver.findElement(By.id("ember29"));
		Actions action = new Actions(driver);
		action.moveToElement(tickets).build().perform();
		WebElement statuses = driver.findElement(By.linkText("Statuses"));
		statuses.click();
		driver.findElement(By.xpath("/html/body/div[3]/div/section/section/div/header/button")).click(); // Xpath starts with double slash "//", //html
		// we should avoid using indexing in xpath, rather we should use xpath axes.
		driver.findElement(By.tagName("input")).sendKeys("Issue Created");
		WebElement statusColourSelect =
		          driver.findElement(By.xpath("//div[@class='sp-replacer sp-light']"));
		          statusColourSelect.click();

		          WebElement statusColourEnter =
		          driver.findElement(By.xpath("//input[@class='sp-input']"));
		          statusColourEnter.clear(); statusColourEnter.sendKeys("#47963f");

		          Robot r = new Robot();
		          r.keyPress(KeyEvent.VK_ESCAPE);
		          // r.keyRelease(KeyEvent.VK_ESCAPE) // After keyPress, we should write keyRelease()
	
        WebElement firstElement = driver.findElement(By.xpath("//a[@id='first-link']"));
        firstElement.click();

       
        WebElement secondElement = driver.findElement(By.xpath("//a[@id='second-link']"));
        secondElement.click();
        

		
		driver.findElement(By.tagName("textarea")).sendKeys("Status when a new ticket is created in HappyFox");
		WebElement addCreate = driver.findElement(By.xpath("//button[@class ='hf-entity-footer_primary hf-primary-action ember-view']"));
	      addCreate.click();

	      Thread.sleep(3000);
	      //Instead of thread.sleep(), we should use explicit Wait for the element to be visible
		    //  WebDriverWait wait=new WebDriverWait(getDriver(),Duration.ofSeconds(3));
			//	wait.until(ExpectedConditions.visibilityOf(moveTo)); 

	      WebElement moveTo = driver.findElement(By.xpath("//td[@class ='lt-cell align-center hf-mod-no-padding ember-view']"));
	      action.moveToElement(moveTo).build().perform();
	      moveTo.click();
	         
	      Thread.sleep(9000);
	    //Instead of thread.sleep(), we should use explicit Wait for the element to be visible
		    //  WebDriverWait wait=new WebDriverWait(getDriver(),Duration.ofSeconds(9));
			//	wait.until(ExpectedConditions.visibilityOf(issue));
	      
	      WebElement issue = driver.findElement(By.xpath("//div[contains(text(),'Issue Created')]"));
			action.moveToElement(issue).build().perform();
			
			
	      WebElement make = driver.findElement(By.linkText("Make Default"));
	      make.click();
	      driver.findElement(By.linkText("Priorities")).click();
	      driver.findElement(By.xpath("//header/button[1]")).click();// We should avoid using indexing
	      driver.findElement(By.tagName("input")).sendKeys("Assistance required"); // Instead of tagname attribute, we should go for xpath locator
	      driver.findElement(By.tagName("textarea")).sendKeys("Priority of the newly created tickets");
	      WebElement button = driver.findElement(By.cssSelector("button[data-test-id='add-priority']"));
	      button.click();
	      
Thread.sleep(9000);
//WebDriverWait wait=new WebDriverWait(getDriver(),Duration.ofSeconds(9));
//	wait.until(ExpectedConditions.visibilityOf(tickets2)); 

WebElement tickets2 = driver.findElement(By.id("ember29"));
action.moveToElement(tickets2).build().perform();
WebElement priorities2 = driver.findElement(By.linkText("Priorities"));
priorities2.click();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);// implicitly wait should not be used multiple times, instead we should use explicitly wait
//WebDriverWait wait=new WebDriverWait(getDriver(),Duration.ofSeconds(time));
//wait.until(ExpectedConditions.visibilityOf(element)); 
driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/section[1]/section[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[9]/td[2]")).click();
//xpath should start with "//html" and we should avoid indexing in finding elements
driver.findElement(By.linkText("Delete")).click();
WebElement delete = driver.findElement(By.cssSelector("button[data-test-id='delete-dependants-primary-action']"));
delete.click();
//WebDriverWait wait=new WebDriverWait(getDriver(),Duration.ofSeconds(time));
//wait.until(ExpectedConditions.visibilityOf(element)); 
Thread.sleep(9000);
driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/header[1]/div[2]/nav[1]/div[7]/div[1]/div[1]")).click(); //xpath should start with "//html" and we should avoid indexing in finding elements
driver.findElement(By.linkText("Logout")).click();

	// } main method should end with }
  // } Class is getting closed here

public class PagesforAutomationAssignment {

    public static void main(String[] args) { //In Place of main method, we can add @Test annotation method which is given by TestNG
        ChromeDriver driver = new ChromeDriver(); // Instead of using ChromeDriver, we should WebDriver driver = new ChromeDriver();
        driver.get("https://www.happyfox.com");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("username", "password");

        HomePage homePage = new HomePage(driver);
        homePage.verifyHomePage();

        driver.quit();
    }
 // } Class is getting closed here

    static class BasePage {// BasePage should be non-static because if we make it static, then we can't do inheritance. It should be non-static  public class. 
        protected WebDriver driver;

        public BasePage(WebDriver driver) {
            this.driver = driver;
        }
    }

    static class LoginPage extends BasePage {//Loginpage class should be non-static because we have ctreated object in PagesforAutomationAssignment class.
        public LoginPage(WebDriver driver) {
            super(driver);
        }

        public void login(String username, String password) {

            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.id("loginButton")).click();
        }

        public void forgotPassword() {
            driver.findElement(By.linkText("Forgot password?")).click();
        }
    }

    static class HomePage extends BasePage { //Homepage class should be non-static because we have ctreated object in PagesforAutomationAssignment class.
        public HomePage(WebDriver driver) {
            super(driver);
        }

        public void verifyHomePage() {
            if (!driver.getCurrentUrl().equals("https://www.happyfox.com/home")) {
                throw new IllegalStateException("Not on the home page");
            }
        }

        public void navigateToProfile() {
            driver.findElement(By.id("profileLink")).click();
        }
   // } HomePage class ends here

    public class TablePage extends BasePage {

    private By rowLocator = By.xpath("//table[@id='dataTable']/tbody/tr"); //Here, we can use @FindBy, It is used not to get get StaleElementReferenceException

    public TablePage(WebDriver driver) {
        super(driver);
    }

    public void retrieveRowTexts() {
        List<WebElement> rows = driver.findElements(rowLocator); // Here, we should import java.util.List;

        for (int i = 0; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            String rowText = row.getText();
            System.out.println("Row " + i + " Text: " + rowText);
        }
    }




	}// TablePage class ends here 

    } // Here, "}" should not come