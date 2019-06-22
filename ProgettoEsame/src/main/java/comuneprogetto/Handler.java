package comuneprogetto;

//import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import org.json.simple.JSONArray;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;


@RestController
@EnableAutoConfiguration

public class Handler { //handling incoming web requests	
	

	
	@RequestMapping("/")
	String home() {  
		return "Hello World!";  //viene visualizzato in localhost:8080 sul browser
	}
	
	//@RequestMapping(path="/data", method = RequestMethod.GET, headers="Accept=application/json; charset=utf-8")
	@GetMapping("/data")
	public ArrayList<LocaleMilano> GetData() throws FileNotFoundException, IOException //stampa tutti i dati del dataset in formato json
	{
		CreaOggetti Lista = new CreaOggetti("Negozi_e_locali_storici_di_milano.csv"); //da cambiare?
		return Lista.getLista();
	}
	
	@GetMapping("/metadata")
	//stampa metadata in formato json
	public JSONArray GetMetadata() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		Metadata metadata = new Metadata(); //\ufeffID_NLS?
		return metadata.getMetadata();
	}
	
	
/*	@GetMapping("/data")
	public ArrayList<LocaleMilano> dataconparametro(@RequestParam("field") String campo,@RequestParam("filter") String filtro)
	{
		//scomporre il filtro ??  esempio {"field" : {"$not" : val}}
		//esempio di filtro: http://localhost:8080/data?field=INIZIO_ATT&op=<&num
		CreaOggetti Lista = new CreaOggetti("Negozi_e_locali_storici_di_milano.csv"); //da cambiare?
		System.out.println("campo passato" + campo);
		//String temp = campo;
		return Lista.filtra(campo, "<", 1900.0);
		//System.out.println("Requested book " + id +""+ id2);
	} */
	
	@GetMapping("/data/filtra")
	public ArrayList<LocaleMilano> datafiltrata(@RequestParam("filter") String filtro)  //problema con []
	{
		//scomporre il filtro ??  esempio {"field" : {"$not" : val}}
		//esempio di filtro: http://localhost:8080/data?field={"field" : {"$not" : val}}
		//usare String split?
		System.out.println("filtro passato " + filtro);
		//https://programmer.help/blogs/characters-are-defined-in-rfc-7230-and-rfc-3986.html 
		//https://stackoverflow.com/questions/41053653/tomcat-8-is-not-able-to-handle-get-request-with-in-query-parameters/51212677#51212677
		//String split = "\\{|\\}|\"|:|\\[|\\]|,";
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
		CreaOggetti Lista = new CreaOggetti("Negozi_e_locali_storici_di_milano.csv"); //da cambiare?
		return Lista.filtra(A[0], A[1], Double.parseDouble(A[2]));
	}
	@GetMapping("/data/stat")
	public ArrayList<Statistiche> statistics(@RequestParam("field") String campo)
	{
		String Campo = campo.toUpperCase();
		//se RIC,INDIR_ORIG,DENOM_IMPRES,INSEGNA ---> conteggio elementi unici
		//se ID_NLS,INIZIO_ATT,GEO_X,GEO_Y ---> avg,min,max,sum,count,devstd
		CreaOggetti Lista = new CreaOggetti("Negozi_e_locali_storici_di_milano.csv"); //da cambiare?
		//System.out.println("campo passato" + campo);
		
		CreaStatistiche stats = new CreaStatistiche(Lista.getLista(),Campo); //se gli passo la lista filtrata?
		//ArrayList al1 = (ArrayList) stats;
		return stats.getstats();  //da statistiche a lista? 

	}
	
	@GetMapping("/data/stat/filtra")
	public ArrayList<Statistiche> filtrastat(@RequestParam("field") String campo,@RequestParam("filter") String filtro)
	{
		//es /data/stat/filtra?field=INIZIO_ATT&filter={"geo_x":{"$gte": 30}}   fa la statistica di inizio_att di tutti i record con geo_x >= 30
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
		CreaOggetti Lista = new CreaOggetti("Negozi_e_locali_storici_di_milano.csv"); //da cambiare?
		CreaStatistiche stats = new CreaStatistiche(Lista.filtra(A[0], A[1], Double.parseDouble(A[2])),Campo); 
		return stats.getstats();  //da statistiche a lista?

	} 
	
}