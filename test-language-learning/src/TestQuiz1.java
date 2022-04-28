
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;

public class TestQuiz1 {
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
  public void testQuiz1() throws Exception {
    driver.get("http://ec2-54-208-51-74.compute-1.amazonaws.com:8080/language-learning/SingIn.html");
    driver.findElement(By.name("username")).click();
    Thread.sleep(1000);
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("B");
    driver.findElement(By.name("username")).click();
    Thread.sleep(1000);

    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("Brayan");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("Lemus");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(1000);

   // driver.get("http://ec2-54-208-51-74.compute-1.amazonaws.com:8080/language-learning/SearchUser");
    driver.findElement(By.linkText("Level 1")).click();
    Thread.sleep(1000);

    driver.get("http://ec2-54-208-51-74.compute-1.amazonaws.com:8080/language-learning/level_one_sp.jsp?userName=Brayan");
    driver.findElement(By.linkText("Quiz")).click();
    driver.get("http://ec2-54-208-51-74.compute-1.amazonaws.com:8080/language-learning/levelQuiz_one_sp.jsp?userName=Brayan");
    driver.findElement(By.xpath("//input[2]")).click();
    Thread.sleep(1000);

    driver.findElement(By.linkText("Next")).click();
    Thread.sleep(1000);

    driver.findElement(By.name("q2")).click();
    Thread.sleep(1000);

    driver.findElement(By.linkText("Next")).click();
    Thread.sleep(1000);

    driver.findElement(By.xpath("//div[3]/div[3]/input[3]")).click();
    Thread.sleep(1000);

    driver.findElement(By.linkText("Next")).click();
    Thread.sleep(1000);

    driver.findElement(By.name("q4")).click();
    Thread.sleep(1000);

    driver.findElement(By.linkText("Next")).click();
    driver.findElement(By.xpath("//div[5]/div[3]/input[4]")).click();
    Thread.sleep(1000);

    driver.findElement(By.linkText("Next")).click();
    driver.findElement(By.xpath("//div[6]/div[3]/input[3]")).click();
    Thread.sleep(1000);

    driver.findElement(By.linkText("Next")).click();
    Thread.sleep(1000);

    driver.findElement(By.xpath("//div[7]/div[3]/input[4]")).click();
    driver.findElement(By.linkText("Next")).click();
    Thread.sleep(1000);

    driver.findElement(By.name("q8")).click();
    driver.findElement(By.linkText("Next")).click();
    Thread.sleep(1000);

    driver.findElement(By.name("q9")).click();
    driver.findElement(By.linkText("Next")).click();
    Thread.sleep(1000);

    driver.findElement(By.xpath("//div[10]/div[3]/input[3]")).click();
    Thread.sleep(1000);

    driver.findElement(By.linkText("Next")).click();
    Thread.sleep(1000);

    driver.findElement(By.name("submit")).click();
    Thread.sleep(1000);

    driver.get("http://ec2-54-208-51-74.compute-1.amazonaws.com:8080/language-learning/GradeQuiz");
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
