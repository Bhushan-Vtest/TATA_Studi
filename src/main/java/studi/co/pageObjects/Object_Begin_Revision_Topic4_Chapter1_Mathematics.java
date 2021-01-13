package studi.co.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Object_Begin_Revision_Topic4_Chapter1_Mathematics extends Object_Syllabus_Option {

	public Object_Begin_Revision_Topic4_Chapter1_Mathematics() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}

	// Locator for Page (title:what you will revise)
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[1]")
	public WebElement Begin_Revision;

	// Locator for the page playing the video

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Hide player controls\"]/android.widget.FrameLayout[4]/android.view.View[2]")
	public WebElement videocentreTap;

	@AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Hide player controls\"]/android.widget.FrameLayout[3]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.TextView[2]")
	public WebElement video_endTime_duration;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.ImageView")
	public WebElement hamburger_icon_1_video;

	// From here below locator for Questions
	@AndroidFindBy(id = "com.tce.afs:id/tv_quiz_title")
	public WebElement whatdoyouthink_Text;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View")
	public WebElement question_1_text;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.TextView[2]")
	public WebElement continue_button;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View/android.view.View[3]")
	public WebElement answer_1_checkbox;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[3]/android.view.View/android.view.View[3]")
	public WebElement answer_2_checkbox;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[4]/android.view.View/android.view.View[3]")
	public WebElement answer_3_checkbox;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[5]/android.view.View/android.view.View[3]")
	public WebElement answer_4_checkbox;

	// locators for Alert/pop-up

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView")
	public WebElement popupText;

	@AndroidFindBy(id = "android:id/button1")
	public WebElement popUp_yes_Button;

	@AndroidFindBy(id = "android:id/button2")
	public WebElement popUp_no_Button;

	public WebElement getBegin_Revision() {
		System.out.println("Performing Operation on Begin_Revision");
		return Begin_Revision;
	}

	public void setBegin_Revision(WebElement begin_Revision) {

		Begin_Revision = begin_Revision;
	}

	public WebElement getVideocentreTap() {
		System.out.println("Performing Operation on videocentreTap");
		return videocentreTap;
	}

	public void setVideocentreTap(WebElement videocentreTap) {
		this.videocentreTap = videocentreTap;
	}

	public WebElement getVideo_endTime_duration() {
		System.out.println("Performing Operaration on video_endTime_duration");
		return video_endTime_duration;
	}

	public void setVideo_endTime_duration(WebElement video_endTime_duration) {
		this.video_endTime_duration = video_endTime_duration;
	}

	public WebElement getHamburger_icon_1_video() {
		System.out.println("Performing Operation on hamburger_icon_1_video");
		return hamburger_icon_1_video;
	}

	public void setHamburger_icon_1_video(WebElement hamburger_icon_1_video) {
		this.hamburger_icon_1_video = hamburger_icon_1_video;
	}

	public WebElement getWhatdoyouthink_Text() {
		System.out.println("Performing Operation on whatdoyouthink");
		return whatdoyouthink_Text;
	}

	public void setWhatdoyouthink_Text(WebElement whatdoyouthink_Text) {
		this.whatdoyouthink_Text = whatdoyouthink_Text;
	}

	public WebElement getQuestion_1_text() {
		System.out.println("Performing Operation on question_1_text");
		return question_1_text;
	}

	public void setQuestion_1_text(WebElement question_1_text) {
		this.question_1_text = question_1_text;
	}

	public WebElement getContinue_button() {
		System.out.println("Performing Operation on continue_button");
		return continue_button;
	}

	public void setContinue_button(WebElement continue_button) {
		this.continue_button = continue_button;
	}

	public WebElement getAnswer_1_checkbox() {
		System.out.println("Performing Operation on answer_1_checkbox");
		return answer_1_checkbox;
	}

	public void setAnswer_1_checkbox(WebElement answer_1_checkbox) {
		this.answer_1_checkbox = answer_1_checkbox;
	}

	public WebElement getAnswer_2_checkbox() {
		System.out.println("Performing Operation on answer_2_checkbox");
		return answer_2_checkbox;
	}

	public void setAnswer_2_checkbox(WebElement answer_2_checkbox) {
		this.answer_2_checkbox = answer_2_checkbox;
	}

	public WebElement getAnswer_3_checkbox() {
		System.out.println("Performing Operation on answer_3_checkbox");
		return answer_3_checkbox;
	}

	public void setAnswer_3_checkbox(WebElement answer_3_checkbox) {
		this.answer_3_checkbox = answer_3_checkbox;
	}

	public WebElement getAnswer_4_checkbox() {
		return answer_4_checkbox;
	}

	public void setAnswer_4_checkbox(WebElement answer_4_checkbox) {
		this.answer_4_checkbox = answer_4_checkbox;
	}

	public WebElement getPopupText() {
		System.out.println("Performing Operation on popText");
		return popupText;
	}

	public void setPopupText(WebElement popupText) {
		this.popupText = popupText;
	}

	public WebElement getPopUp_yes_Button() {
		System.out.println("Performing Operation on popUp_yes_Button");
		return popUp_yes_Button;
	}

	public void setPopUp_yes_Button(WebElement popUp_yes_Button) {
		this.popUp_yes_Button = popUp_yes_Button;
	}

	public WebElement getPopUp_no_Button() {
		System.out.println("Performing Operation on popUp_no_Button");
		return popUp_no_Button;
	}

	public void setPopUp_no_Button(WebElement popUp_no_Button) {
		this.popUp_no_Button = popUp_no_Button;
	}

}
