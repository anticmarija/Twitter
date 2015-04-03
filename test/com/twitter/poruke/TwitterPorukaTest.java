/**
 * 
 */
package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author marijaantic
 *
 */
public class TwitterPorukaTest {

	private TwitterPoruka tp;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		tp = new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		tp = null;
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test
	public void testSetKorisnik() {
		
		tp.setKorisnik("Zika");
		
		assertEquals("Zika", tp.getKorisnik());
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		tp.setKorisnik(null);
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikEmptyString() {
		tp.setKorisnik("");
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test
	public void testSetPoruka() {
		
		tp.setPoruka("ovo je neki tvit");
		
		assertEquals("ovo je neki tvit", tp.getPoruka());
	}
	
	

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#toString()}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
	
		tp.setPoruka(null);
	}
	
	

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#toString()}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPoruka140() {
	
		tp.setPoruka(".............................ovo ce biti neka mnogo dugacka poruka za twiter, imace sigurno vise od 140 karaktera"
				+"		i ona ne sme da bude na twitteru jer je predugacka, ovaj test mora da padne, zato sto "
				+ "ova poruka ima sigurno vise od 140 karaktera i predugacka je za tvit............................ ");
	}
	
		public void testToString() {
		
			tp.setKorisnik("pera");
			tp.setPoruka("ovo je perin tvit");
			
			assertEquals("KORISNIK: pera PORUKA:ovo je perin tvit", tp.toString());
	}

	

}
