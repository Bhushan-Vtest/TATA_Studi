package studi.co.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Object_Subject_Mathematics extends Object_Browse_Books {

	public Object_Subject_Mathematics() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}
	
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView")
	public WebElement mathematics;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView")
	public WebElement allChapters_Heading;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
	public WebElement highlight;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup")
	public WebElement topic_1_chapter_1;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.view.ViewGroup")
	public WebElement topic_2_chapter_1;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.view.ViewGroup")
	public WebElement topic_3_chapter_1;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.view.ViewGroup")
	public WebElement topic_4_chapter_1;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
	public WebElement begin_Revision_topic_4_chapter_1;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]")
	public WebElement begin_Practice_topic_4_chapter_1;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='1. Knowing Our Numbers']")
	public WebElement chapter_1;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='2. Whole Numbers']")
	public WebElement chapter_2;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='3. Playing With Numbers']")
	public WebElement chapter_3;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='4. Basic Geometrical Ideas']")
	public WebElement chapter_4;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='5. Understanding Elementary Shapes']")
	public WebElement chapter_5;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='6. Integers']")
	public WebElement chapter_6;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='7. Fractions']")
	public WebElement chapter_7;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='8. Decimals']")
	public WebElement chapter_8;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='9. Data Handling']")
	public WebElement chapter_9;

	@AndroidFindBy(xpath = " //android.widget.TextView[@text='10. Mensuration']")
	public WebElement chapter_10;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='11. Algebra']")
	public WebElement chapter_11;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='12. Ratio and Proportion']")
	public WebElement chapter_12;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='13. Symmetry']")
	public WebElement chapter_13;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='14. Practical Geometry']")
	public WebElement chapter_14;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView[1]")
	public WebElement begin_Practise;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[1]")
	public WebElement comparing_Numbers;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView")
	public WebElement comparing_Numbers_1;
	
	@AndroidFindBy(id="com.tce.studi:id/tv_primary_action")
	public WebElement begin_Practise_1;
	
	public WebElement getAllChapters_Heading() {
		System.out.println("Performing Operation on allChaptersHeading");
		return allChapters_Heading;
	}

	public void setAllChapters_Heading(WebElement allChapters_Heading) {
		this.allChapters_Heading = allChapters_Heading;
	}

	public WebElement getHighlight() {
		System.out.println("Performing Operation on highlight");
		return highlight;
	}

	public void setHighlight(WebElement highlight) {
		this.highlight = highlight;
	}

	public WebElement getChapter_1() {
		System.out.println("Performing Operation on chapter1");
		return chapter_1;
	}

	public void setChapter_1(WebElement chapter_1) {
		this.chapter_1 = chapter_1;
	}

	public WebElement getTopic_1_chapter_1() {
		System.out.println("Performing Operation on topic_1_chapter_1");
		return topic_1_chapter_1;
	}

	public void setTopic_1_chapter_1(WebElement topic_1_chapter_1) {
		this.topic_1_chapter_1 = topic_1_chapter_1;
	}

	public WebElement getTopic_2_chapter_1() {
		System.out.println("Performing Operation on topic_2_chapter_1");
		return topic_2_chapter_1;
	}

	public void setTopic_2_chapter_1(WebElement topic_2_chapter_1) {
		this.topic_2_chapter_1 = topic_2_chapter_1;
	}

	public WebElement getTopic_3_chapter_1() {
		System.out.println("Performing Operation on topic_3_chapter_1");
		return topic_3_chapter_1;
	}

	public void setTopic_3_chapter_1(WebElement topic_3_chapter_1) {
		this.topic_3_chapter_1 = topic_3_chapter_1;
	}

	public WebElement getTopic_4_chapter_1() {

		System.out.println("Performing Operation on topic_4_chapter_1");
		return topic_4_chapter_1;
	}

	public void setTopic_4_chapter_1(WebElement topic_4_chapter_1) {
		this.topic_4_chapter_1 = topic_4_chapter_1;
	}

	public WebElement getBegin_Revision_topic_4_chapter_1() {
		System.out.println("Performing Operation on begin_Revision_topipc_4_chapter_1");
		return begin_Revision_topic_4_chapter_1;
	}

	public void setBegin_Revision_topic_4_chapter_1(WebElement begin_Revision_topic_4_chapter_1) {
		this.begin_Revision_topic_4_chapter_1 = begin_Revision_topic_4_chapter_1;
	}

	public WebElement getBegin_Practice_topic_4_chapter_1() {
		System.out.println("Performing Operation on begin_Practice_topic_4_chapter_1");
		return begin_Practice_topic_4_chapter_1;
	}

	public void setBegin_Practice_topic_4_chapter_1(WebElement begin_Practice_topic_4_chapter_1) {
		this.begin_Practice_topic_4_chapter_1 = begin_Practice_topic_4_chapter_1;
	}

	public WebElement getChapter_2() {
		System.out.println("Performing Operation on chapter_2");
		return chapter_2;
	}

	public void setChapter_2(WebElement chapter_2) {
		this.chapter_2 = chapter_2;
	}

	public WebElement getChapter_3() {
		System.out.println("Performing Operation on chapter_3");
		return chapter_3;
	}

	public void setChapter_3(WebElement chapter_3) {
		this.chapter_3 = chapter_3;
	}

	public WebElement getChapter_4() {

		System.out.println("Performing Operation on chapter_4");
		return chapter_4;
	}

	public void setChapter_4(WebElement chapter_4) {
		this.chapter_4 = chapter_4;
	}

	public WebElement getChapter_5() {
		System.out.println("Performing Operation on chapter_5");
		return chapter_5;
	}

	public void setChapter_5(WebElement chapter_5) {
		this.chapter_5 = chapter_5;
	}

	public WebElement getChapter_6() {
		System.out.println("Performing Operation on chapter_6");
		return chapter_6;
	}

	public void setChapter_6(WebElement chapter_6) {
		this.chapter_6 = chapter_6;
	}

	public WebElement getChapter_7() {
		System.out.println("Performing Operation on chapter_7");
		return chapter_7;
	}

	public void setChapter_7(WebElement chapter_7) {
		this.chapter_7 = chapter_7;
	}

	public WebElement getChapter_8() {
		System.out.println("Performing Operation on chapter_8");
		return chapter_8;
	}

	public void setChapter_8(WebElement chapter_8) {
		this.chapter_8 = chapter_8;
	}

	public WebElement getChapter_9() {
		System.out.println("Performing Operation on chapter_9");
		return chapter_9;
	}

	public void setChapter_9(WebElement chapter_9) {
		this.chapter_9 = chapter_9;
	}

	public WebElement getChapter_10() {
		System.out.println("Performing Operation chapter_10");
		return chapter_10;
	}

	public void setChapter_10(WebElement chapter_10) {
		this.chapter_10 = chapter_10;
	}

	public WebElement getChapter_11() {
		System.out.println("Performing operation on chapter_11");
		return chapter_11;
	}

	public void setChapter_11(WebElement chapter_11) {
		this.chapter_11 = chapter_11;
	}

	public WebElement getChapter_12() {
		System.out.println("Performing Operation on chpater_12");
		return chapter_12;
	}

	public void setChapter_12(WebElement chapter_12) {
		this.chapter_12 = chapter_12;
	}

	public WebElement getChapter_13() {
		System.out.println("Performing Operation on chapter_13");
		return chapter_13;
	}

	public void setChapter_13(WebElement chapter_13) {

		this.chapter_13 = chapter_13;
	}

	public WebElement getChapter_14() {
		System.out.println("Performing Operation on chapter 14");
		return chapter_14;
	}

	public void setChapter_14(WebElement chapter_14) {
		this.chapter_14 = chapter_14;
	}

}
