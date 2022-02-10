package Testler;

import com.sun.jdi.ThreadGroupReference;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.text.Element;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SeleniumExamples {

    private static WebDriver driver;


    @Test
    public void ChromeDriverBaslatma() throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "Settings/Driver/chromedriver"); //İndirdiğimiz chromedriver'ın yolunu belirtiyoruz
        driver = new ChromeDriver();//Chrome kullanacağımız için ChromeDriver() 'i kullanıyoruz ve driver'ı tanımlıyoruz
        driver.get("https://www.google.com/"); // get kullanarak sayfamızı açıyoruz


    }
    @Test
    public void ElementBulmaYollari() throws InterruptedException {

        driver = new ChromeDriver();//Chrome kullanacağımız için ChromeDriver() 'i kullanıyoruz ve driver'ı tanımlıyoruz
        driver.get("https://www.google.com/");
        //name --öncelikli kullanmamız gereken yöntemlerden ikincisi
        driver.findElement(By.name("inspect yaptıktan sonra ilgili alanın name'i varsa değerini alıp buraya yazıyoruz"))
                .sendKeys("Zeynep Turhan");
        //id -- ilk bakmamız ve kullanmamız gereken yöntem
        driver.findElement(By.xpath("Copy id dedikten sonra değeri bu alana yazıyoruz"));
        //cssselector -- üçüncü kullanmamız gereken yöntem
        driver.findElement(By.cssSelector("Bu alana selector'u kopyalayıp yapıştırıyoruz."));
        //xpath
        driver.findElement(By.xpath("Copy xpath dedikten sonra bu alana yolu yapıştırıyoruz"));

    }
    @Test
    public void SendKeysveClearKullanimi() throws InterruptedException {


        driver = new ChromeDriver();//Chrome kullanacağımız için ChromeDriver() 'i kullanıyoruz ve driver'ı tanımlıyoruz
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Zeynep Turhan"); //Name kullanarak elementimizi buluyoruz ve sendkeys ile o alana değer gönderiyoruz
        Thread.sleep(3000); //Clear işleminin Görülebilmesi için bekleme atadık
        driver.findElement(By.name("q")).clear(); // Clear kullanarak text alanını siliyoruz
    }
    @Test
    public void SayfayiKapatma() {

        driver = new ChromeDriver();//Chrome kullanacağımız için ChromeDriver() 'i kullanıyoruz ve driver'ı tanımlıyoruz
        driver.get("https://www.google.com/");
        driver.quit(); //quit ile sayfa kapanır
    }
    @Test
    public void SayfanınTitleiniGetirme() {

        driver = new ChromeDriver();//Chrome kullanacağımız için ChromeDriver() 'i kullanıyoruz ve driver'ı tanımlıyoruz
        driver.get("https://www.google.com/");
        String title = driver.getTitle(); //getTitle kullanarak sayfa başlığını kısa yoldan çekebiliriz.
    }
    @Test
    public void SiteYonlendirmeIslemi() {

        driver = new ChromeDriver();//Chrome kullanacağımız için ChromeDriver() 'i kullanıyoruz ve driver'ı tanımlıyoruz
        driver.get("https://www.google.com/");
        driver.navigate().to("https://mail.google.com/mail/u/0/"); //Google dan başka bir siteye yönlendirme işlemi yapılır
        driver.navigate().back(); // Bulunduğumuz siteden önceki siteye geri dönebilmek için back kullanıyoruz.
        driver.navigate().forward(); //Önceki siteden bir sonraki siteye gitmeyi sağlar
        driver.navigate().refresh(); //Sayfayı yeniler

    }
    @Test
    public void SayfayiMaximizedYapmaYontem1() {

        driver = new ChromeDriver();//Chrome kullanacağımız için ChromeDriver() 'i kullanıyoruz ve driver'ı tanımlıyoruz
        driver.get("https://www.google.com/");
        driver.manage().window().maximize(); //Bu kodu ekleyerek sayfayı max boyuta getirebiliriz.
    }
    @Test
    public void SayfayiMaximizedYapmaYontem2() {

        ChromeOptions options = new ChromeOptions(); //ChromeOptions ayarlamalarını bu şekilde düzenleyerek driver'a set ediyoruz.
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);//Chrome kullanacağımız için ChromeDriver() 'i kullanıyoruz ve driver'ı tanımlıyoruz
        driver.get("https://www.google.com/");

    }
    @Test
    public void GoogleOrnegi() {

        String gonderdigimdeger = "Zeynep Turhan";
        driver.findElement(By.name("q")).sendKeys(gonderdigimdeger); //Anasayfaya deger giriyoruz ve search ediyoruz
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER); //Bilgisayar tuşları kullanımı Keys.x şeklinde
        String gorulendeger = driver.findElement(By.name("q")).getAttribute("value"); //getAtrribute ile text durumunda olmayan etiketlerin değerlerini alabiliyoruz
        Assert.assertEquals(gonderdigimdeger,gorulendeger.toString()); //Text değerleri assertEquals ile karşılaştırılır.
    }
    @Test
    public void AssertTrueKullanimi() throws InterruptedException {

        boolean deger1 = true;
        boolean deger2 = false;
        Assert.assertTrue(deger1); //deger true döndüğü için passed olarak dönüş sağlanacak
        Assert.assertTrue(deger2); // deger false döndüğü için failed olarak dönecek
        //Assertlerden birini kapatıp deneyebilirsiniz

    }
    @Test
    public void AssertNullKullanimi() throws InterruptedException {

        String deger1 = null;
        Assert.assertNull(null); //deger null olduğu için true dönecek
    }
    @Test
    public void ClickElement() throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "Settings/Driver/chromedriver"); //İndirdiğimiz chromedriver'ın yolunu belirtiyoruz
        driver = new ChromeDriver();//Chrome kullanacağımız için ChromeDriver() 'i kullanıyoruz ve driver'ı tanımlıyoruz
        driver.get("https://yandex.com.tr");
        Thread.sleep(5000); //Bu bekleme yöntemi çok tercih edilmez.Çünkü girilen süre ne ise o kadar bekleme zorunluluğu vardır.Bu süre zarfında elementi yine bulamayabilir.
        driver.findElement(By.cssSelector("body > div.b-layout > div.b-line.b-line__main >" +
                " div > div.b-line.b-line__search > div > div.main__search-arrow > form > div.search2__button > button")).click(); //click() ile tıklama özelliğini kullanabiliriyoruz

    }
    @Test
    public void DoubleClick() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Settings/Driver/chromedriver"); //İndirdiğimiz chromedriver'ın yolunu belirtiyoruz
        driver = new ChromeDriver();//Chrome kullanacağımız için ChromeDriver() 'i kullanıyoruz ve driver'ı tanımlıyoruz
        driver.get("https://www.google.com/");
        Actions act = new Actions(driver); //Actions sınıfına ait bir methodumuz mevcut doubleClick() işlemini bu sınıf sayesinde kullanabiliyoruz
        driver.findElement(By.name("q")).sendKeys("Zeynep");
        //Thread.sleep(4000);
        WebElement element =  driver.findElement(By.name("q"));
        act.doubleClick(element).perform();

    }
    @Test
    public void GettextKulanimi() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Settings/Driver/chromedriver"); //İndirdiğimiz chromedriver'ın yolunu belirtiyoruz
        driver = new ChromeDriver();//Chrome kullanacağımız için ChromeDriver() 'i kullanıyoruz ve driver'ı tanımlıyoruz
        driver.get("https://tr.linkedin.com/");
       System.out.println(driver.findElement(By.cssSelector("#main-content > section.section.min-h-\\[560px\\].flex-nowrap.pt-\\[40px\\].babybear\\:flex-col.babybear\\:min-h-\\[0\\].babybear\\" +
                ":px-mobile-container-padding.babybear\\:pt-\\[24px\\] > div > h1")).getText()); //gettext() ile mevcut text değerini çekebiliyoruz
    }
    @Test
    public void LinkedinMailOrnegiKontrol() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Settings/Driver/chromedriver"); //İndirdiğimiz chromedriver'ın yolunu belirtiyoruz
        driver = new ChromeDriver();//Chrome kullanacağımız için ChromeDriver() 'i kullanıyoruz ve driver'ı tanımlıyoruz
        driver.get("https://tr.linkedin.com/");
        driver.findElement(By.name("email-or-phone")).sendKeys("zeynep.com");
        driver.findElement(By.id("password")).sendKeys("12345zeynep");
        driver.findElement(By.id("join-form-submit")).click();
        //-----------------------------------------  --> bu alanda gelen error mesajının doğruluğunu kontrol ediyoruz
        String error = driver.findElement(By.cssSelector("#main-content >" +
                " section.section.min-h-\\[560px\\].flex-nowrap.pt-\\[40px\\].babybear\\:flex-col.babybear\\" +
                ":min-h-\\[0\\].babybear\\" +
                ":px-mobile-container-padding.babybear\\:pt-\\[24px\\] > div > form > div > div > p")).getText();
        Assert.assertEquals(error,"Lütfen geçerli bir e-posta adresi veya cep  girin.");

        /* -->> Bu kod parçasında ise mail girildiğinde gerçekten bir error mesajı geliyor mu? Bunu kontrol ediyoruz.

               /*WebElement error = driver.findElement(By.cssSelector("#main-content >" +
                " section.section.min-h-\\[560px\\].flex-nowrap.pt-\\[40px\\].babybear\\:flex-col.babybear\\" +
                ":min-h-\\[0\\].babybear\\" +
                ":px-mobile-container-padding.babybear\\:pt-\\[24px\\] > div > form > div > div > p"));
                  Assert.assertNotNull(error);
         */
    }
    @Test
    public void ExplicitWait()
    {
        System.setProperty("webdriver.chrome.driver", "Settings/Driver/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://yandex.com.tr");
        //Thread.sleep(5000);
        WebDriverWait waitelement = new WebDriverWait(driver,300); //Girilen değerin tamamının dolmasını beklemez elementi bulduğu an gerekli işlemi gerçekleştirir.Sadece belirli ögelerde kullanılabilir
        waitelement.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.b-layout > div.b-line.b-line__main >" +
                " div > div.b-line.b-line__search > div > div.main__search-arrow > form > div.search2__button > button")));
    }
    @Test
    public void ImplicitWait()
    {
        System.setProperty("webdriver.chrome.driver", "Settings/Driver/chromedriver"); //İndirdiğimiz chromedriver'ın yolunu belirtiyoruz
        driver = new ChromeDriver();//Chrome kullanacağımız için ChromeDriver() 'i kullanıyoruz ve driver'ı tanımlıyoruz
        driver.get("https://www.google.com/");
        Actions act = new Actions(driver);
        driver.findElement(By.name("q")).sendKeys("Zeynep");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Thread Sleep aksine elementi bulduğu an gerekli işlemi gerçekleştirir.
        WebElement element =  driver.findElement(By.name("q"));
        act.doubleClick(element).perform();
    }
    //element list -  size

}
