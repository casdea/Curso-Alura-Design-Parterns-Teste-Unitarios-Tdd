package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	private LoginPage paginaDeLogin;

	@BeforeAll
	public static void beforeAll() {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
	}

	@BeforeEach
	public void beforeEach() {
		this.paginaDeLogin = new LoginPage();
	}

	@AfterEach
	public void afterEach() {
		this.paginaDeLogin.fechar();
	}

	//@Test
	public void deveriaEfetuarLoginComDadosValidos() {
		paginaDeLogin.preencheFormularioDeLogin("fulano", "pass");
		paginaDeLogin.efetuaLogin();

		Assert.assertFalse(paginaDeLogin.isPaginaDeLogin());
		Assert.assertEquals("fulano", paginaDeLogin.getNomeUsuarioLogado());
	}

	@Test
	public void naoDeveriaLogarComDadosInvalidos() {
	    paginaDeLogin.preencheFormularioDeLogin("invalido", "123");
	    paginaDeLogin.efetuaLogin();

	    Assert.assertTrue(paginaDeLogin.isPaginaDeLoginComDadosInvalidos());
	    Assert.assertTrue(paginaDeLogin.contemTexto("Usuário e senha inválidos."));
	                                                  
	    Assert.assertNull(paginaDeLogin.getNomeUsuarioLogado());
	}
	
	//@Test
	public void naoDeveriaAcessarPaginaRestritaSemEstarLogado() {
		paginaDeLogin.navegaParaPaginaDeLances();
		Assert.assertTrue(paginaDeLogin.isPaginaDeLogin());
		Assert.assertFalse(paginaDeLogin.contemTexto("Dados do Leilão"));
	}
}
