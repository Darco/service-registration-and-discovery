/**
 *
 */
package gems.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.gemfire.GemfireTemplate;
import org.springframework.data.gemfire.repository.GemfireRepository;
import org.springframework.data.gemfire.repository.Wrapper;
import org.springframework.stereotype.Repository;

import gems.model.GemTO;

/**
 * @author David Ruiz C
 *
 */
@Repository
public class GemfireRepositoryImpl implements GemfireRepository<GemTO, Long> {

    @Autowired
    private GemfireTemplate gemfireTemplate;

    /* (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#save(java.lang.Object)
     */
    @Override
    public <S extends GemTO> S save(S entity) {
        gemfireTemplate.create(entity.getId(), entity);
        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#save(java.lang.Iterable)
     */
    @Override
    public <S extends GemTO> Iterable<S> save(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#findOne(java.io.Serializable)
     */
    @Override
    public GemTO findOne(Long id) {
        GemTO gemTO = gemfireTemplate.get(id);
        return gemTO;
    }

    /* (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#exists(java.io.Serializable)
     */
    @Override
    public boolean exists(Long id) {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#findAll()
     */
    @Override
    public Iterable<GemTO> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#findAll(java.lang.Iterable)
     */
    @Override
    public Iterable<GemTO> findAll(Iterable<Long> ids) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#count()
     */
    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#delete(java.io.Serializable)
     */
    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Object)
     */
    @Override
    public void delete(GemTO entity) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Iterable)
     */
    @Override
    public void delete(Iterable<? extends GemTO> entities) {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#deleteAll()
     */
    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.springframework.data.gemfire.repository.GemfireRepository#findAll(org.springframework.data.domain.Sort)
     */
    @Override
    public Iterable<GemTO> findAll(Sort sort) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.data.gemfire.repository.GemfireRepository#save(org.springframework.data.gemfire.repository.Wrapper)
     */
    @Override
    public GemTO save(Wrapper<GemTO, Long> wrapper) {
        // TODO Auto-generated method stub
        return null;
    }

}
