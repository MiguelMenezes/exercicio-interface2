package model.services;

import java.time.LocalDate;

import model.entidades.Contrato;
import model.entidades.Parcela;

public class ServicoContrato {

	private ServicoPagamentoOnline servicoDePagamentoOnline;

	public ServicoContrato(ServicoPagamentoOnline servicoDePagamentoOnline) {
		this.servicoDePagamentoOnline = servicoDePagamentoOnline;
	}

	public void processarContrato(Contrato contrato, Integer meses) {

		// Pega o valor fixo das parcelas, sem juros calculados:
		double parcelaSemJuros = contrato.getValorContrato() / meses;

		for (int i = 1; i <= meses; i++) {

			// Incrementa os meses:
			LocalDate dataParcela = contrato.getData().plusMonths(i);

			// calcula o valor do juros:
			double juros = servicoDePagamentoOnline.taxaDeJuros(parcelaSemJuros, i);

			// calcula a taxa:
			double taxa = servicoDePagamentoOnline.taxaDePagamento(parcelaSemJuros + juros);

			// parcela total calculada:
			double parcelaCalculada = parcelaSemJuros + juros + taxa;

			// adiciona a parcela calculada a lista de parcelas:
			contrato.getParcelas().add(new Parcela(dataParcela, parcelaCalculada));
		}
	}

}
