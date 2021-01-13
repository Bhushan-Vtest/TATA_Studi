package studi.co.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Object_Begin_Practice_Topic4_Chapter1_Mathematics extends Object_Syllabus_Option {
	public Object_Begin_Practice_Topic4_Chapter1_Mathematics() {
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);

	}

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[1]")
	public WebElement beginPractice;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.TextView[1]")
	public WebElement _1of5;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]")
	public WebElement question1_part1_Text;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]")
	public WebElement question1_part2_Text;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.TextView[2]")
	public WebElement check_answer;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.TextView[3]")
	public WebElement attempt_later;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]")
	public List<WebElement> all4Answers;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[2]/android.widget.CheckBox")
	public WebElement first_answer;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[3]/android.widget.CheckBox")
	public WebElement second_answer;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[4]/android.widget.CheckBox")
	public WebElement third_answer;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[5]/android.widget.CheckBox")
	public WebElement fourth_answer;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.TextView[2]")
	public WebElement tryAgain;

	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View/android.view.View")
	public WebElement attemptLeft;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[1]/android.view.View")
	public WebElement answerCorrectMsg;

	@AndroidFindBy(id = "com.tce.studi:id/tvPrimaryAction")
	public WebElement conti_nue;

	public WebElement getBeginPractice() {
		System.out.println("Performing operation on beginPractice");
		return beginPractice;
	}

	public void setBeginPractice(WebElement beginPractice) {
		this.beginPractice = beginPractice;
	}

	public WebElement get_1of5() {
		System.out.println("Performing operation on 1of5");
		return _1of5;
	}

	public void set_1of5(WebElement _1of5) {
		this._1of5 = _1of5;
	}

	public WebElement getQuestion1_part1_Text() {
		System.out.println("Performing Operation on question1_part1_Text");
		return question1_part1_Text;
	}

	public void setQuestion1_part1_Text(WebElement question1_part1_Text) {
		this.question1_part1_Text = question1_part1_Text;
	}

	public WebElement getQuestion1_part2_Text() {
		System.out.println("Performing Operation on question1_part2_text");
		return question1_part2_Text;
	}

	public void setQuestion1_part2_Text(WebElement question1_part2_Text) {
		this.question1_part2_Text = question1_part2_Text;
	}

	public WebElement getCheck_answer() {
		System.out.println("Performing Operation on check_answer");
		return check_answer;
	}

	public void setCheck_answer(WebElement check_answer) {
		this.check_answer = check_answer;
	}

	public WebElement getAttempt_later() {
		System.out.println("Performing Operation on attempt_later");
		return attempt_later;
	}

	public void setAttempt_later(WebElement attempt_later) {
		this.attempt_later = attempt_later;
	}

	public List<WebElement> getAll4Answers() {
		System.out.println("Performing operation on all4Answers");
		return all4Answers;
	}

	public void setAll4Answers(List<WebElement> all4Answers) {
		this.all4Answers = all4Answers;
	}

	public WebElement getFirst_answer() {
		System.out.println("Performing operation on first_answer");
		return first_answer;
	}

	public void setFirst_answer(WebElement first_answer) {
		this.first_answer = first_answer;
	}

	public WebElement getSecond_answer() {
		System.out.println("Performing operation on second_answer");
		return second_answer;
	}

	public void setSecond_answer(WebElement second_answer) {
		this.second_answer = second_answer;
	}

	public WebElement getThird_answer() {
		System.out.println("Performing operation on third_answer");
		return third_answer;
	}

	public void setThird_answer(WebElement third_answer) {
		this.third_answer = third_answer;
	}

	public WebElement getFourth_answer() {
		System.out.println("Performing Operation on fourth_answer");
		return fourth_answer;
	}

	public void setFourth_answer(WebElement fourth_answer) {
		this.fourth_answer = fourth_answer;
	}

	public WebElement getTryAgain() {
		System.out.println("Performing Operation on tryAgain");
		return tryAgain;
	}

	public void setTryAgain(WebElement tryAgain) {
		this.tryAgain = tryAgain;
	}

	public WebElement getAttemptLeft() {
		System.out.println("Performing operation on attemptLeft");
		return attemptLeft;
	}

	public void setAttemptLeft(WebElement attemptLeft) {
		this.attemptLeft = attemptLeft;
	}

	public void selectCorrectOption(int queNumber) {

		switch (queNumber) {
		case 1: clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '3 × (3 + 5)')]")));
		break;
		case 2: clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '(7 – 3) ÷ 4')]")));
		break;
		case 3: clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '40 ÷ [5 × (3 + 5)]')]")));
		break;
		case 4: clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '44')]")));
		break;
		case 5: clickOnElement(getDriver().findElement(By.xpath("//*[contains(@text, '4')]")));
		}

	}

	public int getTotalQuestions() {
		MobileElement ele=getDriver().findElement(By.xpath("//*[contains(@text, '1 of')]"));
		return Character.getNumericValue(ele.getText().charAt(ele.getText().length()-1));
	}

}
