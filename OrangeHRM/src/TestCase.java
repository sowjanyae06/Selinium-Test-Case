

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver", "C://geckodriver.exe");
    driver = new FirefoxDriver();
    baseUrl = "https://www.youtube.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCase() throws Exception {
    driver.get(baseUrl + "/results?search_query=selenium+tutorial+for+beginner");
    driver.findElement(By.id("masthead-search-term")).clear();
    driver.findElement(By.id("masthead-search-term")).sendKeys("selenium tutorial for beginner");
    driver.findElement(By.cssSelector("div.yt-pl-thumb-overlay")).click();
    driver.findElement(By.xpath("//div[@id='movie_player']/div[14]/div/div/div[5]/button")).click();
    driver.findElement(By.xpath("//ol[@id='playlist-autoscroll-list']/li[2]/a/div/h4")).click();
    driver.findElement(By.xpath("//ol[@id='playlist-autoscroll-list']/li[2]/a/div/h4")).click();
    driver.findElement(By.xpath("//ol[@id='playlist-autoscroll-list']/li[3]/a/div/h4")).click();
    driver.findElement(By.xpath("//ol[@id='playlist-autoscroll-list']/li[3]/a/div/h4")).click();
    driver.findElement(By.xpath("//ol[@id='playlist-autoscroll-list']/li[5]/a")).click();
    driver.findElement(By.xpath("//ol[@id='playlist-autoscroll-list']/li[5]/a")).click();
    // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
