package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LeiloesPage {

	private static final String URL_LEILOES = "http://localhost:8080/leiloes";
	private static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";
	private WebDriver browser;

	public LeiloesPage(WebDriver browser) {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe");
		this.browser = browser;
		browser.navigate().to(URL_LEILOES); 
	}

	public void fechar() {
		
		this.browser.quit();

	}
	
	public CadastroLeilaoPage carregarFormulario() {
        this.browser.navigate().to(URL_CADASTRO_LEILAO);
        return new CadastroLeilaoPage(browser);
}

	public boolean isLeilaoCadastrado(String nome, String valor, String data) {
	    WebElement linhaDaTabela = this.browser.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
	    WebElement colunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
	    WebElement colunaDataAbertura = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
	    WebElement colunaValorInicial = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));

	    return colunaNome.getText().equals(nome)
	            && colunaDataAbertura.getText().equals(data) 
	            && colunaValorInicial.getText().equals(valor);
	}

	public boolean isPaginaAtual() {
		// TODO Auto-generated method stub
		 return browser.getCurrentUrl().equals(URL_LEILOES);
	}
}
