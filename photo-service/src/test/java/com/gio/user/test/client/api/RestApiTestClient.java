package com.gio.user.test.client.api;

import java.net.URI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.gio.model.user.User;

public class RestApiTestClient {
    /*REST Client GET -> Extrae todos los usarios*/
    @SuppressWarnings("unchecked")
    private static void listAllUsers(){
        System.out.println("Testing listAllUsers API-----------");
        
       final String REST_SERVICE_URI = "http://localhost:8060/user/users";
          
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject(REST_SERVICE_URI, List.class);
          
        if(usersMap!=null){
            for(LinkedHashMap<String, Object> map : usersMap){
                System.out.println("User : id="+map.get("id")+", Name="+map.get("name")+", Apaterno="+map.get("apaterno"));;
            }
        }else{
            System.out.println("No user exist----------");
        }
    }
    
    
    /*REST Client GET-> Extrae un usuario en especifico  ...*/
    private static void getUserById()
    {
        final String uri = "http://localhost:8060/user/single/{id}";
        
        System.out.println("Testing getUser API----------"); 
        
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", "1");
         
        RestTemplate restTemplate = new RestTemplate();
        User userId = restTemplate.getForObject(uri, User.class, params);
         
        System.out.println(userId);
    }
    
    /*REST Client POST-> Crea un Usuario  ...*/
    private static void createUser() {
    	final String REST_SERVICE_URI = "http://localhost:8060/user/createUser";
        System.out.println("\nTesting create User API----------");
        RestTemplate restTemplate = new RestTemplate();
        User user = new User(4,"Andrea","Fuentes");
        HttpEntity<Object> request = new HttpEntity<Object>(user);
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI, request, User.class);
        System.out.println("Location : "+uri.toASCIIString());
    }
    
    /*REST Client PUT-> Actualiza un Usuario  ...*/
    private static void updateUser() {
    	final String REST_SERVICE_URI = "http://localhost:8060/user/update/{id}";
    	System.out.println("\nTesting update User API----------");
        RestTemplate restTemplate = new RestTemplate();
        User user  = new User(2,"Juana","Fuentes");
        HttpEntity<Object> request = new HttpEntity<Object>(user);
        ResponseEntity<User> response = restTemplate.exchange(REST_SERVICE_URI, HttpMethod.PUT, request, User.class);
        System.out.println(response.getBody());
    }
    
    /* REST Client DELETE-> Elimina un Usuario */
    private static void deleteUser() {
    	final String REST_SERVICE_URI = "http://localhost:8060/user/delete/{id}";
        System.out.println("Testing delete User API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/user/3", HttpMethod.DELETE);
    }
   
    /*
    public static void main(String[] args) {
    	//listAllUsers();
    	//createUser();
    	//updateUser();
    	//deleteUser();
    }
    */
}
