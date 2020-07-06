package pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.GenericFunctions;
import utils.Config.Devices;

public class Footer {

	WebDriver driver;
	Devices device;
	GenericFunctions generic;
	
	public By quickLinksHeading = By.xpath("//h3[contains(text(),'Quick Links')]");
	public By footer = By.xpath("//footer");
	public By aboutUs = By.xpath("//a[contains(@href,'about')]");
	public By faq = By.xpath("//a[contains(text(),'Faq')]");
	public By help = By.xpath("//a[contains(text(),'Help')]");
	public By myAccount = By.xpath("//a[contains(text(),'My account')]");
	public By blog = By.xpath("//a[contains(text(),'Blog')]");
	public By contacts = By.xpath("//a[contains(text(),'Contacts')]");
	
	public By contactsHeading = By.xpath("//h3[contains(text(),'Contacts')]");
	public By address = By.xpath("//li[contains(text(),'155 Bovet Rd')]");
	public By applitoolsEmail = By.xpath("//a[contains(text(),'srd@applitools.com')]");
	
	public By keepInTouchHeading = By.xpath("//h3[contains(text(),'Keep in touch')]");
	public By yourEmail = By.id("email_newsletter");
	public By submitNewsLetter = By.id("submit-newsletter");
	
	public By language = By.xpath("//option[text()='English']/..");
	public By currency = By.xpath("//option[text()='US Dollars']/..");
	public By termsAndConditions = By.xpath("//a[text()='Terms and conditions']");
	public By privacy = By.xpath("//a[text()='Privacy']");
	public By copyright = By.xpath("//span[contains(text(),'2020 Applitools')]");

	
	public Footer(WebDriver driver, GenericFunctions generic, Devices device) {
		this.driver=driver;
		this.device = device;
		this.generic = generic;
	}
	
	
	public Boolean verifyThatAllPageElementsAreDisplayed(int taskNumber){
		switch(device) {

		case LAPTOP:{
			return 	generic.checkAndReport(taskNumber,"Quick Links heading is visible on Laptop", quickLinksHeading,Boolean.TRUE)
			&& generic.checkAndReport(taskNumber,"About Us link is visible by default on Laptop", aboutUs,Boolean.TRUE)
			&& generic.checkAndReport(taskNumber,"FAQ link is visible by default on Laptop", faq,Boolean.TRUE)
			&& generic.checkAndReport(taskNumber,"Help link is visible by default on Laptop", help,Boolean.TRUE)
			&& generic.checkAndReport(taskNumber,"My Account link is visible by default on Laptop", myAccount,Boolean.TRUE)
			&& generic.checkAndReport(taskNumber,"Blog link is visible by default on Laptop", blog,Boolean.TRUE)
			&& generic.checkAndReport(taskNumber,"Contacts link is visible by default on Laptop", contacts,Boolean.TRUE)

			&& generic.checkAndReport(taskNumber,"Contacts heading is visible on Laptop", contactsHeading,Boolean.TRUE)
			&& generic.checkAndReport(taskNumber,"Address is visible by default on Laptop", address,Boolean.TRUE)
			&& generic.checkAndReport(taskNumber,"Applitools email is visible by default on Laptop", applitoolsEmail,Boolean.TRUE)

			
			&& generic.checkAndReport(taskNumber,"Keep In Touch heading is visible on Laptop", keepInTouchHeading,Boolean.TRUE)
			&& generic.checkAndReport(taskNumber,"YourEmail textbox is visible by default on Laptop", yourEmail,Boolean.TRUE)
			&& generic.checkAndReport(taskNumber,"Submit News letter button is visible by default on Laptop", submitNewsLetter,Boolean.TRUE)
			&& generic.hackathonReporter(taskNumber, "English is displayed as selected Language on Laptop", language, generic.getSelectedValue(language).equals("English"))
			&& generic.hackathonReporter(taskNumber, "US Dollars is displayed as selected currency on Laptop", currency, generic.getSelectedValue(currency).equals("US Dollars"))
			&& generic.checkAndReport(taskNumber,"Terms and Conditions link is visible on Laptop", termsAndConditions,Boolean.TRUE)
			&& generic.checkAndReport(taskNumber,"Privacy link is visible on Laptop", privacy,Boolean.TRUE)
			&& generic.checkAndReport(taskNumber,"Copyright link is visible on Laptop", copyright,Boolean.TRUE);

	}

		case TABLET:{
			return  generic.checkAndReport(taskNumber,"Quick Links heading is visible on Tablet", quickLinksHeading,Boolean.TRUE)
			&& generic.checkAndReport(taskNumber,"About Us link is visible by default on Tablet", aboutUs,Boolean.TRUE)
			&& generic.checkAndReport(taskNumber,"FAQ link is visible by default on Tablet", faq,Boolean.TRUE)
			&& generic.checkAndReport(taskNumber,"Help link is visible by default on Tablet", help,Boolean.TRUE)
			&& generic.checkAndReport(taskNumber,"My Account link is visible by default on Tablet", myAccount,Boolean.TRUE)
			&& generic.checkAndReport(taskNumber,"Blog link is visible by default on Tablet", blog,Boolean.TRUE)
			&& generic.checkAndReport(taskNumber,"Contacts link is visible by default on Tablet", contacts,Boolean.TRUE)

			&& generic.checkAndReport(taskNumber,"Contacts heading is visible on Tablet", contactsHeading,Boolean.TRUE)
			&& generic.checkAndReport(taskNumber,"Address is visible by default on Tablet", address,Boolean.TRUE)
			&& generic.checkAndReport(taskNumber,"Applitools email is visible by default on Tablet", applitoolsEmail,Boolean.TRUE)

			&& generic.checkAndReport(taskNumber,"Keep In Touch heading is visible on Tablet", keepInTouchHeading,Boolean.TRUE)
			&& generic.checkAndReport(taskNumber,"YourEmail textbox is visible by default on Tablet", yourEmail,Boolean.TRUE)
			&& generic.checkAndReport(taskNumber,"Submit News letter button is visible by default on Tablet", submitNewsLetter,Boolean.TRUE)
			&& generic.hackathonReporter(taskNumber, "English is displayed as selected Language on Tablet", language, generic.getSelectedValue(language).equals("English"))
			&& generic.hackathonReporter(taskNumber, "US Dollars is displayed as selected currency on Tablet", currency, generic.getSelectedValue(currency).equals("US Dollars"))
			&& generic.checkAndReport(taskNumber,"Terms and Conditions link is visible on Tablet", termsAndConditions,Boolean.TRUE)
			&& generic.checkAndReport(taskNumber,"Privacy link is visible on Tablet", privacy,Boolean.TRUE)
			&& generic.checkAndReport(taskNumber,"Copyright link is visible on Tablet", copyright,Boolean.TRUE);
		}

		case MOBILE:{
			return 	generic.checkAndReport(taskNumber,"Quick Links heading is visible on Mobile", quickLinksHeading,Boolean.TRUE)
			&& generic.checkAndReport(taskNumber,"About Us link is not visible by default on Mobile", aboutUs,Boolean.FALSE)
			&& generic.checkAndReport(taskNumber,"FAQ link is not visible by default on Mobile", faq,Boolean.FALSE)
			&& generic.checkAndReport(taskNumber,"Help link is not visible by default on Mobile", help,Boolean.FALSE)
			&& generic.checkAndReport(taskNumber,"My Account link is not visible by default on Mobile", myAccount,Boolean.FALSE)
			&& generic.checkAndReport(taskNumber,"Blog link is not visible by default on Mobile", blog,Boolean.FALSE)
			&& generic.checkAndReport(taskNumber,"Contacts link is not visible by default on Mobile", contacts,Boolean.FALSE)

			&& generic.checkAndReport(taskNumber,"Contacts heading is visible on Mobile", contactsHeading,Boolean.TRUE)
			&& generic.checkAndReport(taskNumber,"Address is not visible by default on Mobile", address,Boolean.FALSE)
			&& generic.checkAndReport(taskNumber,"Applitools email is not visible by default on Mobile", applitoolsEmail,Boolean.FALSE)

			&& generic.checkAndReport(taskNumber,"Keep In Touch heading is visible on Mobile", keepInTouchHeading,Boolean.TRUE)
			&& generic.checkAndReport(taskNumber,"YourEmail textbox is not visible by default on Mobile", yourEmail,Boolean.FALSE)
			&& generic.checkAndReport(taskNumber,"Submit News letter button is not visible by default on Mobile", submitNewsLetter,Boolean.FALSE)
			&& generic.hackathonReporter(taskNumber, "English is displayed as selected Language on Mobile", language, generic.getSelectedValue(language).equals("English"))
			&& generic.hackathonReporter(taskNumber, "US Dollars is displayed as selected currency on Mobile", currency, generic.getSelectedValue(currency).equals("US Dollars"))
			&& generic.checkAndReport(taskNumber,"Terms and Conditions link is visible on Mobile", termsAndConditions,Boolean.TRUE)
			&& generic.checkAndReport(taskNumber,"Privacy link is visible on Mobile", privacy,Boolean.TRUE)
			&& generic.checkAndReport(taskNumber,"Copyright link is visible on Mobile", copyright,Boolean.TRUE);
		}

		default :{
			return false;
		}
		}
	}
	
	
	public boolean verifyfooterBackgroundColour(int task) {		
		String colour =driver.findElement(footer).getCssValue("background-color");
		Boolean result =colour.equals("rgba(23, 33, 52, 1)") || colour.equals("rgb(23, 33, 52)")  ;
		return generic.hackathonReporter(task, "Footer Background Colour is Dark Blue", footer, result);
	}
	
	public boolean verifyYourEmailBackgroundColour(int task) {		
		String colour =driver.findElement(yourEmail).getCssValue("background-color");
		Boolean result =colour.equals("rgba(255, 255, 255, 0.05)") ;
		return generic.hackathonReporter(task, "Your Email input box Background Colour is Dark Grey", yourEmail, result);
	}
	
	public boolean verifySubmitNewsLetterButtonBackgroundColour(int task) {	
		String colour =driver.findElement(submitNewsLetter).getCssValue("background-color");
		Boolean result =colour.equals("rgba(0, 77, 218, 1)") || colour.equals("rgb(0, 77, 218)")  ;
		return generic.hackathonReporter(task, "Submit News Letter Button Background Colour is Blue", submitNewsLetter, result);
	}
}
