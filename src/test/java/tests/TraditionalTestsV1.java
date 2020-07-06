package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.HomePage;
import pages.ProductDetail;
import utils.Config.Browsers;
import utils.Config.Devices;
import utils.GenericFunctions;
import utils.UrlProvider;

public class TraditionalTestsV1{


	/**
	 * DataProvider for running Tests on 1 combination for debugging purposes 
	 */
	/*@DataProvider(name = "one") 
	public Object[][] one()
	{ 
		return new Object[][]{
			{Browsers.CHROME,Devices.LAPTOP},
		};
	}*/


	/**
	 * DataProvider for running Tests across Laptop, Tablet, Mobile on Chrome, Firefox and EdgeChromium 
	 * parallel=true runs all combinations in parallel simultaneously instead of sequential execution
	 */
	@DataProvider(name = "browsersAndDevices",parallel=true) 
	public Object[][] browsersAndDevices()
	{ 
		return new Object[][]{
			{Browsers.CHROME,Devices.LAPTOP},
			{Browsers.CHROME,Devices.TABLET},
			{Browsers.CHROME,Devices.MOBILE},
			{Browsers.FIREFOX,Devices.LAPTOP},
			{Browsers.FIREFOX,Devices.TABLET},
			{Browsers.EDGECHROMIUM,Devices.LAPTOP},
			{Browsers.EDGECHROMIUM,Devices.TABLET},
		};
	}

	/**
	 * Task1 - Cross-Device Elements Test 
	 */
	@Test(dataProvider = "browsersAndDevices")
	public void task1_CrossDeviceElementsTest(Browsers browser,Devices device) {
		GenericFunctions generic = new GenericFunctions();
		UrlProvider urlProvider = new UrlProvider();
		SoftAssert softAssert = new SoftAssert();
		WebDriver driver = generic.startDriver(browser,device);
		try {
			generic.openUrl(urlProvider.getV1Url());
			HomePage homePage = new HomePage(driver,generic,device);


			//Verify Header elements are visible
			softAssert.assertTrue(homePage.header.verifyThatAllPageElementsAreDisplayed(1));

			//Verify Footer elements are visible
			softAssert.assertTrue(homePage.footer.verifyThatAllPageElementsAreDisplayed(1));

			//Verify Homepage specific elements are visible
			softAssert.assertTrue(homePage.verifyThatAllPageElementsAreDisplayed(1));

			//Colour of the elements are correct
			softAssert.assertTrue(homePage.footer.verifyfooterBackgroundColour(1));
			softAssert.assertTrue(homePage.footer.verifyYourEmailBackgroundColour(1));
			softAssert.assertTrue(homePage.footer.verifySubmitNewsLetterButtonBackgroundColour(1));
			softAssert.assertTrue(homePage.verifyCountdownColour(1));
			softAssert.assertTrue(homePage.verifyNewPriceColour(1));
			softAssert.assertTrue(homePage.verifyOffRibbonColour(1));
			softAssert.assertTrue(homePage.verifyOldPriceColour(1));

			//Image comparison for verifying that Big Shoe Image is correct
			softAssert.assertTrue(homePage.verifyTopBannerShoeImageIsCorrect(1));

			//Image comparison for checking the first shoe image result on homepage is displyed to be sure that shoes are being displayed.
			softAssert.assertTrue(homePage.verifyAppliAirXNightImage(1));



			softAssert.assertAll();
		}
		finally {
			driver.quit();
		}

	}

	/**
	 * Task2 - Shopping Experience Test
	 */
	@Test(dataProvider = "browsersAndDevices")
	public void task2_ShoppingExperienceTest(Browsers browser,Devices device) {
		GenericFunctions generic = new GenericFunctions();
		UrlProvider urlProvider = new UrlProvider();
		SoftAssert softAssert = new SoftAssert();
		WebDriver driver = generic.startDriver(browser,device);
		try {

			generic.openUrl(urlProvider.getV1Url());

			HomePage homePage = new HomePage(driver,generic,device);
			homePage.filterShoesWithColour("Black");


			//Only 2 shoes should be displayed on selecting black shoes
			softAssert.assertTrue(generic.hackathonReporter(2, "Number of shoes displayed are exactly 2", homePage.searchResults_xpath, homePage.getNumberOfShoesDisplayed()==2));

			//Check that AppliAirXNight label is displayed
			softAssert.assertTrue(generic.hackathonReporter(2, "Verify that 1st Black Shoe AppliAirXNight label is displayed", homePage.AppliAirXNightLabel, homePage.isShoeDisplayed(homePage.AppliAirXNightLabel)));

			//Check that AppliAir720 label is displayed
			softAssert.assertTrue(generic.hackathonReporter(2, "Verify that 2nd Black Shoe AppliAir720 label is displayed", homePage.AppliAir720Label, homePage.isShoeDisplayed(homePage.AppliAir720Label)));

			//Image comparison for both Black shoe images to verify that shoe images are correct 
			softAssert.assertTrue(homePage.verifyAppliAirXNightImage(2));
			softAssert.assertTrue(homePage.verifyAppliAir720Image(2));

			//Check that Remaining part of page is not impacted by applying filters. 
			//All below methods are the same as Task 1, I have just passed the task number as 2 for reporting correctly

			//Verify Header elements are visible
			softAssert.assertTrue(homePage.header.verifyThatAllPageElementsAreDisplayed(2));

			//Verify Footer elements are visible
			softAssert.assertTrue(homePage.footer.verifyThatAllPageElementsAreDisplayed(2));

			//Verify Homepage specific elements are visible
			softAssert.assertTrue(homePage.verifyThatAllPageElementsAreDisplayed(2));

			//Colour of the elements are correct
			softAssert.assertTrue(homePage.footer.verifyfooterBackgroundColour(2));
			softAssert.assertTrue(homePage.footer.verifyYourEmailBackgroundColour(2));
			softAssert.assertTrue(homePage.footer.verifySubmitNewsLetterButtonBackgroundColour(2));
			softAssert.assertTrue(homePage.verifyCountdownColour(2));
			softAssert.assertTrue(homePage.verifyNewPriceColour(2));
			softAssert.assertTrue(homePage.verifyOffRibbonColour(2));
			softAssert.assertTrue(homePage.verifyOldPriceColour(2));

			//Verify that Big Shoe Image is correct
			softAssert.assertTrue(homePage.verifyTopBannerShoeImageIsCorrect(2));

			softAssert.assertAll();

		}
		finally {
			driver.quit();
		}
	}


	/**
	 * Task 3 – Product Details Test
	 */
	@Test(dataProvider = "browsersAndDevices")
	public void task3_ProductDetailsTest(Browsers browser, Devices device) {
		GenericFunctions generic = new GenericFunctions();
		UrlProvider urlProvider = new UrlProvider();
		SoftAssert softAssert = new SoftAssert();
		WebDriver driver = generic.startDriver(browser,device);
		try {
			generic.openUrl(urlProvider.getV1Url());
			HomePage homePage = new HomePage(driver,generic,device);
			homePage.filterShoesWithColour("Black");
			homePage.clickShoeAtIndex(1);
			ProductDetail productDetail = new ProductDetail(driver,generic,device);

			//Verify Product detail page specific elements are visible
			softAssert.assertTrue(productDetail.verifyThatAllPageElementsAreDisplayed(3));

			//Image comparison for verifying that big Shoe Image is correct
			softAssert.assertTrue(productDetail.verifyShoeImageIsCorrect(3));

			//Colour of Product detail page specific elements are correct
			softAssert.assertTrue(productDetail.verifyDiscountPercentageColour(3));
			softAssert.assertTrue(productDetail.verifyAddToCartColour(3));
			softAssert.assertTrue(productDetail.verifyNewPriceColour(3));
			softAssert.assertTrue(productDetail.verifyOldPriceColour(3));

			//Check that Shoe Name is displayed correctly
			softAssert.assertTrue(generic.hackathonReporter(3, "Verify that Shoe Name is correct", productDetail.shoeName, productDetail.checkShoeName("Appli Air x Night")));

			//Check that Shoe image is visible on screen
			softAssert.assertTrue(generic.hackathonReporter(3, "Check shoe image is displayed", productDetail.shoeImage, productDetail.checkShoeImageIsDisplayed("1.jpg")));

			//Check that review count is correct
			softAssert.assertTrue(generic.hackathonReporter(3, "Verify that review count is correct", productDetail.reviews, productDetail.checkReviewCount("4")));

			//Check that SKU Text is correct
			softAssert.assertTrue(generic.hackathonReporter(3, "Verify that SKU Text is correct", productDetail.SKU, productDetail.checkSKUText("SKU: MTKRY-001")));

			//Check that the product description is correct
			softAssert.assertTrue(generic.hackathonReporter(3, "Verify that Product description is correct", productDetail.productDescription, productDetail.checkProductDescription()));

			//Check that the default size is Small
			softAssert.assertTrue(generic.hackathonReporter(3, "Verify that default Size is Small", productDetail.sizeDropdown_xpath, productDetail.checkdefaultSizeIsSmall()));

			//Check that the default quantity is 1
			softAssert.assertTrue(generic.hackathonReporter(3, "Verify that default quantity is 1", productDetail.sizeDropdown_xpath, productDetail.checkdefaultQuantityIs1()));

			//check that new price value is correct
			softAssert.assertTrue(generic.hackathonReporter(3, "Verify new price is correct", productDetail.newPrice, productDetail.checkNewPriceValue("$33.00")));

			//check that old price value is correct
			softAssert.assertTrue(generic.hackathonReporter(3, "Verify old price is correct", productDetail.oldPrice, productDetail.checkOldPriceValue("$48.00")));

			//Check that discount percentage is correct
			softAssert.assertTrue(generic.hackathonReporter(3, "Verify discount percentage is correct", productDetail.discountPercentage, productDetail.checkDiscountPercentageValue("-30% discount")));

			//Check that Add to Cart button has correct text
			softAssert.assertTrue(generic.hackathonReporter(3, "Verify Add to cart Text", productDetail.addToCartButton, productDetail.checkAddToCartText()));


			//Check the Remaining part of page 
			//All below methods are the same as Task 1, I have just passed the task number as 3 for reporting correctly


			//Verify Header elements are visible
			softAssert.assertTrue(productDetail.header.verifyThatAllPageElementsAreDisplayed(3));

			//Verify Footer elements are visible
			softAssert.assertTrue(productDetail.footer.verifyThatAllPageElementsAreDisplayed(3));


			//Colour of the footer elements are correct
			softAssert.assertTrue(productDetail.footer.verifyfooterBackgroundColour(3));
			softAssert.assertTrue(productDetail.footer.verifyYourEmailBackgroundColour(3));
			softAssert.assertTrue(productDetail.footer.verifySubmitNewsLetterButtonBackgroundColour(3));

			//Assert All
			softAssert.assertAll();
		}
		finally {
			driver.quit();
		}
	}

}
