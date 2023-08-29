package main;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import exception.DomainException;

public class Relogio {
	private LocalTime horaAtual; // Variável que armazena a hora atual do relógio

	public Relogio() {
		horaAtual = LocalTime.now(); // Inicialização do relógio com a hora atual do sistema
	}

	// Método para definir a hora do relógio
	public void colocarHorario(int horas, int minutos, int segundos) throws DomainException {
		if ((horas <= 23 && horas >= 0) && (minutos <= 59 && minutos >= 0) && (segundos <= 59 && segundos >= 0)) {
			horaAtual = LocalTime.of(horas, minutos, segundos);
		}
		else {
			throw new DomainException("Só pode valores positivos até 23H e até 60 minutos ou segundos senhor");
		}

	}

	// Método para reiniciar o relógio para meia-noite
	public LocalTime reiniciarParaMeiaNoite() {
		return horaAtual = LocalTime.MIDNIGHT;
	}

	public String iniciarCronometro() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite a hora de início (formato HH:mm:ss): ");
		String horaInicioStr = scanner.nextLine();
		System.out.println("Digite a hora de término (formato HH:mm:ss): ");
		String horaFimStr = scanner.nextLine();

		DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
		try {
			LocalTime horaInicio = LocalTime.parse(horaInicioStr, formatoHora);
			LocalTime horaFim = LocalTime.parse(horaFimStr, formatoHora);

			Duration duracao = Duration.between(horaInicio, horaFim);
			long segundosTotais = duracao.getSeconds();

			long horas = segundosTotais / 3600;
			long minutos = (segundosTotais % 3600) / 60;
			long segundos = segundosTotais % 60;

			return String.format("Tempo decorrido: %02d:%02d:%02d", horas, minutos, segundos);
		} catch (Exception e) {
			return "Formato de hora inválido. Use HH:mm:ss.";
		}
	}

	// Método para imprimir a hora atual no formato 24h
	public void imprimirHora() {
		DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
		System.out.println("Hora atual: " + horaAtual.format(formatoHora));
	}

	public String obterHora() {
		DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
		return horaAtual.format(formatoHora);
	}

	public LocalTime getHoraAtual() {
		return horaAtual;
	}

	public void setHoraAtual(LocalTime horaAtual) {
		this.horaAtual = horaAtual;
	}
}
