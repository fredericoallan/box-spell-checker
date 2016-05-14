package br.com.softbox.utils;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.*;

public class MatchWordsRegex {
	
 	/**
	 * metodo para listar as palavras que fazer ou não match das palavras do dicionario
	 * 
	 * @param dicWords lista de palavras regex do dionário para comparação
	 * @return listaPalavras lista de palavras com o resultado do match
	 */

	public Map<String, String> listWords(String palavra, List<String> dicWords, Integer RegexGroup) { //receber uma lista de palavras do dicionário
		
		//variaveis de controle
		int i =0;
		boolean achou = false;
		Integer tamPalavraValida = 2;
		Map<String, String> listaPalavras = new HashMap<String, String>();
		
				
		try{
			
			//replace m por caracteres especiais mantendo acentos pré\requisitos
		    palavra = palavra.replaceAll("[^\\p{L}\\p{Nd}-]+", "").trim();
		    
		    //converter caracteres html em palavra por caracteres normais
		    //palavra  = Parser.unescapeEntities(palavra, false);
			
			//dou ok direto se a palavra for menor que 2 caracteres
			if (palavra.length() > tamPalavraValida){
			
				//System.out.println("\n>>>> Realizando match das palavras no dicionario");
				//palavra match em alguma palavra (regex) do dicionario?
				for (i = 0; i < dicWords.size(); i++){
					
					
					Pattern expDic = Pattern.compile(dicWords.get(i).toUpperCase());
					//String regex = expDic.toString();
					Matcher m = expDic.matcher(palavra.toUpperCase());
					
					//verifico o contrario
					//Pattern expDic = Pattern.compile(palavra);
					//regex = expDic.toString();
					//Matcher m = expDic.matcher(dicWords.get(i));
					
					//somente se meu regex for maior ou igual a minha palavra
					if (expDic.toString().length() >= palavra.length()){
						//se deu match
						if (m.find()){
							//imprimir com o grupo e ver se da diferença
							//p = m.group(RegexGroup);
			 		        //System.out.println(p);
							
							//a chave sendo a palavra nao vai duplicar dentro do map
							//System.out.println("Achei a palavra: " + palavra + " com o regex: " + regex);
			 		        listaPalavras.put(palavra, "achei");
							achou = true;
							break;
						}
					}
					//System.out.println(palavra + " : " + regex);
				}
			
				//apos sair do for (forçado ou nao) verifico se achou 
				if(!achou){
					//System.out.println("Não Achei!!: " + palavra);
					listaPalavras.put(palavra, "nachei");
				}
			}else{
				//palavras menores que o tamanho definido já estão ok
				listaPalavras.put(palavra, "achei");
			}
			
			
						
	 	} catch (Exception ex) {
	 			System.out.println("Erro ao realizar match com regex: " + dicWords.get(i));
				ex.printStackTrace();
		}
		
		return listaPalavras;
 	}
}