package gems.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gems.model.GemTO;
import gems.service.GemService;

@RestController
@RequestMapping("/gem/{id}")
public class GemRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GemRestController.class);

    @Autowired
    private GemService gemService;


    @RequestMapping(value="/read", method = RequestMethod.GET)
    public GemTO read(@PathVariable int id){

        LOGGER.info("id : {}", id);

        final GemTO gemTO = gemService.read(id);

        LOGGER.info("gem : {}", gemTO);

        return gemTO;

    }

    @RequestMapping(value="/create/{name}/{email}", method = RequestMethod.GET)
    public String create(@PathVariable int id, @PathVariable String name, @PathVariable String email){

        LOGGER.info("id : {}", id);
        LOGGER.info("name : {}", name);
        LOGGER.info("email : {}", email);

        GemTO to = new GemTO();
        to.setId(id);
        to.setName(name);
        to.setEmail(email);

        String mensaje = gemService.create(to);

        LOGGER.info("Aviso : {}", mensaje);

        return mensaje;

    }

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public List<GemTO> selectAll(){

        List<GemTO> list = gemService.all();

        LOGGER.info("Usuarios : {}", list);

        return list;

    }



}