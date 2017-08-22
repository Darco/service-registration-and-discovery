/**
 *
 */
package gems.dao;

import org.springframework.data.repository.CrudRepository;

import gems.model.GemTO;

/**
 * @author David Ruiz C
 *
 */
public interface GemRepository extends CrudRepository<GemTO, Long> {

}
