package studi.co.pageModules;

import studi.co.Base.*;
import studi.co.pageObjects.*;

public class Module_Create_Study_Plan extends BaseClass {

	public static String browse_books_page_title, create_study_plan_page_title, created_study_page_title;

	public void Validate_create_study_plan() throws InterruptedException {

		Object_Create_Study_Plan CSP = new Object_Create_Study_Plan();
		CSP.create_study_plan_button.click();
		CSP.select_Geography.click();
		
		
		
		
		
		
		
//		browse_books_page_title = CSP.browse_books_page_title.getText();

//		if (browse_books_page_title.equals("Browse Books")) {
			
//			Thread.sleep(2000);
			
//		CSP.plus_button.click();
			
			
//			CSP.create_study_plan_option.click();

//			create_study_plan_page_title = CSP.create_study_plan_page_title.getText();

			if(create_study_plan_page_title.equals("Create Study Plan"))
			{
				CSP.select_Environmental_Science.click();
				CSP.select_Myself.click();
				CSP.Add_to_portion.click();
				CSP.Next_Step.click();
				CSP.select_flag.click();
				CSP.Next_Step2.click();
				Thread.sleep(2000);
				CSP.Next_Step2.click();
				CSP.Plan_Name.clear();
				CSP.Plan_Name.clear();
				CSP.Plan_Name.sendKeys("Test101");
				driver.navigate().back();
				CSP.Activate_Plan.click();
				CSP.Begin_Studying.click();
				created_study_page_title = CSP.created_study_page_title.getText();
				
				if(created_study_page_title.equals("Test101"))
				System.out.println("Case Study Plan Created successfully");
				else
					System.out.println("Case Study Plan Creation FAILED");
					
			}
			else
				System.out.println("Create Study Plan page NOT found");
			
//		} else
//			System.out.println("No Browse Books page found");

	}

}