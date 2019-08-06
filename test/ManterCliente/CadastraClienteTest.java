/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManterCliente;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author PcLorD
 */
public class CadastraClienteTest { 
    
    
    private static WebDriver driver;
    
    
    
    public CadastraClienteTest(){}
    
    @BeforeClass
    public static void setUpClass(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/PcLorD/Desktop/TCC atualizando/Biblioteca/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/LocacaoVersao2.0/index.jsp");        
    }
    
    @AfterClass
    public static void tearDownClass() {
        driver.quit();
    }
    
    @Test
    public void deveCadastrarUmCliente() {
        WebDriverWait wda = new WebDriverWait(driver,15);
        
        //busca cada campo de texto do form e preenche
        driver.findElement(By.name("usuario")).sendKeys("testeWoley");
        driver.findElement(By.name("senha")).sendKeys("123");
        
        //busca o botão cadastrar
        driver.findElement(By.id("fazerLogin")).click();
        
        wda.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Sua Conta")));
        
        //busca o botão Sua Conta e clica 
        driver.findElement(By.id("Sua Conta")).click();       
        
        
        //localiza os campos do Cliente
        WebElement nome = driver.findElement(By.name("nome"));
        WebElement rg = driver.findElement(By.name("rg"));
        WebElement cpf = driver.findElement(By.name("cpf"));
        WebElement telefone = driver.findElement(By.name("telefone"));
        WebElement celular = driver.findElement(By.name("celular"));
        
        //escreve nos campos de texto de Cliente
        nome.sendKeys("Nome Teste Woley");
        rg.sendKeys("5555555555");
        cpf.sendKeys("5555555555");
        telefone.sendKeys("5555555");
        celular.sendKeys("955555555");
        
        
        driver.findElement(By.id("CadastroCliente")).click(); 
        
        
        driver.findElement(By.name("logradouro")).sendKeys("Rua do Teste Woley");
        driver.findElement(By.name("numero")).sendKeys("123");
        driver.findElement(By.name("cep")).sendKeys("26266226");
        driver.findElement(By.name("bairro")).sendKeys("Bairro Teste Woley");
        driver.findElement(By.name("cidade")).sendKeys("Cidade Teste Woley");
        
        
        
        driver.findElement(By.id("CadastroEndereco")).click(); 
        
        
        
        // valida se a pagina de sucesso foi chamada
        assertEquals("Lobby", driver.getTitle());
        
        
        
    }
    
}
