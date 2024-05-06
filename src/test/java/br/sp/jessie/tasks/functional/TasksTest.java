package br.sp.jessie.tasks.functional;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TasksTest {

	public WebDriver acessarAplicacao(){
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://192.168.15.3:8001/tasks");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;		
	}
	
	@Test
	public void deveSalvarTarefaComSucesso() {
		WebDriver driver = acessarAplicacao();
		try{
		
		//Clicar em Add Todo
		driver.findElement(By.id("addTodo")).click();

		//escrever descrição
		driver.findElement(By.id("task")).sendKeys("Teste via selenium");

		//escrever a data
		driver.findElement(By.id("dueDate")).sendKeys("10/05/2025");

		//clicar em salvar
		driver.findElement(By.id("saveButton")).click();

		//validar mensagem de sucesso
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Success!", message);
	} 	finally {
		//fechar o browser
		driver.quit();
		}
	}

	@Test
	public void naodeveSalvarTarefaSemDescricao() {
		WebDriver driver = acessarAplicacao();
		try{
		
		//Clicar em Add Todo
		driver.findElement(By.id("addTodo")).click();

		//escrever a data
		driver.findElement(By.id("dueDate")).sendKeys("10/05/2030");

		//clicar em salvar
		driver.findElement(By.id("saveButton")).click();
		
		//validar mensagem de sucesso
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Fill the task description", message);
	} 	finally {
		//fechar o browser
		driver.quit();
		}
	}

	@Test
	public void deveSalvarTarefaSemData() {
		WebDriver driver = acessarAplicacao();
		try{
		
		//Clicar em Add Todo
		driver.findElement(By.id("addTodo")).click();

		//escrever descrição
		driver.findElement(By.id("task")).sendKeys("Teste via selenium");

		//clicar em salvar
		driver.findElement(By.id("saveButton")).click();

		//validar mensagem de sucesso
		String message = driver.findElement(By.id("message")).getText();

		Assert.assertEquals("Fill the due date", message);
	} 	finally {
		//fechar o browser
		driver.quit();
		}
		
		}

	@Test
	public void deveSalvarTarefaComDataPassada() {
		WebDriver driver = acessarAplicacao();
		try{
		
		//Clicar em Add Todo
		driver.findElement(By.id("addTodo")).click();

		//escrever descrição
		driver.findElement(By.id("task")).sendKeys("Teste via selenium");

		//escrever a data
		driver.findElement(By.id("dueDate")).sendKeys("10/04/2024");

		//clicar em salvar
		driver.findElement(By.id("saveButton")).click();
		
		//validar mensagem de sucesso
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Due date must not be in past", message);
	} 	finally {
		//fechar o browser
		driver.quit();
		}	

	}
}


