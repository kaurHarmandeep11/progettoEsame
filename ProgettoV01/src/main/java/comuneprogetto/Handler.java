package comuneprogetto;

//import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
//import org.springframework.http.MediaType;
import org.json.simple.JSONArray;
//import com.google.gson.Gson;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.List;
/**
 * Problem
 * https://serverfault.com/questions/785600/web-app-running-on-tomcat-not-updating-when-modified
 *
 */
@RestController
@EnableAutoConfiguration

public class Handler { //handling incoming web requests	
	
	//CreaOggetti temp = new CreaOggetti();
	
	@RequestMapping("/")
	String home() {  
		return "Hello World!";  //viene visualizzato in localhost:8080 sul browser
	}
	
	//@RequestMapping(path="/data", method = RequestMethod.GET, headers="Accept=application/json; charset=utf-8")
	@GetMapping("/data")
	public List<LocaleMilano> GetData() throws FileNotFoundException, IOException //stampa tutti i dati del dataset in formato json
	{
		CreaOggetti Lista = new CreaOggetti("Negozi_e_locali_storici_di_milano.csv"); //da cambiare?
		return Lista.getLista();
	}
	
	@GetMapping("/metadata")
	//stampa metadata in formato json
	public JSONArray GetMetadata() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		MetaData metadata = new MetaData(); //\ufeffID_NLS?
		return metadata.getMetadata();
	}
	
	/*@GetMapping("/filtro")
	//stampa risultati dei filtri applicati in formato json
	public @ResponseBody ArrayList<DatasetStructure> Getfiltri() throws IOException, ClassNotFoundException
	{
		ListGenerator lista = new ListGenerator();
		ArrayList<DatasetStructure> pout = lista.filterField("bbb", "=", "aaa");
		return pout;	
	}*/

}
