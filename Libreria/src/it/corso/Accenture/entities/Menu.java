package it.corso.Accenture.entities;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Menu {

	private int selezione;

	public Menu() {
		super();
		this.selezione = -1;
	}

	public int getSelezione() {
		return selezione;
	}

	public void setSelezione(int selezione) {
		this.selezione = selezione;
	}

	

	public void mostra() throws IOException, ClassNotFoundException {
		
		Libreria l= new Libreria();

		Scanner input = new Scanner(System.in);

		while (this.selezione != 0) {

			System.out.println("\n------SELEZIONA L'AZIONE DA SVOLGERE------\n");
			System.out.println("1 - Inserisci un libro nella libreria");
			System.out.println("2 - Calcola la differenza delle date di uscita di due libri");
			System.out.println("3 - Elimina un libro dalla libreria");
			System.out.println("4 - Ricerca libro per anno di uscita");
			System.out.println("5 - Salva libri su file e recuperali");
			System.out.println("0 - Esci dal programma");
			System.out.println("\n------------------------------------------\n");

			setSelezione(input.nextInt());

			switch (this.selezione) {
			case 1: {
				System.out.println("\n" +"|"+ "\n" +"|"+ "\n" +"V"+ "\n");
				
				try {
					l.InserisciLibro();
				} catch (ParseException e) {
					System.out.println("ERRORE - Data invalida");
				}
				
				break;
			}

			case 2: {
				System.out.println("\n" +"|"+ "\n" +"|"+ "\n" +"V"+ "\n");
				
				Scanner i2= new Scanner(System.in);
				System.out.println("Scrivi il titolo del primo libro: ");
				String titolo1= i2.next();
				System.out.println("Scrivi il titolo del secondo libro: ");
				String titolo2= i2.next();
				
				System.out.println("La differenza delle date di uscita dei due libri è di " + l.DifferenzaDate(titolo1, titolo2) + " giorni");
				
				break;
			}
			case 3: {
				System.out.println("\n" +"|"+ "\n" +"|"+ "\n" +"V"+ "\n");
				
				Scanner i3= new Scanner(System.in);
				System.out.println("Scrivi il titolo del libro da eliminare: ");
				String titolo= i3.next();
				
				
				l.EliminaLibro(titolo);
				
				break;
			}

			case 4: {
				System.out.println("\n" +"|"+ "\n" +"|"+ "\n" +"V"+ "\n");
				
				Scanner i4= new Scanner(System.in);
				System.out.println("Scrivi l'anno del libro da ricercare: ");
				int anno= i4.nextInt();
				System.out.println(l.RicercaLibro(anno));

				break;
			}
			
			
           
            
            case 5:{
            	System.out.println("\n" +"|"+ "\n" +"|"+ "\n" +"V"+ "\n");
            	l.SalvaELeggiSuFile();
            	break;
            }
            
            
           

			default:
				break;
			}// switch

		} // while

	}

}
