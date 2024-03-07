package model.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contrato {

	private Integer numero;
	private LocalDate data;
	private Double valorContrato;

	List<Parcela> parcelas = new ArrayList<>();

	public Contrato(Integer numero, LocalDate data, Double valorContrato) {
		this.numero = numero;
		this.data = data;
		this.valorContrato = valorContrato;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Double getValorContrato() {
		return valorContrato;
	}

	public void setValorContrato(Double valorContrato) {
		this.valorContrato = valorContrato;
	}

	public List<Parcela> getParcelas() {
		return parcelas;
	}

}
