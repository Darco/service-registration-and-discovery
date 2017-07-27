/**
 *
 */
package bookmarks.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import bookmarks.model.BookmarkTO;

/**
 * @author David Ruiz C
 *
 */
public interface BookMarkRepository extends MongoRepository<BookmarkTO, Integer> {

}
