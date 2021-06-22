package com.jb.apijb.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PageController {

    private final PageService pageService;

    @Autowired
    public PageController(final PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping("/pages")
    public ResponseEntity<List<Page>> getAllPages() {
        try {
            List<Page> pageList = pageService.getAllPages();

            if (pageList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(pageList, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pages/{id}")
    public ResponseEntity<Page> getPageById(@PathVariable("id") long id) {
        try {
            Optional<Page> pageOptional = pageService.getPageById(id);

            return pageOptional.map(page -> new ResponseEntity<>(page, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/pages")
    public ResponseEntity<PageDTO> upsertPage(@RequestBody PageDTO pageDTO) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(pageService.upsertPage(pageDTO));
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/pages/{id}")
    public ResponseEntity<HttpStatus> deletePage(@PathVariable("id") long id) {
        try {
            pageService.deletePage(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
