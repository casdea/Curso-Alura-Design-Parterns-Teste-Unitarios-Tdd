package br.com.alura.leilao.acceptance.steps;

import java.math.BigDecimal;

import org.junit.Assert;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class PropondoLanceSteps {

	private Lance lance;
	private Leilao leilao;
	private Lance lance1;
	private Lance lance2;

	@Dado("um lance valido")
	public void um_lance_valido() {
		Usuario usuario = new Usuario("Fulano");
		lance = new Lance(usuario, BigDecimal.TEN);
		leilao = new Leilao("BMW I30");
	}

	@Quando("propoe o lance")
	public void propoe_o_lance() {
		leilao.propoe(lance);
	}

	@Entao("o lance eh aceito")
	public void o_lance_eh_aceito() {
		Assert.assertEquals(1, leilao.getLances().size());
		Assert.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
	}
	
	@Dado("varios lances validos")
	public void varios_lances_validos() {
		Usuario usuario1 = new Usuario("Fulano");
		lance1 = new Lance(usuario1, BigDecimal.TEN);

		Usuario usuario2 = new Usuario("Beltrano");
		lance2 = new Lance(usuario2, new BigDecimal("20.0"));
		
		leilao = new Leilao("BMW I30");
	}

	@Quando("propoe os lances ao leilao")
	public void propoe_os_lances_ao_leilao() {
		leilao.propoe(lance1);
		leilao.propoe(lance2);
	}
	@Entao("os lances sao aceitos")
	public void os_lances_sao_aceitos() {
		Assert.assertEquals(2, leilao.getLances().size());
		Assert.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
		Assert.assertEquals(new BigDecimal("20.0"), leilao.getLances().get(1).getValor());
	}

}
