package main;

import exception.DomainException;

public class Program {

	public static void main(String[] args) throws DomainException {
		Relogio relogio = new Relogio();
		relogio.colocarHorario(24, 20, 30);
		relogio.imprimirHora();

	}

}
