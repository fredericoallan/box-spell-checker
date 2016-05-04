package br.com.softbox.boxspellchecker;

import static org.junit.Assert.*;
//import org.junit.*;
import org.junit.Test;

public class SpellCheckerTest {
	
	SpellChecker spell = new SpellChecker();
	
	 /*
	 *Testar impressao da msg com sucesso e falha
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testMain() {
		assertEquals(true, true);
		spell.main(null);
	}
}
