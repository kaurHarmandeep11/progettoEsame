package progetto;

import org.springframework.boot.SpringApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QueryStringApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueryStringApplication.class, args);
		
		String csvFile = "Negozi e locali storici di milano.csv";
        String line = "";
        int i = 0;
        
        String csvSplitBy = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

          while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] A = line.split(csvSplitBy);

                System.out.println(A[i]);

            }
            while ((line = br.readLine()) != null) {
            	System.out.println(br.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
		
     		
	}

}
