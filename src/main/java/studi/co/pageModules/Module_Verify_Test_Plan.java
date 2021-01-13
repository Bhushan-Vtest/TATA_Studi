package studi.co.pageModules;

import java.net.MalformedURLException;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import studi.co.Base.BaseClass;
import studi.co.Base.Keyword;
import studi.co.pageObjects.Object_Begin_Practice_Topic4_Chapter1_Mathematics;
import studi.co.pageObjects.Object_Test_Unit;

public class Module_Verify_Test_Plan extends BaseClass {

	public void verify_Test_Plan() throws MalformedURLException, InterruptedException {
		Object_Test_Unit test = new Object_Test_Unit();

		
		test.Test_Unit.click();
		Thread.sleep(3000);
		scrollTo1("View Full Schedule");
		applyExplicitWaitsUntilElementVisible(test.comparing_Numbers_2);

		test.comparing_Numbers_2.click();
		applyExplicitWait(20);
//		Thread.sleep(5000);
		test.begin_Practise.click();
		
		Thread.sleep(15000);
//		applyExplicitWaitsUntilElementVisible(test.quetionCount);
	
		int quetionsCount=verify_Question_Count_In_Test_Module();

		SoftAssert soft=new SoftAssert()	;
		for (int i = 1; i <= quetionsCount; i++) {
			
		new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(test.question1_part_Text));
		
		Boolean verify = test.question1_part_Text.isDisplayed();
		System.out.println(i+" print");
		
		soft.assertTrue(verify);
		System.out.println(i+" quetion checked");
		applyExplicitWait(10);
//		test.i_will_attempt_later.click();
		System.out.println(i+"element click");
		System.out.println("Clicked on attempt later button");
		applyExplicitWait(10);

		}
		soft.assertAll();

	}
	
	public void verify_MCQ_Quetions_in_default_state() throws InterruptedException, MalformedURLException{
		
		Object_Test_Unit test = new Object_Test_Unit();
		
		applyExplicitWaitsUntilElementVisible(test.Test_Unit);
		test.Test_Unit.click();
		
		scrollTo1("Upcoming");
		applyExplicitWaitsUntilElementVisible(test.Latitude);

		test.Latitude.click();
		Thread.sleep(5000);									
		test.begin_Practise.click();						

		
		Thread.sleep(15000);
		applyExplicitWaitsUntilElementVisible(test.quetionCount);

		int quetionsCount=verify_Question_Count_In_Test_Module();
		Thread.sleep(10000);
		
		for(int i=0;i<quetionsCount;i++) {
		
			if(test.first_answer_multi.isDisplayed()) {
				
				
				if(test.first_answer_multi.isSelected() && test.second_answer_multi.isSelected() && test.third_answer_multi.isSelected() && test.fourth_answer_multi.isSelected()) {
					System.out.println("Quetions are selected bydefault");
				}
				else {
					System.out.println("Quetions are in Unanswered mode");
				}
				
				test.first_answer_multi.click();
				test.second_answer_multi.click();
				test.third_answer_multi.click();
				test.fourth_answer_multi.click();
				
				test.attempt_later.click();
				
				System.out.println("Quetions are in MultiSelect form");
			}
			else {
				test.attempt_later.click();
			}
		
		}
		
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

}

