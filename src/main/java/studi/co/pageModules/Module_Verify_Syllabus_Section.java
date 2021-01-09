package studi.co.pageModules;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Iterator;
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
	Object_Landing_Page olp;
	Object_Test_Unit test = new Object_Test_Unit();

	public void verify_Begin_Practise_Link() throws IOException, InterruptedException {
		olp = new Object_Landing_Page();
		osm = new Object_Subject_Mathematics();
		olp.syllabus.click();
		applyExplicitWait(10);
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
		applyExplicitWait(100);
		osm.comparing_Numbers.click();
		Boolean verify = osm.begin_Practise.isDisplayed();
		Assert.assertTrue(verify);

		osm.begin_Practise.click();
		applyExplicitWait(30);

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
		applyExplicitWait(100);
		osm.begin_Practise_1.click();
		applyExplicitWait(30);

		int quetionsCount = verify_Question_Count_In_Test_Module();

		SoftAssert soft = new SoftAssert();
//		for (int i = 1; i <= quetionsCount; i++) {
//
//			new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class)
//					.until(ExpectedConditions.elementToBeClickable(test.question1_part_Text));
//
//			Boolean verify = test.question1_part_Text.isDisplayed();
//
//			soft.assertTrue(verify);
//			System.out.println(i + " quetion checked");
//			applyExplicitWait(10);
//			test.i_will_attempt_later.click();
//			System.out.println("Clicked on attempt later button");
//			applyExplicitWait(10);
//
//		}
		soft.assertAll();

	}

	

	public void verify_User_Can_attempt_PractiseQuetions() throws IOException, InterruptedException, AWTException {
		verify_Practise_Quetions();
		int quetionsCount = verify_Question_Count_In_Test_Module();

		SoftAssert assert1 = new SoftAssert();
//		for (int i = 1; i <= quetionsCount; i++) {
//
//			new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class)
//					.until(ExpectedConditions.elementToBeClickable(test.question1_part_Text));
//
//			Boolean verify = test.question1_part_Text.isDisplayed();
//			assert1.assertTrue(verify);
//			System.out.println(i + " quetion is :" + test.question1_part_Text.getText());
//			applyExplicitWait(10);
//
//			test.i_will_attempt_later.click();
//			System.out.println("Clicked on attempt later button");
//			applyExplicitWait(10);
//		}
		System.out.println("All "+quetionsCount+" Quetions text are displayed");
		
		
		Boolean verify_checkAnswer=test.check_answer.isDisplayed();
		if(verify_checkAnswer) {
			System.out.println("Check answer button is available");
		}
		else {
			System.out.println("Check answer button is not available");
		}
		assert1.assertTrue(verify_checkAnswer);
//		scrollTo2("2");
//		Keyword.scrollDown();
		osm.answer_Text_2.click();
		
		applyExplicitWait(5);
//		Boolean answer_click=osm.answer_text_2.isSelected();
//		if(answer_click) {
//			System.out.println("answer is selected");
//		}
//		else {
//			System.out.println("answer is not selected");
//		}
//		applyExplicitWait(5);
		test.check_answer.click();
		
		Thread.sleep(5000);
		applyExplicitWaitsUntilElementVisible(osm.right_Answer_message);
		Boolean check_message=osm.right_Answer_message.isDisplayed();
		if(check_message) {
			System.out.println("Selected answer is right and green smiley icon is displayed");
		}
		else {
			System.out.println("Selected answer is wrong");
		}
		
		
		assert1.assertAll();

	}
	
	public void toVerify_ProperFeedBack_forCorrectOption() throws MalformedURLException, AWTException, InterruptedException {
		SoftAssert assert1=new SoftAssert();
		to_Launch_Practise_Quetions_Quiz();
//		Keyword.scrollDown();
		applyExplicitWaitsUntilElementClickable(osm.answer_Text_2);
		osm.answer_Text_2.click();
		applyExplicitWait(5);
		test.check_answer.click();
		String check_message=osm.right_Answer_message.getText();
		if(check_message.equals("Great job! Let's continue.")) {
			System.out.println(check_message+" this Heading is displayed and green smiley icon is displayed");
		}
		else {
			System.out.println("Heading is not displayed as expected");
		}
		assert1.assertEquals(check_message, "Great job! Let's continue.");
		
	Boolean verify=	osm.continue_Button.isDisplayed();
	if(verify.equals(true)) {
		System.out.println("Continue button is displayed");
	}
	else {
		System.out.println("Continue button is not displayed");
	}
	assert1.assertTrue(verify);
	
	assert1.assertAll();
		
		
	}
	

	
	public void toVerify_Warning_Message() throws MalformedURLException, InterruptedException{
		SoftAssert assert1=new SoftAssert();
		to_Launch_Practise_Quetions_Quiz();
		osm = new Object_Subject_Mathematics();
		osm.back_Button.click();
		applyExplicitWait(5);
		String warning_Message_1=osm.warning_Message_1.getText();
		String warning_Message_2=osm.warning_Message_2.getText();
		
		Boolean warning_verify_1=osm.warning_Message_1.isDisplayed();
		Boolean warning_verify_2=osm.warning_Message_2.isDisplayed();
		
		assert1.assertTrue(warning_verify_1);
		assert1.assertTrue(warning_verify_2);
		
		if(warning_Message_1.equals("Are you sure want to go Away?") && warning_Message_2.equals("Your Progress will be lost.")) {
			System.out.println("Warning message  prints correctly");
		}
		
		else {
			System.out.println("Warning message doesn't  print correctly");
		}
		
		Boolean yes_Button=osm.yes_Button.isDisplayed();
		Boolean no_Button=osm.no_Button.isDisplayed();
		
		if(yes_Button.equals(true)) {
			System.out.println("Yes button is available");
		}
		else {
			System.out.println("Yes button is not available");
		}
		
		if(no_Button.equals(true)) {
			System.out.println("No button is available");
		}
		else {
			System.out.println("No button is not available");
		}
		assert1.assertTrue(yes_Button);
		assert1.assertTrue(no_Button);
		
		osm.no_Button.click();
		applyExplicitWait(5);
		if(test.question1_part_Text.isDisplayed()) {
			System.out.println("User can navigated back to practise quiz after clicking on No button");
		}
		
		osm.back_Button.click();
		osm.yes_Button.click();
		
		applyExplicitWait(5);
		if(osm.your_Confidence_Report.isDisplayed()) {
			System.out.println("User can navigated back to Topic Listing Page after clicking on Yes button");
		}
		
		
		
	}

	public void toVerify_ProperFeedBack_forInCorrectOption() throws MalformedURLException, InterruptedException, AWTException {
		SoftAssert assert1=new SoftAssert();
		to_Launch_Practise_Quetions_Quiz();
		
//		Keyword.scrollDown();
		applyExplicitWaitsUntilElementClickable(osm.answer_Text_35);
		osm.answer_Text_35.click();
		applyExplicitWaitsUntilElementClickable(test.check_answer);

		test.check_answer.click();
		String check_message=osm.wrong_Answer_message.getText();
		if(check_message.equals("Uh-oh! Give it another shot!")) {
			System.out.println(check_message+" this Heading is displayed and Red smiley icon is displayed");
		}
		else {
			System.out.println("Heading is not displayed as expected");
		}
		assert1.assertEquals(check_message, "Uh-oh! Give it another shot!");
		
		
	Boolean try_Button=osm.try_Again_Button.isDisplayed();
	assert1.assertTrue(try_Button);
	if(try_Button)
	System.out.println("TRY AGAIN button is displayed");
	else {
		System.out.println("TRY AGAIN button is not displayed");
	}
	
	Boolean I_dont_know=osm.I_dont_know_Button.isDisplayed();
	assert1.assertTrue(I_dont_know);
	if(I_dont_know)
	System.out.println("I dont know button is displayed");
	else {
		System.out.println("I dont know button is not displayed");
	}
	assert1.assertTrue(I_dont_know);
	
	applyExplicitWait(5);
	osm.I_dont_know_Button.click();
	
	scrollTo1("That’s right.");
	Boolean thatsRight=osm.thats_right.isDisplayed();
	if(thatsRight) {
		System.out.println("Correct answer is displayed after clicking on I dont Know button");
	}
	else {
		System.out.println("Correct answer is not displayed after clicking on I dont Know button");
	}
		assert1.assertTrue(thatsRight);
		

		Boolean continue_Button=osm.continue1.isDisplayed();
		if(continue_Button) {
			System.out.println("Continue Button is displayed");
		}
		else {
			System.out.println("Continue Button is not displayed");
		}
			assert1.assertTrue(continue_Button);
		
			applyExplicitWait(5);
		osm.continue1.click();
		applyExplicitWait(5);
		
		
		scrollTo1("482");
		osm.answer_Text_482.click();
		applyExplicitWait(5);
		test.check_answer.click();
		applyExplicitWait(5);
		osm.try_Again_Button.click();
		applyExplicitWait(5);
		
		String errorMessage=osm.you_have_one_attempt_left.getText();
		if(errorMessage.equals("You have one attempt left")) {
			System.out.println("You have one attempt left -this heading is shown");
		}
		
		Boolean checkAnswer=test.check_answer.isEnabled();
		if(checkAnswer) {
			System.out.println("Check answer button  is enabled");
		}
		else {
			System.out.println("Check answer button is disabled");
		}
		
		scrollTo1("482");
		osm.answer_Text_482.click();
		applyExplicitWait(5);
		
		String error=osm.Not_quite_Lets_continue.getText();
		if(error.equals("Not quite. Let's continue.")) {
			System.out.println("Not quite. Let's continue.-this Heading is displayed");
		}	
			applyExplicitWait(5);
			osm.continue1.click();
			applyExplicitWait(5);
			
			Boolean nextPage=test.question1_part_Text.isDisplayed();
			if(nextPage) {
				System.out.println("User Navigated to Next quetion");
			}
			assert1.assertTrue(nextPage);
		assert1.assertAll();
	}
	
	
	public void toVerify_Confidence_Report_Page() throws MalformedURLException, InterruptedException{
		
		SoftAssert assert1=new SoftAssert();
		to_Launch_Practise_Quetions_Quiz();
		applyExplicitWait(10);
		int quetionCount=verify_Question_Count_In_Test_Module();
		
		for(int i=1;i<=quetionCount;i++) {
			selectCorrectOption(i);
			applyExplicitWait(5);
			test.check_answer.click();
			applyExplicitWait(5);
			osm.continue1.click();
			applyExplicitWait(10);
			
		}
		
	}
	
	public void to_Launch_Practise_Quetions_Quiz() throws MalformedURLException, InterruptedException{
		olp = new Object_Landing_Page();
		osm = new Object_Subject_Mathematics();
		olp.syllabus.click();
		applyExplicitWait(10);
		Keyword.clickOnElementUsingText("Mathematics");
		System.out.println("Clicked on Mathematics subject");
		applyExplicitWaitsUntilElementClickable(osm.comparing_Numbers);
		Thread.sleep(50000);
		osm.comparing_Numbers.click();
		System.out.println("Clicked Comparing Number ");
		applyExplicitWait(10);
		applyExplicitWaitsUntilElementClickable(osm.begin_Practise);
		osm.begin_Practise.click();
		System.out.println("Clicked on Begin Practise button");
		applyExplicitWait(30);
		Thread.sleep(20000);
		applyExplicitWaitsUntilElementClickable(osm.begin_Practise_1);
		osm.begin_Practise_1.click();
		applyExplicitWait(30);
		Thread.sleep(20000);
	}
	
	public int verify_Question_Count_In_Test_Module() throws MalformedURLException, InterruptedException {
		Thread.sleep(50000);
		Object_Test_Unit test1 = new Object_Test_Unit();
		applyExplicitWaitsUntilElementVisible(test1.quetionCount);
		String questionCount = test1.quetionCount.getText();
		String[] s = questionCount.split("of");
		String s1 = s[1].trim();
		int i = Integer.parseInt(s1);
		System.out.println("Total number of questions are : " + i);

		return i;

	}
	
	public Boolean selectCorrectOption(int queNumber) {
		switch (queNumber) {

		case 1:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '2')]")));
			return true;
		case 2:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '6')]")));
			return true;
		case 3:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '3311')]")));
			return true;
		case 4:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '2474')]")));
			return true;
		case 5:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '277')]")));
			return true;
		case 6:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, 'True')]")));
			return true;
		case 7:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '8, 9, 12, 15')]")));
			return true;
		case 8:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, 'Ruler, Sharpener, Eraser, Pencil')]")));
			return true;
		case 9:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, 'Rahul, Jatin, Amit, Deepak')]")));
			return true;
		case 10:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, 'Mary')]")));
			return true;
		case 11:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '14389')]")));
			return true;
		case 12:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '5461')]")));
			return true;
		case 13:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, 'False')]")));
			return true;
		case 14:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, 'City C')]")));
			return true;
		case 15:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, 'Priya - 450')]")));
			return true;
		
		default:
			return false;
		}

	}
	
}
