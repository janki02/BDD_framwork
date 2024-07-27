package Stepdefination;

import org.junit.Assert;

import Com.myStore.Base.BaseClass;
import Com.myStore.PageObject.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class MainStep extends MainPage {

	static MainPage mainpage = new MainPage();
	//static BaseClass baseclass = new BaseClass();

	String Title;

	@Given("The user is on Main page")
	public static void The_user_is_on_Main_page() {
		try {
			mainpage.launchApplication();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("The user gets the title of the page")
	public void The_user_gets_the_title_of_the_page() {
		String Title = mainpage.PageTitle();
		System.out.println("Title of the page:" + Title);
	}
	@And("The page title should be is{string}")
	public void The_page_title_should_be_is(String ExpectedTitle) {
		Assert.assertTrue(Title.contains(ExpectedTitle));

	}
	
	@And("The user see the Logo Of the page")
	public void The_user_see_the_Logo_Of_the_page() throws Throwable {
		boolean Logo = mainpage.ValidteLogo();
		System.out.println("The logo is Displayed:" + Logo);

	}

	@And("The user click on sign in button")
	public void The_user_click_on_sign_in_button() throws Throwable {
		mainpage.SignInButton();

	}

	
}
