package com.twitter;

import java.util.LinkedList;

import com.twitter.poruke.TwitterPoruka;

/**
 * 
 * klasa predstavlja twitter
 * @author marijaantic
 *
 */

public class Twitter {

	/**
	 * lista koja sadrzi twitter poruke.
	 */
	private LinkedList<TwitterPoruka> poruke =
			new LinkedList<TwitterPoruka>();
			
	/**
	 * metoda vraca listu svih twitter poruka
	 * @return poruke kao listu LinkedList<TwitterPoruka>
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke(){
			return poruke;
	  }
	
	/**
	 * metoda unosi poruku na poslednje mesto liste
	 * @param korisnik ime korisnika kao String
	 * @param poruka sadrzaj poruke kao String
	 */
	public void unesi(String korisnik, String poruka) {
			
			TwitterPoruka tp = new TwitterPoruka();
			
			tp.setKorisnik(korisnik);
			tp.setPoruka(poruka);
			
			poruke.addLast(tp);
		}
	
	/**
	 * metova vraca niz poruka koje sadrze tag dat kao parametar
	 * @param maxBroj broj poruka koje niz moze maksimalno da ima, int
	 * @param tag String koji sadrze poruke koje trazimo 
	 * @return niz TwitterPoruka[] elementi poruke koje sadrze tag
	 * @throws java.lang.RuntimeException ako je uneto null ili prazan String za tag 
	 * <ul>
	 * 	<li>null</li>
	 *  <li>prazan String</li>
	 * </ul>
	 */
			
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
			
		if (tag==null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
			//Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
			
		if (maxBroj<=0)
			maxBroj = 100;
		
			int brojac = 0;
		
			TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		
			for (int i = 0; i < poruke.size(); i++)
				if (poruke.get(i).getPoruka().indexOf(tag)!=-1)
					if (brojac < maxBroj){
			rezultat[brojac]=poruke.get(i);
			brojac++;
		}
			else break;
			return rezultat;
		}
}
