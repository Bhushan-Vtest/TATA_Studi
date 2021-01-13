package studi.co.pageModules;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_ReviewPlan;
import studi.co.pageObjects.Object_Syllabus_Option;

public class Module_ReviewPlan extends BaseClass{
	
	Object_Syllabus_Option osm;
	Object_ReviewPlan orp;


	public void toVerify_User_Navigate_to_ReviewPlan() throws MalformedURLException {
		osm = new Object_Syllabus_Option();
		orp=new Object_ReviewPlan();
		SoftAssert assert1=new SoftAssert();
		
		Boolean landingPage=orp.userName.isDisplayed();
		if(landingPage) {
			System.out.println("User can be navigated to the landing page after login");
		}
		else {
			System.out.println("User can not be navigated to the landing page after login");
		}
		assert1.assertTrue(landingPage);
		
		osm.test_unit.click();
		
		Boolean myLessonPage=orp.planTestUnit.isDisplayed();
		if(myLessonPage) {
			System.out.println("User able to navigate to MyLessons Page");
		}
		else {
			System.out.println("User unable to navigate to MyLessons Page");
		}
		assert1.assertTrue(myLessonPage);
		
		scrollTo2("Review Plan");
		applyExplicitWait(5);
		
		Boolean reviewPlanTab=orp.reviewPlan.isDisplayed();
		if(reviewPlanTab) {
			System.out.println("At the bottom review planbutton is displayed");
		}
		else {
			System.out.println("At the bottom review planbutton is not displayed");
		}
		assert1.assertTrue(reviewPlanTab);
		
		assert1.assertAll();
	}


	public void toVerify_ReviewPlan_Tab() throws MalformedURLException, InterruptedException {
		
		toVerify_User_Navigate_to_ReviewPlan();
		
		orp.reviewPlan.click();
		applyExplicitWait(10);
		Thread.sleep(5000);
		Boolean testUnitHeading=orp.testPlanHeading.isDisplayed();
		if(testUnitHeading) {
			System.out.println("User can click on Review Plan button and Test Plan Heading is displayed");
		}
		Assert.assertTrue(testUnitHeading);
		
	}


	public void toVerify_Contents_on_ReviewPlan_Page() throws MalformedURLException, InterruptedException {
		toVerify_ReviewPlan_Tab();
		SoftAssert assert1=new SoftAssert();
		applyExplicitWait(10);
		Boolean graphicalRepresentation=orp.graphicalRepresentation.isDisplayed();
		if(graphicalRepresentation) {
			System.out.println("Graphical Representation is displayed to user");
		}
		assert1.assertTrue(graphicalRepresentation);
		
		Boolean portionProgress=orp.portionProgressBar.isDisplayed();
		if(portionProgress) {
			System.out.println("Portion Progress Bar is displayed to user");
		}
		assert1.assertTrue(portionProgress);
		
		applyExplicitWait(5);
		orp.editButton.click();
		
		Boolean modifyPortion=orp.modifyPortion.isDisplayed();
		if(modifyPortion) {
			System.out.println("Modify Portion Tab is displayed to user");
		}
		assert1.assertTrue(modifyPortion);
		
		Boolean pauseButton=orp.pause.isDisplayed();
		if(pauseButton) {
			System.out.println("Pause Button is displayed to user at bottom");
		}
		assert1.assertTrue(pauseButton);
		
		assert1.assertAll();
	}


	public void toVerify_Contents_of_graph() throws MalformedURLException, InterruptedException {
		toVerify_ReviewPlan_Tab();
		SoftAssert assert1=new SoftAssert();
		applyExplicitWait(10);
		Boolean graphicalRepresentation=orp.graphicalRepresentation.isDisplayed();
		if(graphicalRepresentation) {
			System.out.println("Graphical Representation is displayed to user");
		}
		assert1.assertTrue(graphicalRepresentation);
		
	
		applyExplicitWait(10);
		Boolean informationText=orp.youAlmostThere.isDisplayed();
		if(informationText) {
			System.out.println(orp.youAlmostThere.getText()+" this information text is displayed to keep user in sync with the progress in active plan");
		}
		assert1.assertTrue(informationText);
		
		Boolean plannedTask=orp.plannedTask.isDisplayed();
		if(plannedTask) {
			System.out.println("User able to see the status of the active plan in Planned Task");
		}
		assert1.assertTrue(plannedTask);
		
		Boolean currentTask=orp.currentTask.isDisplayed();
		if(currentTask) {
			System.out.println("User able to see the status of the active plan in Current Task");
		}
		assert1.assertTrue(currentTask);
		
		Boolean requiredTask=orp.requiredTask.isDisplayed();
		if(requiredTask) {
			System.out.println("User able to see the status of the active plan in Required Task");
		}
		assert1.assertTrue(requiredTask);
		
		Boolean filterOption=orp.filter.isDisplayed();
		if(filterOption) {
			System.out.println("Filter option displayed at the top of the Graph");
		} 
		assert1.assertTrue(filterOption);
		
		
		assert1.assertAll();
		
	}
}
