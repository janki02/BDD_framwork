package Com.myStore.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ActionPackge.Action;
import Com.myStore.Base.BaseClass;

public class LoginPage extends BaseClass {
	
	
	Action action = new Action();

	@FindBy (id ="email") 
	WebElement  EmailField;
	@FindBy (id="passwd")
	WebElement Password;
	@FindBy (id="SubmitLogin")
	WebElement SubmitButton;
	

	public LoginPage() {
		PageFactory.initElements(driver, this); // call the object of the class and call all the element
	}
	
	public void login(String Email, String Pass) throws Throwable {
		action.Type(EmailField, Email);
		action.Type(Password, Pass);
	}
	
	
	
	public HomePage  Submit() {
		action.Click(driver, SubmitButton);
		return new HomePage ();
	}
}