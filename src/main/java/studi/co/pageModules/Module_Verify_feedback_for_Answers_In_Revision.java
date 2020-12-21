package studi.co.pageModules;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;
import studi.co.Base.BaseClass;
import studi.co.Base.Keyword;
import studi.co.pageObjects.Object_Begin_Practice_Topic4_Chapter1_Mathematics;
import studi.co.pageObjects.Object_Begin_Revision_Topic4_Chapter1_Mathematics;

public class Module_Verify_feedback_for_Answers_In_Revision extends BaseClass {
	public Module_Verify_feedback_for_Answers_In_Revision() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void verify_Feedback_for_Answers_in_Revision() throws InterruptedException, IOException {
		
		
		
//		Module_Login login = new Module_Login();
//		login.Login_to_app();
		
		Object_Begin_Revision_Topic4_Chapter1_Mathematics obrtcm=new Object_Begin_Revision_Topic4_Chapter1_Mathematics();
		Keyword.clickOnElement(obrtcm.syllabus);
		Keyword.applyExplicitWait(3);
		
		Keyword.clickOnElement(obrtcm.subject_Mathematics);
		System.out.println("Subject:Mathematics is chosen");
		
		Keyword.applyExplicitWait(6);
		Keyword.clickOnElement(obrtcm.topic_4_chapter_1);
		Keyword.applyExplicitWait(3);
		//verification that questions are displayed 
		Object_Begin_Practice_Topic4_Chapter1_Mathematics obptcm=new Object_Begin_Practice_Topic4_Chapter1_Mathematics(); 
		
		String questionText=Keyword.getTextOfElement(obptcm.question1_part1_Text);
		String[] sarray=questionText.split(" ");
		int size=sarray.length;
		for (int i=0; i<size; i++) {
			if (sarray[i].equalsIgnoreCase("Write")) {
				System.out.println("Questions are displayed");
				Assert.assertEquals(true, sarray[i].equalsIgnoreCase("Write"));
				break;
			} else {
				System.out.println("Questions are not displayed");
			}
		}
	
	
		
	}
}
