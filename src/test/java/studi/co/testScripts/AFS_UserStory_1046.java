package studi.co.testScripts;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import studi.co.Base.BaseClass;
import studi.co.pageModules.Module_Login;
import studi.co.pageModules.Module_ReviewPlan;
import studi.co.pageModules.Module_Revision_Syllabus;

public class AFS_UserStory_1046 extends BaseClass{
	
	
	public AFS_UserStory_1046() {
		super();
	}
	
	@BeforeMethod
	public void Validate_Login() throws Exception {
		Module_Login login = new Module_Login();
		login.Login_to_app();
	}
	
	@Test(enabled=false)    
    public void	T01_To_Verify_User_Navigate_To_ReviewPlan() throws IOException, InterruptedException{
		Module_ReviewPlan mrs=new Module_ReviewPlan();
		mrs.toVerify_User_Navigate_to_ReviewPlan();
	}
	
	@Test(enabled=false)
    public void	T02_To_Verify_ReviewPlan_tab() throws IOException, InterruptedException{
		Module_ReviewPlan mrs=new Module_ReviewPlan();
		mrs.toVerify_ReviewPlan_Tab();
	}
	
	@Test(enabled=false)
    public void	T03_To_Verify_Contents_on_ReviewPlan_Page() throws IOException, InterruptedException{
		Module_ReviewPlan mrs=new Module_ReviewPlan();
		mrs.toVerify_Contents_on_ReviewPlan_Page();
	}
	
	@Test(enabled=true)
    public void	T04_To_Verify_Contents_of_Graph() throws IOException, InterruptedException{
		Module_ReviewPlan mrs=new Module_ReviewPlan();
		mrs.toVerify_Contents_of_graph();
	}

}
