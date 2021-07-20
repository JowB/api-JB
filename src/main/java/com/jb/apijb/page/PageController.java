package com.jb.apijb.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PageController {

    private final PageService pageService;

    @Autowired
    public PageController(final PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping("/pages")
    public ResponseEntity<List<PageDTO>> getAllPages() {
        try {
            List<PageDTO> pageDTOList = pageService.getAllPages();

            if (pageDTOList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(pageDTOList, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pages/{id}")
    public ResponseEntity<PageDTO> getPageById(@PathVariable("id") long id) {
            return pageService.getPageById(id);
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
