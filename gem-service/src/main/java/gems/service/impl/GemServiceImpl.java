/**
 *
 */
package gems.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import gems.dao.GemRepository;
import gems.model.GemTO;
import gems.service.GemService;

/**
 * @author David Ruiz C
 *
 */
@Service
public class GemServiceImpl implements GemService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GemServiceImpl.class);

    @Autowired
    private GemRepository gemRepository;

    /* (non-Javadoc)
     * @see gems.service.GemService#create(gems.model.GemTO)
     */
    @Override
    public String create(GemTO to) {
        return this.update(to) ? "success" : "fail";

    }

    /* (non-Javadoc)
     * @see gems.service.GemService#read(int)
     */
    @Override
    public GemTO read(long id) {
        final GemTO gemTO = gemRepository.findOne(id);
        LOGGER.info("read : {}", gemTO);
        return gemTO;
    }

    /* (non-Javadoc)
     * @see gems.service.GemService#update(gems.model.GemTO)
     */
    @Override
    public boolean update(GemTO to) {
        final GemTO gemTO = gemRepository.save(to);
        LOGGER.info("update : {}", gemTO);
        return gemTO != null;
    }

    /* (non-Javadoc)
     * @see gems.service.GemService#delete(java.lang.String)
     */
    @Override
    public boolean delete(long id) {
        gemRepository.delete(id);
        return true;
    }

    /* (non-Javadoc)
     * @see gems.service.GemService#all()
     */
    @Override
    public List<GemTO> all() {
        List<GemTO> list = Lists.newArrayList(gemRepository.findAll());
        LOGGER.info("all : {}", list);
        return list;
    }


}
