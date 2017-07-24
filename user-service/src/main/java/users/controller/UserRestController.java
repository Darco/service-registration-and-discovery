package users.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import users.model.UserTO;
import users.service.UserService;

@RestController
@RequestMapping("/user/{id}")
public class UserRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);

    @Autowired
    private UserService userService;


    @RequestMapping(value="/read", method = RequestMethod.GET)
    public UserTO read(@PathVariable int id){

        LOGGER.info("id : {}", id);

        final UserTO userTO = userService.read(id);

        LOGGER.info("user : {}", userTO);

        return userTO;

    }
    
    @RequestMapping(value="/create/{name}/{email}", method = RequestMethod.GET)
    public String create(@PathVariable int id, @PathVariable String name, @PathVariable String email){

        LOGGER.info("id : {}", id);
        LOGGER.info("name : {}", name);
        LOGGER.info("email : {}", email);
        
        UserTO to = new UserTO();
        to.setId(id);
        to.setName(name);
        to.setEmail(email);
        
        String mensaje = userService.create(to);

        LOGGER.info("Aviso : {}", mensaje);

        return mensaje;

    }
    
    @RequestMapping(value="/all", method = RequestMethod.GET)
    public List<UserTO> selectAll(){
        
        List<UserTO> ListUserTo = userService.all();

        LOGGER.info("Usuarios : {}", ListUserTo);

        return ListUserTo;

    }



}