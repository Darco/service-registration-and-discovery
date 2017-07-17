package bookmarks.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/{userId}/bookmarks")
public class BookmarkRestController {

    @RequestMapping("/testing")
    public String testing(@PathVariable String userId){
        return "Hola " + userId;
    }

}