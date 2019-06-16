package comuneprogetto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.*;
//import com.google.gson.*;
//import java.util.Collection;
public class CreaOggetti {
	
	public List<LocaleMilano> lista = new ArrayList<>();
	//public CreaOggetti json;
	
	
	public CreaOggetti(String csvFile) {
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
            }/*
          for(LocaleMilano x:lista) {
        	  System.out.print(x.getID_NLS());
              System.out.print(x.getRIC());
              System.out.print(x.getINDIR_ORIG());
              System.out.print(x.getDENOM_IMPRES());
              System.out.print(x.getINSEGNA());
              System.out.print(x.getINIZIO_ATT());
              System.out.print(x.getgeo_y());
              System.out.print(x.getgeo_x());
              System.out.println();
          }
          */
//          System.out.print(loc[340].getINSEGNA());  //questo è un test 
        } catch (IOException e) {
            e.printStackTrace();
        }
              	
        }

	public List<LocaleMilano> getLista() {
		return lista;
	}

}
