package studi.co.testScripts;

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
    public void	T01_To_verify_BeginPractise_Link() throws IOException, InterruptedException{
		Module_Verify_Syllabus_Section test =new Module_Verify_Syllabus_Section();
		test.verify_Begin_Practise_Link();
		
	}
	
	@Test(enabled= false)
    public void	T02_To_verify_BeginPractise_Button() throws IOException, InterruptedException{
		Module_Verify_Syllabus_Section test =new Module_Verify_Syllabus_Section();
		test.verify_beginPractise_Button();
		
	}

	@Test(enabled=true)
    public void	T03_To_verify_Practise_Quetions() throws IOException, InterruptedException{
		Module_Verify_Syllabus_Section test =new Module_Verify_Syllabus_Section();
		test.verify_Practise_Quetions();
		
	}
	
	@Test(enabled=true)
    public void	T04_To_verify_User_Can_Attempt_Practise_Quetions() throws IOException, InterruptedException{
		Module_Verify_Syllabus_Section test =new Module_Verify_Syllabus_Section();
		test.verify_User_Can_attempt_PractiseQuetions();
		
	}
	
	
}
