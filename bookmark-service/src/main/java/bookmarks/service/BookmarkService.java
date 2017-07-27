/**
 *
 */
package bookmarks.service;

import bookmarks.model.BookmarkTO;

/**
 * @author David Ruiz C
 *
 */
public interface BookmarkService {

    void create(BookmarkTO data);
    BookmarkTO read(int id);
    void update(BookmarkTO data);
    void delete(int id);

}
