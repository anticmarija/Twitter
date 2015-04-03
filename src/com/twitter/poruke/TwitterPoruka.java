package com.twitter.poruke;

/**
 * Klasa predstavlja twitter poruku.
 * 
 * @author marijaantic
 *
 */

public class TwitterPoruka {

	/**
	 * Predstavlja ime korisnika.
	 */
	private String korisnik;
	
	/**
	 * sadrzaj twitter poruke
	 */
	private String poruka;
	
	/**
	 * metoda vraca ime korisnika
	 * @return korisnik kao String
	 */
	public String getKorisnik() {
		return korisnik;
	}
	
	/**
	 * metoda postavlja ime korisnika 
	 * @param korisnik, ulazni parametar kao String
	 * @throws java.lang.RuntimeException ako je uneto null ili prazan String
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik==null || korisnik.equals(""))
			throw new RuntimeException("Ime korisnika mora biti uneto");
			
		this.korisnik = korisnik;
	}
	
	/**
	 * metoda vraca sadrzaj poruke
	 * @return poruka kao String
	 */
	public String getPoruka() {
		return poruka;
	}
	
	/**
	 * metoda postavlja vrednost atributa poruka na osnovu unetog sadrzaja
	 * @param poruka ulazni paramtera kao String
	 * @throws java.lang.RuntimeException ako je uneti parametar null ili duzi od 140 karaktera
	 */
	public void setPoruka(String poruka) {
		if (poruka==null || poruka.length()>140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
	
		this.poruka = poruka;
	}
	
	
	public String toString(){
		return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
	}
}
