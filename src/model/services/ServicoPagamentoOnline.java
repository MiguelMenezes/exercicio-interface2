package model.services;

public interface ServicoPagamentoOnline {

	double taxaDePagamento(Double valor);
	double taxaDeJuros (Double valor, Integer meses);
	
}
