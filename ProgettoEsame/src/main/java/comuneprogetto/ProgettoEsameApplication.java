package comuneprogetto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Avvia SpringApplication con il server Tomcat e scarica il Json dal url
 * @author Igor Nociaro
 * @author Harmandeep Kaur
 * @version 1.0
 */
@SpringBootApplication
public class ProgettoEsameApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgettoEsameApplication.class, args);
		String url = "https://www.dati.gov.it/api/3/action/package_show?id=624e5fff-9e40-4adc-9b82-a5d06fa95a26";
		String NomeFile = "Negozi_e_locali_storici_di_milano.csv";
			
		new Download(url,NomeFile); 
		//new CreaOggetti();
		
	}

}
