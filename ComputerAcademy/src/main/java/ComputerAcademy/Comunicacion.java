package ComputerAcademy;

import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class Comunicacion {
	
	private static final String URL="http://127.0.0.1:8080/servicio";
	
	public void enviar(String direccion, String subject, String body){
		RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> email= new LinkedMultiValueMap<String, String>();
        email.add("email", direccion);
        email.add("subject", subject);
        email.add("body", body);
        ResponseEntity<String> response =  restTemplate.postForEntity(URL,email,String.class);
	}
}
