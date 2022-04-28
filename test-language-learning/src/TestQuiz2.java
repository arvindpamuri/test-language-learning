
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;

public class TestQuiz2 {
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
  public void testQuiz2() throws Exception {
    driver.get("http://ec2-54-208-51-74.compute-1.amazonaws.com:8080/language-learning/SingIn.html");
    driver.findElement(By.name("username")).click();
    Thread.sleep(1000);

    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("Brayan");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("Lemus");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(1000);

    //driver.get("http://ec2-54-208-51-74.compute-1.amazonaws.com:8080/language-learning/SearchUser");
    driver.findElement(By.linkText("Level 2")).click();
    Thread.sleep(1000);

    driver.get("http://ec2-54-208-51-74.compute-1.amazonaws.com:8080/language-learning/level_two_sp.jsp?userName=Brayan");
    driver.findElement(By.linkText("Quiz")).click();
    Thread.sleep(1000);

    driver.get("http://ec2-54-208-51-74.compute-1.amazonaws.com:8080/language-learning/levelQuiz_two_sp.jsp?userName=Brayan");
    driver.findElement(By.id("Uno")).click();
    driver.findElement(By.linkText("Next")).click();
    Thread.sleep(1000);

    driver.findElement(By.id("Ocho")).click();
    driver.findElement(By.linkText("Next")).click();
    Thread.sleep(1000);

    driver.findElement(By.id("Diez")).click();
    driver.findElement(By.linkText("Next")).click();
    Thread.sleep(1000);

    driver.findElement(By.id("Catorce")).click();
    driver.findElement(By.linkText("Next")).click();
    Thread.sleep(1000);

    driver.findElement(By.id("Veinte")).click();
    driver.findElement(By.linkText("Next")).click();
    Thread.sleep(1000);

    driver.findElement(By.id("Cero")).click();
    driver.findElement(By.linkText("Next")).click();
    Thread.sleep(1000);

    driver.findElement(By.id("Sesenta")).click();
    driver.findElement(By.linkText("Next")).click();
    Thread.sleep(1000);

    driver.findElement(By.id("Treinta y siete")).click();
    driver.findElement(By.linkText("Next")).click();
    Thread.sleep(1000);

    driver.findElement(By.id("Noventa y uno")).click();
    driver.findElement(By.linkText("Next")).click();
    Thread.sleep(1000);

    driver.findElement(By.id("Cien")).click();
    driver.findElement(By.linkText("Next")).click();
    Thread.sleep(1000);

    driver.findElement(By.name("submit")).click();
    Thread.sleep(1000);

    driver.get("http://ec2-54-208-51-74.compute-1.amazonaws.com:8080/language-learning/GradeQuiz");
    Thread.sleep(1000);

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
