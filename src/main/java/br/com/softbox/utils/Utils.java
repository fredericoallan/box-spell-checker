package br.com.softbox.utils;

import javax.swing.text.html.parser.Parser;

public class Utils {

	public static void main(String[] args) {

	}
	
 	/**
	 * metodo teste para imprimir mensagens system.out.println
	 * 
	 * @param msg a string que deseja imprimir
	 */
	public String imprimeMensagens(String msg) {
		System.out.println(msg);
		return msg;
	
	}
	
	/**
	 * metodo para remover caracteres especiais LATIN
	 * 
	 * @param strInput a string para achar caracteres latin
	 * @param strOutput retorno da string corrigida
	 */
 
 	public String replaceLatin(String strInput) {
    
	String strOutput =  "";

	//Lower case para \U00CE => \u00ce
	strInput = strInput.toLowerCase();
	
    //replace accented characters
    strInput = strInput.replace("\\u00c0", "À");
    strInput = strInput.replace("\\u00c1", "Á");
    strInput = strInput.replace("\\u00c2", "Â");
    strInput = strInput.replace("\\u00c3", "Ã");
    strInput = strInput.replace("\\u00c4", "Ä");
    strInput = strInput.replace("\\u00c5", "Å");
    strInput = strInput.replace("\\u00c6", "Æ");
    strInput = strInput.replace("\\u00c7", "Ç");
    strInput = strInput.replace("\\u00c8", "È");
    strInput = strInput.replace("\\u00c9", "É");
    strInput = strInput.replace("\\u00ca", "Ê");
    strInput = strInput.replace("\\u00cb", "Ë");
    strInput = strInput.replace("\\u00cc", "Ì");
    strInput = strInput.replace("\\u00cd", "Í");
    strInput = strInput.replace("\\u00ce", "Î");
    strInput = strInput.replace("\\u00cf", "Ï");
    strInput = strInput.replace("\\u00d1", "Ñ");
    strInput = strInput.replace("\\u00d2", "Ò");
    strInput = strInput.replace("\\u00d3", "Ó");
    strInput = strInput.replace("\\u00d4", "Ô");
    strInput = strInput.replace("\\u00d5", "Õ");
    strInput = strInput.replace("\\u00d6", "Ö");
    strInput = strInput.replace("\\u00d8", "Ø");
    strInput = strInput.replace("\\u00d9", "Ù");
    strInput = strInput.replace("\\u00da", "Ú");
    strInput = strInput.replace("\\u00db", "Û");
    strInput = strInput.replace("\\u00dc", "Ü");
    strInput = strInput.replace("\u00dd", "Ý");

    //Now lower case accents
    strInput = strInput.replace("\\u00df", "ß");
    strInput = strInput.replace("\\u00e0", "à");
    strInput = strInput.replace("\\u00e1", "á");
    strInput = strInput.replace("\\u00e2", "â");
    strInput = strInput.replace("\\u00e3", "ã");
    strInput = strInput.replace("\\u00e4", "ä");
    strInput = strInput.replace("\\u00e5", "å");
    strInput = strInput.replace("\\u00e6", "æ");
    strInput = strInput.replace("\\u00e7", "ç");
    strInput = strInput.replace("\\u00e8", "è");
    strInput = strInput.replace("\\u00e9", "é");
    strInput = strInput.replace("\\u00ea", "ê");
    strInput = strInput.replace("\\u00eb", "ë");
    strInput = strInput.replace("\\u00ec", "ì");
    strInput = strInput.replace("\\u00ed", "í");
    strInput = strInput.replace("\\u00ee", "î");
    strInput = strInput.replace("\\u00ef", "ï");
    strInput = strInput.replace("\\u00f0", "ð");
    strInput = strInput.replace("\\u00f1", "ñ");
    strInput = strInput.replace("\\u00f2", "ò");
    strInput = strInput.replace("\\u00f3", "ó");
    strInput = strInput.replace("\\u00f4", "ô");
    strInput = strInput.replace("\\u00f5", "õ");
    strInput = strInput.replace("\\u00f6", "ö");
    strInput = strInput.replace("\\u00f8", "ø");
    strInput = strInput.replace("\\u00f9", "ù");
    strInput = strInput.replace("\\u00fa", "ú");
    strInput = strInput.replace("\\u00fb", "û");
    strInput = strInput.replace("\\u00fc", "ü");
    strInput = strInput.replace("\\u00fd", "ý");
    strInput = strInput.replace("\\u00ff", "ÿ");

    strOutput = strInput;
    
    return strOutput;
	}
 	
 	public boolean isNumeric(String s) {  
 	    return s.matches("[-+]?\\d*\\.?\\d+");  
 	}  
}