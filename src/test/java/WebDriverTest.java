import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverTest {
    public static WebDriver webDriver;
    public static String baseURL = "https://www.monamie.am/";



    @BeforeClass
    public static void initWebDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

    }
    @Test
    public void clickTest(){
        webDriver.get("https://www.monamie.am/");
        webDriver.findElement(By.xpath("//*[@id=\"ember215\"]")).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.monamie.am/#/shop", "https://www.monamie.am/#/shop");
    }
    @Test
    public void changeLanguageTest() {
        webDriver.get("https://www.monamie.am/");
        webDriver.findElement(By.xpath("//*[@id=\"ember241\"]/div/div/div[1]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"ember241\"]/div/ul/li[2]")).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.monamie.am/", "https://www.monamie.am/");
        Assert.assertEquals(webDriver.findElement(By.xpath("//*[@id=\"ember215\"]"))
                .getText(), "Խանութ", "Խանութ");
    }

    @Test
    public void findElement(){
        webDriver.get("https://www.monamie.am/");
        webDriver.findElement(By.cssSelector("#ember226")).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.monamie.am/#/accessories", "https://www.monamie.am/#/accessories");

    }
    @Test
    public void didLogoTakeToHomePage() {
        webDriver.get("https://www.monamie.am/");
        webDriver.findElement(By.cssSelector("#ember226")).click();
        webDriver.findElement(By.cssSelector("#ember196 > header > div.row > div.col-lg-4.col-md-4.col-sm-4.col-xs-4.start-xs.left > div.logo-container > img")).click();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.monamie.am/#/", "https://www.monamie.am/#/");
    }



    }

