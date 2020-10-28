package it.corso.Accenture.entities;

import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Libro implements Serializable {
	
	private String titolo;
	private String autore;
	private double prezzo;
	
	private GregorianCalendar dataUscita= new GregorianCalendar();

	public Libro(String titolo, String autore, double prezzo, String data) throws ParseException {
		super();
		this.titolo = titolo;
		this.autore = autore;
		this.prezzo = prezzo;
		
		SimpleDateFormat objFormato = new SimpleDateFormat("dd/MM/yyyy");
		Date dataClasseDate = objFormato.parse(data);
		
		this.dataUscita.setTime(dataClasseDate);
	}
	
	public Libro() {
		
		
		
	}
	

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public GregorianCalendar getDataUscita() {
		return dataUscita;
	}

	public void setDataUscita(GregorianCalendar dataUscita) {
		this.dataUscita = dataUscita;
	}
	
	
	
	public void writeObject(java.io.ObjectOutputStream stream)
            throws IOException {
        stream.writeObject(this.titolo);
        stream.writeObject(this.autore);
        stream.writeDouble(this.prezzo);
        stream.writeObject(this.dataUscita);
    }
	
	

    public void readObject(java.io.ObjectInputStream stream)
            throws IOException, ClassNotFoundException {
        titolo =  (String) stream.readObject();
        autore = (String) stream.readObject();
        prezzo = stream.readDouble();
        dataUscita = (GregorianCalendar) stream.readObject();
    }
    
    
    

	@Override
	public String toString() {
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	      String format = dateFormat.format(this.dataUscita.getTime());
		
		
		return "[titolo: " + titolo + ", autore: " + autore + ", prezzo: " + prezzo + "€"+ ", dataUscita: " + format + " ]";
	}
	
	
	
	

}
