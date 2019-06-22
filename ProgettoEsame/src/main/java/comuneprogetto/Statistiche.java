package comuneprogetto;
//import java.util.ArrayList;

public class Statistiche {
	
	
	private double avg;
	private double min;
	private double max;
	private double dev_std;
	private double sum;
	private int count;
	public Statistiche (double avg,double min,double max,double dev_std,double sum,int count) { //come fare per elementi unici e occorrenze?
		this.avg = avg;
		this.min = min;
		this.max = max;
		this.dev_std = dev_std;
		this.sum = sum;
		this.count = count;
		
	}
	
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
