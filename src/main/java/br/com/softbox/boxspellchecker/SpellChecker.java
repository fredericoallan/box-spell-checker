package br.com.softbox.boxspellchecker;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.softbox.boxspellchecker.beans.Extension;
import br.com.softbox.boxspellchecker.beans.Extensions;
import br.com.softbox.boxspellchecker.beans.Dictionary;
import br.com.softbox.utils.ReadDirFiles;
import br.com.softbox.webcrawler.WebCrawler;
import br.com.softbox.utils.MatchFilesRegex;
import br.com.softbox.utils.MatchWordsRegex;

public class SpellChecker {
	//arquivos de configuração
	static String config = "./config.json";
	
	//arquivos dicionario
	static String dictionary = "";

	//recebe o retorno da lista de arquivos encontrados em um diretorio com a extensão desejada
	static List<String> arquivosLista = new ArrayList<>();
	
	//declarar as classes utilitarias para uso
	static ReadDirFiles readDirFiles = new ReadDirFiles();
	static MatchFilesRegex matchFilesRegex = new MatchFilesRegex();
	static MatchWordsRegex matchWordsRegex = new MatchWordsRegex();
	static WebCrawler webCrawler = new WebCrawler();
	
	//recebe o retorno da lista de frases encontradas dentro de um arquivo específico
	static Map<Integer,String> frasesLista = new HashMap<Integer,String>();
	
	//recebe o retorno da lista de palavras com o resultado do match das palavras do dicionario
	static Map<String, String> palavrasLista = new HashMap<String, String>();
	
	//variaveis de controle
	static String tLista = "";
		
	/**
	 * construtor sugerido pelo sonar
	 */
	public SpellChecker(){
		
	}
	
	/**
	 * metodo main para inicio das execucoes
	 * 
	 * @param args parâmetros de entrada do sistema.
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
		//data corrente
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String sDate= sdf.format(date);
		
		//totalizadores
		int totalFiles=0;
		int totalWords=0;
		int totalErrors=0;
		
		//contadores
		int totalFilesErros=0;
		
		
		//validar se estou passando algum valor em args
		
		
		if (args.length > 0 ){
			System.out.println("======================================================");
			System.out.println("Em breve web box spell checker!...");
			//webCrawler.crawl(args[0].toString());
			//webCrawler.crawl("https://mantis.softbox.com.br/my_view_page.php");
			System.out.println("======================================================");
			System.exit(0);
		}
				
		
		//1) ler o arquivo json de configuração em uma variavel transformando em um obj mapper da classe Extensions
		ObjectMapper mapperConfig = new ObjectMapper();
		
		Extensions ext = mapperConfig.readValue(new File(config), Extensions.class);
		
		//2) ler o arquivo json de configuração em uma variavel transformando em um obj mapper da classe Extensions
		dictionary = ext.getDictionaryFile().toString();
		ObjectMapper mapperDic = new ObjectMapper();
		Dictionary dic = mapperDic.readValue(new File(dictionary), Dictionary.class);
		
		try {
			
			//3) iterar entre a qtd de extensoes  "Extension": "html"
			for (Extension e : ext.getExtensions()) {
				
				System.out.println("======================================================");
				System.out.println("");
				System.out.println("LOG OF EXECUTION - " + sDate);
				System.out.println("");

				File dir = new File(e.getPath().toString());
				
				//capturar os arquivos conforme o diretorio informado				
				arquivosLista.addAll(readDirFiles.listFilesForFolder(dir, e.getExt().toString(),e.getFiles()));
				
				totalFiles = arquivosLista.size();
				
				//5) com a lista em mãos, eu varro a lista e abro arquivo por arquivo para leitura			
				for(int x = 0; x < arquivosLista.size(); x ++){
					
					
					File arq = new File(arquivosLista.get(x).toString());
					//recuperar as frases encontradas
					
					frasesLista.putAll(matchFilesRegex.listFrasesForFile(arq, e.getRegex().getExp(), e.getRegex().getGroup()));	
					
					
					//printar o arquivo que estou trabalhando se existem frases capturadas
					if (frasesLista.size() > 0){
						System.out.println((totalFilesErros+1) + ") " + arquivosLista.get(x).toString());
					}
					
					//6) com a lista de frases em maos eu devo fazer match com a lista do dicionario
					// e retornar quais palavras dao match e quais nao dao				
					for(Map.Entry<Integer, String> lista: frasesLista.entrySet()) {
							
						//fazer o split das frases
						String[] words = lista.getValue().split("\\s+");
						
						for (int z = 0; z < words.length; z++){
						
							//jogar palavra por palavra no metodo matchWordRegex
							String palavra = words[z].trim();
							palavrasLista.putAll(matchWordsRegex.listWords(palavra, dic.getDicionario(), e.getRegex().getGroup()));
						}
						
						//capturar o total de palavras
						totalWords = totalWords + palavrasLista.size();
						
						//capturar somente as palavras com boolean false no mapa
						tLista = "";
						
						for(String key : palavrasLista.keySet()){
					        if(palavrasLista.get(key) ==  "nachei"){
					        	//temporary lista
					            tLista = tLista + ",'" + key.toString() + "'";
					            //capturar o total de palavras com erro
					            totalErrors++;
					        }
					    }
												
						//remover a virgula inicial e printar se tiver valores "não achei"
						if (tLista.length() > 0){
							tLista = tLista.substring(1, tLista.length());
							System.out.println("- Line " + lista.getKey() + ": " + tLista);
						}
						
						//limpar a variavel para pegar novos apos a iteração do for
						palavrasLista.clear();
						
					}

					//limpar a variavel para pegar novos apos a iteração do for
					frasesLista.clear();
					System.out.println("");
					
					//totalizar arquivos com erros se tem linhas com erro
					if (tLista.length() > 0){
						totalFilesErros++;
					}
				}
			
				//limpar a variavel para pegar novos apos a iteração do for
				arquivosLista.clear();
				
			}
			
			System.out.println("Result: (" + totalFiles + ") files (" + totalWords + ") words (" + totalErrors + ") errors");
			
			System.out.println("");
			
			System.out.println("fredericoallansouza@gmail.com (2016)");
			
			System.out.println("======================================================");
			
			//System.out.println("dictionaryFile:" + ext.getDictionaryFile());
			
			//printar o resultado final
			
			
		}catch(Exception ex) {
			System.out.println("Fail! Contact the tool administrator.");
			ex.printStackTrace();	
		}
		
	}

}