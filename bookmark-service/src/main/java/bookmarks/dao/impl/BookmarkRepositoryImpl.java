/**
 *
 */
package bookmarks.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.WriteResult;

import bookmarks.dao.BookMarkRepository;
import bookmarks.model.BookmarkTO;

/**
 * @author David Ruiz C
 *
 */
@Repository
public class BookmarkRepositoryImpl implements BookMarkRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookmarkRepositoryImpl.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    /* (non-Javadoc)
     * @see org.springframework.data.mongodb.repository.MongoRepository#save(java.lang.Iterable)
     */
    @Override
    public <S extends BookmarkTO> List<S> save(Iterable<S> entites) {
        LOGGER.info("save Not implemented");
        return new ArrayList<>();
    }

    /* (non-Javadoc)
     * @see org.springframework.data.mongodb.repository.MongoRepository#findAll()
     */
    @Override
    public List<BookmarkTO> findAll() {
        List<BookmarkTO> findAll = mongoTemplate.findAll(BookmarkTO.class);
        LOGGER.debug("items : {}", findAll);
        return findAll;
    }

    /* (non-Javadoc)
     * @see org.springframework.data.mongodb.repository.MongoRepository#findAll(org.springframework.data.domain.Sort)
     */
    @Override
    public List<BookmarkTO> findAll(Sort sort) {

        return findAll();
    }

    /* (non-Javadoc)
     * @see org.springframework.data.mongodb.repository.MongoRepository#insert(java.lang.Object)
     */
    @Override
    public <S extends BookmarkTO> S insert(S entity) {
        mongoTemplate.save(entity);
        return entity;
    }

    /* (non-Javadoc)
     * @see org.springframework.data.mongodb.repository.MongoRepository#insert(java.lang.Iterable)
     */
    @Override
    public <S extends BookmarkTO> List<S> insert(Iterable<S> entities) {
        LOGGER.info("insert Not implemented");
        return new ArrayList<>();
    }

    /* (non-Javadoc)
     * @see org.springframework.data.repository.PagingAndSortingRepository#findAll(org.springframework.data.domain.Pageable)
     */
    @Override
    public Page<BookmarkTO> findAll(Pageable arg0) {
        LOGGER.info("findAll Not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#count()
     */
    @Override
    public long count() {
        return this.findAll().size();
    }

    /* (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#delete(java.io.Serializable)
     */
    @Override
    public void delete(Integer arg0) {
        BookmarkTO findById = findOne(arg0);
        LOGGER.debug("item : {}", findById);
        delete(findById);

    }

    /* (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Object)
     */
    @Override
    public void delete(BookmarkTO arg0) {
        mongoTemplate.remove(arg0);
    }

    /* (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#delete(java.lang.Iterable)
     */
    @Override
    public void delete(Iterable<? extends BookmarkTO> arg0) {
        LOGGER.info("delete Not implemented");

    }

    /* (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#deleteAll()
     */
    @Override
    public void deleteAll() {
        mongoTemplate.dropCollection(BookmarkTO.class);
    }

    /* (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#exists(java.io.Serializable)
     */
    @Override
    public boolean exists(Integer arg0) {

        return findOne(arg0) != null;
    }

    /* (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#findAll(java.lang.Iterable)
     */
    @Override
    public Iterable<BookmarkTO> findAll(Iterable<Integer> arg0) {
        LOGGER.info("findAll Not implemented");
        return null;
    }

    /* (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#findOne(java.io.Serializable)
     */
    @Override
    public BookmarkTO findOne(Integer arg0) {
        return mongoTemplate.findById(arg0, BookmarkTO.class);
    }

    /* (non-Javadoc)
     * @see org.springframework.data.repository.CrudRepository#save(java.lang.Object)
     */
    @Override
    public <S extends BookmarkTO> S save(S arg0) {
        Query query = new Query(Criteria.where("id").is(arg0.getId()));
        Update update = new Update();
        update.set("description", arg0.getDescription());
        update.set("date", new Date());
        mongoTemplate.updateFirst(query, update, BookmarkTO.class);
        return null;
    }



}
