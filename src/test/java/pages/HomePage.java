package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageComponents.Footer;
import pageComponents.Header;
import utils.Config.Devices;
import utils.GenericFunctions;

public class HomePage{

	WebDriver driver;
	Devices device;
	GenericFunctions generic;


	public Header header;
	public Footer footer;

	public By filterLeftSide = By.id("filter_col");
	public By gridViewIcon = By.xpath("//i[@class='ti-view-grid']");
	public By listViewIcon = By.xpath("//i[@class='ti-view-list']");
	public By sortBy = By.xpath("//div[@class='sort_select']");

	public By topBannerShoe=By.xpath("//div[@class='top_banner']");

	public By shoesHeartIcon = By.xpath("(//i[@class='ti-heart'])[1]");
	public By shoesShuffleIcon = By.xpath("(//i[@class='ti-control-shuffle'])[1]");
	public By shoesShoppingCartIcon = By.xpath("(//i[@class='ti-shopping-cart'])[1]");

	public By openFilterIcon = By.id("ti-filter");
	public By openFilterText = By.xpath("//span[text()='Filters']");
	public By filterButton = By.id("filterBtn");
	public By searchResults_xpath=By.xpath("//div[@class='grid_item']");
	public By productGrid=By.id("product_grid");

	public By offRibbon = By.xpath("(//span[@class='ribbon off'])[1]");
	public By countdown = By.xpath("(//div[@class='countdown'])[1]");
	public By newPrice = By.xpath("(//span[@class='new_price'])[1]");
	public By oldPrice = By.xpath("(//span[@class='old_price'])[1]");

	public By AppliAirXNightImage= By.xpath("//img[@alt='Appli Air x Night']");
	public By AppliAir720Image= By.xpath("//img[@alt='Appli Air 720']");

	public By AppliAirXNightLabel= By.xpath("//h3[text()='Appli Air x Night']");
	public By AppliAir720Label= By.xpath("//h3[text()='Appli Air 720']");


	public HomePage(WebDriver driver, GenericFunctions generic, Devices device) {
		this.driver=driver;
		this.device = device;
		this.generic = generic;
		header = new Header(driver, generic, device);
		footer = new Footer(driver, generic, device);
	}

	public Boolean verifyThatAllPageElementsAreDisplayed(int taskNumber){
		switch(device) {

		case LAPTOP:{
			return 	generic.checkAndReport(taskNumber,"Top Banner shoe is visible on Laptop", topBannerShoe,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Filter options are visible by default on Laptop", filterLeftSide,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Sort option is visible by default on Laptop", sortBy,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Search results grid view icon is visible by default on Laptop", gridViewIcon,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Search results list view icon is visible by default on Laptop", listViewIcon,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"30% off ribbon is visible on Laptop", offRibbon,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"1 day left Countdown is visible on Laptop", countdown,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"New Price is visible on Laptop", newPrice,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Old Price is visible on Laptop", oldPrice,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Shoes heart icon is not visible by default on Laptop", shoesHeartIcon,Boolean.FALSE)
					&& generic.checkAndReport(taskNumber,"Shoes shuffle icon is not visible by default on Laptop", shoesShuffleIcon,Boolean.FALSE)
					&& generic.checkAndReport(taskNumber,"Shoes shopping cart icon is not visible by default on Laptop", shoesShoppingCartIcon,Boolean.FALSE)	
					&& generic.checkAndReport(taskNumber,"Filter icon is not visible on Laptop", openFilterIcon,Boolean.FALSE)
					&& generic.checkAndReport(taskNumber,"Filter text is not visible on Laptop", openFilterText,Boolean.FALSE);
		}

		case TABLET:{
			return  
					generic.checkAndReport(taskNumber,"Top Banner shoe is visible on Tablet", topBannerShoe,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Filter options are not visible by default on Tablet", filterLeftSide,Boolean.FALSE)
					&& generic.checkAndReport(taskNumber,"Sort option is visible by default on Laptop", sortBy,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Search results grid view icon is not visible on Tablet", gridViewIcon,Boolean.FALSE)
					&& generic.checkAndReport(taskNumber,"Search results list view icon is not visible on Tablet", listViewIcon,Boolean.FALSE)
					&& generic.checkAndReport(taskNumber,"30% off ribbon is visible on Laptop", offRibbon,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"1 day left Countdown is visible on Tablet", countdown,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"New Price is visible on Tablet", newPrice,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Old Price is visible on Tablet", oldPrice,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Filter icon is visible on Tablet", openFilterIcon,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Filter text is visible on Tablet", openFilterText,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Shoes heart icon is visible by default on Tablet", shoesHeartIcon,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Shoes shuffle icon is visible by default on Tablet", shoesShuffleIcon,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Shoes shopping cart icon is visible by default on Tablet", shoesShoppingCartIcon,Boolean.TRUE);
		}

		case MOBILE:{
			return 	generic.checkAndReport(taskNumber,"Top Banner shoe is visible on Mobile", topBannerShoe,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Filter options are not visible by default on Mobile", filterLeftSide,Boolean.FALSE)
					&& generic.checkAndReport(taskNumber,"Sort option is visible by default on Laptop", sortBy,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Search results grid view icon is not visible on Mobile", gridViewIcon,Boolean.FALSE)
					&& generic.checkAndReport(taskNumber,"Search results list view icon is not visible on Mobile", listViewIcon,Boolean.FALSE)
					&& generic.checkAndReport(taskNumber,"30% off ribbon is visible on Mobile", offRibbon,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"1 day left Countdown is visible on Mobile", countdown,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"New Price is visible on Mobile", newPrice,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Old Price is visible on Mobile", oldPrice,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Filter icon is visible on Mobile", openFilterIcon,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Filter text is not visible on Mobile", openFilterText,Boolean.FALSE)
					&& generic.checkAndReport(taskNumber,"Shoes heart icon is visible by default on Mobile", shoesHeartIcon,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Shoes shuffle icon is visible by default on Mobile", shoesShuffleIcon,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Shoes shopping cart icon is visible by default on Mobile", shoesShoppingCartIcon,Boolean.TRUE);
		}
		default :{
			return false;
		}
		}
	}

	public void filterShoesWithColour(String colour) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		if(!device.equals(Devices.LAPTOP)) {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(openFilterIcon))).click();
		}
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[contains(text(),'"+colour+"')]")))).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(filterButton))).click();
	}

	public int getNumberOfShoesDisplayed() {
		return driver.findElements(searchResults_xpath).size();
	}

	public boolean isShoeDisplayed(By xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(xpath)));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickShoe(By xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(xpath))).click(); 
	}

	public void clickShoeAtIndex(int i) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(searchResults_xpath).get(i-1))).click();		
	}

	public boolean verifyOffRibbonColour(int task) {		
		String colour =driver.findElement(offRibbon).getCssValue("background-color");
		Boolean result  = colour.equals("rgba(255, 51, 51, 1)") || colour.equals("rgb(255, 51, 51)");
		return generic.hackathonReporter(task, "Off Ribbon Colour is Red", offRibbon, result);
	}

	public boolean verifyCountdownColour(int task) {	
		String colour =driver.findElement(countdown).getCssValue("background-color");
		Boolean result =colour.equals("rgba(255, 51, 51, 1)")|| colour.equals("rgb(255, 51, 51)");
		return generic.hackathonReporter(task, "Countdown Colour is Red", countdown, result);
	}

	public boolean verifyNewPriceColour(int task) {		
		String colour =driver.findElement(newPrice).getCssValue("color");
		Boolean result =colour.equals("rgba(0, 77, 218, 1)")|| colour.equals("rgb(0, 77, 218)");;
		return generic.hackathonReporter(task, "New Price Colour is Blue", newPrice, result);
	}

	public boolean verifyOldPriceColour(int task) {	
		String colour =driver.findElement(oldPrice).getCssValue("color");
		Boolean result =colour.equals("rgba(153, 153, 153, 1)") || colour.equals("rgb(153, 153, 153)");;;
		return generic.hackathonReporter(task, "Old Price Colour is Grey", oldPrice, result);
	}

	public boolean verifyTopBannerShoeImageIsCorrect(int task) {
		try {
			//Save image for the first time to create baseline	
			//generic.savePNGImage(topBannerShoe, "src/test/resources/images/topBannerShoe");
			Boolean result = generic.compareWithBaseImage("src/test/resources/images/topBannerShoe.png", topBannerShoe, Boolean.TRUE);
			return generic.hackathonReporter(task, "Top Banner Shoe Image is displayed correctly", topBannerShoe, result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}

	public boolean verifyAppliAirXNightImage(int task) {
		try {
			//Save image for the first time to create baseline	
			//generic.savePNGImage(AppliAirXNightImage, "src/test/resources/images/AppliAirXNight");
			Boolean result = generic.compareWithBaseImage("src/test/resources/images/AppliAirXNight.png", AppliAirXNightImage, Boolean.FALSE);
			return generic.hackathonReporter(task, "Appli Air X Night Image is displayed correctly", AppliAirXNightImage, result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}

	public boolean verifyAppliAir720Image(int task) {
		try {
			//Save image for the first time to create baseline	
			//generic.savePNGImage(AppliAir720Image, "src/test/resources/images/AppliAir720");
			Boolean result = generic.compareWithBaseImage("src/test/resources/images/AppliAir720.png", AppliAir720Image, Boolean.FALSE);
			return generic.hackathonReporter(task, "Appli Air 720 Image is displayed correctly", AppliAir720Image, result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
}
