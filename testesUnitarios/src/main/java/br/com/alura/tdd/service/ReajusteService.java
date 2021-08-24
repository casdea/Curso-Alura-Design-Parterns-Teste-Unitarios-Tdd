package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {

	public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
		// TODO Auto-generated method stub
		BigDecimal reajuste = funcionario.getSalario().multiply(desempenho.percentualReajuste()).setScale(2,
				RoundingMode.HALF_UP);
		funcionario.reajustarSalario(reajuste);

	}

}
