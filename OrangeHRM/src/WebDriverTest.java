import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverTest {
	
	public static void main(String[] args){
		

		 System.setProperty("webdriver.gecko.driver", "C://geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.facebook.com");
		driver.findElement(By.xpath(".//*[@id='u_0_1']")).sendKeys("sowj");
		driver.findElement(By.xpath(".//*[@id='u_0_3']")).sendKeys("e");
		driver.findElement(By.xpath(".//*[@id='u_0_6']")).sendKeys("3333333");
		driver.findElement(By.xpath(".//*[@id='u_0_d']")).sendKeys("facebok");
		
		
		
		
		
	}

}
