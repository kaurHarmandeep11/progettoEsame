package comuneprogetto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.*;
/**
 * Legge il file e crea una lista di {@link LocaleMilano}
 * @author Igor Nociaro
 * @author Harmandeep Kaur
 * @version 1.0
 */
public class CreaOggetti{
	
	public ArrayList<LocaleMilano> lista = new ArrayList<LocaleMilano>();
	Locale loc = new Locale(lista);
	/**
	 * 
	 */
	public CreaOggetti() {
		String line = "";
        String csvSplitBy = ";"; // use semicolon as separator
        String csvFile = "Negozi_e_locali_storici_di_milano.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {  //in questo modo br viene chiuso automaticamente alla fine

        line = br.readLine(); //leggi la prima riga perchè contiene i nomi dei campi per evitare l'errore java.lang.NumberFormatException
        
          while ((line = br.readLine()) != null) {
                
              String[] x = line.split(csvSplitBy);
             
              lista.add(new LocaleMilano(Integer.parseInt(x[0]),x[1],x[2],x[3],x[4],Integer.parseInt(x[5]),Double.parseDouble(x[6]),Double.parseDouble(x[7])));
            }
          
        } catch (IOException e) {e.printStackTrace();}
                    
    }

	public ArrayList<LocaleMilano> getLista() {
		return lista;
	}
	/**
	 * Metodo per il filtraggio della lista
	 * @param fieldName nome del campo
	 * @param operator operatore condizionale
	 * @param value valore di riferimento
	 * @return lista filtrata
	 */
	public ArrayList<LocaleMilano> filtra(String fieldName, String operator, double value){
		ArrayList<LocaleMilano> pout = loc.filterField(fieldName, operator, value);
        return pout;
	}
}
