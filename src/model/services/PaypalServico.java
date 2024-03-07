package model.services;

public class PaypalServico implements ServicoPagamentoOnline{

	@Override
	public double taxaDePagamento(Double valor) {
		return valor * 0.02;
	}

	@Override
	public double taxaDeJuros(Double valor, Integer meses) {
		return valor * 0.01 * meses;
	}

}
