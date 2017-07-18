package users.controller;

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



}