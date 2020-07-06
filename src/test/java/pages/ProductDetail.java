package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageComponents.Footer;
import pageComponents.Header;
import utils.GenericFunctions;
import utils.Config.Devices;

public class ProductDetail{

	WebDriver driver;
	Devices device;
	GenericFunctions generic;

	public Header header;
	public Footer footer;

	public By shoeName= By.id("shoe_name");
	public By shoeImage = By.id("shoe_img");
	public By rating = By.id("SPAN__rating__76");
	public By reviews = By.id("SPAN__rating__76");
	public By SKU = By.id("SMALL____84");
	public By productDescription = By.id("P____83");
	public By sizeLabel = By.id("STRONG____90");
	public By sizeDropdown_xpath = By.xpath("//span[@class='current']");
	public By quantityLabel = By.id("STRONG____100");
	public By quantitySelector = By.id("quantity_1");
	public By newPrice = By.id("new_price");
	public By oldPrice = By.id("old_price");
	public By discountPercentage = By.id("discount");
	public By addToCartButton = By.id("A__btn__114");

	public ProductDetail(WebDriver driver, GenericFunctions generic, Devices device) {
		this.driver=driver;
		this.device = device;
		this.generic = generic;
		header = new Header(driver, generic, device);
		footer = new Footer(driver, generic, device);
	}

	public Boolean verifyThatAllPageElementsAreDisplayed(int taskNumber){
	
		switch(device) {

		case LAPTOP: case TABLET: case MOBILE:{
			return 	generic.checkAndReport(taskNumber,"Verify that Shoe Name label is displayed", shoeName,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Check rating is displayed", rating,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Check Reviews is displayed", reviews,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Check SKU is displayed", SKU,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Check Product description is displayed", productDescription,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Check Size label is displayed", sizeLabel,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Check Quantity label is displayed", quantityLabel,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Check new price is displayed", newPrice,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Check old price is displayed", oldPrice,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Check discount percentage is displayed", discountPercentage,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Check add to cart button is displayed", addToCartButton,Boolean.TRUE);
		}

		default :{
			return false;
		}
		}
	}

	public boolean checkShoeName(String Name) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.visibilityOf(driver.findElement(shoeName))).getText().equals(Name);
	}

	public boolean checkShoeImageIsDisplayed(String imageFileName) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.visibilityOf(driver.findElement(shoeImage))).getAttribute("style").contains(imageFileName);
	}

	public boolean checkReviewCount(String numberOfReviews) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.visibilityOf(driver.findElement(reviews))).getText().split(" ")[0].equals(numberOfReviews);
	}

	public boolean checkSKUText(String SKUText) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.visibilityOf(driver.findElement(SKU))).getText().equals(SKUText);
	}

	public boolean checkProductDescription() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.visibilityOf(driver.findElement(productDescription))).getText().contains("These boots are comfortable enough to wear all day. Well made. I love the “look”. Best Used For Casual Everyday Walk fearlessly into the cooler months in the Sorel Joan Of Arctic Wedge II Chelsea Boot. Boasting the iconic wedge platform that's as comfortable as it is stylish, this boot features a waterproof upper");
	}

	public boolean checkdefaultSizeIsSmall() {
		return driver.findElement(sizeDropdown_xpath).getText().equals("Small (S)");
	}

	public boolean checkdefaultQuantityIs1() {
		return driver.findElement(quantitySelector).getAttribute("value").equals("1");
	}


	public boolean checkNewPriceValue(String newPriceText) {
		return driver.findElement(newPrice).getText().equals(newPriceText);
	}

	public boolean checkOldPriceValue(String oldPriceText) {
		return driver.findElement(oldPrice).getText().equals(oldPriceText);
	}

	public boolean checkDiscountPercentageValue(String discount) {
		return driver.findElement(discountPercentage).getText().equals(discount);
	}

	public boolean checkAddToCartText() {
		return driver.findElement(addToCartButton).getText().equals("Add to Cart");
	}

	public boolean verifyDiscountPercentageColour(int task) {		
		String colour =driver.findElement(discountPercentage).getCssValue("background-color");
		Boolean result =colour.equals("rgba(255, 51, 51, 1)") || colour.equals("rgb(255, 51, 51)");
		return generic.hackathonReporter(task, "Discount Percentage Colour is Red", discountPercentage, result);
	}

	public boolean verifyAddToCartColour(int task) {
		String colour =driver.findElement(addToCartButton).getCssValue("background-color");
		Boolean result =colour.equals("rgba(0, 77, 218, 1)") || colour.equals("rgb(0, 77, 218)");
		return generic.hackathonReporter(task, "Add To Cart Colour is Blue", addToCartButton, result);
	}

	public boolean verifyNewPriceColour(int task) {		
		String colour =driver.findElement(newPrice).getCssValue("color");
		Boolean result =colour.equals("rgba(0, 77, 218, 1)") || colour.equals("rgb(0, 77, 218)");
		return generic.hackathonReporter(task, "New Price Colour is Blue", newPrice, result);
	}

	public boolean verifyOldPriceColour(int task) {		
		String colour =driver.findElement(oldPrice).getCssValue("color");
		Boolean result =colour.equals("rgba(153, 153, 153, 1)") || colour.equals("rgb(153, 153, 153)");
		return generic.hackathonReporter(task, "Old Price Colour is Grey", oldPrice, result);
	}
	
	public boolean verifyShoeImageIsCorrect(int task) {
		try {
			//Save image for the first time to create baseline	
			//generic.savePNGImage(shoeImage, "src/test/resources/images/AppliAirXNight");
			Boolean result = generic.compareWithBaseImage("src/test/resources/images/AppliAirXNight.png", shoeImage, Boolean.TRUE);
			return generic.hackathonReporter(task, "Shoe Image on Product detail Page is displayed correctly", shoeImage, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}
	}


}
