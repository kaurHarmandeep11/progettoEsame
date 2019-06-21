package comuneprogetto;

import java.util.ArrayList;

public class SuperLocale implements Filter<LocaleMilano, Object> {
	private ArrayList<LocaleMilano> SuperLocale;
	private FilterUtils<LocaleMilano> utils;
	
	public SuperLocale(ArrayList<LocaleMilano> people, FilterUtils<LocaleMilano> utils) {
		super();
		this.SuperLocale = people;
		this.utils = utils;
	}
	
	public SuperLocale(ArrayList<LocaleMilano> people) {
		super();
		this.SuperLocale = people;
		this.utils = new FilterUtils<LocaleMilano>();
	}

	public ArrayList<LocaleMilano> getPeople() {
		return SuperLocale;
	}

	public void setPeople(ArrayList<LocaleMilano> SuperLocale) {
		this.SuperLocale = SuperLocale;
	}
	
	@Override
	public ArrayList<LocaleMilano> filterField(String fieldName, String operator, Object value) {
		// TODO Auto-generated method stub
		return (ArrayList<LocaleMilano>) utils.select(this.getPeople(), fieldName, operator, value);
	}
}
