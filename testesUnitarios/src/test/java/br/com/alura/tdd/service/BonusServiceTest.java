package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {

		BonusService bonusService = new BonusService();
		
		//1a forma de fazer
		//assertThrows(
		//		IllegalArgumentException.class,
		//		() -> bonusService.calcularBonus(new Funcionario("JOSE", LocalDate.now(), 
		//		new BigDecimal("100000"))));

		//2a forma de fazer
		try {
			bonusService.calcularBonus(new Funcionario("JOSE", LocalDate.now(),	new BigDecimal("100000")));
			fail("Nao deu exception");
		} catch (Exception e) {
			assertEquals("Funcionario com salario maior que R$ 10.000,00 não pode receber bonus !", e.getMessage());
		}
		
		
	}

	
	@Test
	void bonusDeveriaSerZero10PorCentoDoSalario() {

		BonusService bonusService = new BonusService();
		BigDecimal bonus = bonusService
				.calcularBonus(new Funcionario("JOSE", LocalDate.now(), new BigDecimal("2500")));

		assertEquals(new BigDecimal("250.00"), bonus);

	}

}
