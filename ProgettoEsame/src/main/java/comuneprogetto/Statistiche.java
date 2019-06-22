package comuneprogetto;

/**
 * Una delle statistiche create da {@link CreaStatististiche}
 * @author Igor Nociaro
 * @author Harmandeep Kaur
 * @version 1.0
 */
public class Statistiche {
	//Attributi
	private double avg;
	private double min;
	private double max;
	private double dev_std;
	private double sum;
	private int count;
	//Metodi
	/**
	 * @param avg Media
	 * @param min Minimo
	 * @param max Massimo
	 * @param dev_std Deviazione standard
	 * @param sum Somma
	 * @param count Conta
	 */
	public Statistiche (double avg,double min,double max,double dev_std,double sum,int count) { //come fare per elementi unici e occorrenze?
		this.avg = avg;
		this.min = min;
		this.max = max;
		this.dev_std = dev_std;
		this.sum = sum;
		this.count = count;
		
	}
	/**
	 * getter
	 */
	public double getavg() {
		return avg;
	}
	public double getmin() {
		return min;
	}
	public double getmax() {
		return max;
	}
	public double getdev_std() {
		return dev_std;
	}
	public double getsum() {
		return sum;
	}
	public int getcount() {
		return count;
	}
}
