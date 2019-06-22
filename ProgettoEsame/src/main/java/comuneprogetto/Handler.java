package comuneprogetto;


import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import org.json.simple.JSONArray;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Gestisce le richieste in entrata dal web
 * @author Igor Nociaro
 * @author Harmandeep Kaur
 * @version 1.0
 */

@RestController
@EnableAutoConfiguration
public class Handler { //handling incoming web requests	
	
	@RequestMapping("/")
	String home() {  
		return "Hello World!";  //viene visualizzato in localhost:8080 sul browser
	}
	/**
	 * Visualizza tutti i dati del dataset su localhost:8080/data
	 * @return lista dati da {@link CreaOggetti}
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@GetMapping("/data")
	public ArrayList<LocaleMilano> GetData() throws FileNotFoundException, IOException //stampa tutti i dati del dataset in formato json
	{
		CreaOggetti Lista = new CreaOggetti(); 
		return Lista.getLista();
	}
	/**
	 * Visualizza i metadati del dataset su localhost:8080/metadata
	 * @return lista metadata creata con {@link Metadata}
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@GetMapping("/metadata")
	public JSONArray GetMetadata() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		Metadata metadata = new Metadata(); //\ufeffID_NLS?
		return metadata.getMetadata();
	}
	/**
	 * Visualizza i dati filtrati del dataset su localhost:8080/data/filtra
	 * @param filtro es  http://localhost:8080/data?filter={"field" : {"$gt" : val}}
	 * @return lista filtrata
	 */
	@GetMapping("/data/filtra")
	public ArrayList<LocaleMilano> datafiltrata(@RequestParam("filter") String filtro)  
	{
		System.out.println("filtro passato " + filtro);
		//problema con []
		//https://programmer.help/blogs/characters-are-defined-in-rfc-7230-and-rfc-3986.html 
		//https://stackoverflow.com/questions/41053653/tomcat-8-is-not-able-to-handle-get-request-with-in-query-parameters/51212677#51212677
		String[] parts = filtro.split("\\W");        //ogni non-word character,il dash (_) è considerato carattere
		int i = 0;
		String A[] = {"","","",""};
		for(String x: parts) {
			if(!x.equals("")) {
				System.out.println("part : " + x);
				switch(x) {
				case "not": A[i]= "!="; break;
				case "gt": A[i]= ">"; break;
				case "lt": A[i]= "<"; break;
				case "gte": A[i]= ">="; break;
				case "lte": A[i]= "<="; break;
				default : A[i] = x; break;
				}		
				i++;
			}
		}
		CreaOggetti Lista = new CreaOggetti(); 
		return Lista.filtra(A[0], A[1], Double.parseDouble(A[2]));
	}
	/**
	 * Visualizza le statistiche di un determinato campo su localhost:8080/data/stat
	 * @param campo es http://localhost:8080/data?field=INIZIO_ATT
	 * @return lista statistiche da {@link CreaStatistiche}
	 */
	@GetMapping("/data/stat")
	public ArrayList<Statistiche> statistics(@RequestParam("field") String campo)
	{
		String Campo = campo.toUpperCase();
		CreaOggetti Lista = new CreaOggetti();		
		CreaStatistiche stats = new CreaStatistiche(Lista.getLista(),Campo); 
		return stats.getstats();  

	}
	/**
	 * Visualizza le statistiche di un campo filtrato su localhost:8080/data/stat/filtra
	 * @param campo
	 * @param filtro
	 * es http://localhost:8080/data/stat/filtra?field=INIZIO_ATT&filter={"geo_x":{"$gte": 30}}
	 * fa la statistica di inizio_att di tutti i record con geo_x >= 30
	 * @return lista statistiche filtrata 
	 */
	@GetMapping("/data/stat/filtra")
	public ArrayList<Statistiche> filtrastat(@RequestParam("field") String campo,@RequestParam("filter") String filtro)
	{
		String Campo = campo.toUpperCase();
		System.out.println("filtro passato " + filtro);
		String[] parts = filtro.split("\\W");        //ogni non-word character,il dash (_) è considerato carattere
		int i = 0;
		String A[] = {"","","",""};
		for(String x: parts) {
			if(!x.equals("")) {
				System.out.println("part : " + x);
				switch(x) {
				case "not": A[i]= "!="; break;
				case "gt": A[i]= ">"; break;
				case "lt": A[i]= "<"; break;
				case "gte": A[i]= ">="; break;
				case "lte": A[i]= "<="; break;
				default : A[i] = x; break;
				}		
				i++;
			}
		}
		CreaOggetti Lista = new CreaOggetti();
		CreaStatistiche stats = new CreaStatistiche(Lista.filtra(A[0], A[1], Double.parseDouble(A[2])),Campo); 
		return stats.getstats();  

	} 
	
}