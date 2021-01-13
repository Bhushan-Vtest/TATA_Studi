package studi.co.pageModules;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;
import studi.co.Base.BaseClass;
import studi.co.Base.Keyword;
import studi.co.pageObjects.Object_Begin_Practice_Topic4_Chapter1_Mathematics;
import studi.co.pageObjects.Object_Begin_Revision_Topic4_Chapter1_Mathematics;
import studi.co.pageObjects.Object_Browse_Books;
import studi.co.pageObjects.Object_Syllabus_Option;

public class Module_Verify_Answer_Options_In_Practice extends BaseClass{
	
	public void module_Verify_Answer_Options_In_Practice() throws InterruptedException, IOException {
		
		Module_Login ml=new Module_Login(); 
		ml.Login_to_app();
		
	
		Object_Browse_Books obb=new Object_Browse_Books();
		Object_Syllabus_Option osm=new Object_Syllabus_Option();
		Object_Begin_Practice_Topic4_Chapter1_Mathematics obptcm = new Object_Begin_Practice_Topic4_Chapter1_Mathematics(); 
		obb.syllabus.click();
		Thread.sleep(2000);
		
//		osm.subject_Mathematics.click();
		Keyword.clickOnElementUsingText("Mathematics");
		Thread.sleep(6000);
		osm.topic_4_chapter_1.click();
		
		osm.begin_Practice_topic_4_chapter_1.click();
		Thread.sleep(5000);
		
		obptcm.beginPractice.click();
		Thread.sleep(6000);

		
	 
		 
		
		obptcm.beginPractice.click();
		
		applyExplicitWait(10);
		
		//verification that questions are displayed
		
		String questionText=obptcm.question1_part1_Text.getText(); 
		System.out.println(questionText);
		if(questionText.equals("Write the expression for the following using brackets.")){
			System.out.println("Questions are displayed");
		}
		Thread.sleep(2000);
		
		//verify that the multiple answers are available 
		Thread.sleep(2000);
		
		obptcm.first_answer.click();
		Boolean firstSelectedAfterClick=obptcm.first_answer.isSelected();
		
		Thread.sleep(2000);
		obptcm.second_answer.click();
		
		Boolean secondSelectedAfterClick=obptcm.second_answer.isSelected(); 
		
		if (firstSelectedAfterClick==secondSelectedAfterClick) {
			System.out.println("More than one Option are being clicked subsequently hence multiple answer options displayed");
		}
		
		Boolean firstSelectedAfterSecondAnswerClick=obptcm.first_answer.isSelected();
				
		// verify that answers are multi-select 
		Thread.sleep(2000);
		
		
		if (secondSelectedAfterClick==firstSelectedAfterSecondAnswerClick) {
			System.out.println("Answers are multi-selectable");
		}else {
			System.out.println("Answers are not multi-selectable");
		}
		
		//verify answers are as per designed layout 
		
	}
	public void verify_Question_Count_In_Practice() {
		Object_Begin_Practice_Topic4_Chapter1_Mathematics obptcm=new Object_Begin_Practice_Topic4_Chapter1_Mathematics(); 
		String questionCount=obptcm._1of5.getText();
		String[] s =questionCount.split("of");
		String s1=s[1].trim();
		int i=Integer.parseInt(s1);
		System.out.println("Total number of questions are : "+i);
		
	}
		
		public void verify_Answers_Selectable_Deselectable() throws InterruptedException, IOException {
			
			Module_Login ml=new Module_Login(); 
			ml.Login_to_app();
			
		
			Object_Browse_Books obb=new Object_Browse_Books();
			Object_Syllabus_Option osm=new Object_Syllabus_Option();
			Object_Begin_Practice_Topic4_Chapter1_Mathematics obpt = new Object_Begin_Practice_Topic4_Chapter1_Mathematics(); 
			obb.syllabus.click();
			Thread.sleep(2000);
			
	//		osm.subject_Mathematics.click();
			Keyword.clickOnElementUsingText("Mathematics");
			System.out.println("Subject selected is :Mathematics ");
			
			Thread.sleep(6000);
			osm.topic_4_chapter_1.click();
			
			
			Thread.sleep(4000);
			osm.begin_Practice_topic_4_chapter_1.click();
			System.out.println("Topic 4 of Chapter 1 is selected ");
			Thread.sleep(11000);
			
			obpt.beginPractice.click();
			Thread.sleep(7000);
			
	
			//verification that questions are displayed 
						
			
			
			String questionText=obpt.question1_part2_Text.getText();
			System.out.println("Question asked is : "+ questionText);
			if (questionText.equals("Three multiplied by the sum of three and five")){
				System.out.println("Questions are displayed");
			} else {
				System.out.println("Questions are not displayed");
			}
			//verify that the answers are selectable and deselectable
			
			obpt.first_answer.click();
			Thread.sleep(3000);
			
			Boolean resultAfterSelected=obpt.first_answer.isEnabled(); 
			
			//MobileElement element = (MobileElement)((AndroidDriver<AndroidElement>) getDriver()).findElementByAccessibilityId("c132feff-63e4-471f-876c-62d2e1dca472");
			//boolean isElementSelectedAfterClick = element.isSelected(); 
			
		
			
			obpt.first_answer.click();
			Thread.sleep(3000);
			Boolean resultAfterDeSelect = obpt.first_answer.isEnabled();
			
				
			if (resultAfterSelected==resultAfterDeSelect) {
				System.out.println("Answers are not selectable and de-selectable");
				
				} else {
					System.out.println("Answers are selectable and de-selectable");
				}
			
		} 
	}


