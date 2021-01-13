package studi.co.pageModules.AFS_UserStory_76;

import java.io.IOException;

import org.testng.asserts.SoftAssert;

import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Begin_Practice_Topic4_Chapter1_Mathematics;
import studi.co.pageObjects.Object_Browse_Books;
import studi.co.pageObjects.Object_Syllabus_Option;

public class Module_Verify_Answer_Feedback_Is_Correct_In_Practice extends BaseClass {

	public Module_Verify_Answer_Feedback_Is_Correct_In_Practice() {
		super();
	}

	public void verify_Answer_Feedback() throws InterruptedException, IOException {
		Object_Browse_Books obb = new Object_Browse_Books();
		Object_Syllabus_Option osm = new Object_Syllabus_Option();
		Object_Begin_Practice_Topic4_Chapter1_Mathematics obpt = new Object_Begin_Practice_Topic4_Chapter1_Mathematics();

		clickOnElement(obb.getSyllabus());
		applyExplicitWait(3);
//		clickOnElement(osm.getSubject_Mathematics());
		applyExplicitWait(6);
		clickOnElement(osm.getTopic_4_chapter_1());
		applyExplicitWait(4);
		clickOnElement(osm.getBegin_Practice_topic_4_chapter_1());
		applyExplicitWait(20);
		clickOnElement(obpt.getBeginPractice());
		applyExplicitWait(20);
		int questions=obpt.getTotalQuestions();
		SoftAssert sAss=new SoftAssert();
		for(int i=0;i<questions;)
		{
		obpt.selectCorrectOption(i+1);
		clickOnElement(obpt.check_answer);
		applyExplicitWait(2);
		sAss.assertTrue(obpt.answerCorrectMsg.isDisplayed());
		if(++i!=questions)
		clickOnElement(obpt.conti_nue);
		}
		sAss.assertAll();
	}
}
