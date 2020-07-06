package pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.Config.Devices;
import utils.GenericFunctions;

public class Header {

	WebDriver driver;
	Devices device;
	GenericFunctions generic;
	String pageName;

	public By appliFashionLogo = By.id("IMG____9");
	public By searchBox = By.id("INPUTtext____42");
	public By searchIconInSearchBox = By.id("I__headericon__44");
	public By mainMenu = By.id("DIV__mainmenu__15");
	public By homeMenu = By.id("A__showsubmen__23");
	public By menMenu = By.id("A__showsubmen__25");
	public By womenMenu = By.id("A__showsubmen__27");
	public By runningMenu = By.id("A__showsubmen__29");
	public By trainingMenu = By.id("A__showsubmen__31");
	public By wishListIcon = By.id("A__wishlist__52");
	public By profileIcon = By.id("A__accesslink__56");
	public By cartIcon = By.id("A__cartbt__49");
	public By itemsInCart = By.id("STRONG____50");
	public By showSearchBoxButton = By.id("A__btnsearchm__59");

	public Header(WebDriver driver, GenericFunctions generic, Devices device) {
		this.driver=driver;
		this.device = device;
		this.generic = generic;
	}


	public Boolean verifyWishlistIconVisibility(int taskNumber) {
		switch(device) {
		case LAPTOP:{
			if(driver.getCurrentUrl().contains("ProductDetails")) {
				return generic.checkAndReport(taskNumber,"Wishlist icon is displayed on Laptop on Product Details Page", wishListIcon,Boolean.TRUE);
			}
			else {
				return generic.checkAndReport(taskNumber,"Wishlist icon is displayed on Laptop on Home Page", wishListIcon,Boolean.TRUE);
			}
		}
		case TABLET:{
			if(driver.getCurrentUrl().contains("ProductDetails")) {
				return generic.checkAndReport(taskNumber,"Wishlist icon is displayed on Tablet on Product Details Page", wishListIcon,Boolean.TRUE);
			}
			else {
				return generic.checkAndReport(taskNumber,"Wishlist icon is not displayed on Tablet on Home Page", wishListIcon,Boolean.FALSE);
			}
		}
		case MOBILE:{
			if(driver.getCurrentUrl().contains("ProductDetails")) {
				return generic.checkAndReport(taskNumber,"Wishlist icon is displayed on Mobile on Product Details Page", wishListIcon,Boolean.TRUE);
			}
			else {
				return generic.checkAndReport(taskNumber,"Wishlist icon is not displayed on Mobile on Home Page", wishListIcon,Boolean.FALSE);
			}
		}
		default :{
			return false;
		}
		}
	}


	public Boolean verifyNumberOfItemsinCartVisibility(int taskNumber) {
		switch(device) {
		case LAPTOP:{
			if(driver.getCurrentUrl().contains("ProductDetails")) {
				return generic.checkAndReport(taskNumber,"Number of items in Cart are displayed on Laptop on Product Details Page", itemsInCart,Boolean.TRUE);
			}
			else {
				return generic.checkAndReport(taskNumber,"Number of items in Cart are displayed on Laptop on Home Page", itemsInCart,Boolean.TRUE);
			}
		}
		case TABLET:{
			if(driver.getCurrentUrl().contains("ProductDetails")) {
				return generic.checkAndReport(taskNumber,"Number of items in Cart are displayed on Tablet on Product Details Page", itemsInCart,Boolean.TRUE);
			}
			else {
				return generic.checkAndReport(taskNumber,"Number of items in Cart are displayed on Tablet on Home Page", itemsInCart,Boolean.TRUE);
			}
		}
		case MOBILE:{
			if(driver.getCurrentUrl().contains("ProductDetails")) {
				return generic.checkAndReport(taskNumber,"Number of items in Cart are displayed on Mobile on Product Details Page", itemsInCart,Boolean.TRUE);
			}
			else {
				return generic.checkAndReport(taskNumber,"Number of items in Cart are not displayed on Mobile on Home Page", itemsInCart,Boolean.FALSE);
			}
		}
		default :{
			return false;
		}
		}
	}


	public Boolean verifyThatAllPageElementsAreDisplayed(int taskNumber){	
		switch(device) {
		case LAPTOP:{

			return generic.checkAndReport(taskNumber,"Applifashion Logo is displayed on Laptop", appliFashionLogo,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Search box is displayed on Laptop", searchBox,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Main Menu is displayed on Laptop", mainMenu,Boolean.TRUE)
					&& verifyWishlistIconVisibility(taskNumber)
					&& verifyNumberOfItemsinCartVisibility(taskNumber)
					&& generic.checkAndReport(taskNumber,"Search icon inside Search Box is displayed on Laptop", searchIconInSearchBox,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Profile icon is displayed on Laptop", profileIcon,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Cart icon is displayed on Laptop", cartIcon,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Home option of top Menu is displayed on Laptop", homeMenu,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Men option of top Menu is displayed on Laptop", menMenu,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Women option of top Menu is displayed on Laptop", womenMenu,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Running option of top Menu is displayed on Laptop", runningMenu,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Training option of top Menu is displayed on Laptop", trainingMenu,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Show search box button is not visible on Laptop", showSearchBoxButton,Boolean.FALSE);
		}

		case TABLET:{
			return  generic.checkAndReport(taskNumber,"Applifashion Logo is displayed on Tablet", appliFashionLogo,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Search box is displayed on Tablet", searchBox,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Main Menu is not displayed on Tablet", mainMenu,Boolean.FALSE)
					&& verifyWishlistIconVisibility(taskNumber)
					&& verifyNumberOfItemsinCartVisibility(taskNumber)
					&& generic.checkAndReport(taskNumber,"Search icon inside Search Box is displayed on Tablet", searchIconInSearchBox,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Profile icon is displayed on Tablet", profileIcon,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Cart icon is displayed on Tablet", cartIcon,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Home option of top Menu is not displayed on Tablet", homeMenu,Boolean.FALSE)
					&& generic.checkAndReport(taskNumber,"Men option of top Menu is not displayed on Tablet", menMenu,Boolean.FALSE)
					&& generic.checkAndReport(taskNumber,"Women option of top Menu is not displayed on Tablet", womenMenu,Boolean.FALSE)
					&& generic.checkAndReport(taskNumber,"Running option of top Menu is not displayed on Tablet", runningMenu,Boolean.FALSE)
					&& generic.checkAndReport(taskNumber,"Training option of top Menu is not displayed on Tablet", trainingMenu,Boolean.FALSE)
					&& generic.checkAndReport(taskNumber,"Show search box button is not visible on Tablet", showSearchBoxButton,Boolean.FALSE);

		}

		case MOBILE:{
			return 	generic.checkAndReport(taskNumber,"Applifashion Logo is displayed on Mobile", appliFashionLogo,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Search box is not displayed on Mobile", searchBox,Boolean.FALSE)
					&& generic.checkAndReport(taskNumber,"Main Menu is not displayed on Mobile", mainMenu,Boolean.FALSE)
					&& verifyWishlistIconVisibility(taskNumber)
					&& verifyNumberOfItemsinCartVisibility(taskNumber)
					&& generic.checkAndReport(taskNumber,"Search icon inside Search Box is not displayed on Mobile", searchIconInSearchBox,Boolean.FALSE)
					&& generic.checkAndReport(taskNumber,"Profile icon is displayed on Mobile", profileIcon,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Cart icon is displayed on Mobile", cartIcon,Boolean.TRUE)
					&& generic.checkAndReport(taskNumber,"Home option of top Menu is not displayed on Mobile", homeMenu,Boolean.FALSE)
					&& generic.checkAndReport(taskNumber,"Men option of top Menu is not displayed on Mobile", menMenu,Boolean.FALSE)
					&& generic.checkAndReport(taskNumber,"Women option of top Menu is not displayed on Mobile", womenMenu,Boolean.FALSE)
					&& generic.checkAndReport(taskNumber,"Running option of top Menu is not displayed on Mobile", runningMenu,Boolean.FALSE)
					&& generic.checkAndReport(taskNumber,"Training option of top Menu is not displayed on Mobile", trainingMenu,Boolean.FALSE)
					&& generic.checkAndReport(taskNumber,"Show search box button is visible on Mobile", showSearchBoxButton,Boolean.TRUE);
		}

		default :{
			return false;
		}
		}
	}



}
