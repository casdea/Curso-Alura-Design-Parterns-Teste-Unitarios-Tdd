package br.com.alura.leilao.acceptance.steps;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class PropondoLanceStepsV3 {

	private Leilao leilao;
	private List<Lance> lista;

	@Before
	public void setup() {
		lista = new ArrayList<Lance>();
		leilao = new Leilao("Tablet XPTO");
	}

	@Dado("um lance de {double} reais do usuario {string}")
	public void um_lance_de_reais_do_usuario_fulano(Double valor, String nomeUsuario) {
		Usuario usuario = new Usuario(nomeUsuario);
		lista.add(new Lance(usuario, new BigDecimal(valor)));
	}

	@Quando("propoe os lances com variaveis ao leilao")
	public void propoe_os_lances_ao_leilao() {
		lista.forEach(lance -> leilao.propoe(lance));
	}

	@Entao("os lances com variaveis sao aceitos")
	public void os_lances_sao_aceitos() {
		Assert.assertEquals(lista.size(), leilao.getLances().size());
		Assert.assertEquals(this.lista.get(0).getValor(), leilao.getLances().get(0).getValor());
		Assert.assertEquals(this.lista.get(1).getValor(), leilao.getLances().get(1).getValor());
	}
}
