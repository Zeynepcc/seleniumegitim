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
    public void SayfaninTitleiniGetirme() {

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
    //beklemelerden devam edilecek.

}
