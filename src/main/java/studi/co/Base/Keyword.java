package studi.co.Base;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.maven.surefire.shade.common.org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;

public class Keyword extends BaseClass {

	public Keyword() throws MalformedURLException {

		super();
	}
	/**
	 * This method will tap on the element on which we want to tap on
	 * 
	 * @param element
	 */
	// public static void tapOnElement(WebElement element) {
	// TouchAction action = new TouchAction(getDriver());
	// action.tap((TapOptions) element);
	// }
	/**
	 * This method will perform click operation on the Element for the text
	 * attribute which matches to text which we have passed as an argument out of
	 * the List<WebElements>
	 * 
	 * @param listOfElements
	 * @param text
	 */
	public static void clickAfterTextMatch(List<WebElement> listOfElements, String text) {
		int size = listOfElements.size();
		for (int i = 0; i < size; i++) {
			WebElement ele = listOfElements.get(i);
			String s = ele.getText();
			if (s.equalsIgnoreCase(text)) {
				ele.click();
				break;
			}

		}
	}

	/**
	 * This method performs click operation on the element for which the text
	 * property has been passed as an argument
	 * 
	 * @param:text:The text
	 *                     property of the element on which we want to click
	 */
	public static void clickOnElementUsingText(String text) {
		getDriver().findElementByAndroidUIAutomator("text(\"" + text + "\")").click();
	}
	/**
	 * 
	 * This method will perform long press on the WebElement parameter passed
	 * 
	 * @param:WebElement ele
	 *                       on which we want to perform long press on
	 */
	// public static void longPressOnElement(WebElement element {
	// TouchAction action = new TouchAction(getDriver());
	// action.longPress(longPressOptions);
	// }
	/**
	 * 
	 * This method takes String filepath as a parameter and it is
	 * 
	 * @param filepath:The
	 *            path where we want to save the screenshot
	 * @return the filepath which we have passed as a parameter
	 * @throws IOException
	 */
	/*
	 * public static String takeScreenshot(String tcName) throws IOException {
	 * System.out.println("Capturing Screenshot"); DateFormat dateFormat = new
	 * SimpleDateFormat("dd-MM-YY hh-mm-ss"); Date date = new Date(); String
	 * datetime = dateFormat.format(date);
	 * 
	 * String screenshotPath = System.getProperty("user.dir") +
	 * "\\Screenshots\\" + tcName + " dated " + datetime + ".png"; TakesScreenshot
	 * ts = (TakesScreenshot) getDriver(); File srcFile =
	 * ts.getScreenshotAs(OutputType.FILE); File destFile = new
	 * File(screenshotPath); FileUtils.copyFile(srcFile, destFile); return
	 * screenshotPath; }
	 */
	/**
	 * This method takes screenshot whenever called and returns the String filepath
	 * where we want the screenshot to save
	 * 
	 * @param filepath
	 * @return: String filepath where we want to save the Buffered Image of PNG type
	 * @throws HeadlessException
	 * @throws AWTException
	 * @throws IOException
	 */

	/*
	 * public static String takeScreenshotUsingRobot(String tcName) throws
	 * HeadlessException, AWTException, IOException { DateFormat dateFormat = new
	 * SimpleDateFormat("dd-MM-YY hh-mm-ss"); Date date = new Date(); String
	 * datetime = dateFormat.format(date);
	 * 
	 * String screenshotPath = System.getProperty("user.dir") +
	 * "\\Screenshots\\" + tcName + " dated " + datetime + ".png";
	 * System.out.println("Capturing Screenshot using Robot Class"); BufferedImage
	 * image = new Robot() .createScreenCapture(new
	 * Rectangle(Toolkit.getDefaultToolkit().getScreenSize())); ImageIO.write(image,
	 * "PNG", new File(screenshotPath)); return screenshotPath;
	 * 
	 * }
	 */
	/**
	 * 
	 * @return:boolean result if the given element is selected or not
	 */
	public static boolean isElementSelected(String accessibilityID) {
		MobileElement element = (MobileElement) getDriver().findElementByAccessibilityId(accessibilityID);
		boolean isSelected = element.isSelected();
		return isSelected;
	}
	/*
	 * public static void dragAndDrop(WebElement element) { TouchAction action = new
	 * TouchAction((PerformsTouchActions) getDriver()); //
	 * action.longPress(element(source)).moveT }
	 */
	/**
	 * This method will handle when the video starts. It accepts parameter as two
	 * WebElements. The first locator has to be given precisely for the image of the
	 * lower half of the video(click on the player next to the timer when video
	 * starts for getting this locator). And the second locator is of the video end
	 * time
	 * 
	 * @param element1
	 * @param element2
	 * 
	 * @throws MalformedURLException
	 */
	public static void handleVideoWait(WebElement element1, WebElement element2)
			throws InterruptedException, MalformedURLException {

		element1.click();
		applyExplicitWait(5);
		String totalVideoTime = element2.getText();
		System.out.println(totalVideoTime);
		int totalWaitingMins = Integer.parseInt(totalVideoTime.split(":")[0]);
		int totalWaitingSecs = Integer.parseInt(totalVideoTime.split(":")[1]);
		int minSecs = (totalWaitingMins) * 60;
		int totalWait = (minSecs + totalWaitingSecs + 5) * 1000;
		System.out.println("Waiting for Video to complete. Waiting for '" + (totalWait) / 1000 + "' seconds");
		int wait = 0;
		try {
			while (wait < totalWait) {
				Thread.sleep(5000);
				element1.click();
				wait = wait + 5000;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Waited till '" + (totalWait) / 1000 + "' seconds");
	}

	/**
	 * This method presses the TAB button and will move the location of the driver
	 * instance from current element to the next available element
	 * 
	 * @throws AWTException
	 */
	public static void tabPress() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

	}
	/**
	 * This method can be used to create logs. It uses the log4j library to create logs. 
	 * @param message
	 */
	public static void createLog(String message) {
		log = Logger.getLogger(Keyword.class);
		PropertyConfigurator.configure("log4j.properties");
		log.info(message);

	}
	
	public static void scrollDown() throws AWTException {
		 Robot robot = new Robot();

	        // Scroll Down using Robot class
	        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	}
}
