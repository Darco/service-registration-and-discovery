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

    GemTO read(int id);

    boolean update(GemTO to);

    boolean delete(String id);

    List<GemTO> all();


}
