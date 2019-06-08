package comuneprogetto;

//import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration

public class Handler { //handling incoming web requests
	
	@RequestMapping("/")
	String home() {  
		return "Hello World!";  //viene visualizzato in localhost:8080 sul browser
	}
	//aggiungere visualizzare il file in formato JSON

}
