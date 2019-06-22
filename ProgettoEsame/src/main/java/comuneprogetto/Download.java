package comuneprogetto;

import java.io.*;
import java.net.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import org.apache.commons.io.FileUtils;
/**
 * Scarica e salva il dataset
 * @author Igor Nociaro
 * @author Harmandeep Kaur
 * @version 1.0
 */
public class Download {
	
	String data = "";//inizializza variabili
	String line = "";
	/**
	 * @param url da dove scaricare il file (https://www.dati.gov.it/api/3/action/package_show?id=624e5fff-9e40-4adc-9b82-a5d06fa95a26)
	 * @param Nome con cui salvare il file (Negozi_e_locali_storici_di_milano.csv)
	 */
	public Download(String url,String Nome) {
		
		File NomeFile = new File (Nome); //trasformo da string ad oggetto per poi dare il nome al file con FileUtils.copyURLToFile
		
		try {
			
			URLConnection openConnection = new URL(url).openConnection();		//Si connette all'url
			openConnection.addRequestProperty("User-Agent", "Google Chrome");	//Con l'utente "User-Agent" e "Google Chrome"
			 //evita errore java.io.IOException: Server returned HTTP response code: 403 for URL
			InputStream PrendiDati = openConnection.getInputStream();					//Raccoglie il flusso dei dati
			
			 try {
			  	 InputStreamReader LeggiDati = new InputStreamReader( PrendiDati ); //legge il flusso dei dati
				 BufferedReader Buffer = new BufferedReader( LeggiDati );	
			   														
				 while ( ( line = Buffer.readLine() ) != null ) {	//legge i dati una linea alla volta e li mette in data
					 data+= line;
				 }
			 } finally {
				 PrendiDati.close();		//dopo aver raccolto tutti i dati chiude il flusso
			 }
			 
			JSONObject oggetto = (JSONObject) JSONValue.parseWithException(data);	//Inizia il parsing dei dati come JSON Object
			JSONObject temp = (JSONObject) (oggetto.get("result"));			        //Cerca nel JSON il "result" e lo apre
			JSONArray oggettoarr = (JSONArray) (temp.get("resources"));		        //Poi cerca tutti i resources tra le parentesi {} del result
			  
			for(Object x: oggettoarr){					//Con questo ciclo for controlla ogni resources
			    if ( x instanceof JSONObject ) {					 
			        JSONObject y = (JSONObject)x; 				
			        String format = (String)y.get("format");		//controlla i formati e li mette dentro format
			        URL tempurl = new URL ((String)y.get("url"));	//idem per url, appena ne vede uno lo mette in url
			        if(format.equals("csv")) {						//Se il formato di uno di quei url è cvs (ovvero il file che cerchiamo noi)
			        	FileUtils.copyURLToFile(tempurl, NomeFile);	//lo scarica nella cartella del progetto
			            System.out.println( "Il file è stato scaricato" );
			        }
			    }
			} 
	
		} 
		catch (IOException | ParseException e) { e.printStackTrace(); }//Eccezioni in caso di parse sbagliato
		catch (Exception e) { e.printStackTrace(); }//o di url non adatto
		
	}
}