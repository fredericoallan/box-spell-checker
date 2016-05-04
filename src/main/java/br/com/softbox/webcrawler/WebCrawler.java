package br.com.softbox.webcrawler;

import java.io.IOException;
//import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
//import java.util.Set;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebCrawler {
	
	
	// We'll use a fake USER_AGENT so the web server thinks the robot is a normal web browser.
    private static final String USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2227.0 Safari/537.36";
    //private static final String USER_AGENT = "Mozilla";
    
    private List<String> links = new LinkedList<String>();
    private Document htmlDocument;
		
    /**
     * This performs all the work. It makes an HTTP request, checks the response, and then gathers
     * up all the links on the page. Perform a searchForWord after the successful crawl
     * 
     * @param url URL para se visitar
     * @return se o rastreamento foi bem sucedido
     */
    public boolean crawl(String url)
    {
        try
        {
            Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
            Document htmlDocument = connection.get();
            this.htmlDocument = htmlDocument;
            
            //200 is the HTTP OK status code
            if(connection.response().statusCode() == 200){
                System.out.println("**Navegando** Recebendo a Web page de: " + url);
            }
            
            //se o conteudo da url não conter html text
            if(!connection.response().contentType().contains("text/html")){
                System.out.println("**Falha** Recebi algo diferente de HTML");
                return false;
            }
            
            //capturando os links dentro do htmlDocument
            Elements linksOnPage = htmlDocument.select("a[href]");
            
            System.out.println("Achei (" + linksOnPage.size() + ") links");
            
            //adicionar os links na lista 'links'
            for(Element link : linksOnPage){
                this.links.add(link.absUrl("href"));
            }
            
            String bodyText = this.htmlDocument.body().text();
            
            
            return true;
        }
        catch(IOException ioe)
        {
        	System.out.println("Error! we were not successful in our HTTP request");
            return false;
        }
    }
	
	

}
