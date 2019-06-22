package comuneprogetto;

import java.util.ArrayList;

/**
 * Applica filtri a LocaleMilano
 * @author Igor Nociaro
 * @author Harmandeep Kaur
 * @version 1.0
 */

public class Locale implements Filter<LocaleMilano, Object> {
	private ArrayList<LocaleMilano> Locale;
	private FilterUtils<LocaleMilano> utils;
	
	public Locale(ArrayList<LocaleMilano> Locale, FilterUtils<LocaleMilano> utils) {
		super();
		this.Locale = Locale;
		this.utils = utils;
	}
	
	public Locale(ArrayList<LocaleMilano> Locale) {
		super();
		this.Locale = Locale;
		this.utils = new FilterUtils<LocaleMilano>();
	}
    /**
     * getter and setter
     */
	public ArrayList<LocaleMilano> getlocale() {
		return Locale;
	}

	public void setlocale(ArrayList<LocaleMilano> Locale) {
		this.Locale = Locale;
	}
	
	@Override
	public ArrayList<LocaleMilano> filterField(String fieldName, String operator, Object value) {
		// TODO Auto-generated method stub
		return (ArrayList<LocaleMilano>) utils.select(this.getlocale(), fieldName, operator, value);
	}
}
