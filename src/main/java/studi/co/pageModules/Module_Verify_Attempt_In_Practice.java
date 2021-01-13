package studi.co.pageModules;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import junit.framework.Assert;
import studi.co.Base.BaseClass;
import studi.co.Base.Keyword;
import studi.co.pageObjects.Object_Begin_Practice_Topic4_Chapter1_Mathematics;
import studi.co.pageObjects.Object_Browse_Books;
import studi.co.pageObjects.Object_Syllabus_Option;

public class Module_Verify_Attempt_In_Practice extends BaseClass{
	
	
	public void verify_Attempt_In_Practice() throws InterruptedException, IOException {
//		Module_Login ml=new Module_Login(); 
//		ml.Login_to_app();
		Object_Browse_Books obb=new Object_Browse_Books();
		Object_Syllabus_Option osm=new Object_Syllabus_Option();
		Object_Begin_Practice_Topic4_Chapter1_Mathematics obpt = new Object_Begin_Practice_Topic4_Chapter1_Mathematics(); 
		
		Keyword.clickOnElement(obb.getSyllabus());
		Keyword.applyExplicitWait(3);
		
//		Keyword.clickOnElement(osm.getSubject_Mathematics());
		
		Keyword.applyExplicitWait(6);
		Keyword.clickOnElement(osm.getTopic_4_chapter_1());
		Keyword.applyExplicitWait(4);
		
		Keyword.clickOnElement(osm.getBegin_Practice_topic_4_chapter_1());
		Keyword.applyExplicitWait(5);
		
		Keyword.clickOnElement(obpt.getBeginPractice()); 
		Keyword.applyExplicitWait(6);
		
		String question=Keyword.getTextOfElement(obpt.getQuestion1_part2_Text());
		
		System.out.println("Questions asked is : "+question);
		
		Keyword.clickOnElement(obpt.getFirst_answer());
		Keyword.applyExplicitWait(2);
		
		Keyword.clickOnElement(obpt.getCheck_answer());
		Keyword.applyExplicitWait(2);
		
		Keyword.clickOnElement(obpt.getTryAgain());
		Keyword.applyExplicitWait(2);
		
		String s=Keyword.getTextOfElement(obpt.getAttemptLeft());
		System.out.println(s);
		Boolean result=s.equals("You have one attempt left"); 
		Assert.assertTrue(result);
	}
}