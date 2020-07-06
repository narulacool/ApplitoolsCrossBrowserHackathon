package tests;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;

import pages.HomePage;
import utils.EyesConfig;
import utils.GenericFunctions;
import utils.UrlProvider;
import utils.Config.Browsers;
import utils.Config.Devices;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ModernTestsV1 {
	EyesConfig eyeConfig; 
	VisualGridRunner runner;
	Eyes eyes;
	WebDriver driver;
	GenericFunctions generic;
	UrlProvider urlProvider;
	Devices device;
	Browsers browser;
	
	@BeforeClass
	public void setBatch() {
		eyeConfig = new EyesConfig("UFG Hackathon");
		// Create a runner with concurrency of 10
		runner = new VisualGridRunner(10);
		
		// Create Eyes object with the runner, meaning it'll be a Visual Grid eyes.
		eyes = new Eyes(runner);

		//Setup eyes
		eyeConfig.setUp(eyes);
	}

	@BeforeMethod
	public void initialize() {	

		//Initialize variables & launch browser
		generic = new GenericFunctions();
		urlProvider = new UrlProvider();
		device = Devices.LAPTOP;
		browser = Browsers.CHROME;
		driver = generic.startDriver(browser,device);
		generic = new GenericFunctions(driver);
	}

	
	/**
	 * Task1 - Cross-Device Elements Test 
	 */
	@Test
	public void task1_CrossDeviceElementsTest() {
		try {

			// Navigate to the url we want to test
			generic.openUrl(urlProvider.getV1Url());

			// Call Open on eyes to initialize a test session
			eyes.open(driver, eyeConfig.appName, "Task 1", new RectangleSize(800, 600));

			// check the homepage
			eyes.check(Target.window().fully().withName("Cross-Device Elements Test"));

			// Call Close on eyes to let the server know it should display the results
			eyes.closeAsync();

		} finally  {
			eyes.abortAsync();
		}
	}

	
	/**
	 * Task2 - Shopping Experience Test
	 */
	@Test
	public void task2_ShoppingExperienceTest() {
		try {

			// Navigate to the url we want to test
			generic.openUrl(urlProvider.getV1Url());

			//Filter shoes with Black colour
			HomePage homePage = new HomePage(driver,generic,device);
			homePage.filterShoesWithColour("Black");

			// Call Open on eyes to initialize a test session
			eyes.open(driver, eyeConfig.appName, "Task 2", new RectangleSize(800, 600));

			// check the productgrid region
			eyes.check(Target.region(homePage.productGrid).fully().withName("Filter Results"));

			// Call Close on eyes to let the server know it should display the results
			eyes.closeAsync();

		} finally  {
			eyes.abortAsync();
		}
	}

	
	/**
	 * Task 3 – Product Details Test
	 */
	@Test
	public void task3_ProductDetailsTest() {
		try {

			// Navigate to the url we want to test
			generic.openUrl(urlProvider.getV1Url());

			//Filter shoes with Black colour and open first shoe
			HomePage homePage = new HomePage(driver,generic,device);
			homePage.filterShoesWithColour("Black");
			homePage.clickShoeAtIndex(1);

			// Call Open on eyes to initialize a test session
			eyes.open(driver, eyeConfig.appName, "Task 3", new RectangleSize(800, 600));

			// check the product Details page
			eyes.check(Target.window().fully().withName("Product Details test"));

			// Call Close on eyes to let the server know it should display the results
			eyes.closeAsync();

		} finally  {
			eyes.abortAsync();
		}
	}

	@AfterMethod
	private void tearDown() {
		// Close the browser
		driver.quit();

		/*// we pass false to this method to suppress the exception that is thrown if we find visual differences
		TestResultsSummary allTestResults = runner.getAllTestResults(false);
		System.out.println(allTestResults);*/
	}
	
	@AfterClass
	private void tearDownClass() {

		// we pass false to this method to suppress the exception that is thrown if we find visual differences
		TestResultsSummary allTestResults = runner.getAllTestResults(false);
		System.out.println(allTestResults);
	}
	
}
