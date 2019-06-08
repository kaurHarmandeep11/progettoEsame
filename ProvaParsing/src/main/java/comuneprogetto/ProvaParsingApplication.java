package comuneprogetto;

/**
 * specifiche di progetto : http://s3.amazonaws.com/vrai.univpm/EsempioSpecificheGruppoRev1.pdf
 * data-set : https://www.dati.gov.it/api/3/action/package_show?id=624e5fff-9e40-4adc-9b82-a5d06fa95a26
 * contiene il file CSV da cui dobbiamo ottenere il file JSON
 * 
 * classi disponibili libreria JSON : http://stleary.github.io/JSON-java/index.html
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProvaParsingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProvaParsingApplication.class, args);
		String url = "https://www.dati.gov.it/api/3/action/package_show?id=624e5fff-9e40-4adc-9b82-a5d06fa95a26";
		String NomeFile = "Negozi e locali storici di milano.csv";
		
		new Download(url,NomeFile); 
	}

}
