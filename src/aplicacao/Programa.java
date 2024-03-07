package aplicacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entidades.Contrato;
import model.entidades.Parcela;
import model.services.PaypalServico;
import model.services.ServicoContrato;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in).useLocale(Locale.US);

		System.out.println(" ________________________________");
		System.out.println("|ENTRE COM OS DADOS DO CONTRATO: |");
		System.out.println(" ________________________________");
		System.out.print("Número: ");
		int numero = sc.nextInt();

		System.out.print("Data (dd/mm/aaaa): ");
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data = LocalDate.parse(sc.next(), fmt);

		System.out.print("Valo do contrato: R$");
		double valorContrato = sc.nextDouble();

		Contrato contrato = new Contrato(numero, data, valorContrato);

		System.out.print("Entre com o número de parcelas: ");
		int numParcelas = sc.nextInt();
		
		ServicoContrato servicoContrato = new ServicoContrato(new PaypalServico());
		servicoContrato.processarContrato(contrato, numParcelas);
		
		System.out.println("");
		System.out.println("*****PARCELAS*****:");
		for(Parcela p: contrato.getParcelas()) {
			System.out.println(p);
		}
		
		sc.close();
	}

}
