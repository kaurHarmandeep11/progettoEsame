package comuneprogetto;
/**
 * Uno dei Locali creati dalla classe {@link CreaOggetti}
 * @author Igor Nociaro
 * @author Harmandeep Kaur
 * @version 1.0
 */
public class LocaleMilano  {
	//Attributi
	private int ID_NLS;
	private String RIC;
	private String INDIR_ORIG;
	private String DENOM_IMPRES;
	private String INSEGNA;
	private int INIZIO_ATT;
	private double geo_y;
	private double geo_x;
	//Metodi
	/**
	 * @param ID_NLS ID locale
	 * @param RIC Tipo di locale
	 * @param INDIR_ORIG Indirizzo del locale
	 * @param DENOM_IMPRES Denominazione del locale
	 * @param INSEGNA Insegna
	 * @param INIZIO_ATT Anno di inizio attività
	 * @param geo_y Posizione y locale
	 * @param geo_x Posizione x locale
	 */
	public LocaleMilano(int ID_NLS, String RIC, String INDIR_ORIG, String DENOM_IMPRES, String INSEGNA,
			int INIZIO_ATT, double geo_y, double geo_x) { //costruttore
		
		super();
		this.ID_NLS = ID_NLS;
		this.RIC = RIC;
		this.INDIR_ORIG = INDIR_ORIG;
		this.DENOM_IMPRES = DENOM_IMPRES;
		this.INSEGNA = INSEGNA;
		this.INIZIO_ATT = INIZIO_ATT;
		this.geo_x = geo_x;
		this.geo_y = geo_y;
	}
	/**
	 * getter
	 */
	public int getID_NLS() {
		return ID_NLS;
	}
	
	public String getRIC() {
		return RIC;
	}
	
	public String getINDIR_ORIG() {
		return INDIR_ORIG;
	}
	
	public String getDENOM_IMPRES() {
		return DENOM_IMPRES;
	}
	
	public String getINSEGNA() {
		return INSEGNA;
	}
	
	public int getINIZIO_ATT() {
		return INIZIO_ATT;
	}
	
	public double getgeo_y() {
		return geo_y;
	}
	
	public double getgeo_x() {
		return geo_x;
	}

}
