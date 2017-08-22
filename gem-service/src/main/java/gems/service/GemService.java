/**
 *
 */
package gems.service;

import java.util.List;

import gems.model.GemTO;

/**
 * @author David Ruiz C
 *
 */
public interface GemService {

    String create(GemTO to);

    GemTO read(long id);

    boolean update(GemTO to);

    boolean delete(long id);

    List<GemTO> all();


}
