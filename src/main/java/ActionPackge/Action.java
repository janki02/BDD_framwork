package ActionPackge;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import ActionInterface.ActionInterface;
import Com.myStore.Base.BaseClass;

public class Action extends BaseClass implements ActionInterface {

	public static WebDriver driver;
	public static WebElement ele;

	public static void ScrollbyVisiablityElement(WebDriver driver, WebElement ele) {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("argumet[0].ScrollToView();", ele);

	}

	public  void Click(WebDriver driver, WebElement ele) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).click().build().perform();
	}

	public boolean FindElement(WebDriver driver, WebElement ele) {
		boolean flag = false;

		try {
			ele.isDisplayed();
			flag = true;
		} catch (Exception e) {
			// System.out.println("Location not found: "+locatorName);

			flag = false;
		}

		finally {
			if (flag) {
				System.out.println("Element Succeufully found:");

			} else {
				System.out.println("Element Not found:");

			}
		}
		return flag;

	}

	public boolean isdisplay(WebDriver driver, WebElement ele) {
		boolean flag = false;
		flag = FindElement(driver, ele);
		if (flag) {
			flag = ele.isDisplayed();
			if (flag) {
				System.out.println("The element is Displayed ");
			} else {
				System.out.println("The element is not Displayed ");

			}
		} else {
			System.out.println(" element not Displayed ");
		}
		return flag;
	}

	public String getTitle() {
		boolean flag = false;

		String Title = driver.getTitle();

		if (flag) {
			System.out.println("Titile of the Page:" + Title);
			flag = true;
		}
		return Title;
	}

	public void implicitWait(WebDriver driver, WebElement ele) {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

	}

	public void explicitWait(WebDriver driver, WebElement ele, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfAllElements(ele));
	}

	public void fluentWait(WebDriver driver, WebElement ele, int timeout) {
	    WebDriverWait wait = new WebDriverWait(driver, timeout);
	    new FluentWait<>(driver)
	        .withTimeout(Duration.ofSeconds(30))
	        .pollingEvery(Duration.ofSeconds(5))
	        .until(ExpectedConditions.visibilityOf(ele));
	}

	public boolean Type (WebElement ele, String Text) {
		boolean flag = false;
		try {
			flag = ele.isDisplayed();
			ele.clear();
		    ele.sendKeys(Text);
		    flag =true;
		}
		catch(Exception e) {
			System.out.println("Loaction not found:");
			flag = false;
		}
		finally {
			if(flag) {
				System.out.println("The Value is entered Sucessfully");
			}
			else {
				System.out.println("The Value not entered Sucessfully");

			}
		}
		return flag;

		
	}
}
