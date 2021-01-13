package studi.co.testScripts;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Login;
import studi.co.pageModules.Module_Revision_Syllabus;
import studi.co.pageModules.Module_Verify_Syllabus_Section;

public class AFS_UserStory_2 extends BaseClass{
	
	
	public AFS_UserStory_2() {
		super();
	}
	
	@BeforeMethod
	public void Validate_Login() throws Exception {
		Module_Login login = new Module_Login();
		login.Login_to_app();
	}
	
	
	@Test(enabled=false)
    public void	T01_To_Verify_User_Navigate_To_Revision() throws IOException, InterruptedException{
		Module_Revision_Syllabus mrs=new Module_Revision_Syllabus();
		mrs.toVerify_user_navigate_to_revision();
	}
	
	@Test(enabled=true)
    public void	T02_To_Verify_User_Can_Launch_To_Revision() throws IOException, InterruptedException{
		Module_Revision_Syllabus mrs=new Module_Revision_Syllabus();
		mrs.toVerify_user_launch_to_revision();
	}
}
