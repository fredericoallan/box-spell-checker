package br.com.softbox.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReadDirFiles {
	
 	static String[] files;
 	static int i=0;
 	List<String> listaArquivos = new ArrayList<>();
	
 	/**
	 * metodo para listar os arquivos conforme diretorio passado como parametro
	 * 
	 * @param path diretório de procura dos arquivos.
	 * @param ext extensão que se deve procurar dentro do diretório
	 * @param files lista de arquivos específicos
	 * @return listaArquivos lista de arquivos do folder.
	 */
 	public List<String> listFilesForFolder(final File path, String ext, List<String> files) { //receber uma lista de ext
 		 					
		try{		 
		 		for (final File fileEntry : path.listFiles()) {
		 			if (fileEntry.isDirectory()) {
		 				listFilesForFolder(fileEntry, ext, files);
					} else {
						if (fileEntry.isFile()) {
							String filename = fileEntry.getName().toLowerCase();
							//possui a extensao que estou procurando?
							if (filename.endsWith("." + ext)) {
								//files não é uma lista vazia
								if (files.size() != 0){
									//se tem uma lista, entao varrer a lista
									for (int i = 0; i < files.size(); i++){
										//validar e ver se os arquivos em files são = ao arquivo que estou lendo no diretorio em minusculo pois ele me retorna desta forma
										if (filename.endsWith(files.get(i).toString().toLowerCase())) {
											listaArquivos.add(path.getAbsolutePath()+ "/" + fileEntry.getName());
										}
									}
								}else{
									//adiciono o arquivo diretamente, pois não importa o nome do arquivo
									listaArquivos.add(path.getAbsolutePath()+ "/" + fileEntry.getName());
								}
							}
				  		}
					}
					i++;
				  }	
	 	} catch (Exception ex) {
	 		System.out.println("Cannot read files from source: '" + path + "'");
			ex.printStackTrace();
		}	
		
		return listaArquivos;
 	}
}