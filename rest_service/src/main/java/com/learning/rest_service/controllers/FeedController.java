package com.learning.rest_service.controllers;

import com.learning.rest_service.model.Category;
import com.learning.rest_service.model.Feed;
import com.learning.rest_service.services.FeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/feed")
@CrossOrigin(origins = "*")
public class FeedController {
    @Autowired
    FeedService feedService;

    @GetMapping()
    public Iterable<Feed> listFeeds(){
        return feedService.listFeeds();
    }

    @PostMapping(
            path = "/add",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    String addFeed(@RequestParam(value = "title") String title,
                   @RequestParam(value = "about") String about,
                   @RequestParam(value = "site") String site,
                   @RequestParam(value = "category") Long category,
                   @RequestParam(value = "author") Long author,
                   @RequestParam(value = "image") MultipartFile image){
        feedService.addFeed(title, about, site, author, image, category);
        return "Success";
    }

    @DeleteMapping("/{id}")
    String deleteFeed(@PathVariable Long id){
        feedService.deleteFeed(id);
        return "Success";
    }
    @GetMapping("/categories")
    Iterable<Category> listCategories(){
        return feedService.listCategories();
    }
}
