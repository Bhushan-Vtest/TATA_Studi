package studi.co.testScripts;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Login;
import studi.co.pageModules.Module_Verify_Syllabus_Section;

public class AFS_UserStory_65 extends BaseClass{
	
	public AFS_UserStory_65() {
		super();
	}
	
	@BeforeMethod
	public void Validate_Login() throws Exception {
		Module_Login login = new Module_Login();
		login.Login_to_app();
	}
	
	@Test(enabled=false)
    public void	T01_To_Verify_BeginPractise_Link() throws IOException, InterruptedException{
		Module_Verify_Syllabus_Section test =new Module_Verify_Syllabus_Section();
		test.verify_Begin_Practise_Link();
		
	}
	
	@Test(enabled= false)
    public void	T02_To_Verify_BeginPractise_Button() throws IOException, InterruptedException{
		Module_Verify_Syllabus_Section test =new Module_Verify_Syllabus_Section();
		test.verify_beginPractise_Button();
		
	}

	@Test(enabled=false)
    public void	T03_To_Verify_Practise_Quetions() throws IOException, InterruptedException{
		Module_Verify_Syllabus_Section test =new Module_Verify_Syllabus_Section();
		test.verify_Practise_Quetions();
		
	}
	
	@Test(enabled=false)
    public void	T04_To_Verify_User_Can_Attempt_Practise_Quetions() throws IOException, InterruptedException, AWTException{
		Module_Verify_Syllabus_Section test =new Module_Verify_Syllabus_Section();
		test.verify_User_Can_attempt_PractiseQuetions();
		
	}
	
	@Test(enabled=true)
    public void	T05_To_Verify_User_should_shown_proper_Response_for_correct_option() throws IOException, InterruptedException, AWTException{
		Module_Verify_Syllabus_Section test =new Module_Verify_Syllabus_Section();
		test.toVerify_ProperFeedBack_forCorrectOption();
		
	}
	
	@Test(enabled=false)
    public void	T06_To_Verify_User_should_shown_proper_Response_for_incorrect_option() throws IOException, InterruptedException, AWTException{
		Module_Verify_Syllabus_Section test =new Module_Verify_Syllabus_Section();
		test.toVerify_ProperFeedBack_forInCorrectOption();
		
	}
	
	@Test(enabled=false)
	 public void T07_To_Verify_Warning_Message_On_Clicking_Back_Button() throws IOException, InterruptedException, AWTException{
			Module_Verify_Syllabus_Section test =new Module_Verify_Syllabus_Section();
			test.toVerify_Warning_Message();
			
		}
	
	
	@Test(enabled=false)
	 public void T08_To_Verify_Confidence_Report_Page() throws IOException, InterruptedException, AWTException{
			Module_Verify_Syllabus_Section test =new Module_Verify_Syllabus_Section();
			test.toVerify_Confidence_Report_Page();
			
		}
	
	
	
}
