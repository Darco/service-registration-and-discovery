package bookmarks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bookmarks.model.BookmarkTO;
import bookmarks.service.BookmarkService;

@RestController
@RequestMapping("/bookmarks")
public class BookmarkRestController {

    @Autowired
    private BookmarkService bookmarkService;

    @RequestMapping("/testing")
    public String testing(@PathVariable String userId){
        return "Hola " + userId;
    }

    @RequestMapping(value="/create", method=RequestMethod.POST)
    public ResponseEntity<Integer> create(@RequestBody BookmarkTO bookmarkTO){
        bookmarkService.create(bookmarkTO);
        return new ResponseEntity<>(1, HttpStatus.CREATED);
    }

    @RequestMapping(value="/read/{id}", method=RequestMethod.GET)
    public ResponseEntity<BookmarkTO> read(@PathVariable int id){

        final BookmarkTO bookmarkTO = bookmarkService.read(id);

        return new ResponseEntity<>(bookmarkTO, HttpStatus.OK);

    }

    @RequestMapping(value="/update", method=RequestMethod.POST)
    public ResponseEntity<Integer> update(@RequestBody BookmarkTO bookmarkTO){

        bookmarkService.update(bookmarkTO);

        return new ResponseEntity<>(1, HttpStatus.OK);

    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ResponseEntity<Integer> delete(@PathVariable int id){
        bookmarkService.delete(id);
        return new ResponseEntity<>(1, HttpStatus.OK);
    }

}