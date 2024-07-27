package Stepdefination;

import Com.myStore.PageObject.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginStep extends LoginPage {
	
	LoginPage login = new LoginPage();

	@Given("Enter the valid Email and Password" )
	public  void Enter_the_valid_Email_and_Password(String Username, String Password ) throws Throwable {
		login.login(Username, Password);
	}

	
	@When("The use click on Signin button")
	public void The_use_click_on_Signin_button() {
		login.Submit();
		
	}
	@Then("The user should able to Sigin Succesfully")
	public void The_user_should_able_to_Sigin_Succesfully() {
		
	}
	
	@Given("Enter the invalid {string} and {string}")
	public void Enter_the_invalid_and(String Username,String Password) {
	    // Your code here
		
	}
	
	@Then("The user should  get {string}")
	public void The_should_get(String ErrorMessage ) {
		
	}
}
