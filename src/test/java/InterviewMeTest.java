import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InterviewMeTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/Anya/Documents/chromedriver-2");

        String url = "https://app.interviewme.pl/app/cv/697230f2-a6c7-11eb-ba92-beace83e7dbf/content/69739f6e-a6c7-11eb-a02f-beace83e7dbf";

        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        WebElement firstName = driver.findElement(By.name("firstName"));
        WebElement lastName = driver.findElement(By.name("lastName"));
        WebElement uploadPhoto = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[2]/div[1]/div/div/div[1]/div/div/div[2]/div[1]/div[1]/div/div"));
        WebElement savePhoto = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div[2]/div[2]/button"));


        firstName.click();
        firstName.sendKeys("Anna");
        lastName.click();
        lastName.sendKeys("Laptyuhova");
        uploadPhoto.click();
        uploadPhoto.sendKeys("/Users/Anya/Documents/photo1.png");
        savePhoto.click();

        if(driver.getPageSource().contains("Anna Laptyuhova")){
            System.out.println("Name entered successfully");
        } else {
            System.out.println("Please fill in your name in CV form");
        }

        WebElement uploadedPhoto = driver.findElement(By.className("_1segD"));
        if(uploadedPhoto.isDisplayed()){
            System.out.println("Photo uploaded successfully");
        } else {
            System.out.println("Photo failed to upload. Please try again");
        }
    }
}
