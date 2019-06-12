package comuneprogetto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class CreaOggetti {
	public CreaOggetti(String csvFile) {
		String line = "";
        String csvSplitBy = ";";
        int i = 0;
        LocaleMilano[] loc = new LocaleMilano[500]; //crea un array di oggetti

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {  //in questo modo br viene chiuso automaticamente alla fine

        line = br.readLine(); //leggi la prima riga perchè contiene i nomi dei campi per evitare l'errore java.lang.NumberFormatException
        
          while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] Dati = line.split(csvSplitBy);
             //   System.out.println(Dati[0] + "  " + Dati[1]); //prova
          
              
                loc[i] = new LocaleMilano(Integer.parseInt(Dati[0]),Dati[1],Dati[2],Dati[3],Dati[4],Integer.parseInt(Dati[5]),Double.parseDouble(Dati[6]),Double.parseDouble(Dati[7]));
               //crea un oggetto con i valori estratti
                // Integer.parseInt(Dati[0]) fa il cast da string a int
                //Double.parseDouble(Dati[6]); fa il cast da string a double
                
             /*   System.out.print(loc[i].getID_NLS()); //es
                System.out.print(loc[i].getRIC());
                System.out.print(loc[i].getINDIR_ORIG());
                System.out.print(loc[i].getDENOM_IMPRES());
                System.out.print(loc[i].getINSEGNA());
                System.out.print(loc[i].getINIZIO_ATT());
                System.out.print(loc[i].getgeo_y());
                System.out.print(loc[i].getgeo_x());
                System.out.println();*/
                
                i++;
            }
          System.out.print(loc[340].getINSEGNA());  //questo è un test 
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
}
