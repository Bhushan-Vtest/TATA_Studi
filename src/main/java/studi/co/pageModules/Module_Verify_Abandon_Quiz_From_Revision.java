package studi.co.pageModules;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import studi.co.Base.BaseClass;
import studi.co.pageObjects.Object_Begin_Revision_Topic4_Chapter1_Mathematics;
import studi.co.pageObjects.Object_Browse_Books;
import studi.co.pageObjects.Object_Landing_Page;
import studi.co.pageObjects.Object_Receive_MCQ_Questions_Practice;
import studi.co.pageObjects.Object_Receive_MCQ_Questions_Revision;
import studi.co.pageObjects.Object_Syllabus_Option;

public class Module_Verify_Abandon_Quiz_From_Revision extends Object_Begin_Revision_Topic4_Chapter1_Mathematics {

	public void verifyAbandonQuiz() throws InterruptedException {
		
		Object_Receive_MCQ_Questions_Practice RMQP = new Object_Receive_MCQ_Questions_Practice();
		Object_Receive_MCQ_Questions_Revision RMQP1 = new Object_Receive_MCQ_Questions_Revision();
		
		RMQP.select_syllabus.click();
		Thread.sleep(1000);
		RMQP.select_subject.click();
		Thread.sleep(1000);
		System.out.println("Subject - Geography - Geography Grade 6 is shown");
		RMQP1.select_topic_from_chapter.click();
		Thread.sleep(2000);
		System.out.println("Selected Topic");
		RMQP1.select_Begin_Revision.click();
		Thread.sleep(20000);
		RMQP1.click_Begin_Revision.click();
		Thread.sleep(3000);
		
		System.out.println("Video started");
		
		Thread.sleep(5000);
		
		RMQP1.img_OverviewPg_screen.click();
		String totalVedioTime=RMQP1.img_OverviewPg_screen_time.getText();
		System.out.println(totalVedioTime);
		int totalWaitingMins=Integer.parseInt(totalVedioTime.split(":")[0]);
		int totalWaitingSecs=Integer.parseInt(totalVedioTime.split(":")[1]);
		int minSecs=(totalWaitingMins)*60;
		int totalWait=(minSecs+totalWaitingSecs+5)*1000;
		System.out.println("Waiting for Video to complete. Waiting for '"+(totalWait)/1000+"' seconds");
		int wait=0; 
		try {
		while(wait<totalWait)
		{
			Thread.sleep(5000);
			RMQP1.img_OverviewPg_screen.click();
			wait=wait+5000;
		}
		}
		catch (Exception e) {}
		System.out.println("Waited till '"+(totalWait)/1000+"' seconds");
		
		Thread.sleep(10000);
		
		driver.navigate().back();
		Thread.sleep(1000);
		RMQP1.popUpYes.click();
		Thread.sleep(2000);
		System.out.println("Progress will be lost warning pop-up appeared");
		
		
		driver.navigate().back(); 
		Thread.sleep(2000);
		
		driver.navigate().back();
		Thread.sleep(2000);
		
		driver.navigate().back();
		Thread.sleep(2000);
		
		//System.out.println(((Object) driver).getSessionId()); 
		System.out.println("Navigated to Landing Page Successfully");
		
			}

}
