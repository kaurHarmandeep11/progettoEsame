package comuneprogetto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FilterUtils<T> {
	public static boolean check(Object value, String operator, Object th) {
		if (th instanceof Number && value instanceof Number) {	
			Double thC = ((Number)th).doubleValue();
			Double valuec = ((Number)value).doubleValue();
			if (operator.equals("=="))
				return value.equals(th);
			else if (operator.equals(">"))
				return valuec > thC;
			else if (operator.equals("<"))
				return valuec < thC;
		}else if(th instanceof String && value instanceof String)
			return value.equals(th);
		return false;		
	}
	public Collection<T> select(Collection<T> src, String fieldName, String operator, Object value) {
		Collection<T> out = new ArrayList<T>();
		for(T item:src) {
			try {
				Method m = item.getClass().getMethod("get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1),null);
				try {
					Object tmp = m.invoke(item);
					if(FilterUtils.check(tmp, operator, value))
						out.add(item);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}					
		}
		return out;
	}
	public static List<LocaleMilano> filtro (String tipo, Integer camere, Integer municipio ) throws FileNotFoundException, IOException
	{
		CreaOggetti Lista = new CreaOggetti("Negozi_e_locali_storici_di_milano.csv");
	/*	ArrayList<DatasetStructure> filtroTipo = new ArrayList();
		ArrayList<DatasetStructure> filtroCamere = new ArrayList();
		ArrayList<DatasetStructure> filtroMunicipio = new ArrayList();
		//cambio i nomi per cercare alcuni parametri
		if (tipo != null)   
		{
			if(tipo.equals("BedeBreakfast")) tipo="Bed e Breakfast"; 
			if(tipo.equals("CasaFerie")) tipo="Casa Ferie";
			if(tipo.contentEquals("CasaUniversitaria")) tipo="casa universitaria bertoni";
		}
		//fine cambio nomi
		
		filtroTipo = Lista.filterField("TipoAttivita", "=", tipo);  //filtro i tipi di attività
		filtroCamere = Lista.filterField("Camere", "=",camere);     //filtro i numeri delle camere
		filtroMunicipio = Lista.filterField("Municipio", "=",municipio); //filtro i municipi
        
		//valuto caso per caso il filtro da attuare a seconda della scelta dell'utente
		if(tipo!=null && camere==null && municipio==null) return filtroTipo;
		else if(tipo==null && camere!=null && municipio==null) return filtroCamere;
		else if(tipo==null && camere==null && municipio!=null) return filtroMunicipio;
		else if(tipo!=null || camere!=null || municipio!=null) 
		{
			//filtri multipli: in questo caso devo  prendere l'intersezione degli elementi ottenuti
			if(tipo!=null&&camere!=null&&municipio==null)  return intersezione(filtroTipo,filtroCamere);
            if(tipo!=null&&municipio!=null&&camere==null) return intersezione(filtroTipo,filtroMunicipio);
            if(tipo==null&&municipio!=null&&camere!=null) return intersezione(filtroMunicipio,filtroCamere);
            if(tipo!=null&&camere!=null&&municipio!=null)
			{
				List Intersezione=new ArrayList(filtroTipo);
				Intersezione.retainAll(filtroCamere);
				List Intersezione2=new ArrayList(filtroMunicipio);
				Intersezione2.retainAll(Intersezione);
				return Intersezione2;
			}
		}*/
	 return Lista.getLista(); // in tutti gli altri casi, ovvero quando il filtro è vuoto, riotorna l'intera lista
	}
}