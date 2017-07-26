package photos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class Application {

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    
    /*
    private static void deleteUser() {
    	final String REST_SERVICE_URI = "http://localhost:8080/SpringBootRestApi/delete/{id}";
        System.out.println("\nTesting delete User API----------");
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> request = new HttpEntity<String>();
        restTemplate.exchange(REST_SERVICE_URI+"/user/3", HttpMethod.DELETE, request, User.class);
    }
    */
    
    /*REST Client POST-> Crea un Usuario  ...*/
    /*   Otra Forma de crear nuevo usuario 
    private static void createUser() {
    	final String REST_SERVICE_URI = "http://localhost:8080/SpringBootRestApi/createUser";
        System.out.println("Testing create User API----------");
        RestTemplate restTemplate = new RestTemplate();
        User user = new User(4,"Andrea","Nieto");
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI, user, User.class);
        System.out.println("Location : "+uri.toASCIIString());
    }
    */   
    
    /*  OTRA FORMA DE ACTUALIZAR USUARIO
    private static void updateUser() {
    	final String REST_SERVICE_URI = "http://localhost:8080/SpringBootRestApi/update/{id}";
        System.out.println("Testing update User API----------");
        RestTemplate restTemplate = new RestTemplate();
        User user  = new User(2,"Juana", "Fuentes");
        restTemplate.put(REST_SERVICE_URI, user);
        System.out.println(user);
    } 
    */
    
    /*REST Client -> Extrae todos los usarios*/
    /*
    private static void getAllUsers()
    {
        final String uri = "http://localhost:8080/springrestexample/users.json";
         
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
         
        System.out.println(result);
    }
    */
}

