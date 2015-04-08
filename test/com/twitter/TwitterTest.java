/**
 * 
 */
package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

/**
 * Testiranje klase Twitter
 * @author marijaantic
 * @version 1.0
 *
 */
public class TwitterTest {
	
	private Twitter t;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	
		t = new Twitter();
	
	}
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		
		t = null;
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test
	public void testVratiSvePoruke() {
		
		TwitterPoruka tp1 = new TwitterPoruka();
		tp1.setKorisnik("Mara");
		tp1.setPoruka("ovo je marin tvit");
		
		TwitterPoruka tp2 = new TwitterPoruka();
		tp2.setKorisnik("Pera");
		tp2.setPoruka("ovo je perin tvit");
		
		LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
		poruke.add(tp1);
		poruke.add(tp2);
		
		
		t.unesi("Mara", "ovo je marin tvit");
		t.unesi("Pera", "ovo je perin tvit");
		

		
		t.vratiSvePoruke();
		
		assertEquals(poruke.size(), t.vratiSvePoruke().size());
		
		
		
	}

	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnesi() {
		
		TwitterPoruka tp = new TwitterPoruka();
		
		tp.setKorisnik("Mara");
		tp.setPoruka("ovo je marin tvit #tweet");
		
		t.unesi("Mara", "ovo je marin tvit #tweet");
		
		assertEquals(1, t.vratiSvePoruke().size());
		assertEquals("Mara", tp.getKorisnik());
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagNull() {
		
		t.vratiPoruke(5, null);
		
	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagPrazan() {
		
		t.vratiPoruke(5, "");
		
	}
	

	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test 
	public void testVratiPoruke() {
		
		TwitterPoruka tp1 = new TwitterPoruka();
		tp1.setKorisnik("Mara");
		tp1.setPoruka("ovo je marin tvit #tweet");
		
		TwitterPoruka tp2 = new TwitterPoruka();
		tp2.setKorisnik("Pera");
		tp2.setPoruka("ovo je perin tvit #tweet");
		
		TwitterPoruka tp3 = new TwitterPoruka();
		tp3.setKorisnik("Pera");
		tp3.setPoruka("ovo je perin tvit #pera");
		
		LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
		poruke.add(tp1);
		poruke.add(tp2);
		poruke.add(tp3);
		
		
		
		t.unesi("Mara", "ovo je marin tvit #tweet");
		t.unesi("Pera", "ovo je perin tvit #tweet");
		t.unesi("Pera","ovo je perin tvit #pera" );
		
		TwitterPoruka[] rezultat = t.vratiPoruke(3, "#tweet");
		
		TwitterPoruka[] tweet = new TwitterPoruka[3];
		tweet[0] = tp1;
		tweet[1] = tp2;
		tweet[2] = null;
		
		assertEquals (tweet.length, rezultat.length);
	
		
	}
}
