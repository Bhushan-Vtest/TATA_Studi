package studi.co.pageModules;

import java.net.MalformedURLException;
import java.util.List;

import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileElement;
import junit.framework.Assert;
import studi.co.Base.BaseClass;
import studi.co.Base.Keyword;
import studi.co.pageObjects.Object_Syllabus_Option;

public class Module_Revision_Syllabus extends BaseClass{
	Object_Syllabus_Option osm;
	
	public void toVerify_user_navigate_to_revision() throws MalformedURLException, InterruptedException {
		
		SoftAssert assert1=new SoftAssert();
		String subject="Mathematics";
		String topic1="Estimation of Numbers";
		
		osm = new Object_Syllabus_Option();
		Boolean testUnit=osm.test_unit.isDisplayed();
		if(testUnit) {
			System.out.println("Test Unit tab is available");
	//		test.log(Status.INFO, "Test Unit tab is available");
		}
		
		Boolean syllabus=osm.syllabus.isDisplayed();
		if(syllabus) {
			System.out.println("Syllabus tab is available");
	//		test.log(Status.INFO, "Syllabus tab is available");

		}
		applyExplicitWait(10);
		scrollTo2("Assignments");
		Boolean assignment=osm.assignments.isDisplayed();
		if(assignment) {
			System.out.println("Assignment tab is available");
	//		test.log(Status.INFO, "Assignment tab is available");

		}
		osm.syllabus.click();
		
		Boolean syllabusPage=osm.syllabusHeading.isDisplayed();
		if(syllabusPage) {
			System.out.println("Syllabus Page is displayed after clicking on syllabus tab");
		}
		
		List <MobileElement> subjectList=getDriver().findElementsById("com.tce.studi:id/tv_book_name");
		System.out.println("Total subjects available are :"+subjectList.size());
		for(MobileElement subjects : subjectList)	{
		applyExplicitWait(3);
		scrollTo2(subjects.getText());
		assert1.assertTrue(subjects.isDisplayed());
		System.out.println(subjects.getText());
//		test.log(Status.INFO, subjects.getText()+" subjects displayed");

		}
		
		Keyword.clickOnElementUsingText(subject);
		applyExplicitWait(50);
		Thread.sleep(25000);
		Keyword.clickOnElementUsingText(topic1);
		
		applyExplicitWait(10);
		Thread.sleep(5000);
		Boolean begin_Revision=osm.beginRevision.isDisplayed();
		assert1.assertTrue(begin_Revision);
		if(begin_Revision) {
			System.out.println("Begin revision tab is displayed");
	//		test.log(Status.INFO,"Begin Revision tab is available");
			
		}
		
		
		
		assert1.assertAll();
	}

	public void toVerify_user_launch_to_revision() throws MalformedURLException, InterruptedException {
		
		toVerify_user_navigate_to_revision();	
		osm.beginRevision.click();
		applyExplicitWait(10);
		osm.beginRevision1.click();
		applyExplicitWait(10);
		
		Boolean revisionOverViewPage=osm.overviewPage.isDisplayed();
		if(revisionOverViewPage) {
			System.out.println("User can navigate to Revision OverView Page");
//			test.log(Status.INFO,"User can navigate to Revision OverView Page");
		}
		
		Assert.assertTrue(revisionOverViewPage);
		
	}
	
}
