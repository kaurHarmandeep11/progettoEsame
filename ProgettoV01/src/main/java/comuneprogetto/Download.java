package comuneprogetto;

import java.io.*;
import java.net.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import org.apache.commons.io.FileUtils;

public class Download {
	
	String data = "";//inizializza variabili
	String line = "";

	public Download(String url,String Nome) {
		
		File NomeFile = new File (Nome); //trasformo da string ad oggetto per poi dare il nome al file con FileUtils.copyURLToFile
		
		try {
			
			URLConnection openConnection = new URL(url).openConnection();		//Si connette all'url
			openConnection.addRequestProperty("User-Agent", "Google Chrome");	//Con l'utente "User-Agent" e "Google Chrome"
			//System.setProperty("http.agent", "Chrome"); //evita errore java.io.IOException: Server returned HTTP response code: 403 for URL
			InputStream PrendiDati = openConnection.getInputStream();					//Raccoglie il flusso dei dati
			
			 try {
			  	 InputStreamReader LeggiDati = new InputStreamReader( PrendiDati ); 
				 BufferedReader Buffer = new BufferedReader( LeggiDati );		//Grazie a buffer read legge il flusso dei dati
			   														//e li mette dentro a line che va ad incrementare
				 while ( ( line = Buffer.readLine() ) != null ) {		//data in questo ciclo while
					 data+= line;
				  // System.out.println( "Contenuto del JSON: " +line );	//Nel caso vorresti vedere tutto il JSON in riga
				 }
			 } finally {
				 PrendiDati.close();		//dopo aver raccolto tutti i dati chiude il flusso
			 }
			 
			JSONObject oggetto = (JSONObject) JSONValue.parseWithException(data);	//Inizia il parsing dei dati come JSON Object
			JSONObject temp = (JSONObject) (oggetto.get("result"));				//Cerca nel JSON il "result" e lo apre
			JSONArray oggettoarr = (JSONArray) (temp.get("resources"));				//Poi cerca tutti i resources tra le parentesi {} del result
			
			for(Object x: oggettoarr){									//Con questo ciclo for controlla ogni resources
			    if ( x instanceof JSONObject ) {					 
			        JSONObject y = (JSONObject)x; 				
			        String format = (String)y.get("format");		//e "scorrendo" controlla i formati e li mette dentro format
			        URL tempurl = new URL ((String)y.get("url"));	//idem per url, appena ne vede uno lo mette in url
			        //System.out.println(format + " | " + url1);			//Questo print serve se si vuole vedere ogni url contenuto nel JSON
			        if(format.equals("csv")) {						//Se il formato di uno di quei url è cvs (ovvero il file che cerchiamo noi)
			        	FileUtils.copyURLToFile(tempurl, NomeFile);	//lo scarica nella cartella del progetto
			        	//perchè lo scarica nella cartella principale?come faccio a cambiare cartella?
			        	//per FileUtils scaricare Apache Commons IO http://www.java2s.com/Code/Jar/o/Downloadorgapachecommonsiojar.htm
			            System.out.println( "Il file è stato scaricato" );
			        }
			    }
			} 
	
		} 
		catch (IOException | ParseException e) { e.printStackTrace(); }//Eccezioni in caso di parse sbagliato
		catch (Exception e) { e.printStackTrace(); }//o di url non adatto
		
	}
}