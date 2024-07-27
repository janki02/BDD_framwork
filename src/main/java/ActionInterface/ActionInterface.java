package ActionInterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ActionInterface {
	
	//Added all user actions abstract methods to achieve Abstraction  
	public static void ScrollbyVisiablityElement(WebDriver driver , WebElement ele) {
	}
	public static void Click(WebDriver driver , WebElement ele) {
	}
	public static void getTitle() {
	}
	public static void implicitWait(WebDriver driver, WebElement ele) {
	}
	public static void explicitWait(WebDriver driver, WebElement ele, int timeout) {
	}
	public static void fluentWait(WebDriver driver, WebElement ele, int timeout) {
	}
	public static void  Type (WebElement ele, String Text) {
	}
	
}
