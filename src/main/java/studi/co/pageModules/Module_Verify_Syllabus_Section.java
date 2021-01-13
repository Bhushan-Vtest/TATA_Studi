package studi.co.pageModules;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import studi.co.Base.BaseClass;
import studi.co.Base.Keyword;
import studi.co.pageObjects.Object_Landing_Page;
import studi.co.pageObjects.Object_Syllabus_Option;
import studi.co.pageObjects.Object_Test_Unit;

public class Module_Verify_Syllabus_Section extends BaseClass {
	Object_Syllabus_Option osm;

	public void verify_Begin_Practise_Link() throws IOException, InterruptedException {
		SoftAssert assert1=new SoftAssert();
		
		String subject="Mathematics";
		String topic1="Comparing Numbers";
		
		osm = new Object_Syllabus_Option();
		osm.syllabus.click();
		applyExplicitWait(10);
		scrollTo2(subject);
		Keyword.clickOnElementUsingText(subject);
		applyExplicitWait(50);

		List <MobileElement> chapters=getDriver().findElementsById("com.tce.studi:id/tv_chapter");
		System.out.println(chapters.size());
		for(MobileElement chapter1 : chapters)	{
		applyExplicitWait(3);
		scrollTo2(chapter1.getText());
		assert1.assertTrue(chapter1.isDisplayed());
		System.out.println(chapter1.getText());
//		test.log(Status.INFO, chapter1.getText()+" chapter displayed");
		}
		
		List<MobileElement> list = getDriver().findElements(By.id("com.tce.studi:id/tv_topic"));
		System.out.println("Chapters available in given topic are :");
		for (MobileElement topic : list) {
			assert1.assertTrue(topic.isDisplayed());
		}
		applyExplicitWait(50);
		Keyword.clickOnElementUsingText(topic1);
		
		Boolean verify = osm.begin_Practise.isDisplayed();
		if(verify) {
//			test.log(Status.INFO, "Begin Practise Button Displayed");
		}
		assert1.assertTrue(verify);
		
		assert1.assertAll();
	}

	public void verify_beginPractise_Button() throws IOException, InterruptedException {
		SoftAssert assert1=new SoftAssert();
		String subject="Mathematics";
		String topic1="Comparing Numbers";
		
		verify_Begin_Practise_Link();
		osm.begin_Practise.click();
		applyExplicitWait(30);
//		WebElement topicname=getDriver().findElement(By.xpath("//*[contains(@text, '"+topic1+"')]"));
		Boolean verify = osm.topicHeading.isDisplayed();
		assert1.assertTrue(verify);
		
		System.out.println("Heading is displayed as : " + osm.topicHeading.getText());
		List<MobileElement> list_Topics = getDriver().findElementsById("com.tce.studi:id/tvQuesId");

		System.out.println("Total " + list_Topics.size() + " Topics are available ");
		for (MobileElement topic : list_Topics) {
			assert1.assertTrue(topic.isDisplayed());
		}

		List<MobileElement> list_videoIcons = getDriver().findElementsById("com.tce.studi:id/imgFlagId");
		for(MobileElement video: list_videoIcons) {
			assert1.assertTrue(video.isDisplayed());
		}
	System.out.println("Total " + list_videoIcons.size() + " Video Icons are available after each Quetions:");
	
	assert1.assertAll();
	}

	public void verify_Practise_Quetions() throws IOException, InterruptedException {
		verify_beginPractise_Button();
		applyExplicitWait(100);
		osm.begin_Practise_1.click();
		applyExplicitWait(30);

		int quetionsCount = verify_Question_Count_In_Test_Module();

		SoftAssert soft = new SoftAssert();
		for (int i = 1; i <= quetionsCount; i++) {

			new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.elementToBeClickable(osm.question1_part_Text));

			Boolean verify = osm.question1_part_Text.isDisplayed();

			soft.assertTrue(verify);
			System.out.println("Quetion No-"+i+" Checked");
			applyExplicitWait(10);
			osm.i_will_attempt_later.click();
			System.out.println("Clicked on attempt later button");
			applyExplicitWait(10);

		}
		soft.assertAll();

	}

	

	public void verify_User_Can_attempt_PractiseQuetions() throws IOException, InterruptedException, AWTException {
		verify_Practise_Quetions();
		int quetionsCount = verify_Question_Count_In_Test_Module();

		SoftAssert assert1 = new SoftAssert();
		
		System.out.println("All "+quetionsCount+" Quetions text are displayed");
		List<MobileElement> checkbox=getDriver().findElements(By.className("android.widget.CheckBox"));
		System.out.println(checkbox.size());
		int i=1;
		for(MobileElement check : checkbox) {
		Boolean verify=	check.isDisplayed();
		System.out.println("Answer option no"+i+" is displayed");
		assert1.assertTrue(verify);
			i++;
		}
		
		
		Boolean verify_checkAnswer=osm.check_answer.isDisplayed();
		if(verify_checkAnswer) {
//			test.log(Status.INFO, "Check Answer Button displayed");
		}
		else {
			System.out.println("Check answer button is not available");
		}
		assert1.assertTrue(verify_checkAnswer);
		osm.answer_Text_2.click();
		
		applyExplicitWait(5);

		osm.check_answer.click();
		
		Thread.sleep(5000);
		applyExplicitWaitsUntilElementVisible(osm.right_Answer_message);
		Boolean check_message=osm.right_Answer_message.isDisplayed();
		if(check_message) {
//			test.log(Status.INFO, "Great job! Let's continue.- message displayed");
		}
		else {
			System.out.println("Selected answer is wrong");
		}
		assert1.assertTrue(check_message);
		
		osm.continue1.click();
		applyExplicitWait(5);
		osm.answer_Text_3.click();
		osm.check_answer.click();
		
		applyExplicitWaitsUntilElementVisible(osm.wrong_Answer_message);
		Boolean check_wrong_message=osm.wrong_Answer_message.isDisplayed();
		if(check_wrong_message) {
//			test.log(Status.INFO, "Uh-oh! Give it another shot!- message displayed");
		}
		assert1.assertTrue(check_wrong_message);
		
		Boolean tryAgain=osm.try_Again_Button.isDisplayed();
		assert1.assertTrue(tryAgain);
		if(tryAgain) {
			System.out.println("Try Again Button is displayed");
//			test.log(Status.INFO, "Try Again Button is displayed");
		}
		assert1.assertAll();

	}
	
	public void toVerify_ProperFeedBack_forCorrectOption() throws MalformedURLException, AWTException, InterruptedException {
		SoftAssert assert1=new SoftAssert();
		to_Launch_Practise_Quetions_Quiz();
		applyExplicitWaitsUntilElementClickable(osm.answer_Text_2);
		osm.answer_Text_2.click();
		applyExplicitWait(5);
		osm.check_answer.click();
		String check_message=osm.right_Answer_message.getText();
		if(check_message.equals("Great job! Let's continue.")) {
//			test.log(Status.INFO, "Great job! Let's continue.- message displayed and green smiley icon is displayed");
		}
		else {
			System.out.println("Heading is not displayed as expected");
		}
		assert1.assertEquals(check_message, "Great job! Let's continue.");
		
	Boolean verify=	osm.continue_Button.isDisplayed();
	if(verify.equals(true)) {
//		test.log(Status.INFO, "Continue Button is displayed");
	}
	else {
		System.out.println("Continue button is not displayed");
//		test.log(Status.INFO, "Continue button is not displayed");
	}
	assert1.assertTrue(verify);
	
	assert1.assertAll();
		
		
	}
	
	public void toVerify_Warning_Message() throws MalformedURLException, InterruptedException{
		SoftAssert assert1=new SoftAssert();
		to_Launch_Practise_Quetions_Quiz();
		osm = new Object_Syllabus_Option();
		applyExplicitWaitsUntilElementClickable(osm.back_Button);
		Thread.sleep(5000);
		osm.back_Button.click();
		applyExplicitWait(5);
		Thread.sleep(5000);
		String warning_Message_1=osm.warning_Message_1.getText();
		String warning_Message_2=osm.warning_Message_2.getText();
		
		Boolean warning_verify_1=osm.warning_Message_1.isDisplayed();
		Boolean warning_verify_2=osm.warning_Message_2.isDisplayed();
		
		assert1.assertTrue(warning_verify_1);
		assert1.assertTrue(warning_verify_2);
		
		if(warning_Message_1.equals("Are you sure want to go Away?") && warning_Message_2.equals("Your Progress will be lost.")) {
//			test.log(Status.INFO, "Warning message  prints correctly");
			System.out.println("Warning message  prints correctly");
		}
		
		else {
//			test.log(Status.INFO, "Warning message doesn't  print correctly");
			System.out.println("Warning message doesn't  print correctly");
		}
		
		Boolean yes_Button=osm.yes_Button.isDisplayed();
		Boolean no_Button=osm.no_Button.isDisplayed();
		
		if(yes_Button.equals(true)) {
//			test.log(Status.INFO, "Yes button is available");
			System.out.println("Yes button is available");
		}
		else {
//			test.log(Status.INFO, "Yes button is not available");
			System.out.println("Yes button is not available");
		}
		
		if(no_Button.equals(true)) {
//			test.log(Status.INFO, "No button is available");
			System.out.println("No button is available");
		}
		else {
	//		test.log(Status.INFO, "No button is not available");
			System.out.println("No button is not available");
		}
		assert1.assertTrue(yes_Button);
		assert1.assertTrue(no_Button);
		
		osm.no_Button.click();
		applyExplicitWait(5);
		if(osm.question1_part_Text.isDisplayed()) {
//			test.log(Status.INFO, "User can navigated back to practise quiz after clicking on No button");
			System.out.println("User can navigated back to practise quiz after clicking on No button");
		}
		
		osm.back_Button.click();
		osm.yes_Button.click();
		
		applyExplicitWait(5);
		if(osm.your_Confidence_Report.isDisplayed()) {
//			test.log(Status.INFO, "User can navigated back to Topic Listing Page after clicking on Yes button");
			System.out.println("User can navigated back to Topic Listing Page after clicking on Yes button");
		}
	}

	public void toVerify_ProperFeedBack_forInCorrectOption() throws MalformedURLException, InterruptedException, AWTException {
		SoftAssert assert1=new SoftAssert();
		to_Launch_Practise_Quetions_Quiz();
		
//		Keyword.scrollDown();
		applyExplicitWaitsUntilElementClickable(osm.answer_Text_35);
		osm.answer_Text_35.click();
		applyExplicitWaitsUntilElementClickable(osm.check_answer);

		osm.check_answer.click();
		String check_message=osm.wrong_Answer_message.getText();
		if(check_message.equals("Uh-oh! Give it another shot!")) {
			test.log(Status.INFO, check_message+" this Heading is displayed and Red smiley icon is displayed");
			System.out.println(check_message+" this Heading is displayed and Red smiley icon is displayed");
			
		}
		else {
//			test.log(Status.INFO, "Heading is not displayed as expected");
			System.out.println("Heading is not displayed as expected");
		}
		assert1.assertEquals(check_message, "Uh-oh! Give it another shot!");
		
		
	Boolean try_Button=osm.try_Again_Button.isDisplayed();
	assert1.assertTrue(try_Button);
	if(try_Button) {
	System.out.println("TRY AGAIN button is displayed");
//	test.log(Status.INFO, "TRY AGAIN button is displayed");

	}
	else {
		System.out.println("TRY AGAIN button is not displayed");
//		test.log(Status.INFO, "TRY AGAIN button is not displayed");
	}
	
	Boolean I_dont_know=osm.I_dont_know_Button.isDisplayed();
	assert1.assertTrue(I_dont_know);
	if(I_dont_know) {
	System.out.println("I dont know button is displayed");
//	test.log(Status.INFO, "I dont know button is displayed");
	
	}
	else {
		System.out.println("I dont know button is not displayed");
//		test.log(Status.INFO, "I dont know button is not displayed");

	}
	assert1.assertTrue(I_dont_know);
	
	applyExplicitWait(5);
	osm.I_dont_know_Button.click();
	applyExplicitWait(5);
	Thread.sleep(5000);
	scrollTo2("That’s right.");
	Boolean thatsRight=osm.thats_right.isDisplayed();
	if(thatsRight) {
		System.out.println("Correct answer is displayed after clicking on I dont Know button");
//		test.log(Status.INFO, "Correct answer is displayed after clicking on I dont Know button");

	}
	else {
		System.out.println("Correct answer is not displayed after clicking on I dont Know button");
//		test.log(Status.INFO, "Correct answer is not displayed after clicking on I dont Know button");

	}
		assert1.assertTrue(thatsRight);
		

		Boolean continue_Button=osm.continue1.isDisplayed();
		if(continue_Button) {
			System.out.println("Continue Button is displayed");
//			test.log(Status.INFO, "Continue Button is displayed");

		}
		else {
			System.out.println("Continue Button is not displayed");
//			test.log(Status.INFO, "Continue Button is not displayed");

		}
			assert1.assertTrue(continue_Button);
		
			applyExplicitWait(5);
		osm.continue1.click();
		applyExplicitWait(5);
		
		
		scrollTo1("482");
		osm.answer_Text_482.click();
		applyExplicitWait(5);
		osm.check_answer.click();
		applyExplicitWait(5);
		osm.try_Again_Button.click();
		applyExplicitWait(5);
		
		String errorMessage=osm.you_have_one_attempt_left.getText();
		if(errorMessage.equals("You have one attempt left")) {
//			test.log(Status.INFO, "You have one attempt left -this heading is displayed");
			System.out.println("You have one attempt left -this heading is displayed");
		}
		
		Boolean checkAnswer=osm.check_answer.isEnabled();
		if(checkAnswer) {
//			test.log(Status.INFO, "Check answer button  is enabled");
			System.out.println("Check answer button  is enabled");
		}
		else {
//			test.log(Status.INFO, "Check answer button  is disabled");
			System.out.println("Check answer button is disabled");
		}
		
		scrollTo1("482");
		osm.answer_Text_482.click();
		applyExplicitWait(5);
		osm.check_answer.click();
		
		String error=osm.Not_quite_Lets_continue.getText();
		if(error.equals("Not quite. Let's continue.")) {
//			test.log(Status.INFO, "Not quite. Let's continue.-this Heading is displayed");
			System.out.println("Not quite. Let's continue.-this Heading is displayed");
		}	
			applyExplicitWait(5);
			osm.continue1.click();
			applyExplicitWait(5);
			
			Boolean nextPage=osm.question1_part_Text.isDisplayed();
			if(nextPage) {
//				test.log(Status.INFO, "User Navigated to Next quetion");
				System.out.println("User Navigated to Next quetion");
			}
			assert1.assertTrue(nextPage);
		assert1.assertAll();
	}
	
	
	public void toVerify_Confidence_Report_Page() throws MalformedURLException, InterruptedException{
		
		SoftAssert assert1=new SoftAssert();
		osm = new Object_Syllabus_Option();
		osm.syllabus.click();
		applyExplicitWait(10);
		Keyword.clickOnElementUsingText("Mathematics");
		System.out.println("Clicked on Mathematics subject");
		Thread.sleep(10000);
		applyExplicitWaitsUntilElementClickable(osm.estimation_of_Numbers);
		Thread.sleep(10000);
		osm.estimation_of_Numbers.click();
		System.out.println("Clicked on Estimation of Numbers");
		applyExplicitWait(10);
		applyExplicitWaitsUntilElementClickable(osm.practiseAgain1);
		osm.practiseAgain1.click();
		System.out.println("Clicked on Practise Again Button");
		applyExplicitWait(30);
		Thread.sleep(10000);
		applyExplicitWaitsUntilElementClickable(osm.practiseAgain2);
		osm.practiseAgain2.click();
		applyExplicitWait(30);
		Thread.sleep(10000);
		applyExplicitWait(10);
		int quetionCount=verify_Question_Count_In_Test_Module();
		
		for(int i=1;i<=quetionCount;i++) {
			selectCorrectOption1(i);
			applyExplicitWait(5);
			osm.check_answer.click();
			applyExplicitWait(5);
			osm.continue1.click();
			applyExplicitWait(10);
			
		}
		
		Boolean report=osm.your_Confidence_Report.isDisplayed();
		if(report) {
			System.out.println("Confidence Report is displayed");
//			test.log(Status.INFO, "Confidence Report is displayed");

		}
		else {
			System.out.println("Confidence report is not displayed");
//			test.log(Status.INFO, "Confidence Report is not displayed");

		}
		assert1.assertTrue(report);
		
		Boolean score=osm.high_Medium_Low.isDisplayed();
		if(score) {
			System.out.println("Score in High,Medium and Low sections are displayed");
//			test.log(Status.INFO, "Score in High,Medium and Low sections are displayed");

		}
		else {
			System.out.println("Score in High,Medium and Low sections are not displayed");
//			test.log(Status.INFO, "Score in High,Medium and Low sections are displayed");

		}
		assert1.assertTrue(score);										
		
		List<MobileElement> list_Topics = getDriver().findElementsById("com.tce.studi:id/tvQuesId");

		System.out.println("Total " + list_Topics.size() + " Topics available are as below :");
		for (MobileElement topic : list_Topics) {
			System.out.println(topic.getText());
		}
		
		Boolean continue_Studying_Button=osm.continue_Studying.isDisplayed();
		if(continue_Studying_Button) {
			System.out.println("Continue Studying Button is available");
//			test.log(Status.INFO, "Continue Studying Button is available");

		}
		assert1.assertTrue(continue_Studying_Button);
		
		osm.continue_Studying.click();
		applyExplicitWait(5);
		
		Boolean topic_Name=osm.topic_Name.isDisplayed();
		if(topic_Name) {
			System.out.println("User Navigated to next topic after clicking on Continue Studying Buttton");
//			test.log(Status.INFO, "User Navigated to next topic after clicking on Continue Studying Buttton");

		}
		assert1.assertTrue(topic_Name);
		
		Boolean practise_Again=osm.practise_Again.isDisplayed();
		if(practise_Again) {
			System.out.println("Practise Again button is available and after clicking Practise button User can reattempt the quiz");
//			test.log(Status.INFO, "Practise Again button is available and after clicking Practise button User can reattempt the quiz");

		}
		assert1.assertTrue(practise_Again);
		
		assert1.assertAll();
		
	}
	
	public void to_Launch_Practise_Quetions_Quiz() throws MalformedURLException, InterruptedException{
		String subject="Mathematics";
		String topic1="Comparing Numbers";
		osm = new Object_Syllabus_Option();
		osm.syllabus.click();
		applyExplicitWait(10);
		Keyword.clickOnElementUsingText(subject);
		System.out.println("Clicked on "+subject+" subject");
		Thread.sleep(10000);
		applyExplicitWaitsUntilElementClickable(osm.comparing_Numbers);
		Keyword.clickOnElementUsingText(topic1);
		System.out.println("Clicked on "+ topic1);
		applyExplicitWait(10);
		applyExplicitWaitsUntilElementClickable(osm.begin_Practise);
		osm.begin_Practise.click();
		System.out.println("Clicked on Begin Practise button");
		applyExplicitWait(30);
		Thread.sleep(20000);
		applyExplicitWaitsUntilElementClickable(osm.begin_Practise_1);
		osm.begin_Practise_1.click();
		applyExplicitWait(30);
	}
	
	public int verify_Question_Count_In_Test_Module() throws MalformedURLException, InterruptedException {
		Thread.sleep(10000);
		applyExplicitWaitsUntilElementVisible(osm.quetionCount);
		String questionCount = osm.quetionCount.getText();
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
	
	
	public Boolean selectCorrectOption1(int queNumber) {
		switch (queNumber) {

		case 1:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '90')]")));
			return true;
		case 2:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '13200')]")));
			return true;
		case 3:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '6,500')]")));
			return true;
		case 4:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '30')]")));
			return true;
		case 5:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '₹630')]")));
			return true;
		case 6:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '3,000')]")));
			return true;
		case 7:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '5,000')]")));
			return true;
		case 8:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '38,900')]")));
			return true;
		case 9:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '80 days')]")));
			return true;
		case 10:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '3529')]")));
			return true;
		case 11:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '14400')]")));
			return true;
		case 12:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '18000')]")));
			return true;
		case 13:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '30,000')]")));
			return true;
		case 14:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, 'Round off each number to its greatest place and multiply.')]")));
			return true;
		case 15:
			clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '10,80,000')]")));
			return true;
		
		default:
			return false;
		}
		
	}
	
	
}
