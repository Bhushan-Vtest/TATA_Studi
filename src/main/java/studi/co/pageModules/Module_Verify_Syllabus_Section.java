package studi.co.pageModules;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.MobileElement;
import studi.co.Base.BaseClass;
import studi.co.Base.Keyword;
import studi.co.pageObjects.Object_Landing_Page;
import studi.co.pageObjects.Object_Subject_Mathematics;
import studi.co.pageObjects.Object_Test_Unit;

public class Module_Verify_Syllabus_Section extends BaseClass {
	Object_Subject_Mathematics osm;
	Object_Test_Unit test = new Object_Test_Unit();

	public void verify_Begin_Practise_Link() throws IOException, InterruptedException {
		Object_Landing_Page olp = new Object_Landing_Page();
		osm = new Object_Subject_Mathematics();
		olp.syllabus.click();
		Keyword.clickOnElementUsingText("Mathematics");
		applyExplicitWait(100);
		Thread.sleep(35000);

//		for (int i = 1; i <= 14; i++) {

//			WebElement[] chapter= {osm.chapter_1,osm.chapter_2,osm.chapter_3,osm.chapter_4,osm.chapter_5,osm.chapter_6,osm.chapter_7,osm.chapter_8,osm.chapter_9,osm.chapter_10,osm.chapter_11,osm.chapter_12,osm.chapter_13,osm.chapter_14};

//			WebElement chapter = getDriver().findElement(By.xpath(
//					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup["
//							+ i + "]/android.view.ViewGroup[1]/android.widget.TextView"));
//			applyExplicitWait(3);
//			scrollTo1(chapter[i].getText());
//			System.out.println(i + " Chapter name is " + chapter[i].getText());

//		}

		List<MobileElement> list = getDriver().findElements(By.id("com.tce.studi:id/tv_topic"));
		System.out.println("Chapters available in given topic are as follows :");
		for (MobileElement topic : list) {
			System.out.println(topic.getText());
		}
		osm.comparing_Numbers.click();
		Boolean verify = osm.begin_Practise.isDisplayed();
		Assert.assertTrue(verify);

		osm.begin_Practise.click();

	}

	public void verify_beginPractise_Button() throws IOException, InterruptedException {
		verify_Begin_Practise_Link();

		Boolean verify = osm.comparing_Numbers_1.isDisplayed();
		System.out.println("Heading is displayed as : " + osm.comparing_Numbers_1.getText());

		List<MobileElement> list_Topics = getDriver().findElementsById("com.tce.studi:id/tvQuesId");

		System.out.println("Total " + list_Topics.size() + " Topics available are as below :");
		for (MobileElement topic : list_Topics) {
			System.out.println(topic.getText());
		}

		List<MobileElement> list_videoIcons = getDriver().findElementsById("com.tce.studi:id/imgFlagId");

		System.out.println("Total " + list_videoIcons.size() + " Video Icons are available after each Quetions:");

	}

	public void verify_Practise_Quetions() throws IOException, InterruptedException {
		verify_beginPractise_Button();

		osm.begin_Practise_1.click();
		applyExplicitWait(30);

		int quetionsCount = verify_Question_Count_In_Test_Module();

		SoftAssert soft = new SoftAssert();
		for (int i = 1; i <= quetionsCount; i++) {

			new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.elementToBeClickable(test.question1_part_Text));

			Boolean verify = test.question1_part_Text.isDisplayed();

			soft.assertTrue(verify);
			System.out.println(i + " quetion checked");
			applyExplicitWait(10);
			test.i_will_attempt_later.click();
			System.out.println("Clicked on attempt later button");
			applyExplicitWait(10);

		}
		soft.assertAll();

	}

	public int verify_Question_Count_In_Test_Module() throws MalformedURLException {

		Object_Test_Unit test1 = new Object_Test_Unit();
		applyExplicitWait(40);
		String questionCount = test1.quetionCount.getText();
		String[] s = questionCount.split("of");
		String s1 = s[1].trim();
		int i = Integer.parseInt(s1);
		System.out.println("Total number of questions are : " + i);

		return i;

	}
	
	public void verify_User_Can_attempt_PractiseQuetions() throws IOException, InterruptedException {
		verify_Practise_Quetions();
		
		
		
	}
}
