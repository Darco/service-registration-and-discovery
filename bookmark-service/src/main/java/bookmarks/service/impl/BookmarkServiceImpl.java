/**
 *
 */
package bookmarks.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookmarks.dao.BookMarkRepository;
import bookmarks.model.BookmarkTO;
import bookmarks.service.BookmarkService;

/**
 * @author David Ruiz C
 *
 */
@Service
public class BookmarkServiceImpl implements BookmarkService {

    @Autowired
    private BookMarkRepository bookMarkRepository;

    /* (non-Javadoc)
     * @see bookmarks.service.BookmarkService#create(bookmarks.model.BookmarkTO)
     */
    @Override
    public void create(BookmarkTO data) {

        bookMarkRepository.insert(data);

    }

    /* (non-Javadoc)
     * @see bookmarks.service.BookmarkService#read(int)
     */
    @Override
    public BookmarkTO read(int id) {
        return bookMarkRepository.findOne(id);
    }

    /* (non-Javadoc)
     * @see bookmarks.service.BookmarkService#update(bookmarks.model.BookmarkTO)
     */
    @Override
    public void update(BookmarkTO data) {
        bookMarkRepository.save(data);

    }

    /* (non-Javadoc)
     * @see bookmarks.service.BookmarkService#delete(int)
     */
    @Override
    public void delete(int id) {
        bookMarkRepository.delete(id);

    }

}
