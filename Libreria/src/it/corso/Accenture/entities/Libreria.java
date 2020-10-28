package it.corso.Accenture.entities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Libreria {

	ArrayList<Libro> libri = new ArrayList<Libro>();

	public void InserisciLibro() throws ParseException {

		Scanner input = new Scanner(System.in);
		System.out.println("Inserisci il titolo del libro: ");
		String titolo = input.next();
		System.out.println("Inserisci l'autore del libro: ");
		String autore = input.next();
		System.out.println("Inserisci il prezzo del libro: ");
		double prezzo = input.nextDouble();
		System.out.println("Inserisci la data d'uscita del libro (formato dd/MM/yyyy): ");
		String data = input.next();

		Libro nLibro = new Libro(titolo, autore, prezzo, data);
		libri.add(nLibro);
		

		
	}

	public void EliminaLibro(String titolo) {
		
		
		

		int index = -1;
		for (Libro libro : libri) {
        //si itera nella lista dei libri per trovare il libro che ha il titolo uguale a quello indicato
			if (libro.getTitolo().compareTo(titolo) == 0) {

				index = libri.indexOf(libro);  //memorizzo l'indice del libro trovato
			}

		}
		if (index != -1) { //se ho trovato il libro la variabile "index" passa dal valore di default "-1" all'indice del libro trovato

			libri.remove(index);
			System.out.println("Libro Eliminato.");

		} else
			System.out.println("Libro non eliminato!");

	}

	public String RicercaLibro(int anno) {
		String trovato = "";
		for (Libro libro : libri) {
        //confronto l'anno della data di uscita indicato con quello dei libri iterati nella lista
			if (libro.getDataUscita().get(Calendar.YEAR) == anno) {

				System.out.println("Libro trovato!");
				trovato = libro.toString();
			}

		}
		//se "trovato" rimane col suo valore di default vuol dire che non è stata trovata nessuna corrispondenza con l'anno indicato
		if(trovato == "") {
			System.out.println("Libro Non trovato!");
		} 

		return trovato;
	}

	public int DifferenzaDate(String titolo1, String titolo2) {

		Libro libro1 = new Libro();
		Libro libro2 = new Libro();
		int giorni = 0;
      //memorizzo in due oggetti i libri di cui voglio trovare la differenza fra date
		for (Libro libro : libri) {
			if (libro.getTitolo().compareTo(titolo1) == 0) {
				libro1 = libro;
			}
			if (libro.getTitolo().compareTo(titolo2) == 0) {

				libro2 = libro;

			}

		}
		
          //se trovo la corrispondenza dei due libri che ho indicato allora trasformo le date dei due libri in millisecondi e ne calcolo la differenza, dopodichè trasformo quest'ultima in giorni
		if (libro1 == null || libro2==null) {
			
			System.out.println("Libri non trovati!");
			
		} else if ( libro1!= null || libro2!=null) {

			long data1 = libro1.getDataUscita().getTimeInMillis();
			long data2 = libro2.getDataUscita().getTimeInMillis();

			giorni = (int) (data1 - data2 / (1000 * 60 * 60 * 24));

		}

		return giorni;

	}
	
	
	
	public void SalvaELeggiSuFile() throws IOException, ClassNotFoundException {
		
		
		//se il file "libreria.txt" non esiste lo creo
		File f= new File("libreria.txt");
		if(!f.exists()) {
			f.createNewFile();
			
		}
		
		
		FileOutputStream fis = new FileOutputStream(f);
		ObjectOutputStream out = new ObjectOutputStream(fis);
		//scrivo su "libreria.txt" ogni singolo libro preso dalla lista
		for (Libro libro : libri) {
			out.writeObject(libro);
			
		}
		
		
		FileInputStream fileInput = new FileInputStream(f);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInput);
      //creo un vettore dove immagazzino tutti i libri trovati nel file e lo visualizzo su schermo
		Libro[] elenco = new Libro[libri.size()];

		for (Libro l : elenco) {
			l = (Libro) objectInputStream.readObject();
			System.out.println(libri.indexOf(l) + 1 + " " + l.toString());
		}
		
		out.close();
		objectInputStream.close();
		
	}

}
