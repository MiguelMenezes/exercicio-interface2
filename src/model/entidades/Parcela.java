package model.entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Parcela {

	private LocalDate dataVencimento;
	private Double valorParcela;
	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Parcela(LocalDate dataVencimento, Double valorParcela) {
		this.dataVencimento = dataVencimento;
		this.valorParcela = valorParcela;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Double getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(Double valorParcela) {
		this.valorParcela = valorParcela;
	}

	@Override
	public String toString() {
		return dataVencimento.format(fmt) + " - " + String.format("%.2f", valorParcela);
	}

}
