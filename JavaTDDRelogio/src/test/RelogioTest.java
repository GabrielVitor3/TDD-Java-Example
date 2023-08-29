package test;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import exception.DomainException;
import main.Relogio;

class RelogioTest {
	Relogio relogio = new Relogio();
	Relogio rolex;
	DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");

	@Test
	void testReiniciarParaMeiaNoite() {

		LocalTime horarioReiniciado = relogio.reiniciarParaMeiaNoite();
		String original = relogio.obterHora();


		System.out.println("Horário reiniciado: " + formatoHora.format(horarioReiniciado));

		Assertions.assertEquals("00:00:00", original);
		System.out.println("Teste 1 pronto");
	}

	@Test
	void testDefinirHorario() throws DomainException {
		relogio.colocarHorario(10, 20, 30);
		String hora = relogio.obterHora();
		String horaTest = "10:20:30";

		Assertions.assertEquals(horaTest, hora);
		System.out.println("Teste 2 pronto");

	}

	@Test
	void testCornometro() {
		relogio.reiniciarParaMeiaNoite();
		String test = relogio.iniciarCronometro(); // testar com 05:10:15 e depois 10:20:30
		relogio.imprimirHora();
		Assertions.assertEquals("Tempo decorrido: 05:10:15", test);
		System.out.println("Teste 3 pronto");
	}

	@Test
	void testImprimirHHmmss() {
		relogio.imprimirHora();
		System.out.println("Teste 4 pronto");
	}

	@Test
	void testImprimirHora() {
		relogio.obterHora();
		relogio.imprimirHora();
		System.out.println("Teste 5 passou");
	}

	@Test
	public void testColocandoOsExtremosCima() {
		Assertions.assertThrows(DomainException.class, () -> {
			relogio.colocarHorario(24, 00, 00);
		});
		System.out.println("Teste 6 pronto");
	}

	@Test
	public void testColocandoOsExtremosBaixo() {
		Assertions.assertThrows(DomainException.class, () -> {
			relogio.colocarHorario(-01, 00, 00);
		});
		System.out.println("Teste 7 pronto");
	}

}
