package testes;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Cadastro_de_livros {

        WebDriver driver = new ChromeDriver();


    @BeforeMethod
    public void Setup() throws InterruptedException {
        driver.get("https://ts-scel.herokuapp.com/");
        driver.findElement(By.name("username")).sendKeys("jose");
        driver.findElement(By.name("password")).sendKeys("123");
        driver.findElement(By.xpath("//button")).click();
        WebElement cps = driver.findElement(By.xpath("//h3"));
        assertEquals(cps.getText(),"Centro Paula Souza - Curso de Análise e Desenvolvimento de Sistemas");
        Thread.sleep(2000);

    }

    @AfterMethod
    public void TearDown() {
        driver.close();
    }



    @Test
    public void CT01_cadastrarlivroComSucesso() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Windows\\chromedriver.exe");

        driver.findElement(By.xpath("//a[contains(text(),'Livros')]")).click();
        driver.findElement(By.id("isbn")).sendKeys("4455");
        driver.findElement(By.id("autor")).sendKeys("ricardo satoshi");
        driver.findElement(By.id("titulo")).sendKeys("programaçao made in japan");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        WebElement lista_titulo = driver.findElement(By.xpath("//h5"));


        assertEquals(lista_titulo.getText(),"Lista de livros");

    }

    @Test
    public void CT02_cadastrarlivroComISBNjaCadstrado() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Windows\\chromedriver.exe");

        driver.findElement(By.xpath("//a[contains(text(),'Livros')]")).click();
        driver.findElement(By.id("isbn")).sendKeys("4455");
        driver.findElement(By.id("autor")).sendKeys("ricardo satoshi");
        driver.findElement(By.id("titulo")).sendKeys("programaçao made in japan");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        WebElement label_ja_cadastrado = driver.findElement(By.xpath("//h6[contains(text(),'Livro ja cadastrado')]"));


        assertEquals(label_ja_cadastrado.getText(),"Livro ja cadastrado");


    }

    @Test
    public void CT03_cadastrarlivroComISBNemBranco() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Windows\\chromedriver.exe");

        driver.findElement(By.xpath("//a[contains(text(),'Livros')]")).click();
        driver.findElement(By.id("isbn")).sendKeys("");
        driver.findElement(By.id("autor")).sendKeys("ricardo satoshi");
        driver.findElement(By.id("titulo")).sendKeys("programaçao made in japan");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        WebElement alert_ISBN = driver.findElement(By.xpath("//span[contains(text(),'ISBN deve ter 4 caracteres')]"));


        assertEquals(alert_ISBN.getText(),"ISBN deve ter 4 caracteres");



    }

    @Test
    public void CT04_cadastrarlivroComTituloEmBranco() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Windows\\chromedriver.exe");

        driver.findElement(By.xpath("//a[contains(text(),'Livros')]")).click();
        driver.findElement(By.id("isbn")).sendKeys("5555");
        driver.findElement(By.id("autor")).sendKeys("ricardo satoshi");
        driver.findElement(By.id("titulo")).sendKeys("");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        WebElement alert_Titulo = driver.findElement(By.xpath("//span[contains(text(),'Titulo deve ter entre 1 e 50 caracteres')]"));


        assertEquals(alert_Titulo.getText(),"Titulo deve ter entre 1 e 50 caracteres");


    }

    @Test
    public void CT05_cadastrarlivroComAutorEmBranco() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Windows\\chromedriver.exe");

        driver.findElement(By.xpath("//a[contains(text(),'Livros')]")).click();
        driver.findElement(By.id("isbn")).sendKeys("5555");
        driver.findElement(By.id("autor")).sendKeys("");
        driver.findElement(By.id("titulo")).sendKeys("programacao em java");
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        WebElement alert_Autor = driver.findElement(By.xpath("//span[contains(text(),'Autor deve ter entre 1 e 50 caracteres')]"));

        assertEquals(alert_Autor.getText(),"Autor deve ter entre 1 e 50 caracteres");



    }
}
