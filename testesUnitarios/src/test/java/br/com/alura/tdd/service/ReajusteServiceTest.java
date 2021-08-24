package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {

	private ReajusteService service;
	private Funcionario funcionario;

	@BeforeEach
	public void inicializar() {
		service = new ReajusteService();
		funcionario = new Funcionario("JOAO", LocalDate.now(), new BigDecimal("1000"));
	}

	@Test
	public void reajusteDeveriaSer3PorcentoQuandoDesempenhoADesejar() {

		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);

		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}

	@Test
	public void reajusteDeveriaSer15PorcentoQuandoDesempenhoBom() {

		service.concederReajuste(funcionario, Desempenho.BOM);

		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}

	@Test
	public void reajusteDeveriaSer20PorcentoQuandoDesempenhoOtimo() {

		service.concederReajuste(funcionario, Desempenho.EXCELENTE);

		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}

}
