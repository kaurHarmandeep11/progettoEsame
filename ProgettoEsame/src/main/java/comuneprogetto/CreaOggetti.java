package comuneprogetto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.*;
//import com.google.gson.*;
//import java.util.Collection;
public class CreaOggetti/* implements Filter<LocaleMilano, Object> */ {
	
	public ArrayList<LocaleMilano> lista = new ArrayList<LocaleMilano>();
//	private FilterUtils<LocaleMilano> utils;
	//public CreaOggetti json;
	//ArrayList<Person> p = new ArrayList<Person>();
	Locale loc = new Locale(lista);
	
	public CreaOggetti(String csvFile) {
		//System.out.print("all'interno di creaoggetti");
		String line = "";
        String csvSplitBy = ";";
      //  int i = 0;
     //   LocaleMilano[] loc = new LocaleMilano[500]; //crea un array di oggetti

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {  //in questo modo br viene chiuso automaticamente alla fine

        line = br.readLine(); //leggi la prima riga perchè contiene i nomi dei campi per evitare l'errore java.lang.NumberFormatException
        
          while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] x = line.split(csvSplitBy);
             //   System.out.println(Dati[0] + "  " + Dati[1]); //prova
          
              lista.add(new LocaleMilano(Integer.parseInt(x[0]),x[1],x[2],x[3],x[4],Integer.parseInt(x[5]),Double.parseDouble(x[6]),Double.parseDouble(x[7])));
             // String json = new Gson().toJson(lista );
              //   loc[i] = new LocaleMilano(Integer.parseInt(Dati[0]),Dati[1],Dati[2],Dati[3],Dati[4],Integer.parseInt(Dati[5]),Double.parseDouble(Dati[6]),Double.parseDouble(Dati[7]));
               //crea un oggetto con i valori estratti
                // Integer.parseInt(Dati[0]) fa il cast da string a int
                //Double.parseDouble(Dati[6]); fa il cast da string a double
            }
          //filtro
       /*   ArrayList<LocaleMilano> pout = loc.filterField("INIZIO_ATT", "<", 1940.0);
          System.out.print(pout);*/
          
        } catch (IOException e) {
            e.printStackTrace();
        }
      /*  ArrayList<LocaleMilano> pout = loc.filterField("INIZIO_ATT", "<", 1940.0);
        System.out.print(pout);*/
        }

	public ArrayList<LocaleMilano> getLista() {
		return lista;
	}
	
	/*public ArrayList<LocaleMilano> filtra(String fieldName, String operator, double value){
		//ArrayList<LocaleMilano> pout = loc.filterField("INIZIO_ATT", "<", 1940.0);
		ArrayList<LocaleMilano> pout = loc.filterField(fieldName, operator, value);
        System.out.print(pout);
        return pout;
	}*/
	
	public ArrayList<LocaleMilano> filtra(String fieldName, String operator, double value){
		//ArrayList<LocaleMilano> pout = loc.filterField("INIZIO_ATT", "<", 1940.0);
		ArrayList<LocaleMilano> pout = loc.filterField(fieldName, operator, value);
        System.out.print(pout);
        return pout;
	}
}
