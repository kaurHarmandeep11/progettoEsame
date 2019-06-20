package comuneprogetto;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Filters {
	
	//Lista degli operatori di confronto
    private static final List<String> operators = Arrays.asList("$eq", "$not", "$in", "$nin", "$gt", "$gte", "$lt", "$lte", "$bt");

    
    public static boolean check(Object value, String operator, Object ref) {
        if (operators.contains(operator)) {  //controllo operatore valido
            if (value instanceof Number) {   //controllare valore numerico
                double numValue = ((Number) value).doubleValue();   //conversione double
                if (ref instanceof Number) {  //riferimento è un singolo numero
                    double numRef = ((Number) ref).doubleValue(); // conversione double
                    switch (operator) {     //confronto corrispondente all'operatore
                        case "$eq":
                            return numValue == numRef;   
                        case "$not":
                            return numValue != numRef;
                        case "$gt":
                            return numValue > numRef;
                        case "$gte":
                            return numValue >= numRef;
                        case "$lt":
                            return numValue < numRef;
                        case "$lte":
                            return numValue <= numRef;
                        default: 
                            String message = "Invalid operator: '" + operator + "' for given operands: '" + value + "' , '" + ref + "'";
                            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message); //warning in formato JSON al client
                    }
                    
                } else if (ref instanceof List) {  //riferimento lista
                    List listRef = ((List) ref); //conversione in lista generica
                    if (!listRef.isEmpty() && listRef.get(0) instanceof Number) {
                        // conversione lista generica in una lista di double
                        List<Double> listRefNum = new ArrayList<>();
                        for (Object elem : listRef) {
                            listRefNum.add(((Number) elem).doubleValue());
                        } 
                        
                        switch (operator) { 
                            case "$in":
                                return listRefNum.contains(numValue);
                            case "$nin":
                                return !listRefNum.contains(numValue);
                            case "$bt":
                                double vInf = listRefNum.get(0);
                                double vSup = listRefNum.get(1);
                                return numValue >= vInf && numValue <= vSup;
                            default:
                                String message = "Invalid operator: '" + operator + "' for given operands: '" + value + "' , '" + ref + "'";
                                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
                        }
                    } else
                        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ref list is empty or contains invalid elements"); // se la lista è vuota o non contiene numeri
                } else
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ref object: '" + ref + "' not compatible with value: '" + value + "'");  // se il riferimento non è compatibile con il valore
            } else if (value instanceof String) {   // se il valore è una stringa
            	String strValue = ((String) value); // lo converto
                if (ref instanceof String) {        // se il riferimento è una singola stringa
                    String strRef = ((String) ref); // converto anche lui
                    switch (operator) {
                        case "$eq":
                            return strValue.equals(strRef);  
                        case "$not":
                            return !strValue.equals(strRef);
                        default:
                            String message = "Invalid operator: '" + operator + "' for given operands: '" + value + "' , '" + ref + "'";
                            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
                    }
                } else if (ref instanceof List) { 
                    List listRef = ((List) ref);
                    if (!listRef.isEmpty() && listRef.get(0) instanceof String) {
                        // convrsione lista generica in una lista di String
                        List<String> listRefStr = new ArrayList<>();
                        for (Object elem : listRef) {
                            listRefStr.add((String) elem);
                        }
                        switch (operator) {
                        case "$in":
                            return listRefStr.contains(strValue);
                        case "$nin":
                            return !listRefStr.contains(strValue);
                        default:
                            String message = "Invalid operator: '" + operator + "' for given operands: '" + value + "' , '" + ref + "'";
                            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
                    }
                } else
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ref list is empty or contains invalid elements");
            } else
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ref object: '" + ref + "' not compatible with value: '" + value + "'"); 
        } else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid value object: '" + value + "'"); // valore non valido
    } else
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid operator: " + operator);  //l'operatore non valido
}

    public static List<Integer> select(List values, String operator, Object ref) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            if (check(values.get(i), operator, ref))        // specifica soddisfatta = il controllo (check)
                indexes.add(i);
        }
        return indexes;        //restituisco la lista degli indici
   }
 
    public static List<String> getOperators() {
        return operators;
    }

}
