package br.com.softbox.boxspellchecker;

import br.com.softbox.utils.*;

import static org.junit.Assert.*;
//import org.junit.*;
import org.junit.Test;

public class UtilsTest {
	
	//inicializar util com a classe Utils.java do outro pacote
	Utils util = new Utils();
	
	/*
	 *Testar impressao da msg com sucesso e falha
	 */
	@Test
	public void testImprimeMensagens() {
		assertEquals("fred-test", util.imprimeMensagens("fred"));
		assertEquals("joão-test", util.imprimeMensagens("joão"));
		assertEquals("allan--test", util.imprimeMensagens("allan-"));
	}
}
