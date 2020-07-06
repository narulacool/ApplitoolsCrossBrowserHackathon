package utils;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.Config.Browsers;
import utils.Config.Devices;

public class GenericFunctions {

	WebDriver driver;
	WebDriverWait wait;
	Config config=new Config();
	ChromeDriverService service ;
	String browser;
	String viewPort;
	String device;

	public GenericFunctions(){

	}

	public GenericFunctions(WebDriver driver){
		this.driver=driver;
	}
	public WebDriver startDriver(Browsers browser, Devices device) {
		if(browser.equals(Browsers.CHROME))
		{	
			System.setProperty("webdriver.chrome.driver", getClass().getClassLoader().getResource("chromeDriver/chromedriver.exe").getPath());
			driver = new ChromeDriver();
		}
		else if(browser.equals(Browsers.FIREFOX))
		{	
			System.setProperty("webdriver.gecko.driver", getClass().getClassLoader().getResource("geckoDriver/geckodriver.exe").getPath());
			driver = new FirefoxDriver();
		}
		else if(browser.equals(Browsers.EDGECHROMIUM))
		{	
			System.setProperty("webdriver.edge.driver", getClass().getClassLoader().getResource("edgeDriver/msedgedriver.exe").getPath());
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Unsupported Browser!");
		}

		this.browser = browser.toString();
		this.viewPort = config.viewPortSize.get(device);
		this.device = device.toString();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);

		int width=Integer.parseInt(viewPort.split("x")[0]);
		int height=Integer.parseInt(viewPort.split("x")[1]);
		Dimension targetSize = new Dimension(width,height);
		driver.manage().window().setSize(targetSize);

		return driver;
	}

	public void openUrl(String url) {
		driver.get(url);
	}


	/**
	 * A Helper to check if the provided element is displayed or not & call the hackathonReporter function to write results in text file
	 * Task: <Task Number>, Test Name: <Test Name>, DOM Id:: <id>, Browser: <Browser>, Viewport: <Width x Height>, Device<Device type>, Status: <Pass | Fail>
	 * 
	 * Example: Task: 1, Test Name: Search field is displayed, DOM Id: DIV__customsear__41, Browser: Chrome, Viewport: 1200 x 700, Device: Laptop, Status: Pass
	 * 
	 * @param task                    int - 1, 2 or 3
	 * @param testName.               string - Something meaningful. E.g. 1.1 Search field is displayed
	 * @param domId                   string - DOM ID of the element
	 * @param isDisplayed        	  boolean - True if the element should be displayed, False otherwise
	 * @return			  boolean - returns the same comparison result back so that it can be used for further Assertions in the test code.
	 */
	public boolean checkAndReport(int task, String testName, By domId, boolean isDisplayed) {
		return hackathonReporter(task, testName, domId, driver.findElement(domId).isDisplayed()==isDisplayed);
	}
	

	/**
	 * A Helper to print the test result in the following format:
	 * Task: <Task Number>, Test Name: <Test Name>, DOM Id:: <id>, Browser: <Browser>, Viewport: <Width x Height>, Device<Device type>, Status: <Pass | Fail>
	 * 
	 * Example: Task: 1, Test Name: Search field is displayed, DOM Id: DIV__customsear__41, Browser: Chrome, Viewport: 1200 x 700, Device: Laptop, Status: Pass
	 * 
	 * @param task                    int - 1, 2 or 3
	 * @param testName.               string - Something meaningful. E.g. 1.1 Search field is displayed
	 * @param domId                   string - DOM ID of the element
	 * @param comparisonResult        boolean - The result of comparing the "Expected" value and the "Actual" value.
	 * @return			  boolean - returns the same comparison result back so that it can be used for further Assertions in the test code.
	 */
	public boolean hackathonReporter(int task, String testName, By domId, boolean comparisonResult) {
		String fileName="UnknownURL.txt";
		if(driver.getCurrentUrl().contains("V1")) {
			fileName = config.fileNameV1;
		}
		else if(driver.getCurrentUrl().contains("V2")) {
			fileName = config.fileNameV2;
		}
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
			writer.write("Task: " + task + ", Test Name: " + testName +", DOM " + domId.toString().substring(3) + ", Browser: " + browser 
					+ ", Viewport: " + viewPort + ", Device: " + device + ", Status: " + (comparisonResult ? "Pass" : "Fail"));
			writer.newLine();
			writer.close();
		}catch(Exception e){
			System.out.println("Error writing to report file");
			e.printStackTrace();
		}
		//returns the result so that it can be used for further Assertions in the test code.
		return comparisonResult;
	}

	public String savePNGImage(By id,String imgName){

		WebElement logo = driver.findElement(id);
		String logoSRC = logo.getAttribute("src");


		BufferedImage saveImage;
		try {
			URL imageURL = new URL(logoSRC);
			saveImage = ImageIO.read(imageURL);
			ImageIO.write(saveImage, "png", new File(imgName+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imgName+".png";

	}

	public BufferedImage getBufferedImage(By id){

		WebElement logo = driver.findElement(id);
		String logoSRC = logo.getAttribute("src");


		BufferedImage saveImage = null;
		try {
			URL imageURL = new URL(logoSRC);
			saveImage = ImageIO.read(imageURL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return saveImage;

	}

	public String savePNGImageWithBackgroundAttribute(By id,String imgName){

		WebElement logo = driver.findElement(id);
		String logoSRC = logo.getCssValue("background-image");


		BufferedImage saveImage;
		try {
			logoSRC =logoSRC.substring(5, logoSRC.length() - 2);

			URL imageURL = new URL(logoSRC);
			saveImage = ImageIO.read(imageURL);
			ImageIO.write(saveImage, "png", new File(imgName+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imgName+".png";

	}

	public BufferedImage getBufferedBackgroundImage(By id){

		WebElement logo = driver.findElement(id);
		String logoSRC = logo.getCssValue("background-image");
		BufferedImage saveImage = null;
		try {
			logoSRC =logoSRC.split("\"")[1];
			URL imageURL = new URL(logoSRC);
			saveImage = ImageIO.read(imageURL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return saveImage;
	}

	public static void createPngImage(BufferedImage image, String fileName) throws IOException {
		ImageIO.write(image, "png", new File(fileName));
	}
	public static void createJpgImage(BufferedImage image, String fileName) throws IOException {
		ImageIO.write(image, "jpg", new File(fileName));
	}

	public Boolean compareWithBaseImage(String baseImagePath,By locatorActualImage, Boolean isActualImageBackgroundImage)
			throws IOException {
		Boolean isSameImage=Boolean.TRUE;
		File baseFile = new File(baseImagePath);
		BufferedImage bImage = ImageIO.read(baseFile);
		BufferedImage cImage = null;
		if(isActualImageBackgroundImage) {
			cImage = getBufferedBackgroundImage(locatorActualImage);
		}
		else{
			cImage = getBufferedImage(locatorActualImage);
		}
		int height = bImage.getHeight();
		int width = bImage.getWidth();

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				try {
					int pixelC = cImage.getRGB(x, y);
					int pixelB = bImage.getRGB(x, y);
					if (pixelB != pixelC ) 
					{
						isSameImage=Boolean.FALSE;
					}
				} catch (Exception e) {
					isSameImage=Boolean.FALSE;
				}
			}
		}
		return isSameImage;
	}

	public String getSelectedValue(By locator) {
		return new Select(driver.findElement(locator)).getFirstSelectedOption().getText();
	}


}
