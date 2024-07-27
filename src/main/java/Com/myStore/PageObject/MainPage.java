package Com.myStore.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ActionPackge.Action;
import Com.myStore.Base.BaseClass;

public class MainPage extends BaseClass {

	private static WebDriver driver;

	Action action = new Action();
	BaseClass bs = new BaseClass();

	@FindBy(xpath = "//div[@class=\"header_user_info\"]")
	WebElement signin_Button;

	@FindBy(id = "header_logo")
	WebElement logo;

	public MainPage() {
		PageFactory.initElements(driver, this); // call the object of the class and call all the element
	}

	public String PageTitle() {
		return action.getTitle();
	}
	
	public boolean ValidteLogo()throws Throwable {
		return action.isdisplay(driver, logo);
	}
	
  public LoginPage SignInButton ()throws Throwable {
	  action.explicitWait(driver, signin_Button, 10);
	   action.Click(driver, signin_Button);
	   return new LoginPage();
	  
  }
}
