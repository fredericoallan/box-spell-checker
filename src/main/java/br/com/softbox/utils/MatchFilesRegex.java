package br.com.softbox.utils;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.*;

public class MatchFilesRegex {
	
 	/**
	 * metodo para listar as palavras dentro de um arquivo capturadas
	 * 
	 * @param pathfile caminho do arquivo para leitura.
	 * @return listaFrases lista de frases 
	 */

	public Map<Integer, String> listFrasesForFile(File pathfile, List<String> exp, Integer RegexGroup) { //receber uma lista de exp
		
		//lista multidimensional
		Map<Integer,String> listaFrases = new HashMap<Integer,String>();
		
		//variaveis
		int i = 1;
 		 					
		try{
			
			//declarando um buffer de memoria para ler o arquivo
			//BufferedReader buffRead = new BufferedReader(new FileReader(pathfile));
			BufferedReader buffRead = new BufferedReader(new InputStreamReader(new FileInputStream(pathfile),"UTF-8"));
			
	 		String linha = "";
	 		
	 		//enquanto tiver linhas
	 		while ((linha = buffRead.readLine()) != null){
	 			
	 			//se a linha corrente nao estiver vazia
	 			if (linha != null &&  !(linha.isEmpty())) {
	 			
	 				//para cada linha valida percorro as expressoes nela
	 				for (int j = 0; j < exp.size(); j++){
	 					
	 					Pattern expReg = Pattern.compile(exp.get(j).toString());
	 					
			 			// Para cara match feita na linha, extrair a frase e printar
			 			Matcher m = expReg.matcher(linha);
			 			
			 			while (m.find()) {
			 				
			 				//imprimir com o grupo e ver se da diferença
			 		        String frase = m.group(RegexGroup);
			 		        //System.out.println(frase);
			 		        
			 		        //replace m por caracteres especiais
			 		        //frase = frase.replaceAll("[^a-zA-Z0-9\\s]", "").trim();
			 		        
			 		        
			 		        // Get the starting position of the text
			 		        //int start = m.start(0);
			 		        // Get ending position
			 		        //int end = m.end(0);
			 		        // Print whatever matched.
			 		        // Use CharacterIterator.substring(offset, end);
			 		        
			 		        //caso a frase não tenha nada
			 		        if (frase == null ){
			 		        	listaFrases.put(i, "Error!");
			 		        }else{
			 		        	if (frase.trim().length() == 0){
			 		        		listaFrases.put(i, "Error!");
			 		        	}else{
			 		        		listaFrases.put(i, frase);
			 		        	}
			 		        }
			 		      }
	 				}
				}
	 			i++;
	 		}
	 		
	 		//fechar o buffer
	 		buffRead.close();
			
		 		
	 	} catch (Exception ex) {
			System.out.println("Erro na leitura do arquivo: " + pathfile + " Linha: " + i);
			ex.printStackTrace();
		}	
		
		return listaFrases;
 	}
}