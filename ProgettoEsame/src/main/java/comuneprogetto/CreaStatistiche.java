package comuneprogetto;

import java.util.ArrayList;
/**
 * Classe che crea le statistiche e le mette in una lista
 * @author Igor Nociaro
 * @author Harmandeep Kaur
 * @version 1.0
 */
public class CreaStatistiche {
	public ArrayList<Statistiche> listastat = new ArrayList<Statistiche>();
	/**
	 * 
	 * @param lista è la lista di{@link LocaleMilano} che può essere intera o filtrata precedentemente
	 * @param campo nome del campo dove fare statistiche
	 */
	public CreaStatistiche(ArrayList<LocaleMilano> lista,String campo) {
		if(campo.equals("ID_NLS")||campo.equals("INIZIO_ATT")||campo.equals("GEO_X")||campo.equals("GEO_Y")) {
			//average
			double totalAmount = 0;
			double temp = 0;
		    for (int i=0; i<lista.size(); i++){
		    	if(campo.equals("ID_NLS")) temp= lista.get(i).getID_NLS ();
		    	if(campo.equals("INIZIO_ATT")) temp= lista.get(i).getINIZIO_ATT ();
		    	if(campo.equals("GEO_X")) temp= lista.get(i).getgeo_x ();
		    	if(campo.equals("GEO_Y")) temp= lista.get(i).getgeo_y ();
		        totalAmount += temp; 
		    }
		    double media = totalAmount/lista.size();
		    
		    //minimo e massimo
		    double max = 0;
		    double min = 999999.0;
		    for(int i=0; i<lista.size(); i++){
		    	if(campo.equals("ID_NLS")) {
		    		if(lista.get(i).getID_NLS() > max)  max = lista.get(i).getID_NLS();
		    		if(lista.get(i).getID_NLS() < min)  min = lista.get(i).getID_NLS();
		    		}
		    	if(campo.equals("INIZIO_ATT")){
		    		if(lista.get(i).getINIZIO_ATT() > max)  max = lista.get(i).getINIZIO_ATT();
		    		if(lista.get(i).getINIZIO_ATT() < min)  min = lista.get(i).getINIZIO_ATT();
		    		}
		    	if(campo.equals("GEO_X")){
		    		if(lista.get(i).getgeo_x() > max)  max = lista.get(i).getgeo_x();
		    		if(lista.get(i).getgeo_x() < min)  min = lista.get(i).getgeo_x();
		    		}
		    	if(campo.equals("GEO_Y")){
		    		if(lista.get(i).getgeo_y() > max)  max = lista.get(i).getgeo_y();
		    		if(lista.get(i).getgeo_y() < min)  min = lista.get(i).getgeo_y();
		    		}
		    }
		    listastat.add(new Statistiche(media,min,max,0,totalAmount,lista.size()));
		}
		if(campo.equals("RIC")||campo.equals("INDIR_ORIG")||campo.equals("DENOM_IMPRES")||campo.equals("INSEGNA")) {
			//todo elementi unici e occorrenze
		}
	}
	/**
	 * Fornisce le statistiche 
	 * @return Statistiche in formato ArrayList
	 */
	public ArrayList<Statistiche> getstats(){
		return listastat;
	}

}
