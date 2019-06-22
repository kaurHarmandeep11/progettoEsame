package comuneprogetto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Statistics {
	
	public static double round(double x, int n) {
        double factor = Math.pow(10, n);   
        return Math.round(x * factor) / factor;
    }
	
	 public static int count(List lista) {
	        return lista.size();    
	    }
	 public static double sum(List<Number> lista) {
	        double s = 0;
	        for (Number n : lista) {
	            s += n.doubleValue();    
	        }
	        return s;
	    }
	 public static double avg(List<Number> lista) {
	        return round(sum(lista) / count(lista), 2);  
	    }
	 
	 public static double max(List<Number> lista) {
	        double max = lista.get(0).doubleValue();    
	        for (Number n : lista) {
	            double nval = n.doubleValue();
	            if (nval > max) max = nval;
	        }
	        return max;
	    }
	 
	 public static double min(List<Number> lista) {    
	        double min = lista.get(0).doubleValue();
	        for (Number n : lista) {
	            double nval = n.doubleValue();
	            if (nval < min) min = nval;
	        }
	        return min;
	    }
	 
	 public static double std(List<Number> lista) { 
	        double avg = avg(lista);
	        double var = 0;
	        for (Number n : lista) {
	            var += Math.pow(n.doubleValue() - avg, 2);
	        }
	        return round(Math.sqrt(var), 2);
	    }
	 
	 public static Map<Object, Integer> uniqueElements(List lista) {
	        Map<Object, Integer> map = new HashMap<>();
	        for (Object elem : lista) {
	            if (map.containsKey(elem)) {       
	                map.replace(elem, map.get(elem) + 1);  
	            } else {
	                map.put(elem, 1);    
	            }
	        }
	        return map;
	    }
	 
	 public static Map<String, Object> getAllStats(String fieldName, List lista) {
	        Map<String, Object> map = new HashMap<>();
	        map.put("field", fieldName);
	        if (!lista.isEmpty()) {
	            if (lista.get(0) instanceof Number) {    // calcolo statistiche
	                map.put("avg", avg(lista));
	                map.put("min", min(lista));
	                map.put("max", max(lista));
	                map.put("std", std(lista));
	                map.put("sum", sum(lista));
	                map.put("count", count(lista));
	                return map;
	            } else {     
	                map.put("uniqueElements", uniqueElements(lista));
	                map.put("count", count(lista));
	            }
	        }
	        return map;
	    }




}
