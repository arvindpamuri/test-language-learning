
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//import org.apache.commons.io.FileUtils;
import java.io.File;

public class TestTranslate {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "/Users/ravibuchupalli/eclipse-workspace/workspace-testing/test-webapp/lib/chromedriver");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testTranslate() throws Exception {
    driver.get("http://ec2-54-208-51-74.compute-1.amazonaws.com:8080/language-learning/SingIn.html");
    driver.findElement(By.name("username")).click();
    Thread.sleep(1500);
    
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("aravind");
    driver.findElement(By.name("password")).click();
    Thread.sleep(1500);
    
    
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("pamoori");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(1500);
    
    driver.findElement(By.id("translate")).click();
    driver.findElement(By.id("input-text")).click();
    driver.findElement(By.id("input-text")).clear();
    Thread.sleep(1500);
    
    driver.findElement(By.id("input-text")).sendKeys("good morning");
    driver.findElement(By.xpath("//button[@value='Submit']")).click();
//    driver.get("http://ec2-54-208-51-74.compute-1.amazonaws.com:8080/language-learning/translate?text=good+morning&lang=es&userName=aravind&userID=19");
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
