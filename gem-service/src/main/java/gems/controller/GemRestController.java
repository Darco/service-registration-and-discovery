package gems.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gems.model.GemTO;
import gems.service.GemService;

@RestController
@RequestMapping("/gem")
public class GemRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GemRestController.class);

    @Autowired
    private GemService gemService;


    @RequestMapping(value="/read/{id}", method = RequestMethod.GET)
    public GemTO read(@PathVariable long id){

        LOGGER.info("id : {}", id);

        final GemTO gemTO = gemService.read(id);

        LOGGER.info("gem : {}", gemTO);

        return gemTO;

    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public String create(@RequestBody GemTO gemTO){

        String mensaje = gemService.create(gemTO);

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