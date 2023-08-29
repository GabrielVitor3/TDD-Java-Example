package main;

import java.util.Scanner;

import exception.DomainException;

public class Program {

	public static void main(String[] args) throws DomainException {
		 Relogio relogio = new Relogio();
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("Escolha uma opção:");
	            System.out.println("1 - Definir hora");
	            System.out.println("2 - Reiniciar para meia-noite");
	            System.out.println("3 - Iniciar cronômetro");
	            System.out.println("4 - Imprimir hora (formato 24h)");
	            System.out.println("0 - Sair");

	            int escolha = scanner.nextInt();
	            scanner.nextLine();

	            switch (escolha) {
	                case 1:
	                    System.out.print("Digite as horas: ");
	                    int horas = scanner.nextInt();
	                    System.out.print("Digite os minutos: ");
	                    int minutos = scanner.nextInt();
	                    System.out.print("Digite os segundos: ");
	                    int segundos = scanner.nextInt();
	                    relogio.colocarHorario(horas, minutos, segundos);
	                    relogio.imprimirHora();
	                    break;
	                case 2:
	                    relogio.reiniciarParaMeiaNoite();
	                    relogio.imprimirHora();
	                    break;
	                case 3:
	                    String tempo = relogio.iniciarCronometro();
	                    System.out.println(tempo);
	        
	                    break;
	                case 4:
	                    relogio.imprimirHora();
	                    break;
	                case 0:
	                    System.out.println("Encerrando o programa...");
	                    System.exit(0);
	                    break;
	                default:
	                    System.out.println("Pelo amor de Deus, avisei que era de 0 a 5...");
	           
	            scanner.close();
	            }
	        }

	}

}
