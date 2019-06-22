package comuneprogetto;

import java.util.Collection;
/**
 * @author Igor Nociaro
 * @author Harmandeep Kaur
 * @version 1.0
 */
public interface Filter<E,T> {
	abstract Collection<E> filterField(String fieldName, String operator, T value);
}
