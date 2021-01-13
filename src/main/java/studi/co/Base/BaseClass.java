/*
 * Project Name : demo Demo Framework
* Author : vTESTcorp
* Version : V1.0.demo
* Reviewed By : Manjeet
* Date of Creation : Feb 7, 2019
* Modification History :
* Date of change : Feb 15, 2019
* Version : V1.1.demo
* changed function : 
* change description :
* Modified By : Manjeet
*/

package studi.co.Base;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

//Handling Config file operations and Extent report initialization
//Included @BeforeSuite & @AfterSuite capabilities for handling various iOS platforms

public class BaseClass {

	public static Properties prop; // Property file initialization
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public ExtentTest logger;
	public static String Report_Path = null;
	// public static String platform_version;
	public static AndroidDriver<MobileElement> driver;
	public DesiredCapabilities caps;
	public URL url;
	public static TouchAction action;
	public static WebDriverWait wait;
	public static Logger log;
	public ExtentTest test;

	public BaseClass() {
		
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "src//main//java//studi//co//Config//config.properties");
			prop.load(ip);
		} catch (Exception ex) {
			System.out.println(ex.getStackTrace());
		}
	}

	/*
	 * Initializing pre-requisite capabilities necessary for invoking corresponding
	 * device.
	 */
	@BeforeTest
	@Parameters({ "type" })
	public void beforeTest(String type) throws Exception {
		String s = type;
		caps = new DesiredCapabilities();
		if (s.equalsIgnoreCase("Android")) {
			// caps.setCapability(MobileCapabilityType.DEVICE_NAME, "ZY223HQBHZ");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Appium");
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			// caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
			caps.setCapability("appPackage", "com.tce.studi");
			caps.setCapability("appActivity", "com.tce.view.ui.activities.SplashScreenActivity");
			caps.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");
			System.out.println("Required Desired Capabilities Defined");
			final String appiumserverUrl = "http://127.0.0.1:4723/wd/hub";
			URL url = new URL(appiumserverUrl);
			System.out.println("Appium Server URL is entered");
			driver = new AndroidDriver<MobileElement>(url, caps);
			System.out.println("AndroidDriver Configured with the required Desired Capabilities and URL");

		} else {
			caps = new DesiredCapabilities();
			caps.setCapability("automationName", prop.getProperty("automationName"));
			caps.setCapability("deviceName", "Apple 11");
			// platform_version=deviceName;
			caps.setCapability("udid", "iOS11");
			caps.setCapability("platformName", prop.getProperty("platformName"));
			// caps.setCapability("platformVersion", iOSversion);
			caps.setCapability("bundleId", prop.getProperty("bundleId"));
			// caps.setCapability("appActivity",
			// "com.demo.liveplaces.view.activity.SplashActivity");
			caps.setCapability("noReset", "true");
			// caps.setCapability("wdaLocalPort", wdaLocalPort);
			caps.setCapability("newCommandTimeout", "120");
			// iOSDriver<MobileElement> driver = new IOSDriver<MobileElement>(url, caps);
		}

		getDriver().manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

	}

	public static AndroidDriver<MobileElement> getDriver() {

		return driver;
	}

	public static void takeScreenshot(String screenshotName) throws MalformedURLException {
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YY hh-mm-ss");
		Date date = new Date();
		String datetime = dateFormat.format(date);
		File finalDestination = new File(
				System.getProperty("user.dir") + "//Screenshots//" + screenshotName + "_" + datetime + ".png");
		try {
			FileUtils.copyFile(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE), finalDestination);
		} catch (WebDriverException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void takeScreenshot() throws MalformedURLException {
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YY hh-mm-ss");
		Date date = new Date();
		String datetime = dateFormat.format(date);
		File finalDestination = new File(System.getProperty("user.dir") + "//Screenshots//"
				+ Thread.currentThread().getStackTrace()[3].getMethodName() + "_" + datetime + ".png");
		try {
			FileUtils.copyFile(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE), finalDestination);
		} catch (WebDriverException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This method returns the property for the key which we will pass which are
	 * defined in the .property File in Config file
	 * 
	 * @param key
	 * @param fileNamewithExtension
	 * @return
	 * @throws IOException
	 */
	public static String getPropertyFromPropertyFile(String key) throws IOException {
		String s = prop.getProperty(key);
		return s;
	}

	/**
	 * This method performs click operation on the element which we have passed as
	 * an argument
	 * 
	 * @param element
	 */
	public static void clickOnElement(WebElement element) {
		System.out.println("Clicking on element" + element.getText());
		element.click();
	}

	/**
	 * This method will send the text at the location for which we have specified
	 * the locator
	 * 
	 * @param element    at which we want to send the text
	 * @param text:which we want to send
	 */
	public static void sendText(WebElement element, String text) {
		System.out.println("Sending Text in the Text Input Field");
		element.sendKeys(text);

	}

	/**
	 * This method clears the text if there is already some pre-typed/saved text in
	 * the textbox
	 * 
	 * @param:element Accepts a paramter for the element which we want to clear the
	 *                        text
	 */
	public static void clearText(WebElement element) {
		System.out.println("Clearing the previousy entered Text if any");
		element.clear();
	}

	/**
	 * This method will return the text value of the Element of our interest which
	 * we have passed as an argument
	 */
	public static String getTextOfElement(WebElement element) {
		System.out.println("Geting the text property of the given Element");
		String s = element.getText();
		return s;
	}

	/**
	 * This method will perform scroll function until an element for which the text
	 * is matching and we pass this as an argument
	 * 
	 * @param text
	 */
	
//	public void swipeDown(int howManySwipes) {
//		Dimension size = driver.manage().window().getSize();
//		// calculate coordinates for vertical swipe
//		int startVerticalY = (int) (size.height * 0.8);
//		int endVerticalY = (int) (size.height * 0.21);
//		int startVerticalX = (int) (size.width / 2.1);
//				try {
//					for (int i = 1; i <= howManySwipes; i++) {
//					new TouchAction<>(driver).press(point(startVerticalX, endVerticalY))
//							.waitAction(waitOptions(ofSeconds(2))).moveTo(point(startVerticalX, startVerticalY))
//							.release().perform();
//				}
//			} catch (Exception e) {
//				    				//print error or something
//			}
//			}
	

	public static void swipeDown(int howManySwipes) {
		org.openqa.selenium.Dimension size = getDriver().manage().window().getSize();
		System.out.println("Size is "+size);
		// calculate coordinates for vertical swipe
		int startVerticalY = (int) (size.height * 0.8);
		int endVerticalY = (int) (size.height * 0.21);
		int startVerticalX = (int) (size.width / 2.1);
		
		System.out.println(startVerticalY+" "+endVerticalY+" "+startVerticalX);
		try {
		for (int i = 1; i <= howManySwipes; i++) {
		new TouchAction(getDriver()).press(point(startVerticalX, endVerticalY))
		.waitAction(waitOptions(ofSeconds(2))).moveTo(point(startVerticalX, startVerticalY))
		.release().perform();
		}
		} catch (Exception e) {
		//print error or something
		}
		}
	
	private static WaitOptions waitOptions(Object ofSeconds) {
		// TODO Auto-generated method stub
		return null;
	}


	private static Object ofSeconds(int i) {
		// TODO Auto-generated method stub
		return null;
	}


	private static PointOption point(int startVerticalX, int startVerticalY) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void scrollTo1(String text) {
		System.out.println("Scrolling to the Element which has the given text property : " + text);
		getDriver().findElement(MobileBy
				.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));
	}

	/**
	 * This method performs
	 * 
	 * @param text
	 */
	public static void scrollTo2(String text) {
		System.out.println("Scrolling to the Element which has the given text property : " + text);
		getDriver().findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ text + "\").instance(0))");
	}

	/**
	 * This will apply fluent wait until the given element is visible
	 * 
	 * @param element:Accepts WebElement element as an argumentS
	 * @throws MalformedURLException
	 */
	public static void applyExplicitWaitsUntilElementVisible(WebElement element) throws MalformedURLException {
		System.out.println("Applying Explicit wait until the given element is visible");
		WebDriverWait wait = new WebDriverWait(getDriver(), 25);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.withTimeout(15, TimeUnit.SECONDS);
	}

	/**
	 * This method will apply fluent wait until the specified element becomes
	 * clickable
	 * 
	 * @param element
	 */
	public static void applyExplicitWaitsUntilElementClickable(WebElement element) {
		System.out.println("Applying explicit wait until the given element is clickable");
		WebDriverWait wait = new WebDriverWait(getDriver(), 40);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.withTimeout(15, TimeUnit.SECONDS);
	}

	/**
	 * This method will give explicit wait for the specified duration
	 * 
	 * @param timeInSeconds
	 * @throws MalformedURLException
	 */
	public static void applyExplicitWait(int timeInSeconds) throws MalformedURLException {
		System.out.println("Applying explicit wait for the given time duration in seconds : " + timeInSeconds);
		WebDriverWait wait = new WebDriverWait(getDriver(), 30);
		wait.withTimeout(timeInSeconds, TimeUnit.SECONDS);
	}

	/**
	 * This method apply implicit wait and takes argument as integer value as time
	 * duration in seconds for which time the wait will be applied for
	 * 
	 * @param timeInSeconds
	 * @throws MalformedURLException
	 */
	public static void applyImplicitWait(int timeInSeconds) throws MalformedURLException {
		System.out.println("Applying implicit wait for the given time duartion in Seconds : " + timeInSeconds);
		getDriver().manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
	}

	/**
	 * This method will give us the attribute or property value for the element of
	 * our interest and it needs that WebElement as well as the attribute key
	 * 
	 * @param : Locator of type accessibilityID
	 * @param:elementPropertyOrAttribute for which we want to get the
	 *                                       property/attribute value
	 * @return value of the property/attribute
	 * @throws MalformedURLException
	 */
	public static String getElementAttribute(WebElement element, String attributeKey) throws MalformedURLException {
		System.out.println("Geting the value for the attribute/property for the given mobile element");
		MobileElement ele = (MobileElement) element;
		Keyword.applyImplicitWait(20);
		String value = ele.getAttribute(attributeKey);
		return value;

	}

	public static void getColorFromScreenshot(WebElement element) throws HeadlessException, AWTException {
		MobileElement ele = (MobileElement) element;
		Point point = ele.getCenter();
		int centreX = point.getX();
		int centreY = point.getY();
		BufferedImage image = new Robot()
				.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		int color = image.getRGB(centreX, centreY);
		int red = (color & 0x00ff0000) >> 16;
		int green = (color & 0x0000ff00) >> 8;
		int blue = color & 0x000000ff;
		System.out.println("Red Color value = " + red);
		System.out.println("Green Color value = " + green);
		System.out.println("Blue Color value = " + blue);
	}

	/**
	 * This method will handle when the video starts. It accepts parameter as two
	 * WebElements. The first locator has to be given precisely for the image of the
	 * lower half of the video(click on the player next to the timer when video
	 * starts for getting this locator). And the second locator is of the video end
	 * time
	 * 
	 * @param element1
	 * @param element2
	 * @throws IOException 
	 * @throws WebDriverException 
	 * @throws InterruptedException 
	 * 
	 * @throws MalformedURLException
	 */
	public static void forwardVideoTimerToEnd() throws WebDriverException, IOException, InterruptedException {
		action = new TouchAction(getDriver());
		Thread.sleep(5000);
		/*action.tap(PointOption.point(200, 200)).perform();
		action.tap(PointOption.point(240, 360)).perform();*/
		getDriver().findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Show player controls\"]/android.widget.FrameLayout[3]/android.view.View[2]")).click();
		applyExplicitWait(2);
		getDriver().findElementByAccessibilityId("Pause").click();
		WebElement seekBar = (MobileElement) driver.findElementByClassName("android.widget.SeekBar");
		// get location of seek bar from left
		int start = seekBar.getLocation().getX();
		System.out.println("Startpoint - " + start);

		// get location of seekbar from top
		int y = seekBar.getLocation().getY();
		System.out.println("Yaxis - " + y);

		// Get total width of seekbar
		int end = seekBar.getSize().getWidth();
		System.out.println("End point - " + end);

		action.press(PointOption.point(start, y)).moveTo(PointOption.point(end + start - 3, y)).release().perform();
		getDriver().findElementByAccessibilityId("Play").click();

	}

	// @AfterTest
	public void afterTest() {
		getDriver().quit();
		// TLD.get(null);
	}

}
