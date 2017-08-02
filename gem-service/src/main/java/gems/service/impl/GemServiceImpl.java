/**
 *
 */
package gems.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import gems.model.GemTO;
import gems.service.GemService;

/**
 * @author David Ruiz C
 *
 */
@Service
public class GemServiceImpl implements GemService {

    /* (non-Javadoc)
     * @see gems.service.GemService#create(gems.model.GemTO)
     */
    @Override
    public String create(GemTO to) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see gems.service.GemService#read(int)
     */
    @Override
    public GemTO read(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see gems.service.GemService#update(gems.model.GemTO)
     */
    @Override
    public boolean update(GemTO to) {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see gems.service.GemService#delete(java.lang.String)
     */
    @Override
    public boolean delete(String id) {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see gems.service.GemService#all()
     */
    @Override
    public List<GemTO> all() {
        // TODO Auto-generated method stub
        return null;
    }


}
