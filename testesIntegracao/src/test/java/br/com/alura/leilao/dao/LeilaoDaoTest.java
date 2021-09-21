package br.com.alura.leilao.dao;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;

class LeilaoDaoTest {

	private LeilaoDao dao;

	private EntityManager em;

	@BeforeEach
	public void beforeEach() {
		this.em = JPAUtil.getEntityManager();
		this.dao = new LeilaoDao(em);
		em.getTransaction().begin();

	}

	@AfterEach
	public void afterEach() {
		em.getTransaction().rollback();
	}

	@Test
	void testeDeveriaCadastrarUmLeilao() {

		Usuario usuario = criarUsuario();
		Leilao leilao = new Leilao("Mochila", new BigDecimal("70"), LocalDate.now(), usuario);
		leilao = dao.salvar(leilao);
		
		Leilao encontrado = this.dao.buscarPorId(leilao.getId());
		Assert.assertNotNull(encontrado);
	}

	@Test
	void testeDeveriaAtualizarUmLeilao() {

		Usuario usuario = criarUsuario();
		Leilao leilao = new Leilao("Mochila", new BigDecimal("70"), LocalDate.now(), usuario);
		leilao = dao.salvar(leilao);
		
		leilao.setNome("Celular");
		leilao.setValorInicial(new BigDecimal("400"));
		leilao = dao.salvar(leilao);
		
		Leilao encontrado = this.dao.buscarPorId(leilao.getId());
		Assert.assertEquals("Celular", encontrado.getNome());
		Assert.assertEquals(new BigDecimal("400"), encontrado.getValorInicial());
	}

	Usuario criarUsuario() {
		Usuario usuario = new Usuario("fulano", "fulano@email.com", "12345678");
		em.persist(usuario);
		return usuario;
	}

}
